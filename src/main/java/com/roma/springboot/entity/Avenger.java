package com.roma.springboot.entity;

import java.util.*;

import javax.persistence.*;

@Entity
@Table(name = "avenger")
public class Avenger {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "age")
	private Integer age;	

	@Column(name = "phone")
	private String phone;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "address_avenger",
    		   joinColumns = @JoinColumn(name = "id_avenger"),
    		   inverseJoinColumns = @JoinColumn(name = "id_address"))
	private List<Address> address;
		
	public List<Address> getAddress() {
		return address;
	}

	public void setAddress(List<Address> address) {
		this.address = address;
	}
	
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "auto_avenger",
    		   joinColumns = @JoinColumn(name = "id_avenger"),
    		   inverseJoinColumns = @JoinColumn(name = "id_auto"))
	private List<Auto> auto;
		
	public List<Auto> getAuto() {
		return auto;
	}

	public void setAuto(List<Auto> auto) {
		this.auto = auto;
	}

	/*@Override
	public String toString() {
		String str = "";
		int size = auto.size();
		
		for (int i = 0; i < size; i++) {
			str = auto.get(i).getBrand() + "; " + str;
		}
		return str;
	}
	
	
	th:value="${avengers.toString()}"*/
	
	
	
	
	/*private String[] brand;
	
	public String[] getBrand() {
		List<String> brandList = new ArrayList<String>(Arrays.asList(brand));
		for (Auto auto2 : auto) {
			brandList.add(auto2.getBrand());
		}
		brand = brandList.toArray(brand);
		return brand;
	}
	
	private String brand1;
	private String brand2;
	//private Integer size = auto.size();
	
	public String getBrand1() {
		brand1 = auto.get(0).getBrand();
		return brand1;
	}
	
	public String getBrand2() {
		brand2 = auto.get(1).getBrand();
		return brand2;
	}*/
	
}
