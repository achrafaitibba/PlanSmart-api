package net.techbridges.plansmart.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;
@Entity
@AllArgsConstructor
@NoArgsConstructor

public class TodoRecord {
    @Id
    @GeneratedValue
    private Long id;
    @ManyToOne
    private User user;
    private LocalDate date;
    @OneToMany
    private List<Task> tasks;
    private Integer rate; // 40/100 hh
    @OneToMany
    private List<Note> notes; // I did read 3 Surat/Parts of quran...
    private String comment; // {use the following templates} Today I'm grateful for my health, family...One thing I did that sucked...
}
