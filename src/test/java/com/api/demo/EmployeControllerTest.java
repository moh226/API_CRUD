package com.api.demo;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
public class EmployeControllerTest {
	
	@Autowired
	public MockMvc mockMvc;
	
	@Test
	public void testGetEmploye() throws Exception {
		
		mockMvc.perform(get("/employe")).andExpect(status().isOk()).andExpect(jsonPath("$[0].firstName", is("Laurent")));  
		
	}

}
