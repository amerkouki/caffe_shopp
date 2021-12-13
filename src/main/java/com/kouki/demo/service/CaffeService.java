package com.kouki.demo.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.kouki.demo.Entity.CaffeShop;
import com.kouki.demo.Entity.CaffeUserRoles;
import com.kouki.demo.Entity.Roles;
import com.kouki.demo.Entity.User;
import com.kouki.demo.Repository.CaffeRepository;
import com.kouki.demo.Repository.RoleRepository;
import com.kouki.demo.Repository.UserRepository;
import com.kouki.demo.model.RequestCaffeShop;
import com.kouki.demo.model.RequestCaffeUserLink;
import com.kouki.demo.model.RequestUpdateCaffeShop;
import com.kouki.demo.model.RequestUserRole;
import com.kouki.demo.util.FileUploadUtil;

import javassist.NotFoundException;


@Service
public class CaffeService {


	@Autowired 
	private CaffeRepository caffeRepository;
	@Autowired
	private RoleRepository roleRepository;
	@Autowired
	private UserRepository userRepository;

	public List<CaffeShop> getCaffes(){
		return this.caffeRepository.findAll();
	}

	public List<CaffeShop> getCaffeByName(String name){
		return this.caffeRepository.findByName(name);
	}


	public List<CaffeShop> getCaffesByUser(int idUser){
		return this.caffeRepository.findByCaffeUserRolesUserId(idUser);//this.caffeRepository.findByUsersId(idUser);
	}

	public CaffeShop getCaffeById(int id) {
		return this.caffeRepository.findById(id).get();
	}

	public List<CaffeShop> getCaffesByVille(String ville){
		return this.caffeRepository.findByVille(ville);
	}

	public ResponseEntity<Object> ajoutCaffe(RequestCaffeShop requestCaffe) throws NotFoundException {

		try {
			CaffeShop caffe =new CaffeShop();
			caffe.setName(requestCaffe.getName());
			caffe.setAddresse(requestCaffe.getAddresse());
			caffe.setCodePostal(requestCaffe.getCodePostal());
			caffe.setImageCaffeSop(requestCaffe.getImageCaffeSop());
			caffe.setDateOuverture(requestCaffe.getDateFermetture());
			caffe.setDateFermetture(requestCaffe.getDateFermetture());
			caffe.setDescription(requestCaffe.getDescription());
			caffe.setEmail(requestCaffe.getEmail());
			caffe.setTel(requestCaffe.getTel());
			caffe.setVille(requestCaffe.getVille());
			caffe=this.caffeRepository.save(caffe);

			try {
				User user=new User(requestCaffe.getUsers());
				Roles role=this.roleRepository.findByName("ROLE_ADMIN_CREATEUR");
				CaffeUserRoles cur=new CaffeUserRoles();
				cur.setUser(user);
				cur.setRole(role);
				cur.setCaffe(caffe);

				caffe.addCaffeUserRoles(cur);
				this.caffeRepository.save(caffe);
				return  new ResponseEntity<Object>(caffe,HttpStatus.OK);
			} catch (Exception e) {
				this.caffeRepository.deleteById(caffe.getId());
				throw new NotFoundException("Failed To ADD New Caffe  ");
			}	
		} catch (Exception e) {
			throw new NotFoundException("Failed To ADD New Caffe  ");
		}
	}


	public ResponseEntity<Object> updateCaffe(RequestUpdateCaffeShop caffeModel, int idUser) {
		Roles role=this.roleRepository.findByCaffeShopIdUserId(caffeModel.getId(), idUser);
		if(role.getName().equals("ROLE_ADMIN") || role.getName().equals("ROLE_ADMIN_CREATEUR")) {
			
			CaffeShop caffe=new CaffeShop();
			caffe.setId(caffeModel.getId());
			caffe.setName(caffeModel.getName());
			caffe.setAddresse(caffeModel.getAddresse());
			caffe.setTel(caffeModel.getTel());
			caffe.setVille(caffeModel.getVille());
			caffe.setEtat(caffeModel.getEtat());
			caffe.setDateOuverture(caffeModel.getDateOuverture());
			caffe.setDateFermetture(caffeModel.getDateFermetture());
			caffe.setDescription(caffeModel.getDescription());
			caffe.setCodePostal(caffeModel.getCodePostal());
			caffe.setEmail(caffeModel.getEmail());
			
			CaffeShop newCaffe=this.caffeRepository.save(caffe);
			return new ResponseEntity<Object>(newCaffe,HttpStatus.OK);
		}
		else {
			return new ResponseEntity<Object>("this user inaccecible to this option",HttpStatus.OK);
		}
		
	
	}


	//*RequestCaffeUserLink :
	//**{idCaffe , caffeUserRole:[ {idUser,Role}]}
	public ResponseEntity<Object> ajouUserCaffe(RequestCaffeUserLink caffeUserLink) throws NotFoundException {	
		
			CaffeShop caffe=this.caffeRepository.findById(caffeUserLink.getIdCaffe()).get();
			
			for(RequestUserRole requestUserRole:caffeUserLink.getCaffeUserRole()) {
				CaffeUserRoles cur=new CaffeUserRoles();
				User user=this.userRepository.findById(requestUserRole.getIdUser()).get();
				Roles role=this.roleRepository.findById(requestUserRole.getIdRole()).get();
				cur.setCaffe(caffe);
				cur.setUser(user);
				cur.setRole(role);
				caffe.addCaffeUserRoles(cur);
			}
			this.caffeRepository.save(caffe);	
			return  new ResponseEntity<Object>(caffe,HttpStatus.OK);
		
	}

	
	public ResponseEntity<Object> deleteCaffe(int id) {
		return null;
	}


	public List<CaffeShop> getCaffeByCreateur(int idCreateur) {
		return this.caffeRepository.findByUserCreateur(idCreateur);
	}
	
	
	
	public List<CaffeShop> getCaffeByAdmin(int idAdmin){
		return this.caffeRepository.findByUserAdmin(idAdmin);
	}
	
	
	public ResponseEntity<Object> uploadImage(int idCaffe,MultipartFile file) throws IOException {

		CaffeShop caffe=this.caffeRepository.getById(idCaffe);
		Path path = FileUploadUtil.saveFile("uploads/" + caffe.getId(), "" + ((new Date()).getTime()) + ".png", file);
		caffe.setImageCaffeSop(path.toString());

		this.caffeRepository.save(caffe);
		return new ResponseEntity<>("upload image succuffull",HttpStatus.OK);
	}

	public ResponseEntity<Object> downloadImage(int id) throws IOException
	{
		CaffeShop caffe=this.caffeRepository.getById(id);
		String filename =caffe.getImageCaffeSop();
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
