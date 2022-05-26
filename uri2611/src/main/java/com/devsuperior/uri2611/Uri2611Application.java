package com.devsuperior.uri2611;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.devsuperior.uri2611.dto.MovieFullDTO;
import com.devsuperior.uri2611.projections.MovieFullProjection;
import com.devsuperior.uri2611.repositories.MovieRepository;

@SpringBootApplication
public class Uri2611Application implements CommandLineRunner {
	
	@Autowired
	private MovieRepository repository;
	
	public static void main(String[] args) {
		SpringApplication.run(Uri2611Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		System.out.println(" \nConsulta SQL Raiz: \n");
		
		List<MovieFullProjection> list = repository.filmsByGenre("Action");
		List<MovieFullDTO> listDto = list.stream().map(m -> new MovieFullDTO(m)).collect(Collectors.toList());
		
		for(MovieFullDTO m : listDto) {
			System.out.println(m);
		}
		
		
		
		System.out.println(" \nConsulta JPQL: \n");
		
		List<MovieFullDTO> list2 = repository.filmsByGenreJpql("Action");
		
		for(MovieFullDTO m : list2) {
			System.out.println(m);
		}
		
	}
}
