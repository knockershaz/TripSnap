package com.app.TripSnap.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.TripSnap.Models.Bus;
import com.app.TripSnap.Repository.BusRepository;

@RestController
@RequestMapping("/api")
public class BusController {
	
	@Autowired
	private BusRepository busRepository;
	
	@PostMapping("/bus/add")
	public Bus addBus(@RequestBody Bus bus) {
		busRepository.save(bus);
		return bus;
	}
	
	
	@GetMapping("/bus")
	public List<Bus> getAllBus(){
		return (List<Bus>) busRepository.findAll();
	}
	
	@GetMapping("/bus/{id}")
	public Optional<Bus> getById(@PathVariable(value="id")int id) {
		return busRepository.findById(id);
	}
	

}
