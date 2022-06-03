package com.devsuperior.uri2737;

import com.devsuperior.uri2737.dto.LawyerMinDTO;
import com.devsuperior.uri2737.projections.LawyerMinProjection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.devsuperior.uri2737.repositories.LawyerRepository;

import java.util.List;
import java.util.stream.Collectors;

@SpringBootApplication
public class Uri2737Application implements CommandLineRunner {

	@Autowired
	private LawyerRepository repository;
	
	public static void main(String[] args) {
		SpringApplication.run(Uri2737Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		System.out.println("Consulta SQL Raiz: \n");

		List<LawyerMinProjection> list = repository.lawyersReport1();
		List<LawyerMinDTO> list1 = list.stream().map(x -> new LawyerMinDTO(x)).collect(Collectors.toList());

		for(LawyerMinDTO l : list1) {
			System.out.println(l);
		}

	}
}
