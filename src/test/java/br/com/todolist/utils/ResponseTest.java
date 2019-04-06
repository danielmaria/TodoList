package br.com.todolist.utils;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import br.com.todolist.dto.UserDTO;

public class ResponseTest {

	@Test
	public void hasErrorsTest() {
		Response<UserDTO> response = new Response<>();
		response.getErrors().add("Gereric Error");
		assertTrue(response.hasErrors());
	}
	
	@Test
	public void hasntErrorsTest() {
		Response<UserDTO> response = new Response<>();
		assertFalse(response.hasErrors());
	}
	
	@Test
	public void errorsIsNullTest() {
		Response<UserDTO> response = new Response<>();
		response.setErrors(null);
		assertFalse(response.hasErrors());
	}

}
