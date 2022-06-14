package com.vn.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
@Table(name = "CINEMA_ROOM")
@Entity
public class CinemaRoom {

	@Id
    @Column(name = "CINEMA_ROOM_ID")
    private String cinemaRoomId;

    @Column(name = "CINEMA_ROOM_NAME")
    private String cinemaRoomName;

    @Column(name = "ROW_SIZE")
    private Integer rowSize;

    @Column(name = "COL_SIZE")
    private Integer colSize;

    @OneToMany(mappedBy = "cinemaRoom")
    private List<Seat> seats;

    @OneToMany(mappedBy = "cinemaRoom")
    private List<Show> shows;
}
