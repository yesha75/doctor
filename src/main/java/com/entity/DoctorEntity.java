package com.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="doctor")
public class DoctorEntity 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer doctor_id;
	private String doctorName;
    private String password;
	public Integer getDoctor_id() {
		return doctor_id;
	}
	public void setDoctor_id(Integer doctor_id) {
		this.doctor_id = doctor_id;
	}
	
	public String getDoctorName() {
		return doctorName;
	}
	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
