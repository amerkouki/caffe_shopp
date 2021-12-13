package com.kouki.demo.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.data.domain.Sort.Direction;
import com.kouki.demo.Entity.Produit;

import com.kouki.demo.Repository.ProduitRepository;
import com.kouki.demo.util.FileUploadUtil;

@Service
public class ProduitService {

	
	@Autowired
	ProduitRepository produitRepository;
	
	
	public List<Produit> getProduits(int limit){
		return this.produitRepository.findLimited( PageRequest.of(0,limit));
	}
	public List<Produit> getProduits(){
		return this.produitRepository.findAll();
	}
	
	public int getmaxId() {
		return this.produitRepository.findMaxId();
	}
	public Produit getProduitById(int id) {
		return this.produitRepository.findById(id).get();
	}
	public List<Produit> getProduitByName(String nameProduit) {
		return this.produitRepository.findBynameProduit(nameProduit);
	}
	
	public List<Produit> getPdoduitsByIdCategorie(int id){
		return this.produitRepository.findByCategorieId(id);
	}
	public List<Produit> getPdoduitsByNameCategorie(String nameCategrie){
		return this.produitRepository.findByCategorieNameCategorie(nameCategrie);
	}
	//**********
	//***getProduitByUserShop
	//**id
	//**name
	//**getProduit selon localisation de caffe
	//**
	//*****
	public Produit updaterProduit(Produit produit) {
		return this.produitRepository.save(produit);
	}
	public Produit SaveProduit(Produit produit) {
		return this.produitRepository.save(produit);
	}
	
	public ResponseEntity<Object> deleteProduitByName(String nameProduit){
		try {
			this.produitRepository.deleteByNameProduit(nameProduit);
			return new ResponseEntity<Object>("delete produit : "+nameProduit +" successfuly ",HttpStatus.OK);
		}
	 catch (Exception e) {
		// TODO: handle exception
	}
		return null;
		}
	
	public ResponseEntity<Object> deleteProduitById(int id){
		try {
			this.produitRepository.deleteById(id);
			return new ResponseEntity<Object>("delete produit : "+id +" successfuly ",HttpStatus.OK);
		}
	 catch (Exception e) {
		// TODO: handle exception
	}
		return null;
		}
	public ResponseEntity<Object> deleteProduit(Produit produit){
		try {
			this.produitRepository.delete(produit);
			return new ResponseEntity<Object>("delete produit : "+produit.getId() +" successfuly ",HttpStatus.OK);
		}
	 catch (Exception e) {
		// TODO: handle exception
	}
		return null;
		}
	
	public ResponseEntity<Object> deleteAllProduit(){
		try {
			this.produitRepository.deleteAll();
			return new ResponseEntity<Object>("delete  All produits  successfuly ",HttpStatus.OK);
		}
	 catch (Exception e) {
		// TODO: handle exception
	}
		return null;
		}
	
	
	
	public ResponseEntity<Object> uploadImage(int idUser,MultipartFile file) throws IOException {

		Produit produit=this.produitRepository.getById(idUser);
		Path path = FileUploadUtil.saveFile("uploads/" + produit.getId(), "" + ((new Date()).getTime()) + ".png", file);
		produit.setImageProduit(path.toString());

		this.produitRepository.save(produit);
		return new ResponseEntity<>("upload image succuffull",HttpStatus.OK);
	}

	public ResponseEntity<Object> downloadImage(int id) throws IOException
	{
		Produit produit=this.produitRepository.getById(id);
		String filename =produit.getImageProduit();
		Path uploadPath = Paths.get(filename);
		File file = new File(uploadPath.toString());
		InputStreamResource resource = new InputStreamResource(new FileInputStream(file));

		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Disposition",
				String.format("attachment; filename=\"%s\"", file.getName()));
		headers.add("Cache-Control", "no-cache, no-store, must-revalidate");
		headers.add("Pragma", "no-cache");
		headers.add("Expires", "0");

		ResponseEntity<Object> responseEntity = ResponseEntity.ok().headers(headers)
				.contentLength(file.length())
				.contentType(MediaType.parseMediaType("application/txt")).body(resource);

		return responseEntity;
	}
}
