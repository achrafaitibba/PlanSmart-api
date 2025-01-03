package net.techbridges.plansmart.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import net.techbridges.plansmart.model.enums.FREQUENCY;
import net.techbridges.plansmart.model.enums.RoutineTaskType;

import java.time.LocalDate;
import java.time.LocalTime;
@Entity
@AllArgsConstructor
@NoArgsConstructor

public class RoutineTask {
    @Id
    @GeneratedValue
    private Long id;
    @ManyToOne
    private User user;
    private String taskDescription;
    @Enumerated(EnumType.STRING)
    private RoutineTaskType type;
    private Double quantity; // For tasks that require a quantity (studying 4H a day)
    @Enumerated(EnumType.STRING)
    private FREQUENCY frequency; // For occasional tasks (Sun/cold bath once a week..)
    private LocalDate date;
    private LocalTime startTime;
    private Boolean isStreak; //todo, automatically generate streak for it (gym/quran/studies...)
}
