package com.kouki.demo.Entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Categorie {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nameCategorie;
	private String description;
	private Date dateAjout;
	//caffe qui ajout cette categorie
	@ManyToOne
	@JoinColumn(name ="caffe_id")
	private CaffeShop caffe;
	
	
	public Categorie(int id, String name, String description,int vendeur) {
		super();
		this.id = id;
		this.nameCategorie = name;
		this.description = description;
		this.caffe=new CaffeShop(vendeur);
		this.dateAjout = new Date();
	}
	public Categorie() {
		super();
		this.dateAjout=new Date();
	}
	public Categorie(int id) {
		super();
		this.id=id;
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
	public void setNameCategorie(String name) {
		this.nameCategorie = name;
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
	
	@Override
	public String toString() {
		return "Categorie [id=" + id + ", name=" + nameCategorie + ", description=" + description + ", dateAjout=" + dateAjout
				+ "]";
	}
	
	

}
