package com.qa.animalcrossing.villager.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.qa.animalcrossing.villager.domain.Villager;

@Service
public interface VillagerService {
	
	Villager createVillager(Villager newVillager);

	static List<Villager> getVillagers() {
		// TODO Auto-generated method stub
		return null;
	}

	Villager getVillager(Long id);

	Villager replaceVillager(Long id, Villager newVillager);

	boolean removeVillager(Long id);

}
	
	
	
