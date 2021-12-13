package com.kouki.demo.Entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Produit {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_produit")
	private int id;
	private String nameProduit;
	private String descriptionProduit;
	private float prixProduit;
	private float soldeProduit;
	private boolean disponibiliteProduit;
	private String imageProduit;
	private boolean  nouveauteProduit;
	//private float taxeProduit;
	private Date dateAjoutProduit;
	//caffe shopp qui ajout produit manyToOne
	
	//categorie
	@JoinColumn(name ="categorie_id")
	@ManyToOne
	private Categorie categorie;
	
	
	/*@ManyToOne
	@JoinColumn(name ="caffe_id")
	private CaffeShop caffe;
	*/
	public Produit(int id, String nameProduit, String descriptionProduit, float prixProduit, float soldeProduit,
			boolean disponibiliteProduit, String imageProduit, boolean nouveauteProduit,int idCategorie,int vendeur) {
		super();
		this.id = id;
		this.nameProduit = nameProduit;
		this.descriptionProduit = descriptionProduit;
		this.prixProduit = prixProduit;
		this.soldeProduit = soldeProduit;
		this.disponibiliteProduit = disponibiliteProduit;
		this.imageProduit = imageProduit;
		this.nouveauteProduit = nouveauteProduit;
		this.dateAjoutProduit = new Date();
		this.categorie=new Categorie();
		this.categorie.setId(idCategorie);
		//this.caffe=new CaffeShop(vendeur);
	}
	public Produit() {
		super();
		this.dateAjoutProduit=new Date();
	}
	public Produit(int id ) {
		super();
		this.id=id;
		this.dateAjoutProduit=new Date();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNameProduit() {
		return nameProduit;
	}
	public void setNameProduit(String nameProduit) {
		this.nameProduit = nameProduit;
	}
	public String getDescriptionProduit() {
		return descriptionProduit;
	}
	public void setDescriptionProduit(String descriptionProduit) {
		this.descriptionProduit = descriptionProduit;
	}
	public float getPrixProduit() {
		return prixProduit;
	}
	public void setPrixProduit(float prixProduit) {
		this.prixProduit = prixProduit;
	}
	public float getSoldeProduit() {
		return this.soldeProduit;
	}
	public void setSoldeProduit(float soldeProduit) {
		this.soldeProduit = soldeProduit;
	}
	public boolean isDisponibiliteProduit() {
		return disponibiliteProduit;
	}
	public void setDisponibiliteProduit(boolean disponibiliteProduit) {
		this.disponibiliteProduit = disponibiliteProduit;
	}
	public String getImageProduit() {
		return imageProduit;
	}
	public void setImageProduit(String imageProduit) {
		this.imageProduit = imageProduit;
	}
	public boolean isNouveauteProduit() {
		return nouveauteProduit;
	}
	public void setNouveauteProduit(boolean nouveauteProduit) {
		this.nouveauteProduit = nouveauteProduit;
	}
	
	public Date getDateAjoutProduit() {
		return dateAjoutProduit;
	}
	public void setDateAjoutProduit(Date dateAjoutProduit) {
		this.dateAjoutProduit = dateAjoutProduit;
	}
	
	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}
	
	
	
	public Categorie getCategorie() {
		return categorie;
	}
/*	
	public CaffeShop getVendeur() {
		return caffe;
	}
	public void setVendeur(CaffeShop vendeur) {
		this.caffe = vendeur;
	}
	
	
	public CaffeShop getCaffe() {
		return caffe;
	}
	public void setCaffe(CaffeShop caffe) {
		this.caffe = caffe;
	}
	*/
	@Override
	public String toString() {
		return "Produit [id=" + id + ", nameProduit=" + nameProduit + ", descriptionProduit=" + descriptionProduit
				+ ", prixProduit=" + prixProduit + ", SoldeProduit=" + soldeProduit + ", disponibiliteProduit="
				+ disponibiliteProduit + ", imageProduit=" + imageProduit + ", nouveauteProduit=" + nouveauteProduit
				+  ", dateAjoutProduit=" + dateAjoutProduit + "]";
	}
	
	

	
	
	
	
}
