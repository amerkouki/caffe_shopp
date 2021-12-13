package com.kouki.demo.Repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.kouki.demo.Entity.CaffeUserRoles;

public interface CaffeUserRolesRepository extends JpaRepository<CaffeUserRoles, Integer> {

	@Transactional
	@Modifying
	@Query("delete from CaffeUserRoles cur where cur.user.id= :id")
	void deleteByUserId(int id);
}
