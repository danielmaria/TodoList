package br.com.todolist.dto.builder;

import br.com.todolist.dto.UserDTO;

public class UserDTOBuilder {
	
	private UserDTO user;
	
	private UserDTOBuilder() {}
	
	public static UserDTOBuilder newDtoUser() {
		UserDTOBuilder builder = new UserDTOBuilder();
		builder.user = new UserDTO();
		return builder;
	}
	
	public UserDTOBuilder named(String name){
		this.user.setName(name);
		return this;
	}
	
	public UserDTOBuilder withEmail(String email){
		this.user.setEmail(email);
		return this;
	}
	
	public UserDTOBuilder withRole(String role){
		this.user.setRole(role);
		return this;
	}
	
	public UserDTO now() {
		return user;
	}

}
