package com.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity(name = "category")
public class Category {

	private int id;
	private String name;
	private List movieList = new ArrayList<>();

	public Category() {
		
	}
	
	public Category (int id) {
		this.id = id;
	}

	public Category(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name = "name" , unique = true)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Transient
	public List getMovieList() {
		return movieList;
	}
	
	public void setMovieList(List movieList) {
		this.movieList = movieList;
	}
	
}
