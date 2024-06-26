package com.tripmaker.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Booking {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer bookinId;
	
	
	public Integer getBookinId() {
		return bookinId;
	}

	public void setBookinId(Integer bookinId) {
		this.bookinId = bookinId;
	}

	public String getBookingType() {
		return bookingType;
	}

	public void setBookingType(String bookingType) {
		this.bookingType = bookingType;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getBookingTitle() {
		return bookingTitle;
	}

	public void setBookingTitle(String bookingTitle) {
		this.bookingTitle = bookingTitle;
	}

	public LocalDate getBookingDate() {
		return bookingDate;
	}

	public void setBookingDate(LocalDate bookingDate) {
		this.bookingDate = bookingDate;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Package getPackages() {
		return packages;
	}

	public void setPackages(Package packages) {
		this.packages = packages;
	}

	public List<TicketDetails> getTickets() {
		return tickets;
	}

	public void setTickets(List<TicketDetails> tickets) {
		this.tickets = tickets;
	}

	@NotNull(message = "Booking Type is mandatory")
	@NotEmpty(message = "Booking Type is mandatory")
	@Size(min = 5, max = 15, message = "User Type should be of 5-7 charecters")
	private String bookingType;
	
	@NotNull(message = "Booking description is mandatory")
	@NotEmpty(message = "Booking description is mandatory")
	@Size(min = 5, max = 50, message = "Description should be of 5-50 charecters")
	private String description;
	
	
	@NotNull(message = "Booking title is mandatory")
	@NotEmpty(message = "Booking title is mandatory")
	@Size(min = 5, max = 15, message = "Description should be of 5-15 charecters")
	private String bookingTitle;
	
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyyy")
	private LocalDate bookingDate;
	
	@JsonIgnore
	@ManyToOne(cascade = CascadeType.ALL)
	private User user;
	
	@JsonIgnore
	@ManyToOne(cascade = CascadeType.ALL)
	private Package packages;
	
	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL)
	private List<TicketDetails> tickets = new ArrayList<>();
}
