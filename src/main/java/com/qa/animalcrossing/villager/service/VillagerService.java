package com.qa.animalcrossing.villager.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.qa.animalcrossing.villager.domain.Villager;

@Service
public interface VillagerService {
	
	Villager createVillager(Villager newVillager);

	static List<Villager> getVillagers() {
		return null;
	}

	Villager getVillager(Integer villagerId);

	Villager replaceVillager(Integer id, Villager newVillager);

	boolean removeVillager(Integer id);

}
	
	
	
