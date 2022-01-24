package com.roma.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.roma.springboot.repository.AutoRepository;

@Controller
public class AutoController {
	
	/*@Autowired
	AutoRepository autoRepository;
	
	@RequestMapping("/avenger/show")
    public String show(@PathVariable Integer id, Model model) {
        model.addAttribute("autos", autoRepository.findAllByAvenger(id));
        return "show";
    }*/
	
}
