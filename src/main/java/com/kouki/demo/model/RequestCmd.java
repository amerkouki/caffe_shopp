package com.kouki.demo.model;

public class RequestCmd {


	private String cmntrCmd;
	private String lieuLivraison;
	//private int idCaffe;
	//private int idUser;
	private int[]produits;
	
	
	public RequestCmd(String cmntrCmd, String lieuLivraison, int[] produits) {
		super();
		this.cmntrCmd = cmntrCmd;
		this.lieuLivraison = lieuLivraison;
		this.produits = produits;
	}
	public RequestCmd() {
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
	
	
	
	
}
