package com.tripmaker.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Package {
	

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer packageId;
	
	
	public Integer getPackageId() {
		return packageId;
	}

	public void setPackageId(Integer packageId) {
		this.packageId = packageId;
	}

	public String getPackageName() {
		return packageName;
	}

	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}

	public String getPackageDescription() {
		return packageDescription;
	}

	public void setPackageDescription(String packageDescription) {
		this.packageDescription = packageDescription;
	}

	public String getPackageType() {
		return packageType;
	}

	public void setPackageType(String packageType) {
		this.packageType = packageType;
	}

	public double getPackageCost() {
		return packageCost;
	}

	public void setPackageCost(double packageCost) {
		this.packageCost = packageCost;
	}

	public PaymentDetails getPaymetnDetails() {
		return paymetnDetails;
	}

	public void setPaymetnDetails(PaymentDetails paymetnDetails) {
		this.paymetnDetails = paymetnDetails;
	}

	public List<Booking> getBookings() {
		return bookings;
	}

	public void setBookings(List<Booking> bookings) {
		this.bookings = bookings;
	}

	public List<TicketDetails> getTicket() {
		return ticket;
	}

	public void setTicket(List<TicketDetails> ticket) {
		this.ticket = ticket;
	}

	public List<Hotel> getHotels() {
		return hotels;
	}

	public void setHotels(List<Hotel> hotels) {
		this.hotels = hotels;
	}

	@NotNull(message = "Package name is mandatory")
	private String packageName;
	
	@NotNull(message = "Package description is mandatory")
	private String packageDescription;
	
	@NotNull(message = "Package type is mandatory")
	private String packageType;
	
	@NotNull(message = "Package cost is mandatory")
	private double packageCost;
	

	@OneToOne(cascade = CascadeType.ALL)
	@JsonIgnore
	private PaymentDetails paymetnDetails;
	
	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL)
	private List<Booking> bookings = new ArrayList<>();
	
	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL)
	private List<TicketDetails> ticket = new ArrayList<>();
	
	@JsonIgnore
	@ManyToMany(cascade = CascadeType.ALL)
	private List<Hotel> hotels;
	

}
