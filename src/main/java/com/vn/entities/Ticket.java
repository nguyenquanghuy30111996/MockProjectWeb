package com.vn.entities;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.vn.enums.TicketStatus;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "TICKET")
public class Ticket {
    @Id
    @GeneratedValue
    @Column(name = "TICKET_ID")
    private String ticketId;

    @Column(columnDefinition = "MONEY", name = "PRICE")
    private BigDecimal price;

    @Column(name = "TICKET_STATUS")
    private TicketStatus status;

    @ManyToOne
    @JoinColumn(name = "SEAT_ID", referencedColumnName = "SEAT_ID")
    private Seat seat;

    @ManyToOne
    @JoinColumn(name = "SHOW_ID", referencedColumnName = "SHOW_ID")
    private Show show;

    // booking
    @ManyToOne
    @JoinColumn(name = "BOOKING_ID", referencedColumnName = "BOOKING_ID")
    private Booking booking;
}

