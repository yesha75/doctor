package com.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.entity.DoctorEntity;

public interface DoctorRepo extends JpaRepository<DoctorEntity, Integer> 
{

	DoctorEntity findByDoctorNameAndPassword(String doctorName, String password);

}

