package com.kouki.demo.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import com.kouki.demo.Entity.Commande;
import com.kouki.demo.Entity.Produit;
import com.kouki.demo.Repository.CommandeRepository;
import com.kouki.demo.Repository.ProduitRepository;
import com.kouki.demo.model.RequestCommande;

import javassist.NotFoundException;

@Service
public class CommandeService {

	@Autowired
	CommandeRepository commandeRepository;
	@Autowired
	ProduitRepository produitRepository;
	
	public List<Commande> getCommandes(int limite){
		return this.commandeRepository.findLimited( PageRequest.of(0,limite));
	}
	
	public List<Commande> getCommandes(){
		return this.commandeRepository.findAll();
	}
	public Commande getCommandeById(int id) {
		return this.commandeRepository.findById(id).get();
	}
	
	public List<Commande> getCommandeByDateCmd (String dateCmd) throws ParseException{
		return this.commandeRepository.findByDateCmd(dateCmd);
	}
	
	
	public List<Commande> getCommandeByDateLivraison (String dateLiv){
		return this.commandeRepository.findByDateLivraison(dateLiv);
	}
	
	
	public List<Commande> getByCommandeByLieuLivraison (String lieuLiv){
		return this.commandeRepository.findByLieuLivraison(lieuLiv);
	}
	
	
	public List<Commande> getCommandeByProduitsId (int id ){
		return this.commandeRepository.findByProduitsId(id);
	}

	
	public Commande updateCommande(Commande cmd) {
		return this.commandeRepository.save(cmd);
	}
	
	
	
	
	
	public ResponseEntity<Object> ajoutCommande(RequestCommande requestCmd) throws NotFoundException {
		try {
			
			Commande cmd=new Commande(requestCmd.getCmntrCmd(),requestCmd.getLieuLivraison(),requestCmd.getIdUser());
			System.out.println(cmd.toString());
			cmd=this.commandeRepository.save(cmd);
			try {
				for(int prod :requestCmd.getProduits()){
					Produit poduit=this.produitRepository.getById(prod);
					cmd.addProduits(poduit);
				}	
				 this.commandeRepository.save(cmd);
			return new ResponseEntity<Object>(cmd,HttpStatus.OK);
			} catch (Exception e) {
				this.commandeRepository.deleteById(cmd.getIdCmd());
				throw new NotFoundException("Commande failed \n "+e.getMessage());
			}
			
		} catch (Exception e) {
			throw new NotFoundException("Commande failed");
			}
	}
	
	
	public Commande ajoutProduitToCommande(int idCmd,int idProd) {	
		Commande cmd=this.getCommandeById(idCmd);
		Produit prod=this.produitRepository.getById(idProd);
		cmd.getProduits().add(prod);
		return this.commandeRepository.save(cmd);
	}
	
	
	public Commande ajoutProduitsToCommande(int idCmd,int[] idProd) {	
		Commande cmd=this.getCommandeById(idCmd);
		for(int idprod :idProd) {
		Produit prod=this.produitRepository.getById(idprod);
		cmd.getProduits().add(prod);
		}
		return this.commandeRepository.save(cmd);
	}
	
	public ResponseEntity<Object> deleteCommandeById(int id) throws NotFoundException{
		try {
			Commande cmd=this.commandeRepository.getById(id);
			cmd.getProduits().removeAll(cmd.getProduits());
			this.commandeRepository.delete(cmd);
			return new ResponseEntity<Object>("Delete Commande : "+id +" successfuly ",HttpStatus.OK);
		}
	 catch (Exception e) {
		// TODO: handle exception
		 throw new NotFoundException("Filed To Delete command");
	}
		
	}
	public ResponseEntity<Object> deleteCommandeByDateCmd(String dateCmd){
		try {
			this.commandeRepository.deleteByDateCmd(dateCmd);
			return new ResponseEntity<Object>("Delete Commande on : "+dateCmd +" successfuly ",HttpStatus.OK);
		}
	 catch (Exception e) {
		// TODO: handle exception
	}
		return null;
	}
	public ResponseEntity<Object> deleteCommandeByLieuLivraison(String lieuLiv){
		try {
			this.commandeRepository.deleteByLieuLivraison(lieuLiv);
			return new ResponseEntity<Object>("Delete Commande to : "+lieuLiv +" successfuly ",HttpStatus.OK);
		}
	 catch (Exception e) {
		// TODO: handle exception
	}
		return null;
	}
	
}
