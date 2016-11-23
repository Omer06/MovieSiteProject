package com.entities;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.codehaus.jackson.annotate.JsonManagedReference;

@Entity(name = "movie")
public class Movie {

	private int id;
	private String title;
	private String name;
	private String subject;
	private int hit;
	private Collection<Category> categoryList = new ArrayList<Category>();
	private List<Comment> commentList = new ArrayList<Comment>();
	private ImdbPoint imdbPoint;
	private Director director;
	private Language language;
	private int releaseDate;
	private Date loadingDate;
	private String embedPath;
	private String posterPath;

	public Movie() {
	}
	
	

	public Movie(int id, String title, String name, String subject, int hit, Collection<Category> categoryList,
			ImdbPoint imdbPoint, Director director, Language language, int releaseDate, Date loadingDate,
			String embedPath, String posterPath) {
		super();
		this.id = id;
		this.title = title;
		this.name = name;
		this.subject = subject;
		this.hit = hit;
		this.categoryList = categoryList;
		this.imdbPoint = imdbPoint;
		this.director = director;
		this.language = language;
		this.releaseDate = releaseDate;
		this.loadingDate = loadingDate;
		this.embedPath = embedPath;
		this.posterPath = posterPath;
	}



	public Movie(String title, String name, String subject, int hit, int releaseDate, String embedPath,
			String posterPath) {
		super();
		this.title = title;
		this.name = name;
		this.subject = subject;
		this.hit = hit;
		this.releaseDate = releaseDate;
		this.embedPath = embedPath;
		this.posterPath = posterPath;
	}

	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "subject" ,length = 600)
	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public int getHit() {
		return hit;
	}

	public void setHit(int hit) {
		this.hit = hit;
	}

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "movie_category", 
	joinColumns = @JoinColumn(name = "movie_id"), 
	inverseJoinColumns = @JoinColumn(name = "category_id"))
	public Collection<Category> getCategoryList() {
		return categoryList;
	}

	public void setCategoryList(Collection<Category> categoryList) {
		this.categoryList = categoryList;
	}

	@OneToOne
	@JoinTable(name = "movie_imdbPoint",
	joinColumns = @JoinColumn(name = "movie_id"), 
	inverseJoinColumns = @JoinColumn(name = "imdbPoint_id"))
	public ImdbPoint getImdbPoint() {
		return imdbPoint;
	}

	public void setImdbPoint(ImdbPoint imdbPoint) {
		this.imdbPoint = imdbPoint;
	}

	@OneToOne
	@JoinTable(name = "movie_director", joinColumns = @JoinColumn(name = "movie_id"), inverseJoinColumns = @JoinColumn(name = "director_id"))
	public Director getDirector() {
		return director;
	}

	public void setDirector(Director director) {
		this.director = director;
	}

	public int getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(int releaseDate) {
		this.releaseDate = releaseDate;
	}

	@Temporal(TemporalType.DATE)
	public Date getLoadingDate() {
		if (loadingDate == null)
			return new Date();

		return loadingDate;
	}

	public void setLoadingDate(Date loadingDate) {
		this.loadingDate = loadingDate;
	}

	public String getEmbedPath() {
		return embedPath;
	}

	public void setEmbedPath(String embedPath) {
		this.embedPath = embedPath;
	}

	public String getPosterPath() {
		return posterPath;
	}

	public void setPosterPath(String posterPath) {
		this.posterPath = posterPath;
	}
	
	@OneToOne
	@JoinTable(name = "movie_language", joinColumns = @JoinColumn(name = "movie_id"), inverseJoinColumns = @JoinColumn(name = "language_id"))
	public Language getLanguage() {
		return language;
	}
	
	public void setLanguage(Language language) {
		this.language = language;
	}
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "movie_comment" , 
	joinColumns = @JoinColumn(name = "movie_id"),
	inverseJoinColumns = @JoinColumn(name = "comment_id"))
	public List<Comment> getCommentList() {
		return commentList;
	}
	
	public void setCommentList(List<Comment> commentList) {
		this.commentList = commentList;
	}
}
