package br.com.todolist.security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import br.com.todolist.entity.User;
import br.com.todolist.security.JwtUserFactory;
import br.com.todolist.service.UserService;

@Service
public class JwtUserDetailsService implements UserDetailsService {

	@Autowired
	private UserService usuarioService;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User funcionario = usuarioService.findByEmail(username);

		if (!ObjectUtils.isEmpty(funcionario)) {
			return JwtUserFactory.create(funcionario);
		}

		throw new UsernameNotFoundException("Email não encontrado.");
	}

}
