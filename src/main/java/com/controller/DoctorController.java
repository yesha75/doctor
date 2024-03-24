package com.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import com.Dto.PatientDto;
import com.entity.DoctorEntity;
import com.repository.DoctorRepo;

import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/doctor")
public class DoctorController 
{
	@Autowired
	DoctorRepo doctorRepo;
	
	@Value("${google.patient.url}")
	String patientUrl;
	
	@GetMapping("/new")
	public ResponseEntity<?> newDoc()
	{
		System.out.println("new doc");
		return ResponseEntity.ok("new");
	}
	
	  @PostMapping("/add")
	    public ResponseEntity<DoctorEntity> addDoctor(@RequestBody DoctorEntity doctorEntity) {
	        doctorRepo.save(doctorEntity);
	        return ResponseEntity.ok(doctorEntity);
	    }

	    @GetMapping("/list")
	    public ResponseEntity<List<DoctorEntity>> listDoctors() {
	        List<DoctorEntity> doctorEntities = doctorRepo.findAll();
	        return ResponseEntity.ok(doctorEntities);
	    }

	    @GetMapping("/{doctorId}")
	    public ResponseEntity<Optional<DoctorEntity>> getDoctorById(@PathVariable Integer doctorId) {
	        Optional<DoctorEntity> doctorEntity = doctorRepo.findById(doctorId);
	        if (doctorEntity.isPresent()) {
	            return ResponseEntity.ok(doctorEntity);
	        } else {
	            return ResponseEntity.notFound().build();
	        }
	    }
	    
	    @PostMapping("/login")
		public ResponseEntity<?> loginPatient(@RequestBody DoctorEntity doctorEntity) {
		    DoctorEntity doc = doctorRepo.findByDoctorNameAndPassword(doctorEntity.getDoctorName(), doctorEntity.getPassword());
		    if (doc != null) {
		        return ResponseEntity.ok(doc);
		    } else {
		        return ResponseEntity.badRequest().body("Invalid username or password");
		    }
		}
	    
	    //@PutMapping("/patient/{patientId}")
//	    public ResponseEntity<?> updatePatientDetails(@PathVariable Integer patientId, @RequestBody PatientDto updatedPatientDto) {
//	        Optional<PatientEntity> patientOptional = pr.findById(patientId);
//	        if (patientOptional.isPresent()) {
//	            PatientEntity patient = patientOptional.get();
//	            
//	            // Update patient details
//	            if (updatedPatientDto.getMedicines() != null) {
//	                patient.setMedicines(updatedPatientDto.getMedicines());
//	            }
//	            if (updatedPatientDto.getDisease() != null) {
//	                patient.setDisease(updatedPatientDto.getDisease());
//	            }
//	            
//	            // Add more fields to update as needed
//	            
//	            // Save the updated patient
//	            pr.save(patient);
//	            
//	            return ResponseEntity.ok("Patient details updated successfully");
//	        } else {
//	            return ResponseEntity.notFound().build();
//	        }
//	    }
	    
	    @PutMapping("/update/{patient_id}")
	    public ResponseEntity<?> updateDetails(@PathVariable("patient_id") Integer id,@RequestBody PatientDto updatedPatient)
	    {
//	    	WebClient webClient = WebClient.create(patientUrl);
//
//			Flux<PatientDto> myObjectsFlux = webClient.get().uri("/patient/{patient_id}",id).accept(MediaType.APPLICATION_JSON)
//					.retrieve().bodyToFlux(PatientDto.class);
//
//			System.out.print("hello");
//			            WebClient.ResponseSpec responseSpec = webClient.put()
//			                    .uri("/patient/{patient_id}",id)
//			                    .bodyValue(updatedPatient)
//			                    .retrieve();
//					System.out.print(responseSpec);
//			            return ResponseEntity.ok(updatedPatient);
	    	
	    	RestTemplate restTemplate = new RestTemplate();

	        // Set the request headers
	        HttpHeaders headers = new HttpHeaders();
	        headers.setContentType(MediaType.APPLICATION_JSON);

	        // Create the request entity with updated patient data and headers
	        HttpEntity<PatientDto> requestEntity = new HttpEntity<>(updatedPatient, headers);

	        // Make the PUT request to update the patient
	        ResponseEntity<String> response = restTemplate.exchange(
	                patientUrl + "/patient/" + id,
	                HttpMethod.PUT,
	                requestEntity,
	                String.class);

	        // Check the response status and return appropriate response
	        if (response.getStatusCode().is2xxSuccessful()) {
	            return ResponseEntity.ok("Patient details updated successfully");
	        } else {
	            return ResponseEntity.status(response.getStatusCode()).body("Failed to update patient details");
	        }
			    }
	    
	    @GetMapping("/patient/{patientName}")
	    public ResponseEntity<?> getPatientDetailsByName(@PathVariable("patientName") String patientName) {
	    	WebClient webClient = WebClient.create(patientUrl);

			Flux<PatientDto> myObjectsFlux = webClient.get().uri("/patient/name/{patientName}",patientName).accept(MediaType.APPLICATION_JSON)
					.retrieve().bodyToFlux(PatientDto.class);

			// Now you can collect these objects into a list if needed
			List<PatientDto> patients = myObjectsFlux.collectList().block();
			if (patients != null) {
		        Map<String, Object> response = new HashMap<>();
		        response.put("data", patients);
		        return ResponseEntity.ok(response);
		    } else {
		        return ResponseEntity.notFound().build();
		    }

	    }

	    
	    @GetMapping("/all")
		public ResponseEntity<?> getAllProjects() {

			WebClient webClient = WebClient.create(patientUrl);

			Flux<PatientDto> myObjectsFlux = webClient.get().uri("/patient/listpatient").accept(MediaType.APPLICATION_JSON)
					.retrieve().bodyToFlux(PatientDto.class);

			// Now you can collect these objects into a list if needed
			List<PatientDto> projects = myObjectsFlux.collectList().block();

			HashMap<String, Object> hm = new HashMap<>();

			hm.put("data", projects);
			return ResponseEntity.ok(hm); // all projects

		}
}
