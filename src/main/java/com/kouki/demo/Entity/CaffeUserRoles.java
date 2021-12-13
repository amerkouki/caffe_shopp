package com.kouki.demo.Entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class CaffeUserRoles {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	@JoinColumn(name="caffe_id")
	@JsonBackReference
	private CaffeShop caffe;
	
	@ManyToOne(cascade = {CascadeType.ALL},fetch=FetchType.LAZY)
	@JoinColumn(name="user_id")
	@JsonBackReference
	private User user;
	
	
	@ManyToOne(cascade = {CascadeType.PERSIST , CascadeType.MERGE})
	@JoinColumn(name="role_id")
	//@JsonBackReference
	private Roles role;


	public CaffeUserRoles(int id, CaffeShop caffe, User user, Roles role) {
		super();
		this.id = id;
		this.caffe = caffe;
		this.user = user;
		this.role = role;
	}


	public CaffeUserRoles(int id, int caffeId, int userId, int roleId) {
		super();
		this.id = id;
		this.caffe = new CaffeShop(caffeId);
		this.user = new User(userId);
		this.role = new Roles(roleId);
	}
	public CaffeUserRoles(int caffeId, int userId, int roleId) {
		super();
		this.id = id;
		this.caffe = new CaffeShop(caffeId);
		this.user = new User(userId);
		this.role = new Roles(roleId);
	}
	


	public CaffeUserRoles() {
		super();
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public CaffeShop getCaffe() {
		return caffe;
	}


	public void setCaffe(CaffeShop caffe) {
		this.caffe = caffe;
	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


	public Roles getRole() {
		return role;
	}


	public void setRole(Roles role) {
		this.role = role;
	}
	
	
	
	
	
}
