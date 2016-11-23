package com.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.codehaus.jackson.annotate.JsonBackReference;

@Entity(name = "comment")
public class Comment {

	private int id;
	private String audienceName;
	private String comment;
	private Date date;
	
	public Comment() { }
	
	public Comment(String audienceName, String comment , Movie movie) {
		super();
		this.audienceName = audienceName;
		this.comment = comment;
	}

	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAudienceName() {
		return audienceName;
	}

	public void setAudienceName(String audienceName) {
		this.audienceName = audienceName;
	}

	@Temporal(TemporalType.DATE)
	public Date getDate() {
		if(date == null)
			return new Date();
		
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
	public String getComment() {
		return comment;
	}
	
	public void setComment(String comment) {
		this.comment = comment;
	}
}
