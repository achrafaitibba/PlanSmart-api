# Stage 1: Build the application with Maven
FROM maven:3.8.7-openjdk-18 AS maven-builder
WORKDIR /opt/app
COPY .mvn/ .mvn
COPY mvnw pom.xml ./
RUN ./mvnw dependency:go-offline
COPY ./src ./src
RUN ./mvnw clean install -DskipTests

# Stage 2: Build the minimal JRE using jlink
FROM amazoncorretto:17 AS jre-builder
WORKDIR /opt/jre
RUN yum install -y binutils
RUN jlink \
    --module-path "$JAVA_HOME/jmods" \
    --add-modules java.base,java.compiler,java.desktop,java.instrument,java.management,\
java.net.http,java.prefs,java.rmi,java.scripting,java.security.jgss,java.sql.rowset,jdk.jfr,jdk.unsupported \
    --verbose \
    --strip-debug \
    --compress 2 \
    --no-header-files \
    --no-man-pages \
    --output /opt/jre-minimal

# Stage 3: Final image with minimal JRE and application
FROM bitnami/minideb:bullseye
WORKDIR /opt/app
ENV JAVA_HOME=/opt/jre-minimal
ENV PATH="$PATH:$JAVA_HOME/bin"
COPY --from=jre-builder /opt/jre-minimal /opt/jre-minimal
COPY --from=maven-builder /opt/app/target/PlanSmart.jar /opt/app/PlanSmart.jar
EXPOSE 8080
ENTRYPOINT ["java","-Dspring.profiles.active=prod","-jar","/opt/app/PlanSmart.jar"]


## To find needed dependencies
#mkdir app
#cd ./app
#unzip ../app.jar
#cd ..
#jdeps --print-module-deps --ignore-missing-deps --recursive --multi-release 17 --class-path="./app/BOOT-INF/lib/*" --module-path="./app/BOOT-INF/lib/*" ./app.jar
#rm -Rf ./app

#Or just use : --add-modules ALL-MODULE-PATH \
# jdeps --list-deps