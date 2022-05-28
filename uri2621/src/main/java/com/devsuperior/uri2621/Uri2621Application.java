package com.devsuperior.uri2621;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.devsuperior.uri2621.dto.ProductMinDTO;
import com.devsuperior.uri2621.projections.ProductMinProjetion;
import com.devsuperior.uri2621.repositories.ProductRepository;

@SpringBootApplication
public class Uri2621Application implements CommandLineRunner {

	@Autowired
	private ProductRepository repository;
	
	public static void main(String[] args) {
		SpringApplication.run(Uri2621Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
	
		
		System.out.println("\n Consulta Raiz SQL: \n");
		
		List<ProductMinProjetion> listProductMinProjetions = repository.productByQuantityAndSupplier(10, 20, "P");
		List<ProductMinDTO> listProductMinDTO = listProductMinProjetions.stream().map(p -> new ProductMinDTO(p)).collect(Collectors.toList());
		
		for(ProductMinDTO p : listProductMinDTO) {
			System.out.println(p);
		}
		
		
		
		System.out.println("\n Consulta JPQL: \n");
		
		List<ProductMinDTO> listProductMinDTO2 = repository.productByQuantityAndSupplierJpql(10, 20, "P");
		
		for(ProductMinDTO p : listProductMinDTO2) {
			System.out.println(p);
		}
		
		
	}
}
