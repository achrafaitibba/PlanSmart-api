package net.techbridges.plansmart;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PlanSmartApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(PlanSmartApiApplication.class, args);
    }
    //todo, export to pdf each record, may print it later hh
    //todo, create routine challenge (90 days of the following routine ... )
    //todo, statistics (by week/month/routine challenge duration) -> 'you studied 70h/140 or 50% of your monthly/challenge target...'
    //todo, statistics reminder (sun baths is less than expected, in 3 weeks you should do 3, you only did it once....) because it's set on routine task
    //todo, streaks
    //todo, every task is updatable ( previous 'study - 3h', actual '4h'...)
}
