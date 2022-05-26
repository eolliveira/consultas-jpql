package com.devsuperior.uri2611.dto;

import com.devsuperior.uri2611.projections.MovieFullProjection;

public class MovieFullDTO {

	private Long id;
	private String name;
	
	public MovieFullDTO() {}
	
	public MovieFullDTO(Long id, String name) {
		this.id = id;
		this.name = name;
	}
	
	public MovieFullDTO(MovieFullProjection mfp) {
		this.id = mfp.getId();
		this.name = mfp.getName();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "MovieFullDTO [id=" + id + ", name=" + name + "]";
	}
	
}
