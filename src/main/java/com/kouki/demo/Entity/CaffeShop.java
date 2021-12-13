package com.kouki.demo.Entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonManagedReference;



@Entity
public class CaffeShop {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name ="caffe_id")
	private int id;
	private String name;
	private String addresse;
	private String tel;
	private String ville;
	private String etat;
	private Date dateOuverture;
	private Date dateFermetture;
	private String ImageCaffeSop;
	private Date dateCreation;
	
	private String description;
	private String codePostal;
	private String email;
	
	@OneToMany(mappedBy = "caffe",cascade  = {CascadeType.PERSIST,CascadeType.MERGE}, fetch = FetchType.EAGER)
	@JsonManagedReference
	private Set<CaffeUserRoles> caffeUserRoles=new HashSet<>();
	
	
	
	

	public CaffeShop(int id, String name, String addresse, String tel, String ville, String etat, Date dateOuverture,
			Date dateFermetture, String imageCaffeSop, String description, String codePostal,
			String email,Set<CaffeUserRoles> caffeUserRoles) {
		super();
		this.id = id;
		this.name = name;
		this.addresse = addresse;
		this.tel = tel;
		this.ville = ville;
		this.etat = etat;
		this.dateOuverture = dateOuverture;
		this.dateFermetture = dateFermetture;
		ImageCaffeSop = imageCaffeSop;
		this.dateCreation = new Date();
		this.description = description;
		this.codePostal = codePostal;
		this.email = email;
		this.caffeUserRoles =caffeUserRoles;
	}
	
	public CaffeShop() {
		super();
		this.dateCreation=new Date();
	}
	public CaffeShop(int id) {
		super();
		this.id=id;
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
	public String getImageCaffeSop() {
		return ImageCaffeSop;
	}
	public void setImageCaffeSop(String imageCaffeSop) {
		ImageCaffeSop = imageCaffeSop;
	}
	public Date getDateCreation() {
		return dateCreation;
	}
	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
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

	@Override
	public String toString() {
		return "CaffeShop [id=" + id + ", name=" + name + ", addresse=" + addresse + ", tel=" + tel + ", ville=" + ville
				+ ", etat=" + etat + ", dateOuverture=" + dateOuverture + ", dateFermetture=" + dateFermetture
				+ ", ImageCaffeSop=" + ImageCaffeSop + ", dateCreation=" + dateCreation + ", description=" + description
				+ ", codePostal=" + codePostal + ", email=" + email + ", caffeUserRoles=" + caffeUserRoles + "]";
	}
	
	
	
}
