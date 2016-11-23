package com.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name = "language")
public class Language {

	private int id;
	private String movieLanguage;

	public Language() { }

	public Language(int id, String movieLanguage) {
		super();
		this.id = id;
		this.movieLanguage = movieLanguage;
	}

	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMovieLanguage() {
		return movieLanguage;
	}

	public void setMovieLanguage(String movieLanguage) {
		this.movieLanguage = movieLanguage;
	}

}
