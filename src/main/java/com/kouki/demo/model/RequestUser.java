package com.kouki.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;

public class RequestUser {

	
	private String username;
	private String password;
	private String tel;
	private String email;
	private String status;
	private String codePostale;
	private String ville;
	private String pays;
	private String photoUser;
	private String addIp;
	
	public RequestUser(String username, String password, String tel, String email, String status, String codePostale,
			String ville, String pays, String photoUser, String addIp) {
		super();
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
		
	}
	public RequestUser() {
		super();
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
}
