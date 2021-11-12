package com.qa.animalcrossing.villager.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qa.animalcrossing.villager.domain.Villager;
import com.qa.animalcrossing.villager.service.VillagerService;


//This class has all of the resources for my API
//It serves as the business logic for managing villagers (business/service layer)

@RestController //makes this class serve rest end-points 
@RequestMapping(path = "api/v1/villager") //(value = "/villager") adds this to the end points
public class VillagerController {
	
	//referencing the Villager service class
	private final VillagerService villagerService;
	private Object service;
	
	//Constructor
	@Autowired  //magically instantiates villagerService for me and injects it into the constructor 
	public VillagerController(VillagerService villagerService) {
		this.villagerService = villagerService;
	}

	//---demo---
	@GetMapping("/hello") // listen for a request at /hello
	public String hello() {
		return "Hello, World!"; // sends response!
	}
	
	@PostMapping("/create") // receives and processes POST request. Creates new villager and saves to db
	public ResponseEntity<Villager> createVillager(@RequestBody Villager newVillager) { 
		Villager responseBody = ((VillagerService) this.service).createVillager(newVillager);
		return new ResponseEntity<Villager>(responseBody, HttpStatus.CREATED);
	}

	//a rest end-point method
//	The function receives a GET request, processes it and gives back a list of villagers as a response.
	@GetMapping ({"/villagers/{villagerId}"}) //Gets info about a villager and throws an exception if not found.
	public ResponseEntity<List<Villager>> getAllVillagers() {
        List<Villager> villagers = VillagerService.getVillagers();
        return new ResponseEntity<>(villagers, HttpStatus.OK);
    }
	//this does the same but for the id 
	@GetMapping({"/{villagerId}"})
    public ResponseEntity<Villager> getVillager(@PathVariable Integer villagerId) {
        return new ResponseEntity<>(villagerService.getVillager(villagerId), HttpStatus.OK);
	}
	
	
    //The function receives a PUT request, updates the Todo with the specified Id and returns the updated Todo
    @PutMapping({"/{villagerId}"})
    public ResponseEntity<Villager>replaceVillager(@PathVariable("villagerId") 
    Integer villagerId, @RequestBody Villager villager) {
        villagerService.replaceVillager(villagerId, villager);
        System.out.println("Villager with id of " + villagerId + " has been updated.");
        return new ResponseEntity<>(villagerService.getVillager(villagerId), HttpStatus.OK);
    }
	
    //The function receives a DELETE request, deletes the villager with the specified Id.
    @DeleteMapping({"/{villagerId}"})
    public ResponseEntity<Villager> deleteVillager(@PathVariable("villagerId") Integer villagerId) {
        villagerService.getVillager(villagerId);
        System.out.println("Villager with id of " + villagerId + " has been deleted.");
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
	
}