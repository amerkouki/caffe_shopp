package com.kouki.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.kouki.demo.Entity.Categorie;
import com.kouki.demo.Entity.Produit;
import com.kouki.demo.Repository.CategorieRepository;
import com.kouki.demo.Repository.ProduitRepository;
import com.kouki.demo.model.RequestCategorie;

@Service
public class CategorieService {

	
	@Autowired
	CategorieRepository categorieRepository;
	@Autowired
	ProduitService produitService;
	
	public List<Categorie> getCategories(){
		return this.categorieRepository.findAll();
	}
	public List<Categorie> getCategories(int limit){
		return this.categorieRepository.findLimited( PageRequest.of(0,limit));
	}
	public Categorie getCategorieById(int id) {
		return this.categorieRepository.findById(id).get();
	}
	public List<Categorie>getByNameCategorie(String nameCategorie) {
		return this.categorieRepository.findByNameCategorie(nameCategorie);
	}
	
	/*
	public List<Produit> getProduitByCategorie(String nameCategorie){
		return this.produitService.getPdoduitsByNameCategorie(nameCategorie);
	}
	*/
	
	
	
	public Categorie updateCategorie(Categorie categorie) {
		return this.categorieRepository.save(categorie);
	}
	public ResponseEntity<Object> saveCategorie(RequestCategorie categorie) {
		try {
			Categorie cat=new Categorie();
			cat.setId(categorie.getId());
			cat.setNameCategorie(categorie.getNameCategorie());
			cat.setDescription(categorie.getDescription());
			cat.setDateAjout(categorie.getDateAjout());
			cat.setCaffe(categorie.getCaffe());
			Categorie newCat= this.categorieRepository.save(cat);
			return new ResponseEntity<Object>(newCat,HttpStatus.OK);
			
		} catch (Exception e) {
			return new ResponseEntity<Object>("error d'ajout ",HttpStatus.FAILED_DEPENDENCY);
		}
		
	}
	
	public ResponseEntity<Object> deleteCategogrie(Categorie categorie){
		try {
			this.categorieRepository.delete(categorie);
			return new ResponseEntity<Object>("delete produit : "+categorie.getId() +" successfuly ",HttpStatus.OK);
		}
	 catch (Exception e) {
		// TODO: handle exception
	}
		return null;
		}
	public ResponseEntity<Object> deleteCategogrieById(int id){
		try {
			this.categorieRepository.deleteById(id);
			return new ResponseEntity<Object>("delete produit : "+id +" successfuly ",HttpStatus.OK);
		}
	 catch (Exception e) {
		// TODO: handle exception
	}
		return null;
		}
	public ResponseEntity<Object> deleteCategogrieByName(String nameCategorie){
		try {
			this.categorieRepository.deleteByNameCategorie(nameCategorie);
			return new ResponseEntity<Object>("delete produit : "+nameCategorie +" successfuly ",HttpStatus.OK);
		}
	 catch (Exception e) {
		// TODO: handle exception
	}
		return null;
		}
}
