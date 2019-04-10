package br.com.todolist.service.interfaces;

import br.com.todolist.entity.User;

public interface IUserService {

	User findByEmail(String email);
}
