package com.tripmaker.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//Yedhu Nanthan.S
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Admin {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer adminId;
	private String adminName;
	private String email;
	private String password;
	private String mobial;
	
	public Integer getAdminId() {
		return adminId;
	}

	public void setAdminId(Integer adminId) {
		this.adminId = adminId;
	}

	public String getAdminName() {
		return adminName;
	}

	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMobial() {
		return mobial;
	}

	public void setMobial(String mobial) {
		this.mobial = mobial;
	}

	public Set<Report> getReports() {
		return reports;
	}

	public void setReports(Set<Report> reports) {
		this.reports = reports;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL)
	private Set<Report> reports = new HashSet<>();
	@JsonIgnore
	@ManyToOne(cascade =  CascadeType.ALL)
	private User user;

	public Admin(String adminName, String email, String password, String mobial) {
		super();
		this.adminName = adminName;
		this.email = email;
		this.password = password;
		this.mobial = mobial;
		this.reports = new HashSet<>();
		this.user = null;
	}
	
	
}
