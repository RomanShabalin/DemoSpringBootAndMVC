package com.roma.springboot.entity;

import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "address")
public class Address {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "city")
	private String city;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}
	
	@ManyToMany(mappedBy = "address")
	private List<Avenger> avenger;

	public List<Avenger> getAvenger() {
		return avenger;
	}

	public void setAvenger(List<Avenger> avenger) {
		this.avenger = avenger;
	}
		
}
