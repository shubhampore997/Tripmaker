package com.tripmaker.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CurrentAdmin {

	@Id
	private Integer userId;
	private String UserType;
	private LocalDateTime localDateTime;
	
	
	public CurrentAdmin(Integer userId, String userType, LocalDateTime localDateTime, String uuid) {
		super();
		this.userId = userId;
		UserType = userType;
		this.localDateTime = localDateTime;
		this.uuid = uuid;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUserType() {
		return UserType;
	}

	public void setUserType(String userType) {
		UserType = userType;
	}

	public LocalDateTime getLocalDateTime() {
		return localDateTime;
	}

	public void setLocalDateTime(LocalDateTime localDateTime) {
		this.localDateTime = localDateTime;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	@Column(unique = true)
	private String uuid;
}
