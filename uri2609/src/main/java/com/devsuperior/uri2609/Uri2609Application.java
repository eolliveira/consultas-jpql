package com.devsuperior.uri2609;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.devsuperior.uri2609.dto.CategorySumDTO;
import com.devsuperior.uri2609.projections.CategorySumProjection;
import com.devsuperior.uri2609.repositories.CategoryRepository;

@SpringBootApplication
public class Uri2609Application implements CommandLineRunner {

	@Autowired
	private CategoryRepository repository;
	
	public static void main(String[] args) {
		SpringApplication.run(Uri2609Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		System.out.println(" \n Consulta SQL Raiz: ");
		
		List<CategorySumProjection> list = repository.quantityPerCategory();
		List<CategorySumDTO> list2 = list.stream().map(x -> new CategorySumDTO(x)).collect(Collectors.toList());
		
		for(CategorySumDTO x : list2) {
			System.out.println(x);
		}
		
		
		System.out.println(" \n Consulta JPQL: ");
		
		List<CategorySumDTO> list3 = repository.quantityPerCategoryJpql();
		
		for(CategorySumDTO x : list3) {
			System.out.println(x);
		}
		
		
	}
}
