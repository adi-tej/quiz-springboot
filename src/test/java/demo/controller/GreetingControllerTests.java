/*
 * Copyright 2016 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package demo.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;

import demo.entity.User;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class GreetingControllerTests {

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void noParamGreetingShouldReturnDefaultMessage() throws Exception {

		this.mockMvc.perform(get("/greeting")).andDo(print()).andExpect(status().isOk())
				.andExpect(jsonPath("$.content").value("Hello, World!"));
	}

	@Test
	public void paramGreetingShouldReturnTailoredMessage() throws Exception {

		this.mockMvc.perform(get("/greeting").param("name", "Spring Community")).andDo(print())
				.andExpect(status().isOk()).andExpect(jsonPath("$.content").value("Hello, Spring Community!"));
	}

	@Test
	/**
	 * Test with param Tom
	 * totalNumbers should be number, and name should be Tom
	 * @throws Exception
	 */
	public void paramTomShouldReturnTotalNumber() throws Exception {
		this.mockMvc.perform(post("/user").content(asJsonString(new User(0, "Tom"))).contentType(MediaType.APPLICATION_JSON)
			      .accept(MediaType.APPLICATION_JSON)).andDo(print())
				.andExpect(status().isOk()).andExpect(jsonPath("$.totalNumbers").isNumber()).andExpect(jsonPath("$.name").value("Tom"));

	}
	
	@Test
	/**
	 * Test with param John
	 * totalNumbers should be number, and name should be John
	 * @throws Exception
	 */
	public void paramJohnShouldReturnTotalNumber() throws Exception {
		this.mockMvc.perform(post("/user").content(asJsonString(new User(0, "John"))).contentType(MediaType.APPLICATION_JSON)
			      .accept(MediaType.APPLICATION_JSON)).andDo(print())
				.andExpect(status().isOk()).andExpect(jsonPath("$.totalNumbers").isNumber()).andExpect(jsonPath("$.name").value("John"));
	}
	
	@Test
	/**
	 * Test with param emily
	 * totalNumbers should be zero, and name should be emily
	 * @throws Exception
	 */
	public void paramEmilyShouldReturnZero() throws Exception {
		this.mockMvc.perform(post("/user").content(asJsonString(new User(0, "emily"))).contentType(MediaType.APPLICATION_JSON)
			      .accept(MediaType.APPLICATION_JSON)).andDo(print())
				.andExpect(status().isOk()).andExpect(jsonPath("$.totalNumbers").value(0)).andExpect(jsonPath("$.name").value("emily"));
	}

	@Test
	/**
	 * Test without name
	 * totalNumbers should be zero
	 * @throws Exception
	 */
	public void noParamShouldReturnUserNotFound() throws Exception {
		this.mockMvc.perform(post("/user").content(asJsonString(new User(0, ""))).contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON)).andDo(print())
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.totalNumbers").value(0))
				.andExpect(jsonPath("$.name").value("Missing User Information"));
	}
	
	public static String asJsonString(final Object obj) {
	    try {
	        return new ObjectMapper().writeValueAsString(obj);
	    } catch (Exception e) {
	        throw new RuntimeException(e);
	    }
	}

}
