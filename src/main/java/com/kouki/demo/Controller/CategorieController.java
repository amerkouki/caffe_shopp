package com.kouki.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;

import com.kouki.demo.Entity.Categorie;
import com.kouki.demo.error.NotFoundException;
import com.kouki.demo.model.RequestCategorie;
import com.kouki.demo.service.CategorieService;

@RestController
@RequestMapping("/categorie")
@CrossOrigin(origins = "http://localhost:4200/")
public class CategorieController {

	@Autowired
	CategorieService categorieService;
	
	
	@GetMapping("/")
	public List<Categorie> getCategories(){
		return this.categorieService.getCategories(10);
	}
	@GetMapping("/id/{id}")
	public Categorie getCategorieById(@PathVariable int id){
		return this.categorieService.getCategorieById(id);
	}
	
	@GetMapping("/name/{name}")
	public List<Categorie> getCategorieById(@PathVariable String name){
		return this.categorieService.getByNameCategorie(name);
	}
	
	
	
	@RequestMapping(value = "/ajout" , method = RequestMethod.POST)
	public ResponseEntity<Object> ajoutCategorie(@RequestBody RequestCategorie categorie) {
			ResponseEntity<Object> cat=this.categorieService.saveCategorie(categorie);
			if(cat!=null) {
				return new ResponseEntity<>(cat,HttpStatus.OK);
			}
			else {
				throw new NotFoundException("erreur d'ajout categorie");
			}
		
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<Object> updateCategorie(@RequestBody Categorie categorie,@PathVariable Integer id) {
		if(id != categorie.getId()) {
			return new ResponseEntity<Object>("error 404 url://update/"+id+"innaccessible ",HttpStatus.OK);
		}
		this.categorieService.updateCategorie(categorie);
		return new ResponseEntity<Object>("update successifull",HttpStatus.OK);
	}
	
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Object> deteleById(@PathVariable Integer id){
		return this.categorieService.deleteCategogrieById(id);
	}
	
	@DeleteMapping("/delete/name/{name}")
	public ResponseEntity<Object> deteleByName(@PathVariable String name){
		return this.categorieService.deleteCategogrieByName(name);
	}
	
}
