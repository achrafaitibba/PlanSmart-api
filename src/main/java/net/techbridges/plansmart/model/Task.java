package net.techbridges.plansmart.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import net.techbridges.plansmart.model.enums.DailyTaskType;
import net.techbridges.plansmart.model.enums.TaskStatus;
import net.techbridges.plansmart.model.enums.TaskType;

import java.time.LocalTime;
import java.util.List;
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Task {
    @Id
    @GeneratedValue
    private Long id;
    private Integer taskOrder;
    @Enumerated(EnumType.STRING)
    private TaskType taskType;
    private String taskDescription;
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Subtask> subTasks;
    @Enumerated(EnumType.STRING)
    private DailyTaskType type;
    @Enumerated(EnumType.STRING)
    private TaskStatus status;
    private Boolean isRequired;
    private LocalTime startTime;
    private LocalTime endTime; //todo, not required, auto completed if next task is done
}
