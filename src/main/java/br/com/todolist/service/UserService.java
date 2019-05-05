package br.com.todolist.service;

import static br.com.todolist.entity.builder.UserBuilder.newUser;
import static br.com.todolist.security.enums.RoleEnum.ROLE_ADMIN;
import static br.com.todolist.utils.PasswordUtil.encode;
import static java.util.Arrays.asList;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

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
		Response<UserDTO> response = new Response<>();
		if(verifyNewUserIsAdminAndUserCreatorIsNotAdmin(userDTO)) {
			response.addError("Apenas administradores podem criar outros usuários administradores.");
			return response;
		}
		
		User user = newUser().named(userDTO.getName()).withEmail(userDTO.getEmail()).now();
		user.setPassword(encode(userDTO.getPassword()));
		try {
			userRepository.save(user);
		} catch (DataIntegrityViolationException e) {
			response.addError("Já existe um usuário com este mesmo e-mail. Utilize outro.");
			return response;
		}
		response.setData(userDTO);
		return response;
	}

	private boolean verifyNewUserIsAdminAndUserCreatorIsNotAdmin(UserDTO userDTO) {
		return (ROLE_ADMIN.name().equals(userDTO.getRole()) && ObjectUtils.isEmpty(userDTO.getUserCreator()))
				|| (ROLE_ADMIN.name().equals(userDTO.getRole()) && !ROLE_ADMIN.name().equals(userDTO.getUserCreator().getRole()));
	}
	
	public User findByEmail(String email) {
		return userRepository.findByEmail(email);
	}
	
	
}
