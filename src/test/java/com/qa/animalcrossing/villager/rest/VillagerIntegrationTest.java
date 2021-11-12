//package com.qa.animalcrossing.villager.rest;
//
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//import java.util.List;
//
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.http.MediaType;
//import org.springframework.test.context.ActiveProfiles;
//import org.springframework.test.context.jdbc.Sql;
//import org.springframework.test.context.jdbc.Sql.ExecutionPhase;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.RequestBuilder;
//import org.springframework.test.web.servlet.ResultMatcher;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.qa.animalcrossing.villager.domain.Villager;
//
//@SpringBootTest  //boots up test
//@AutoConfigureMockMvc //instructs spring to make mockmvc object
//						//which sends test requests
//@Sql(scripts = { "classpath:villager-schema.sql",
//				 "classpath:vllager-data.sql" } , executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)//runs both files before each test
//@ActiveProfiles("test")
//public class VillagerIntegrationTest {
//
//	@Autowired //auto injects object
//	private MockMvc mvc;
//	
//	
//	@Autowired 
//	private ObjectMapper mapper; //JSON converter
//
//	@Test
//	void testCreate() throws Exception {
//		Villager requestBody = new Villager("Kiki", "Cat", "Normal", false, 80);
//		String requestBodyAsJSON = this.mapper.writeValueAsString(requestBody);
//
//		RequestBuilder request = post("/villager/create").contentType(MediaType.APPLICATION_JSON)
//				.content(requestBodyAsJSON); // sets up the test request
//
//		Villager responseBody = new Villager(2, "Kiki 2", "Cat", "Normal" ,false, 44);
//		String responseBodyAsJSON = this.mapper.writeValueAsString(responseBody);
//
//		ResultMatcher checkStatus = status().isCreated(); // check the status code is 201
//		ResultMatcher checkBody = content().json(responseBodyAsJSON); // check the body matches the example
//
//		this.mvc.perform(request).andExpect(checkStatus).andExpect(checkBody); // performs request and checks the
//																				// response
//	}
//
//	@Test
//	void testVillagerNotFound() throws Exception {
//		this.mvc.perform(get("/villager/get/9999999")).andExpect(status().isNotFound());
//	}
//
//	@Test
//	void testGetAll() throws Exception {
//
//		RequestBuilder request = get("/villager/getAll");
//
//		ResultMatcher checkStatus = status().isOk();
//
//		Villager villager = new Villager(1, "Lily", "Frog", "Normal", false, 60);
//		List<Villager> villagers = List.of(villager);
//		String responseBody = this.mapper.writeValueAsString(villagers);
//		ResultMatcher checkBody = content().json(responseBody);
//
//		this.mvc.perform(request).andExpect(checkStatus).andExpect(checkBody);
//	}
//
//	@Test
//	void testGet() throws Exception {
//		final String responseBody = this.mapper.writeValueAsString(new Villager(1, "Lily", "Frog", "Normal", false, 60));
//		this.mvc.perform(get("/villager/get/1")).andExpect(status().isOk()).andExpect(content().json(responseBody));
//	}
//
//	@Test
//	void testReplace() throws Exception {
//		final String responseBody = this.mapper.writeValueAsString(new Villager(1, "Snake", "Rabbit", "Jock", false, 120));
//
//		RequestBuilder request = put("/villager/replace/1").contentType(MediaType.APPLICATION_JSON).content(responseBody);
//
//		ResultMatcher checkStatus = status().isAccepted();
//		ResultMatcher checkBody = content().json(responseBody);
//
//		this.mvc.perform(request).andExpect(checkStatus).andExpect(checkBody);
//	}
//
//	@Test
//	void testDelete() throws Exception {
//		this.mvc.perform(delete("/villager/remove/1")).andExpect(status().isNoContent());
//	}
//
//}
