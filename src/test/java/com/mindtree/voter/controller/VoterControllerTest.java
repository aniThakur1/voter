package com.mindtree.voter.controller;




import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mindtree.voter.entity.Voter;
import com.mindtree.voter.service.VoterService;

@RunWith(SpringRunner.class)
@WebMvcTest(value=VoterController.class)
public class VoterControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private VoterService voterService;
	
	@Test
	public void testCreateVoter() throws Exception{
		
		Voter mockVoter = new Voter();
		mockVoter.setId("003");
		mockVoter.setName("Anurag");
		mockVoter.setGender("Male");
		mockVoter.setState("Chattisgarh");
		mockVoter.setCity("Raipur");
		
		String inputInJson = this.mapToJson(mockVoter);
		
		String URI = "/api/v1/voter";
		
		Mockito.when(voterService.createVoter(Mockito.any(Voter.class))).thenReturn(mockVoter);
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders
				.post(URI)
				.accept(MediaType.APPLICATION_JSON).content(inputInJson)
				.contentType(MediaType.APPLICATION_JSON);
		
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		
		MockHttpServletResponse response = result.getResponse();
		
		String outputInJson = response.getContentAsString();
		
		assertThat(outputInJson).isEqualTo(inputInJson);
		
		assertEquals(HttpStatus.OK.value(),response.getStatus());
		
		
		
				
	}
	@Test
	public void testGetAllVoter() throws Exception {
		Voter mockVoter1 = new Voter();
		mockVoter1.setId("003");
		mockVoter1.setName("Anurag");
		mockVoter1.setGender("Male");
		mockVoter1.setState("Chattisgarh");
		mockVoter1.setCity("Raipur");
		
		Voter mockVoter2 = new Voter();
		mockVoter2.setId("004");
		mockVoter2.setName("Vishal");
		mockVoter2.setGender("Male");
		mockVoter2.setState("Chattisgarh");
		mockVoter2.setCity("Raipur");
		
		List<Voter> voterList = new ArrayList<>();
		voterList.add(mockVoter1);
		voterList.add(mockVoter2);
		
		Mockito.when(voterService.getAllVoter()).thenReturn(voterList);
		
		String URI = "/api/v1/voter";
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
				URI).accept(MediaType.APPLICATION_JSON);
		
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		
		String expectedJson = this.mapToJson(voterList);
		String outputInJson = result.getResponse().getContentAsString();
		assertThat(outputInJson).isEqualTo(expectedJson);

		
		
	}
	
	
	private  String mapToJson(Object object) throws JsonProcessingException {
		ObjectMapper objectMapper = new ObjectMapper();
		return objectMapper.writeValueAsString(object);
	}

	

}
