package br.com.todolist.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

public class UserDTO {

	private Long id;
	private String name;
	private String email;
	private String password;
	private String role;
	private UserDTO userCreator;
	
 	public Long getId() {
		return id;
	}

	@NotNull(message = "O nome do usuário não pode ser vazio.")
	@Length(min = 5, message = "O nome não pode conter menos que 5 caracteres.")
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	@Email
	@NotNull(message = "O email do usuário não pode ser vazio.")
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	@NotNull(message = "A senha do usuário não pode ser vazia.")
	@Length(min = 5, max = 25, message = "Sua senha deve conter de 5 a 25 caracteres.") 
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}

	public UserDTO getUserCreator() {
		return userCreator;
	}
	public void setUserCreator(UserDTO userCreator) {
		this.userCreator = userCreator;
	}
	
	
}
