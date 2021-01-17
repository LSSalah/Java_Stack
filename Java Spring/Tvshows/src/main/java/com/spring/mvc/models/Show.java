package com.spring.mvc.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="shows")
public class Show {

	//Attributes
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Size(min=4, max=60, message="Title must be more than 3 characters!")
	@NotBlank(message="Title cannot be empty!")
	private String title;
	
	@Size(min=1, max=60, message="Network must be more than 1 character!")
	@NotBlank(message="Network cannot be empty!")
	private String network;
	
	@FutureOrPresent	
	@DateTimeFormat(pattern="yyyy-mm-dd")
	private Date date;
	
	
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
	
	//Relationships
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(
		name = "users_shows",
		joinColumns = @JoinColumn(name = "show_id"),
		inverseJoinColumns = @JoinColumn(name = "user_id")
	)
	private List<User> joinedUsers;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="user_id")
	private User user;
	
	@OneToMany(mappedBy="show", fetch = FetchType.LAZY)
	private List<Rating> ratings;
	
    
	//Constructors
    public Show() {
    }
    
    //Getters
	public Long getId() {
		return id;
	}
	public String getTitle() {
		return title;
	}
	public Date getDate() {
		return date;
	}
	
	public Date getCreatedAt() {
		return createdAt;
	}
	public Date getUpdatedAt() {
		return updatedAt;
	}
	public List<User> getJoinedUsers() {
		return joinedUsers;
	}
	public User getUser() {
		return user;
	}
	public List<Rating> getRatings() {
		return ratings;
	}
	
	
	//Setters
	public void setId(Long id) {
		this.id = id;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getNetwork() {
		return network;
	}
	public void setNetwork(String network) {
		this.network = network;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
	public void setJoinedUsers(List<User> joinedUsers) {
		this.joinedUsers = joinedUsers;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public void setRatings(List<Rating> ratings) {
		this.ratings = ratings;
	}
	
}