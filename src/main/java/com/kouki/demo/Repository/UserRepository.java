package com.kouki.demo.Repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.kouki.demo.Entity.User;

public interface UserRepository extends JpaRepository<User, Integer>{

	User findByUsername(String username);
	
	@Transactional
	@Modifying
	@Query("update User u set u.status='B' where u.id=:id")
	void blockerUser(int id);
	
	@Query("select distinct u from User u inner join CaffeUserRoles cur on u.id=cur.user.id "+
			"inner join Roles r on r.id=cur.role.id where r.name like %:role%")
	List<User> getUserByRoles(String role);	
	
	@Query("select distinct u from User u inner join CaffeUserRoles cur on u.id=cur.user.id "+
			"inner join Roles r on r.id=cur.role.id where r.id = :id")
	List<User> findBycaffeUserRolesRoleId(int id);
	
	@Transactional
	@Modifying
	@Query("delete from User u where u.id= :id")
	void deleteUserById(int id);
	

}
