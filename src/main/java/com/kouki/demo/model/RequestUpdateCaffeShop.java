package com.kouki.demo.model;

import java.util.Date;

public class RequestUpdateCaffeShop {

	private int id;
	private String name;
	private String addresse;
	private String tel;
	private String ville;
	private String etat;
	private Date dateOuverture;
	private Date dateFermetture;
	
	
	
	private String description;
	private String codePostal;
	private String email;
	public RequestUpdateCaffeShop(int id, String name, String addresse, String tel, String ville, String etat,
			Date dateOuverture, Date dateFermetture, String imageCaffeSop, String description,
			String codePostal, String email) {
		super();
		this.id = id;
		this.name = name;
		this.addresse = addresse;
		this.tel = tel;
		this.ville = ville;
		this.etat = etat;
		this.dateOuverture = dateOuverture;
		this.dateFermetture = dateFermetture;
		//ImageCaffeSop = imageCaffeSop;
		//this.dateCreation = dateCreation;
		this.description = description;
		this.codePostal = codePostal;
		this.email = email;
	}
	public RequestUpdateCaffeShop() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddresse() {
		return addresse;
	}
	public void setAddresse(String addresse) {
		this.addresse = addresse;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getVille() {
		return ville;
	}
	public void setVille(String ville) {
		this.ville = ville;
	}
	public String getEtat() {
		return etat;
	}
	public void setEtat(String etat) {
		this.etat = etat;
	}
	public Date getDateOuverture() {
		return dateOuverture;
	}
	public void setDateOuverture(Date dateOuverture) {
		this.dateOuverture = dateOuverture;
	}
	public Date getDateFermetture() {
		return dateFermetture;
	}
	public void setDateFermetture(Date dateFermetture) {
		this.dateFermetture = dateFermetture;
	}

	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getCodePostal() {
		return codePostal;
	}
	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
	
}
