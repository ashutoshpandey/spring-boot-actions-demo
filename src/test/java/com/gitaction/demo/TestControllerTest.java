package com.gitaction.demo;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.HashMap;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
class TestControllerTest {

	@Autowired
    private MockMvc mvc;

    @Test
    public void getHello() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/hello").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo("hello")));
    }

    @Test
    public void getBye() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/bye").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo("bye")));
    }

    @Test
    public void sayByeToName() throws Exception {
    	HashMap<String, String> data = new HashMap<>();
    	data.put("name", "Ashutosh");
    	
    	System.out.println(new ObjectMapper().writeValueAsString(data));
    	
        mvc.perform(
    		MockMvcRequestBuilders.post("/bye-to-name")
    		.accept(MediaType.APPLICATION_JSON)
    		.contentType(MediaType.APPLICATION_JSON)
    		.content(new ObjectMapper().writeValueAsString(data))
    	)        		
		.andExpect(status().isOk())
        .andExpect(content().string(equalTo("Bye Ashutosh")));
    }
}
