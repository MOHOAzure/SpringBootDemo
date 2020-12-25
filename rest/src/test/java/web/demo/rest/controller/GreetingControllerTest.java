package web.demo.rest.controller;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@WebMvcTest(GreetingController.class)
class GreetingControllerTest {
	
	@ Autowired
	private MockMvc mvc;
	
	@Test
	void testGreeting() throws Exception {
		//Arrange
		RequestBuilder request = MockMvcRequestBuilders.get("/greeting");
		
		//Act
		ResultActions result = mvc.perform(request).andDo(print());

		//Assert
		result.andExpect(status().isOk())
			.andExpect(content().string(containsString("Hello, World")));
	}

	@Test
	void testGreetingWithName() throws Exception {
		//Arrange
		RequestBuilder request = MockMvcRequestBuilders.get("/greeting?name=Ye");
		
		//Act
		ResultActions result = mvc.perform(request).andDo(print());

		//Assert
		result.andExpect(status().isOk()).andExpect(content().string(containsString("Hello, Ye")));
	}
}
