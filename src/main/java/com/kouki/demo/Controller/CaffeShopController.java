package com.kouki.demo.Controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.kouki.demo.Entity.CaffeShop;
import com.kouki.demo.Entity.Roles;
import com.kouki.demo.model.RequestCaffeShop;
import com.kouki.demo.model.RequestCaffeUserLink;
import com.kouki.demo.model.RequestUpdateCaffeShop;
import com.kouki.demo.service.CaffeService;

import javassist.NotFoundException;

@RestController
@RequestMapping("/caffe")
@CrossOrigin(origins = "http://localhost:4200/")
public class CaffeShopController {

	
	
	@Autowired
	private CaffeService caffeService;
	
	@GetMapping("")
	public List<CaffeShop> getCaffes(){
		return this.caffeService.getCaffes();
	}
	
	@GetMapping("/name/{name}")
	public List<CaffeShop> getCaffeByName(@PathVariable String name){
		return this.caffeService.getCaffeByName(name);
	}
	
	@GetMapping("/ville/{ville}")
	public List<CaffeShop> getCaffeByVille(@PathVariable String ville){
		return this.caffeService.getCaffesByVille(ville);
	}
	
	@GetMapping("/id/{id}")
	public CaffeShop getCaffeById(@PathVariable int id){
		return this.caffeService.getCaffeById(id);
	}
	
	@GetMapping("/idUser/{idUser}")
	public List<CaffeShop> getCaffesByUser(@PathVariable int idUser){
		return this.caffeService.getCaffesByUser(idUser);
	}
	
	
	@PostMapping("/ajout")
	public ResponseEntity<Object> ajoutCaffeShop(@RequestBody RequestCaffeShop requestCaffe) throws NotFoundException {
		return this.caffeService.ajoutCaffe(requestCaffe);
	}
	
	
	@RequestMapping(value = "/ajoutUsers" , method = RequestMethod.POST)
	public ResponseEntity<Object> ajoutCaffeUser(@RequestBody RequestCaffeUserLink requestCaffeUserLink) throws NotFoundException{
	 return this.caffeService.ajouUserCaffe(requestCaffeUserLink);	
	}
	//******************************
	//blocke user 
	//****************************
	
	/*
	@RequestMapping(value = "/updateCaffe/{idUser}" , method = RequestMethod.POST)
	public ResponseEntity<Object> updateCaffe(@RequestBody CaffeShop caffe , @PathVariable int idUser){
		return this.caffeService.updateCaffe(caffe, idUser);
	}*/

	@RequestMapping(value = "/updateCaff/{idUser}" , method = RequestMethod.POST)
	public ResponseEntity<Object> updateCaff(@RequestBody RequestUpdateCaffeShop caffe , @PathVariable int idUser) throws NotFoundException{
		return this.caffeService.updateCaffe(caffe, idUser);
		
	}
	
	@GetMapping("/admin/{id}")
	public List<CaffeShop> getCaffeByAdmin(@PathVariable int id){
		return this.caffeService.getCaffeByAdmin(id);			
	}
	
	
	@GetMapping("/createur/{id}")
	public List<CaffeShop> getCaffeByCreateur(@PathVariable int id){
		return this.caffeService.getCaffeByCreateur(id);			
	}
	
	

	@RequestMapping(value = "/changeImage/{id}" , method = RequestMethod.POST)
	public ResponseEntity<Object> uploadImage(@PathVariable int id , @RequestParam("imageCaffe") MultipartFile file) throws IOException{
		return this.caffeService.uploadImage(id, file);
	}
	
	@GetMapping("/downloadImage/{id}")
	public ResponseEntity<Object> downloadImage(@PathVariable int id) throws IOException{
		return this.caffeService.downloadImage(id);
	}
}
