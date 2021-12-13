package com.kouki.demo.Repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.kouki.demo.Entity.Categorie;

public interface CategorieRepository extends JpaRepository<Categorie, Integer> {
	
	@Query("select c from Categorie c where c.nameCategorie like %:i%")
	public List<Categorie> findByNameCategorie(String i);
	
	public void deleteByNameCategorie(String nameCategorie);
	
	@Query("select c from Categorie c")
	List<Categorie> findLimited(Pageable pageabl);
}
