package com.roma.springboot.entity;

import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "auto")
public class Auto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "brand")
	private String brand;
	
	/*public Integer getId() {
		return id;
	}*/

	public void setId(Integer id) {
		this.id = id;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}
	
	@ManyToMany(mappedBy = "auto")
	private List<Avenger> avenger;

	public List<Avenger> getAvenger() {
		return avenger;
	}

	public void setAvenger(List<Avenger> avenger) {
		this.avenger = avenger;
	}

	/*@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(name = "auto_avenger",
    		   joinColumns = @JoinColumn(name = "id_auto"),
    		   inverseJoinColumns = @JoinColumn(name = "id_number"))
	private AutoNumber autoNumber;

	public AutoNumber getAutoNumber() {
		return autoNumber;
	}

	public void setAutoNumber(AutoNumber autoNumber) {
		this.autoNumber = autoNumber;
	}*/

}
