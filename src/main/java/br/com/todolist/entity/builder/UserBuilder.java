package br.com.todolist.entity.builder;

import br.com.todolist.entity.User;
import br.com.todolist.security.enums.RoleEnum;

public class UserBuilder {
	
	private User user;
	
	private UserBuilder() {}
	
	public static UserBuilder newUser() {
		UserBuilder builder = new UserBuilder();
		builder.user = new User();
		return builder;
	}
	
	public UserBuilder named(String name){
		this.user.setName(name);
		return this;
	}
	
	public UserBuilder withEmail(String email){
		this.user.setEmail(email);
		return this;
	}
	
	public UserBuilder withRole(String role){
		this.user.setRole(RoleEnum.getRole(role));
		return this;
	}
	
	public UserBuilder withRole(RoleEnum role){
		this.user.setRole(role);
		return this;
	}
	
	public User now() {
		return user;
	}

}
