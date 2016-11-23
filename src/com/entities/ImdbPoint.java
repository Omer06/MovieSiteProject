package com.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name = "imdbPoint")
public class ImdbPoint {

	private int id;
	private String point;

	public ImdbPoint() {
	}

	public ImdbPoint(int id, String point) {
		super();
		this.id = id;
		this.point = point;
	}

	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPoint() {
		return point;
	}

	public void setPoint(String point) {
		this.point = point;
	}



}
