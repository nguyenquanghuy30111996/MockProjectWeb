package com.vn.entities;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="SHOW")
public class Show {
    @Id
    @GeneratedValue
    @Column(name = "SHOW_ID")
    private String showId;

    @Column(name = "PRICE")
    private BigDecimal price;

    
    @ManyToOne
    @JoinColumn(name = "CINEMA_ROOM_ID", referencedColumnName = "CINEMA_ROOM_ID")
    private CinemaRoom cinemaRoom;

    @ManyToOne
    @JoinColumn(name = "SCHEDULE_ID", referencedColumnName = "SCHEDULE_ID")
    private Schedule schedule;

    @OneToMany(mappedBy = "show")
    private List<Ticket> tickets;

    
    @OneToMany(mappedBy = "show")
    private List<Booking> bookings;


    
    @ManyToOne
    @JoinColumn(name = "MOVIE_ID", referencedColumnName = "MOVIE_ID")
    private Movie movie;
}
