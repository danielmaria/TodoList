package br.com.todolist.service;

import java.util.Arrays;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.todolist.dto.UserDTO;
import br.com.todolist.entity.User;
import br.com.todolist.repository.UserRepository;
import br.com.todolist.service.interfaces.IUserService;
import br.com.todolist.utils.Response;

@Service
public class UserService implements IUserService {
	
	@Autowired
	private UserRepository userRepository;

	public Response<UserDTO> createUser(@Valid UserDTO userDTO) {
		User user = new User();
		user.setName(userDTO.getName());
		user.setEmail(userDTO.getEmail());
		user.setPassword(new BCryptPasswordEncoder().encode(userDTO.getPassword()));
		Response<UserDTO> response = new Response<UserDTO>();
		try {
			userRepository.save(user);
		} catch (DataIntegrityViolationException e) {
			response.setErrors(Arrays.asList("Já existe um usuário com este mesmo e-mail. Utilize outro."));
			return response;
		}
		response.setData(userDTO);
		return response;
	}
	
	public User findByEmail(String email) {
		return userRepository.findByEmail(email);
	}
	
	
}