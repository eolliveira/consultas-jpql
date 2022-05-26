package com.devsuperior.uri2611.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.devsuperior.uri2611.entities.Movie;
import com.devsuperior.uri2611.projections.MovieFullProjection;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {

	
	@Query(nativeQuery = true, value = "SELECT "
			+ "m.id, "
			+ "m.name "
			+ "FROM movies m "
			+ "JOIN genres g ON m.id_genres = g.id "
			+ "WHERE UPPER(g.description) = UPPER(:genre)")
	List<MovieFullProjection> filmsByGenre(String genre);
	
	
}
