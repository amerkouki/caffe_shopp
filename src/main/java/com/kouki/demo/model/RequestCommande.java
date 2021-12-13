package com.kouki.demo.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class RequestCommande {

	
	
	
	private String cmntrCmd;
	private String lieuLivraison;
	//private int idCaffe;
	private int idUser;
	private int[]produits;
	
	
	
	public RequestCommande( String cmntrCmd, String lieuLivraison, int idCaffe,int idUser,
			int[] produits) {
		super();
		this.cmntrCmd = cmntrCmd;
		this.lieuLivraison = lieuLivraison;
		//this.idCaffe = idCaffe;
		this.idUser = idUser;
		this.produits = produits;
	}



	public RequestCommande() {
		super();
	}





	



	public String getCmntrCmd() {
		return cmntrCmd;
	}



	public void setCmntrCmd(String cmntrCmd) {
		this.cmntrCmd = cmntrCmd;
	}



	public String getLieuLivraison() {
		return lieuLivraison;
	}



	public void setLieuLivraison(String lieuLivraison) {
		this.lieuLivraison = lieuLivraison;
	}






	


	public int[] getProduits() {
		return produits;
	}



	public void setProduits(int[] produits) {
		this.produits = produits;
	}



	public int getIdUser() {
		return idUser;
	}



	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

	
	
}
