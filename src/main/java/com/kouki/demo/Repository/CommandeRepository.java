package com.kouki.demo.Repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.kouki.demo.Entity.Categorie;
import com.kouki.demo.Entity.Commande;

public interface CommandeRepository extends JpaRepository<Commande, Integer> {

	@Query("select c from Commande c where c.dateCmd like %:date%")
	public List<Commande> findByDateCmd( String date);
	
	@Query("select c from Commande c where c.dateLivraison like %:i%")
	public List<Commande> findByDateLivraison(String i);
	
	@Query("select c from Commande c where c.lieuLivraison like %:i%")
	public List<Commande> findByLieuLivraison(String i);
	
	public List<Commande> findByProduitsId(int id);
	
	@Query("select c from Commande c")
	List<Commande> findLimited(Pageable pageabl);
	
	@Query("DELETE from Commande c where c.dateCmd like %:i%")
	public List<Commande> deleteByDateCmd(String i);
	
	@Query("DELETE from Commande c where c.lieuLivraison like %:i%")
	public List<Commande> deleteByLieuLivraison(String i);
}
