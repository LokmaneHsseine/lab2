package com.example.demo;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import com.example.demo.entities.Patient;
import com.example.demo.repositories.PatientRepository;

@SpringBootApplication
public class TpJpaHsseineApplication implements CommandLineRunner {
	
	@Autowired
	private PatientRepository patientRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(TpJpaHsseineApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		patientRepository.save(new Patient(null,"Lokmane", new Date(), 1234, true));
		patientRepository.save(new Patient(null,"Hitler", new Date(), 9999, false));
		patientRepository.save(new Patient(null,"Iron man", new Date(), 8789, true));
		patientRepository.save(new Patient(null,"King Kong", new Date(), 0001, false));
		
		System.out.println("***********************************");
		patientRepository.findAll().forEach(p->{
			System.out.println(p.toString());
		});
		
		System.out.println("***********************************");
		Patient patient = patientRepository.findById(4L).get();
		System.out.println(patient.toString());
		
		
		System.out.println("***********************************");
		List<Patient> patients = patientRepository.findByNomContains("L");
		patients.forEach(p->{
			System.out.println(p.toString());
		});
		
		
		System.out.println("***********************************");
		List<Patient> patients2 = patientRepository.findByMalade(true);
		patients2.forEach(p->{
			System.out.println(p.toString());
		});
		
		
		System.out.println("***********************************");
		List<Patient> patients3 = patientRepository.findByNomContainsAndMalade("H", false);
		patients3.forEach(p->{
			System.out.println(p.toString());
		});
		
		patientRepository.deleteById(3L);
		
		
		System.out.println("***********************************");
		Page<Patient> pagepatients = patientRepository.findAll(PageRequest.of(0, 2));
		System.out.println("Nombre de Page"+pagepatients.getTotalPages());
		List<Patient> listpatient = pagepatients.getContent();
		listpatient.forEach(p->{
			System.out.println(p.toString());
		});
	}

}
