package com.vn.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.vn.enums.SeatType;

@Entity
@Table(name = "SEAT")
public class Seat {
    @Id
    @GeneratedValue
    @Column(name = "SEAT_ID")
    private String seatId;

    @Column(name = "SEAT_ROW")
    private Integer seatRow;

    @Column(name = "SEAT_COLUMN")
    private Integer seatColumn;

    @Column(name = "SEAT_TYPE")
    private SeatType seatType;

    
    @ManyToOne
    @JoinColumn(name = "CINEMA_ROOM_ID", referencedColumnName = "CINEMA_ROOM_ID")
    private CinemaRoom cinemaRoom;

    
    @OneToMany(mappedBy = "seat")
    private List<Ticket> tickets;
}
