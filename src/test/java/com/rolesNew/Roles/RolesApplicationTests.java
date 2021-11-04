package com.rolesNew.Roles;

import com.rolesNew.Roles.roles.Roles;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class RolesApplicationTests extends AbstractTest {
	@Override
	@BeforeEach
	public void setUp() {
		super.setUp();
	}

//	@Test
//		void contextLoads() {
//	}


	@Test
	public void getAllRoles() throws Exception {
		String uri = "/getAll";
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
				.accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();

		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
		String content = mvcResult.getResponse().getContentAsString();
		Roles[] roles = super.mapFromJson(content, Roles[].class);
		assertTrue(roles.length > 0);
	}

	@Test
	public void createRoles() throws Exception {
		String uri="/addRole";
		Roles role = new Roles("TestDescription",true);
		String inputJson = super.mapToJson(role);

		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
				.contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson)).andReturn();

		int status = mvcResult.getResponse().getStatus();
		String content = mvcResult.getResponse().getContentAsString();
		assertEquals(200,status);

	}

	@Test
	public void updateRoles() throws Exception{
		int id=11;
		String uri="/updateRole/"+Integer.toString(id);
		Roles role = new Roles(id,"TestUpdateDesc",true);
		String inputJson = super.mapToJson(role);

		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.put(uri)
				.contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson)).andReturn();

		int status = mvcResult.getResponse().getStatus();
		String content = mvcResult.getResponse().getContentAsString();
		assertEquals(200,status);
		assertEquals(inputJson,content);
	}

	@Test
	public void deleteRoles() throws Exception{
		String uri="/deleteRole/12";

		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.delete(uri)).andReturn();
		int status = mvcResult.getResponse().getStatus();
		String content = mvcResult.getResponse().getContentAsString();
		assertEquals(200,status);

	}

}
