package br.com.todolist.security.enums;

public enum RoleEnum {
	ROLE_ADMIN,
	ROLE_USER;

	public static RoleEnum getRole(String role) {
		switch (role) {
			case "ADMIN":
			case "ROLE_ADMIN":
				return ROLE_ADMIN;
				
			case "USER":
			case "ROLE_USER":
				return ROLE_USER;
				
			default:
				return ROLE_USER;
		}
	}
}
