package com.devsuperior.uri2602;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.devsuperior.uri2602.dto.CustomerMinDTO;
import com.devsuperior.uri2602.projections.CustomerMinProjection;
import com.devsuperior.uri2602.repositories.CustomersRepository;

@SpringBootApplication
public class Uri2602Application implements CommandLineRunner {

	@Autowired
	private CustomersRepository repository;
	
	public static void main(String[] args) {
		SpringApplication.run(Uri2602Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		System.out.println(" \nConsulta SQL Raiz: \n");
		
		List<CustomerMinProjection> list = repository.CustomersByState("RS");
		List<CustomerMinDTO> listDto = list.stream().map(c -> new CustomerMinDTO(c)).collect(Collectors.toList());
		
		for(CustomerMinDTO c : listDto) {
			System.out.println(c);
		}
		
		
		System.out.println(" \nConsulta JPQL: \n");
		
		List<CustomerMinDTO> list2 = repository.CustomersByStateJpql("RS");
		
		for(CustomerMinDTO c : list2) {
			System.out.println(c);
		}
		
	
	}
}
