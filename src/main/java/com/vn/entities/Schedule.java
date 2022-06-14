package com.vn.entities;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "SCHEDULE")
public class Schedule {
    @Id
    @GeneratedValue
    @Column(name = "SCHEDULE_ID")
    private String scheduleId;

    @Column(columnDefinition = "DATE", name = "SCHEDULE_DATE")
    private LocalDate scheduleDate;

    @Column(columnDefinition = "TIME", name = "SCHEDULE_TIME")
    private LocalTime scheduleTime;

   
    @OneToMany(mappedBy = "schedule")
    private List<Show> shows;
}
