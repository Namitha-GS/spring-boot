package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.dao.AlienRepository;
import com.example.demo.model.Alien;

//@Controller
@RestController
public class AlienController {
	
	@Autowired
	AlienRepository repo;
	
	@RequestMapping("/")
	public String home() {
		return "home.jsp";
	}
	
	@RequestMapping("/addAlien")
	public String addAlien(Alien alien) {
		repo.save(alien);
		return "home.jsp";
	}
	
	@RequestMapping("/getAlien")
	public ModelAndView getAlien(@RequestParam("aid") int id) {
		ModelAndView mv = new ModelAndView();
		//Alien alien = repo.findById(id).orElse(new Alien());
		// if specific ID is not present in db, orElse(new Alien()) -> returns default object
		Optional<Alien> alien = repo.findById(id);
		// if specific ID is not present in db, Optional -> returns Optional.empty
		mv.addObject("alien", alien);
		mv.setViewName("display.jsp");
		return mv;
	}
	
	@RequestMapping("/updateAlien")
	public ModelAndView updateAlien(Alien alien) {
		ModelAndView mv = new ModelAndView();
		int id = alien.getAid();
		if(repo.existsById(id))
			repo.deleteById(id);
		repo.save(alien);
		mv.addObject("alien", alien);
		mv.setViewName("display.jsp");
		return mv;
	}
	
	@RequestMapping("/deleteAlien")
	public String deleteAlien(@RequestParam int aid) {
		repo.deleteById(aid);
		return "home.jsp";
	}
	
	@RequestMapping("/getByTech")
	public ModelAndView getByTech(@RequestParam("tech") String technology) {
		ModelAndView mv = new ModelAndView();
		List<Alien> alien = repo.findByTech(technology);
		mv.addObject("alien", alien);
		mv.setViewName("display.jsp");
		return mv;
	}
	
	@RequestMapping("/getByIdGreaterThan")
	public ModelAndView getByIdGreaterThan(@RequestParam("aid") int id) {
		ModelAndView mv = new ModelAndView();
		List<Alien> alien = repo.findByAidGreaterThan(id);
		mv.addObject("alien", alien);
		mv.setViewName("display.jsp");
		return mv;
	}
	
	@RequestMapping("/getByTechSorted")
	public ModelAndView getByTechSorted(@RequestParam("tech") String tech) {
		ModelAndView mv = new ModelAndView();
		List<Alien> alien = repo.findByTechSorted(tech);
		mv.addObject("alien", alien);
		mv.setViewName("display.jsp");
		return mv;
	}
	
	// REST
	@RequestMapping(path="/aliens", produces="application/xml")
	@ResponseBody
	public List<Alien> getAllAliens() {
		return repo.findAll();
	}
	
	@RequestMapping("/alien/{aid}")
	@ResponseBody
	public Optional<Alien> getAlienById(@PathVariable("aid") int id) {
		return repo.findById(id);
	}
	
	@PostMapping(path="/alienClient", consumes={"application/json"})
	public Alien postAlien(@RequestBody Alien alien) {
		repo.save(alien);
		return alien;
	}
	
	@GetMapping(path="/alienClients")
	public List<Alien> getAlien() {
		return repo.findAll();
	}
	
	@GetMapping(path="/alienClient/{aid}")
	public Optional<Alien> getAlienClientById(@PathVariable("aid") int id) {
		return repo.findById(id);
	}
	
	@DeleteMapping(path="/alien/{aid}")
	public String deleteAlienClient(@PathVariable("aid") int id) {
		repo.deleteById(id);
		return "deleted";
	}
	
	@PutMapping(path="/alienClient", consumes= {"application/json"})
	public Alien updateAlienClient(@RequestBody Alien alien) {
		repo.save(alien);
		return alien;
	}
	

}
