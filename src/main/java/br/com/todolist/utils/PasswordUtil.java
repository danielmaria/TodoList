package br.com.todolist.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.util.StringUtils;

public class PasswordUtil {
	
	private PasswordUtil() {
		
	}
	
	public static String encode(String password) {
		if(StringUtils.isEmpty(password)) {
			return password;
		}
		return new BCryptPasswordEncoder().encode(password);
	}
	
	public static boolean compare(String password, String encodedPassword) {
		return new BCryptPasswordEncoder().matches(password, encodedPassword);
	}
	

}
