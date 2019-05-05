package br.com.todolist.service.interfaces;

import br.com.todolist.dto.UserDTO;
import br.com.todolist.entity.User;
import br.com.todolist.utils.Response;

public interface IUserService {

	User findByEmail(String email);
	
	Response<UserDTO> createUser(UserDTO userDTO);
}
