package br.com.todolist.controller;

import br.com.todolist.dto.UserDTO;
import br.com.todolist.service.UserService;
import br.com.todolist.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserService userService;
	
	@PostMapping
	@PreAuthorize("hasAnyRole('ADMIN')")
    public ResponseEntity<Response<UserDTO>> createUser(@Valid @RequestBody UserDTO user, BindingResult result) {
		if(result.hasErrors()) {
			Response<UserDTO> response = new Response<UserDTO>();
			result.getAllErrors().forEach(error -> response.getErrors().add(error.getDefaultMessage()));
			return ResponseEntity.badRequest().body(response);
		}
		Response<UserDTO> createUserResponse = userService.createUser(user);
		if(createUserResponse.hasErrors()) {
			return ResponseEntity.badRequest().body(createUserResponse);	
		}
		return ResponseEntity.ok(createUserResponse);
	}
	
}
