package com.kouki.demo.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.kouki.demo.Entity.Roles;

public interface RoleRepository extends JpaRepository<Roles, Integer> {
	
	Roles findByName(String name);
	@Query("select distinct r from Roles r  join CaffeUserRoles cur on r.id=cur.role.id"+
				" where cur.caffe.id= :idCaffe and cur.user.id= :idUser")
	Roles findByCaffeShopIdUserId(int idCaffe, int idUser);

}
