package com.ennate.code.challenge.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.ennate.code.challenge.CodechallengeApplicationTests;
import com.ennate.code.challenge.entity.Alerts;
import com.ennate.code.challenge.service.impl.AlertsService;

@RunWith(SpringRunner.class)
public class AlertsControllerTest extends CodechallengeApplicationTests{

	@Autowired
	protected WebApplicationContext context;
	
	@MockBean
	protected AlertsService service;

	@InjectMocks
	protected AlertsController controller;

	protected MockMvc mockMvc;
	
	String json = "{\"timeStamp\": \"" + String.valueOf(System.currentTimeMillis()) + "\", \"value\": \"150\"}";
	

	@Before
	public void setup() {

		MockitoAnnotations.initMocks(this);
		this.mockMvc = MockMvcBuilders.standaloneSetup(controller)
				.build();

	}

	@Test
	public void testHappyPath() throws Exception{
			
		when(service.fetchAll()).thenReturn(new ArrayList<Alerts>());
		
		mockMvc
        .perform(get("/v1/metrics/read"))
        .andExpect(status().isOk());

	}
	
	@Test
	public void testExecption() throws Exception{
			
		when(service.fetchAll()).thenThrow(RuntimeException.class);
		
		mockMvc
        .perform(get("/v1/metrics/read"))
        .andExpect(status().is5xxServerError());

	}
	
	@Test
	public void testTimeRangeHappPath() throws Exception{
			
		when(service.fetchByTimeStampRange(Mockito.anyLong(), Mockito.anyLong())).thenReturn(new ArrayList<Alerts>());
		
		mockMvc
        .perform(get("/v1/metrics/readByTimeRange?start=3434&end=43534"))
        .andExpect(status().isOk());

	}
	
	@Test
	public void testTimeRangeExecption() throws Exception{
			
		when(service.fetchByTimeStampRange(Mockito.anyLong(), Mockito.anyLong())).thenThrow(RuntimeException.class);
		
		mockMvc
        .perform(get("/v1/metrics/readByTimeRange?start=3434&end=43534"))
        .andExpect(status().is5xxServerError());

	}
	
}
