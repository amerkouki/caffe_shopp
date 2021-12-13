package com.kouki.demo.Controller;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;
import java.util.List;

import javax.websocket.server.PathParam;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.kouki.demo.Entity.Categorie;
import com.kouki.demo.Entity.Produit;
import com.kouki.demo.service.ProduitService;


@RestController
@RequestMapping("/produit")
@CrossOrigin(origins = "http://localhost:4200/")
public class ProduitController {

	@Autowired
	ProduitService produitService;
	
	@GetMapping("")
	public List<Produit> gelAllProduit(){
		return this.produitService.getProduits();
	}
	
	@GetMapping("/id/{id}")
	public Produit getProduitById(@PathVariable int id) {
		return this.produitService.getProduitById(id);
	}
	@GetMapping("/name/{name}")
	public List<Produit> getProduitByName(@PathVariable String name) {
		return this.produitService.getProduitByName(name);
	}
	
	@GetMapping("/categorie/{id}")
	public List<Produit> getProduitByCategorieId(@PathVariable int id){
		return this.produitService.getPdoduitsByIdCategorie(id);
	}
	@PostMapping("/ajout")
	public Produit ajoutProduit(@RequestBody Produit produit)  {
		return this.produitService.SaveProduit(produit);
	}
	@PutMapping("/update/{id}")
	public ResponseEntity<Object> updateCategorie(@RequestBody Produit produit,@PathVariable int id) {
		System.out.println("************ ");
		if(id != produit.getId()) {
			return new ResponseEntity<Object>("error 404 url://update/"+id+"innaccessible ",HttpStatus.OK);
		}
		this.produitService.updaterProduit(produit);
		return new ResponseEntity<Object>("update successifull",HttpStatus.OK);
	}
	
	@GetMapping("/max")
	public int getMaxId()  {
		return this.produitService.getmaxId();
	}
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Object> deteleById(@PathVariable Integer id){
		return this.produitService.deleteProduitById(id);
	}
	
	
	@PostMapping("/uploadImage")
	public Produit uploadImage(@RequestParam("imageProduit") MultipartFile file,@RequestParam("id") int id) throws IOException {
		Produit produit=this.produitService.getProduitById(id);
		Path path = com.kouki.demo.util.FileUploadUtil.saveFile("uploads/" + produit.getNameProduit(), "" + ((new Date()).getTime()) + ".png", file);
		produit.setImageProduit(path.toString());
		return this.produitService.SaveProduit(produit);
	}
	
	
	@GetMapping("/picture/download")
	public ResponseEntity<byte[]> getImage(@RequestParam("url") String url) throws IOException {
		InputStream in = new FileInputStream(url);
		byte[] targetArray = new byte[in.available()];
		in.read(targetArray);
		System.out.println(url);
		in.close();
		return ResponseEntity.ok(targetArray);
	}
	
	@GetMapping("/picture/download/{id}")
	public ResponseEntity<byte[]> getImageProduit(@PathVariable int id) throws IOException {
		String url =this.produitService.getProduitById(id).getImageProduit();
		
		InputStream in = new FileInputStream(url);
		byte[] targetArray = new byte[in.available()];
		in.read(targetArray);
		System.out.println(url);
		in.close();
		return ResponseEntity.ok(targetArray);
	}
	
	
	@PostMapping("/changeImage/{id}")
	public ResponseEntity<Object> uploadImage(@PathVariable int id , @RequestParam("imageProduit") MultipartFile file) throws IOException{
		return this.produitService.uploadImage(id, file);
	}
	
	@GetMapping("/downloadImage/{id}")
	public ResponseEntity<Object> downloadImage(@PathVariable int id) throws IOException{
		return this.produitService.downloadImage(id);
	}
	
}
