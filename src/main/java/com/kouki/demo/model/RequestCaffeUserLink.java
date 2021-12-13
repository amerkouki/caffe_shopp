package com.kouki.demo.model;

public class RequestCaffeUserLink {

	private RequestUserRole[] caffeUserRole;
	private int idCaffe;
	
	public RequestCaffeUserLink(RequestUserRole[] caffeUser,int idCaffe) {
		super();
		this.caffeUserRole = caffeUser;
		this.idCaffe=idCaffe;
	}

	public RequestCaffeUserLink() {
		super();
	}

	public RequestUserRole[] getCaffeUserRole() {
		return caffeUserRole;
	}

	public void setCaffeUserRole(RequestUserRole[] caffeUser) {
		this.caffeUserRole = caffeUser;
	}

	public int getIdCaffe() {
		return idCaffe;
	}

	public void setIdCaffe(int idCaffe) {
		this.idCaffe = idCaffe;
	}
	
	
	
}
