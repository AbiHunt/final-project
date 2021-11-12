//my app loads through this main class 

package com.qa.animalcrossing;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.RestController;

import com.qa.animalcrossing.villager.service.VillagerService;

@SpringBootApplication
public class AnimalCrossingAhApplication {

	// main method here
		public static void main(String[] args) throws Exception {
			ApplicationContext ac = SpringApplication.run(AnimalCrossingAhApplication.class, args);

			VillagerService service = ac.getBean(VillagerService.class);

			System.out.println(service);

		}
	}
