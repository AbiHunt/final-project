package com.qa.animalcrossing.villager.service;

import java.util.List;
import java.util.Optional;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.ConverterNotFoundException;

import com.qa.animalcrossing.villager.domain.Villager;
import com.qa.animalcrossing.villager.repo.VillagerRepo;


@Configuration //indicates this class will declare one or more beans 
public class VillagerServiceDB implements VillagerService{
	
	//my villager service db needs a repo because that's how it interacts with a database
	private VillagerRepo repo;
	
	public VillagerServiceDB(VillagerRepo repo) {
		super();
		this.repo = repo;
	}
	
	@Override
	public Villager createVillager(Villager newVillager) {
		return this.repo.save(newVillager);

	}

	public List<Villager> getVillagers() {
		return this.repo.findAll(); 
	}

	@Override
	public Villager getVillager(Integer id) {
		Optional<Villager> villagerOptional = this.repo.findById(id);

		if (villagerOptional.isPresent()) {
			Villager villager = villagerOptional.get();
			return villager;
		} else {
			throw new ConverterNotFoundException(null, null);
		}
	}

	@Override
	public Villager replaceVillager(Integer id, Villager newVillager) {
		Villager existing = this.getVillager(id);

		existing.setName(newVillager.getName());
		existing.setAnimalType(newVillager.getAnimalType());
		existing.setPersonality(newVillager.getPersonality());
		existing.setNpc(newVillager.isNpc());
		existing.setHeight(newVillager.getHeight());
		
		return this.repo.save(existing);
	}

	@Override
	public boolean removeVillager(Integer id) {
		this.repo.deleteById(id);
		return !this.repo.existsById(id);

	}

}	