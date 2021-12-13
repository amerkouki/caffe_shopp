package com.kouki.demo.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.kouki.demo.Entity.CaffeShop;


public interface CaffeRepository extends JpaRepository<CaffeShop, Integer>{

	//List<CaffeShop> findByUsersId(int id);
	
	@Query("select c from CaffeShop c where c.ville like %:ville%")
	List<CaffeShop> findByVille(String ville);
	
	@Query("select c from CaffeShop c where c.name like %:name%")
	List<CaffeShop> findByName(String name);
	
	List<CaffeShop> findByCaffeUserRolesUserId(int id);
	
	@Query("select distinct c from CaffeShop c inner join CaffeUserRoles cur on c.id=cur.caffe.id"+
			" where cur.user.id= :idUser and cur.role.name like 'ROLE_ADMIN_CREATEUR'")
		
	List<CaffeShop> findByUserCreateur(int idUser);

	@Query("select distinct c from CaffeShop c inner join CaffeUserRoles cur on c.id=cur.caffe.id  where cur.user.id= :idUser "+
				" and cur.role.name like '%ADMIN%'")	
	List<CaffeShop> findByUserAdmin(int idUser);
}
