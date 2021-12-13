package com.kouki.demo.model;

public class RequestUserRole {

	private int idUser;
	private int idRole;
	
	public RequestUserRole(int idUser, int idRole) {
		super();
		this.idUser = idUser;
		this.idRole = idRole;
	}

	public RequestUserRole() {
		super();
	}

	public int getIdUser() {
		return idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

	public int getIdRole() {
		return idRole;
	}

	public void setIdRole(int idRole) {
		this.idRole = idRole;
	}
	
	
	
}
