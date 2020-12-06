package com.avi;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.avi.model.Person;

public class AviApplicationTests extends AbstractTest {

	@Override
	@Before
	public void setUp() {
		super.setUp();
	}

	@Test
	public void getPersonList() throws Exception {
		String uri = "/person";
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
				.accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();

		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
		String content = mvcResult.getResponse().getContentAsString();
		Person[] personlist = super.mapFromJson(content, Person[].class);
		System.out.println("List of person : " + personlist);
		assertTrue(personlist.length > 0);
	}

	@Test
	public void getPersonCount() throws Exception {
		String uri = "/person/count";
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
				.accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();

		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
		String content = mvcResult.getResponse().getContentAsString();
		System.out.println(content);
	}

	@Test
	public void createPerson() throws Exception {
		String uri = "/person/put/15";
		Person person = new Person();
		person.setId((long) 15);
		person.setfName("AviJ");
		String inputJson = super.mapToJson(person);
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
				.contentType(MediaType.APPLICATION_JSON_VALUE)
				.content(inputJson)).andReturn();

		int status = mvcResult.getResponse().getStatus();
		assertEquals(405, status);
		String content = mvcResult.getResponse().getContentAsString();
		System.out.println(content);
	}
	
	@Test
	public void updatePerson() throws Exception {
		String uri = "/person/put/2";
		Person person = new Person();
		person.setId((long) 2);
		person.setfName("AviJa");
		String inputJson = super.mapToJson(person);
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.put(uri)
				.contentType(MediaType.APPLICATION_JSON_VALUE)
				.content(inputJson)).andReturn();

		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
		String content = mvcResult.getResponse().getContentAsString();
		System.out.println(content);
	}
	
	@Test
	public void deletePerson() throws Exception {
		String uri = "/person/delete/1";
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.delete(uri)).andReturn();
		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
		String content = mvcResult.getResponse().getContentAsString();
		System.out.println(content);
	}
}
