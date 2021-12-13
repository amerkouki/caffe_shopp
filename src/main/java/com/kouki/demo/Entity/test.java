package com.kouki.demo.Entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class test {
	@Id
	private int id;
	
	private String name;

	public test(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public test() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	

}
