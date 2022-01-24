package com.roma.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.roma.springboot.entity.Address;
import com.roma.springboot.entity.Avenger;
import com.roma.springboot.repository.AddressRepository;

@Controller
@RequestMapping("/address")
public class AddressController {
	
	@Autowired
	AddressRepository addressRepository;
	
	@RequestMapping("/createAddress")
    public String createAddress(Model model) {		
        return "createAddress";
    }
	
	@RequestMapping("/saveAddress")
	public String saveAddress(@RequestParam String city) {
		Address address = new Address();
		address.setCity(city);
		addressRepository.save(address);
	    return "successfulPage";
	}
	
	/*@RequestMapping("/add")
	public String add(@RequestParam Integer idAvenger, @RequestParam Integer idAddress) {
		//создать класс Address_Avenger, засетить значения
		Avenger avenger = new Avenger();
	    avenger.setName(name);
	    avenger.setAge(age);
	    avenger.setPhone(phone);
	    avengerRepository.save(avenger);
	    return "redirect:/avenger/show?id=" + avenger.getId();
		
		addressRepository.saveAddressByAvenger(idAvenger, idAddress);
	    return "successfulPage";
	}*/
	
}
