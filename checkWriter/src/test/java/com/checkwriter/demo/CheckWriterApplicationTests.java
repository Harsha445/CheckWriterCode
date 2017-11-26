package com.checkwriter.demo;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class CheckWriterApplicationTests {

	@Test
	public void contextLoads() {
	}

	 //@Autowired
	    private MockMvc mockMvc;

	 @Test
	    public void checkWriter() throws Exception {
	        mockMvc.perform(get("/checkWriter"))
	                .andExpect(content().string(containsString("dollars only")));
	    }
	 @Test
	    public void checkWriterWithData() throws Exception {
	        mockMvc.perform(get("/checkWriter").param("name", "125.75"))
	                .andExpect(content().string(containsString("One Hundred Twenty Five dollars and 75/100")));
	    }
	public MockMvc getMockMvc() {
		return mockMvc;
	}
	@Autowired(required = true)
	public void setMockMvc(MockMvc mockMvc) {
		this.mockMvc = mockMvc;
	}
}
