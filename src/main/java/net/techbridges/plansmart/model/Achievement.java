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
public class Achievement {
    @Id
    @GeneratedValue
    private Long id;
    @ManyToOne
    private User owner;
    private Integer importanceLevel; // 40%
    private String name;
    private String description;
    private LocalDate date;
}
