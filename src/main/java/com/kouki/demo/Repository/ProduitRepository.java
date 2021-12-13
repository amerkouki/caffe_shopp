package com.kouki.demo.Repository;


import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.kouki.demo.Entity.Produit;

public interface ProduitRepository extends JpaRepository<Produit, Integer> {

	@Query("select p.id from Produit p where p.id = 1")
	Produit findId(int i);
	
	@Query("select max(p.id) from Produit p")
	int findMaxId();
	
	@Query("select p from Produit p where p.nameProduit like %:i%")
	List<Produit> findBynameProduit(String i);
	
	@Query("select p from Produit p")
	List<Produit> findLimited(Pageable pageabl);

	
	
	
	List<Produit> findByNameProduit(String nameProduit);
	void deleteByNameProduit(String nameProduit);
	List<Produit> findByCategorieId(int id);
	List<Produit> findByCategorieNameCategorie(String nameCategorie);
}
