package br.com.todolist.utils;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import br.com.todolist.dto.UserDTO;

import java.util.ArrayList;

public class ResponseTest {
    private Response<UserDTO> response;

    @Before
    public void setup(){
        this.response = new Response<>();
    }

	@Test
	public void hasErrorsTest() {
		response.getErrors().add("Gereric Error");
		assertTrue(response.hasErrors());
	}
	
	@Test
	public void hasntErrorsTest() {
		assertFalse(response.hasErrors());
	}

	@Test
	public void errorsIsNullTest() {
        response.setErrors(null);
		assertFalse(response.hasErrors());
	}

    @Test
    public void addErrorEmpty() {
        response.addError("");
        assertFalse(response.hasErrors());
    }

    @Test
    public void addNullError() {
        response.addError(null);
        assertFalse(response.hasErrors());
    }

    @Test
    public void addValidError() {
        response.addError("Erro");
        assertTrue(response.hasErrors());
    }


}
