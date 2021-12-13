package com.kouki.demo.Controller;

import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kouki.demo.Entity.Commande;
import com.kouki.demo.Entity.Produit;
import com.kouki.demo.model.RequestCmd;
import com.kouki.demo.model.RequestCommande;
import com.kouki.demo.service.CommandeService;

import javassist.NotFoundException;

@RestController
@RequestMapping("/cmd")
@CrossOrigin(origins = "http://localhost:4200/")
public class CommandeController {

	
	@Autowired
	CommandeService commandeService;
	
	@GetMapping("")
	public List<Commande> getCommandes(){
		return this.commandeService.getCommandes();
	}
	@GetMapping("/id/{id}")
	public Commande getCommandeById(@PathVariable int id){
		return this.commandeService.getCommandeById(id);
	}
	
	
	@GetMapping("/dateCmd/{dateCmd}")
	public List<Commande> getCommandeByDateCmd(@PathVariable String dateCmd) throws ParseException{
		return this.commandeService.getCommandeByDateCmd(dateCmd);
	}
	
	
	@GetMapping("/dateLiv/{dateLiv}")
	public List<Commande> getCommandeByDateLivraison(@PathVariable String dateLiv){
		return this.commandeService.getCommandeByDateLivraison(dateLiv);
	}
	
	
	@GetMapping("/lieuLiv/{lieuLiv}")
	public List<Commande> getCommandeById(@PathVariable String lieuLiv){
		return this.commandeService.getByCommandeByLieuLivraison(lieuLiv);
	}
	
	
	@PostMapping("/ajout")
	public ResponseEntity<Object> ajoutCommande(@RequestBody RequestCommande cmd) throws NotFoundException {
		
		return this.commandeService.ajoutCommande(cmd);
	}
	
	@PostMapping("/ajoutProd")
	public Commande AjoutProduitToCommande(@RequestParam("idCmd") int idCmd,@RequestParam("idProd")int idProd) {
		 return this.commandeService.ajoutProduitToCommande(idCmd,idProd);
	}
	
	
	@PutMapping("/update")
	public Commande updateCommande(@RequestBody Commande cmd) {
		return this.commandeService.updateCommande(cmd);
	}
	
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Object> deleteCommandeById(@PathVariable int id) throws NotFoundException{
		return this.commandeService.deleteCommandeById(id);
	}
	
	
	@DeleteMapping("/delete/dateCmd/{dateCmd}")
	public ResponseEntity<Object> deleteCommandeByDateCmd(@PathVariable String dateCmd){
		return this.commandeService.deleteCommandeByDateCmd(dateCmd);
	}
	
	
	@DeleteMapping("/delete/lieuLiv/{lieuLiv}")
	public ResponseEntity<Object> deleteCommandeById(@PathVariable String lieuLiv){
		return this.commandeService.deleteCommandeByLieuLivraison(lieuLiv);
	}
	
}

