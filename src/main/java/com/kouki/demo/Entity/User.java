package com.kouki.demo.Entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.sun.istack.NotNull;

@Entity
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id")
	private int id;
	//@Column(length = 158 , nullable = false , unique = true)
	private String username;
	@JsonIgnore
	@NotNull
	private String password;
	private String tel;
	//@Column(length = 158 , nullable = false , unique = true)
	private String email;
	private String status;
	private String codePostale;
	private String ville;
	private String pays;
	private String photoUser;
	private String addIp;

	
	@OneToMany(mappedBy = "user",cascade  = {CascadeType.ALL, CascadeType.MERGE})
	@JsonManagedReference
	private Set<CaffeUserRoles> caffeUserRoles=new HashSet<>();

	public User(int id, String username, String password, String tel, String email, String status, String codePostale,
			String ville, String pays, String photoUser, String addIp, Set<CaffeUserRoles> caffeUserRoles) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.tel = tel;
		this.email = email;
		this.status = status;
		this.codePostale = codePostale;
		this.ville = ville;
		this.pays = pays;
		this.photoUser = photoUser;
		this.addIp = addIp;
		this.caffeUserRoles = caffeUserRoles;
	}

	public User() {
		super();
	}
	public User(int id) {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getCodePostale() {
		return codePostale;
	}

	public void setCodePostale(String codePostale) {
		this.codePostale = codePostale;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public String getPays() {
		return pays;
	}

	public void setPays(String pays) {
		this.pays = pays;
	}

	public String getPhotoUser() {
		return photoUser;
	}

	public void setPhotoUser(String photoUser) {
		this.photoUser = photoUser;
	}

	public String getAddIp() {
		return addIp;
	}

	public void setAddIp(String addIp) {
		this.addIp = addIp;
	}

	
	public Set<CaffeUserRoles> getCaffeUserRoles() {
		return caffeUserRoles;
	}

	public void setCaffeUserRoles(Set<CaffeUserRoles> caffeUserRoles) {
		this.caffeUserRoles = caffeUserRoles;
	}

	public void addCaffeUserRoles(CaffeUserRoles caffeUserRoles) {
		this.caffeUserRoles.add(caffeUserRoles);
	}
	
	public void removeCaffeUserRoles() {
		this.caffeUserRoles.clear();
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", tel=" + tel + ", email="
				+ email + ", status=" + status + ", codePostale=" + codePostale + ", ville=" + ville + ", pays=" + pays
				+ ", photoUser=" + photoUser + ", addIp=" + addIp + ", caffeUserRoles=" + caffeUserRoles + "]";
	}
	



	
}
