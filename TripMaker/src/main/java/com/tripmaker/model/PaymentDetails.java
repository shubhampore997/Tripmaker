package com.tripmaker.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PaymentDetails {
	

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Integer paymentId;
	
	
	public Integer getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(Integer paymentId) {
		this.paymentId = paymentId;
	}

	public String getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}

	public LocalDate getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(LocalDate paymentDate) {
		this.paymentDate = paymentDate;
	}

	public Package getPackageDetails() {
		return packageDetails;
	}

	public void setPackageDetails(Package packageDetails) {
		this.packageDetails = packageDetails;
	}

	@NotNull(message = "Payment Type is mandatory")
	@NotEmpty(message = "Payment Type is mandatory")
	@Size(min = 5, max = 50, message = "Description should be of 5-50 charecters")
	@Pattern(regexp = "^[A-Z][a-z]*", message = "Only alphabets are allowed")
	private String paymentType;
	
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyyy")
	private LocalDate paymentDate;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Package packageDetails;
	

}