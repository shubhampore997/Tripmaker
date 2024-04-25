
package com.tripmaker.model;

import javax.persistence.Column;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class CustomerSigninDTO {
	@NotNull(message = "Name cannot be null")
	private String customerName;
	
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Email(message="Enter your Email properly")
	@NotNull(message = "Email is mandatory")
	private String email;
	private String address;
	@Column(unique = true)
	@Size(max = 10,min = 10)
	@NotNull(message = "Mobile is mandatory")
	private String mobile;
	@NotNull(message = "Password is mandatory")
	private String password;

}