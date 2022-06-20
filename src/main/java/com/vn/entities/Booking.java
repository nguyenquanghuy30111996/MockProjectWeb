package com.vn.entities;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.vn.enums.BookingStatus;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "BOOKING")
public class Booking {

	@Id
	@GeneratedValue
	@Column(name = "BOOKING_ID")
	private String bookingId;

	@Column(name = "ADD_SCORE")
	private Integer addScore;

	@Column(name = "USE_SCORE")
	private Integer useScore;

	@Column(name = "TOTAL_MONEY", columnDefinition = "MONEY")
	private BigDecimal total;

	@Column(name = "BOOKING_DATE")
	private LocalDateTime bookingDate = LocalDateTime.now();

	@Enumerated(EnumType.STRING)
	@Column(name = "BOOKING_STATUS")
	private BookingStatus status;

	@ManyToOne
	@JoinColumn(name = "SHOW_ID", referencedColumnName = "SHOW_ID")
	private Show show;

	@OneToMany(mappedBy = "booking")
	private List<Ticket> tickets;

	// account
	@ManyToOne
	@JoinColumn(name = "user_id")
	private Users account;
}
