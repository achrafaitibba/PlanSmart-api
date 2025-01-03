package net.techbridges.plansmart.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Entity
@AllArgsConstructor
@NoArgsConstructor

// Maintaining or breaking a hobby{not listening to music, going gym...}
public class Streak {
    @Id
    @GeneratedValue
    private Long id;
    @ManyToOne
    private User user;
    private String name;
    private LocalDate startDate;
    private LocalDate date;
    private Boolean isLimited; // For streak based tasks for limited time (30 days no coffee.. after 30 days i can drink coffee hh )
    private Integer maxStreak;
}
