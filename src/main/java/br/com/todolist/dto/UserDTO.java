package br.com.todolist.dto;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

public class UserDTO {

	private String name;
	private String login;
	private String password;
	
	@NotNull(message = "O nome do usuário não pode ser vazio.")
	@Length(min = 5, message = "O nome não pode conter menos que 5 caracteres.")
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@NotNull(message = "O login do usuário não pode ser vazio.")
	@Length(min = 5, message = "O login não pode conter menos que 5 caracteres.")
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	@NotNull(message = "A senha do usuário não pode ser vazia.")
	@Length(min = 5, max = 25, message = "Sua senha deve conter de 5 a 25 caracteres.") 
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
