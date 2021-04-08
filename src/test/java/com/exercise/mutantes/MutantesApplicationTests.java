package com.exercise.mutantes;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;


@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
class MutantesApplicationTests {
	
	private final String URI_STAT = "/api/mutants/stats";
	private final String URI_MUTANT = "/api/mutants/mutant";
	
	@Autowired
	private MockMvc mockMvc;

	@Test
	void contextLoads() {
	}
	
	@Test
	public void testStat() throws Exception {
		this.mockMvc.perform(
				get(URI_STAT)
					.contentType(MediaType.APPLICATION_JSON_UTF8))
				.andExpect(status().isOk());

	}
	
	@Test
	public void testMutant() throws Exception {
		String request = 
				"{\n"+ 
			    "  \"params\": {\n"+ 
				"      \"dna\": " +
				"        [\"ATGCGA\",\n" + 
				"         \"CAGTGC\",\n" + 
				"         \"TTATGT\",\n" + 
				"         \"AGAAGG\",\n" + 
				"         \"CCCCTA\",\n" + 
				"         \"TCACTG\" " + 
				"        ]\n" +
				"  }" + 
				"}"; 
		
		this.mockMvc.perform(
				post(URI_MUTANT)
					.contentType(MediaType.APPLICATION_JSON_UTF8)
					.content(request.getBytes()))
				.andExpect(status().isOk());

	}
	
	@Test
	public void testNotMutant() throws Exception {
		String request = 
				"{\n"+ 
			    "  \"params\": {\n"+ 
				"      \"dna\": " +
				"        [\"ACCTATC\",\n" + 
				"         \"CTCACTT\",\n" + 
				"         \"ACGCTAT\",\n" + 
				"         \"ACCTACC\",\n" + 
				"         \"CAATTCC\",\n" + 
				"         \"CACCAAT\",\n" + 
				"         \"CAACAAT\"" +
				"        ]\n" +
				"  }" + 
				"}"; 
		
		this.mockMvc.perform(
				post(URI_MUTANT)
					.contentType(MediaType.APPLICATION_JSON_UTF8)
					.content(request.getBytes()))
				.andExpect(status().isForbidden());

	}
	
}
