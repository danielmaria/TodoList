package br.com.todolist.security.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public class JwtAuthenticationDTO {

	private String email;
	private String password;

	public JwtAuthenticationDTO() {
	}

	@NotBlank(message = "Email não pode ser vazio.")
	@Email(message = "Email inválido.")
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@NotBlank(message = "Senha não pode ser vazia.")
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "JwtAuthenticationRequestDto [email=" + email + ", password=" + password + "]";
	}

}
