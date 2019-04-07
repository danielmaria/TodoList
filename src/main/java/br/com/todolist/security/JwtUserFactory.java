package br.com.todolist.security;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import br.com.todolist.security.entity.User;
import br.com.todolist.security.enums.RoleEnum;

public class JwtUserFactory {
	private JwtUserFactory() {
	}

	/**
	 * Generate a JwtUser with User datas.
	 * 
	 * @param user
	 * @return JwtUser
	 */
	public static JwtUser create(User user) {
		return new JwtUser(user.getId(), user.getEmail(), user.getPassword(),
				mapToGrantedAuthorities(user.getRole()));
	}

	/**
	 * Convert the enum to enum type used by Spring Security.
	 * 
	 * @param roleEnum
	 * @return List<GrantedAuthority>
	 */
	private static List<GrantedAuthority> mapToGrantedAuthorities(RoleEnum roleEnum) {
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		authorities.add(new SimpleGrantedAuthority(roleEnum.toString()));
		return authorities;
	}
	
}
