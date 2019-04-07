package br.com.todolist.security.service.interfaces;

import java.util.Optional;

import br.com.todolist.security.entity.User;

public interface IUserService {

	Optional<User> findByEmail(String email);
}
