package com.roma.springboot.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.roma.springboot.entity.Avenger;
import com.roma.springboot.repository.AddressRepository;
import com.roma.springboot.repository.AutoRepository;
import com.roma.springboot.repository.AvengerRepository;

@Controller
@RequestMapping("/avenger")
public class AvengerController {
	
	@Autowired
	AvengerRepository avengerRepository;
	
	@Autowired
	AutoRepository autoRepository;
	
	@Autowired
	AddressRepository addressRepository;
	
	@RequestMapping()
    public String avenger(Model model) {
        model.addAttribute("avengers", avengerRepository.findAll());
        return "avenger";
    }
	
	@RequestMapping("/show")
    public String showByButton(@Validated Integer id, Model model) {
        model.addAttribute("avengers", avengerRepository.findById(id).get());
        return "show";
    }
	
	@RequestMapping("/show/{id}")
    public String show(@PathVariable Integer id, Model model) {
        model.addAttribute("avengers", avengerRepository.findById(id).get());
        return "show";
    }
	
	@RequestMapping("/create")
    public String create(Model model) {
        return "create";
    }
	
	@RequestMapping("/save")
	public String save(@RequestParam String name, @RequestParam Integer age, @RequestParam String phone) {
		Avenger avenger = new Avenger();
	    avenger.setName(name);
	    avenger.setAge(age);
	    avenger.setPhone(phone);
	    avengerRepository.save(avenger);
	    return "redirect:/avenger/show?id=" + avenger.getId();
	}
	
	@RequestMapping("/delete")
	public String delete(@RequestParam Integer id) {
	    Optional<Avenger> avenger = avengerRepository.findById(id);
	    avengerRepository.delete(avenger.get());
	    return "redirect:/avenger";
	}
	
	@RequestMapping("/update")
	public String update(@RequestParam Integer id, @RequestParam String name, @RequestParam Integer age, @RequestParam String phone) {
		Optional<Avenger> avenger = avengerRepository.findById(id);
		avenger.get().setName(name);
		avenger.get().setAge(age);
		avenger.get().setPhone(phone);
		avengerRepository.save(avenger.get());
	    return "redirect:/avenger/show?id=" + avenger.get().getId();
	}
	
	@RequestMapping("/changeAuto")
	public String changeAutoByButton(@Validated Integer id, Model model) {
		model.addAttribute("avengers", avengerRepository.findById(id).get());
		model.addAttribute("autos", autoRepository.findAll());
	    return "changeAuto";
	}
	
	/*@RequestMapping("/changeAuto/{id}")
	public String changeAuto(@PathVariable Integer id, Model model) {
		model.addAttribute("avengers", avengerRepository.findById(id).get());
	    return "changeAuto";
	}*/
	
	@RequestMapping("/changeAddress")
	public String changeAddressByButton(@Validated Integer id, Model model) {
		model.addAttribute("avengers", avengerRepository.findById(id).get());
		model.addAttribute("addresses", addressRepository.findAll());
	    return "changeAddress";
	}
	
	@RequestMapping("/changeAddress/{id}")
	public String changeAddress(@PathVariable Integer id, Model model) {
		model.addAttribute("avengers", avengerRepository.findById(id).get());
	    return "changeAddress";
	}

}
