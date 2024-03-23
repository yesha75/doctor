package com.Dto;

public class PatientDto {
	private Integer patient_id;
	private String patientName;
	private String password;
	
	
	public Integer getPatient_id() {
		return patient_id;
	}
	public void setPatient_id(Integer patient_id) {
		this.patient_id = patient_id;
	}
	public String getPatientName() {
		return patientName;
	}
	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

}
