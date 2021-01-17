package com.spring.mvc.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Entity
@Table(name="ratings")
public class Rating {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Min(1)
	@Max(5)
	private Double rating;
	
    @Column(updatable=false)
    private Date createdAt;
    private Date updatedAt;

	@PrePersist
	protected void onCreate() {
		this.createdAt = new Date();
	}
	@PreUpdate
	protected void onUpdate() {
		this.updatedAt = new Date();
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="user_id")
	private User user;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="show_id")
	private Show show;
	
	//Constructors
	public Rating() {
	}	
	
	public Rating(Double rating, User user, Show show) {
		this.rating = rating;
		this.user = user;
		this.show = show;
	}

	//Getters
	public Long getId() {
		return id;
	}
	public Double getRating() {
		return rating;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public Date getUpdatedAt() {
		return updatedAt;
	}
	public User getUser() {
		return user;
	}
	public Show getShow() {
		return show;
	}
	
	//Setters
	public void setId(Long id) {
		this.id = id;
	}
	public void setRating(Double rating) {
		this.rating = rating;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public void setShow(Show show) {
		this.show = show;
	}
}
