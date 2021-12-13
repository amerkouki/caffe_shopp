package com.kouki.demo.Entity;

import java.io.Serializable;
import java.text.SimpleDateFormat;
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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@Entity

public class Commande  {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_cmd")
	private int idCmd;
	private float montantCmd;
	private String dateLivraison;
	private String EtatCmd;
	//@Temporal(TemporalType.TIMESTAMP)
	private String dateCmd;
	private String cmntrCmd;
	private String lieuLivraison;
	private float prixTotalLivraison;
	private Date dateLuCmd;
	
	
	//cafeeShop
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(
			name = "cmd_produit",
			joinColumns = @JoinColumn(name = "id_cmd"),
			inverseJoinColumns = @JoinColumn(name="id_produit")
			)
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	Set<Produit> produits=new HashSet<>();
	
	
    @OneToOne
    @JoinColumn(name = "user_id")
    
	private User user;
	
    /*
	@OneToOne
	@JoinColumn(name ="caffe_id")
	private CaffeShop caffe;
*/

	public Commande(int idCmd,float montantCmd, String dateLivraison, String etatCmd, String dateCmd, String cmntrCmd,
			String lieuLivraison ,float prixTotalLivraison,int user,int vendeur , int idProduit) {
		super();
		this.idCmd = idCmd;
		this.montantCmd = montantCmd;
		this.dateLivraison = dateLivraison;
		EtatCmd = etatCmd;
		this.dateCmd = dateCmd;
		this.cmntrCmd = cmntrCmd;
		this.lieuLivraison = lieuLivraison;
		this.prixTotalLivraison = prixTotalLivraison;
		this.dateLuCmd=null;
		this.user=new User(user);
		this.produits.add(new Produit(idProduit));
		//this.caffe=new CaffeShop(vendeur);
	}
	
	public Commande( String cmntr,String lieuLiv,int idUser) {
		this.dateCmd=new SimpleDateFormat("yyyy-MM-dd HH:mm").format(new Date());
		this.cmntrCmd=cmntr;
		this.lieuLivraison=lieuLiv;
		this.user=new User();
		this.user.setId(idUser);
		
	}
	public Commande( String cmntr,String lieuLiv,int user,int vendeur) {
		this.dateCmd=new SimpleDateFormat("yyyy-MM-dd HH:mm").format(new Date());
		this.cmntrCmd=cmntr;
		this.lieuLivraison=lieuLiv;
		this.user=new User(user);
		//this.caffe=new CaffeShop(vendeur);
	}
	public Commande() {
		super();
		this.dateCmd=new SimpleDateFormat("yyyy-MM-dd HH:mm").format(new Date());
		List<Produit> produits=new ArrayList<Produit>();
	}

	public int getIdCmd() {
		return idCmd;
	}

	public void setIdCmd(int idCmd) {
		this.idCmd = idCmd;
	}

	public float getMontantCmd() {
		return montantCmd;
	}

	public void setMontantCmd(float montantCmd) {
		this.montantCmd = montantCmd;
	}

	public String getDateLivraison() {
		return dateLivraison;
	}

	public void setDateLivraison(String dateLivraison) {
		this.dateLivraison = dateLivraison;
	}

	public String getEtatCmd() {
		return EtatCmd;
	}

	public void setEtatCmd(String etatCmd) {
		EtatCmd = etatCmd;
	}

	public String getDateCmd() {
		return dateCmd;
	}

	public void setDateCmd(String dateCmd) {
		this.dateCmd = dateCmd;
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

	public float getPrixTotalLivraison() {
		return prixTotalLivraison;
	}

	public void setPrixTotalLivraison(float prixTotal) {
		this.prixTotalLivraison = prixTotal;
	}

	public Set<Produit> getProduits() {
		return produits;
	}

	public void setProduits(Set<Produit> produits) {
		this.produits = produits;
	}
	public void  addProduits(Produit prod) {
		this.produits.add(prod);
	}

	public Date getDateLuCmd() {
		return dateLuCmd;
	}

	public void setDateLuCmd(Date dateLuCmd) {
		this.dateLuCmd = dateLuCmd;
	}

	
	
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
/*
	public CaffeShop getCaffe() {
		return caffe;
	}

	public void setCaffe(CaffeShop caffe) {
		this.caffe = caffe;
	}
*/
	@Override
	public String toString() {
		return "Commande [idCmd=" + idCmd + ", montantCmd=" + montantCmd + ", dateLivraison=" + dateLivraison
				+ ", EtatCmd=" + EtatCmd + ", dateCmd=" + dateCmd + ", cmntrCmd=" + cmntrCmd + ", lieuLivraison="
				+ lieuLivraison + ", prixTotalLivraison=" + prixTotalLivraison + ", dateLuCmd=" + dateLuCmd
				+ ", produits=" + produits + "]";
	}

	
	
	
}
