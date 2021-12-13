package com.kouki.demo.model;

import java.util.Date;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.kouki.demo.Entity.CaffeShop;

public class RequestCategorie {

	private int id;
	private String nameCategorie;
	private String description;
	private Date dateAjout;
	//caffe qui ajout cette categorie
	private CaffeShop caffe;
	
	public RequestCategorie(int id, String nameCategorie, String description, Date dateAjout, int idcaffe) {
		
		this.id = id;
		this.nameCategorie = nameCategorie;
		this.description = description;
		this.dateAjout = dateAjout;
		this.caffe = new CaffeShop();
		this.caffe.setId(idcaffe);
	}

	public RequestCategorie() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNameCategorie() {
		return nameCategorie;
	}

	public void setNameCategorie(String nameCategorie) {
		this.nameCategorie = nameCategorie;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getDateAjout() {
		return dateAjout;
	}

	public void setDateAjout(Date dateAjout) {
		this.dateAjout = dateAjout;
	}

	public CaffeShop getCaffe() {
		return caffe;
	}

	public void setCaffe(CaffeShop caffe) {
		this.caffe = caffe;
	}
	
	
	
}
