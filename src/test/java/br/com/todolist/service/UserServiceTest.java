package br.com.todolist.service;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ErrorCollector;
import org.junit.rules.ExpectedException;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.util.CollectionUtils;

import br.com.todolist.dto.UserDTO;
import br.com.todolist.dto.builder.UserDTOBuilder;
import br.com.todolist.entity.User;
import br.com.todolist.repository.UserRepository;
import br.com.todolist.utils.Response;

public class UserServiceTest {
	
	@Rule
	public ErrorCollector error = new ErrorCollector();
	
	@Rule
	public ExpectedException exception = ExpectedException.none();
	
	@InjectMocks
	private UserService userService;
	
	@Mock
	private UserRepository userRepository;
	
	@Before
	public void setup(){
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void createUserAdminWithUserCreatorIsNotAdmin() {
		UserDTO user = UserDTOBuilder.newDtoUser().withRole("ROLE_ADMIN").now();
		UserDTO userCreator = UserDTOBuilder.newDtoUser().withRole("ROLE_USER").now();
		
		user.setUserCreator(userCreator);
		
		Response<UserDTO> createUserResponse = userService.createUser(user);
		assertFalse(CollectionUtils.isEmpty(createUserResponse.getErrors()));
		assertThat(createUserResponse.getErrors().get(0), is("Apenas administradores podem criar outros usuários administradores."));
	}
	
	@Test
	public void createUserAdminWithUserCreatorIsAdmin() {
		UserDTO user = UserDTOBuilder.newDtoUser().withRole("ROLE_ADMIN").now();
		UserDTO userCreator = UserDTOBuilder.newDtoUser().withRole("ROLE_ADMIN").now();
		
		user.setUserCreator(userCreator);
		
		Mockito.when(userRepository.save(Mockito.any(User.class))).thenReturn(new User());
		
		Response<UserDTO> createUserResponse = userService.createUser(user);
		assertTrue(CollectionUtils.isEmpty(createUserResponse.getErrors()));
	}
	
	@Test
	public void createUserAdminWithUserCreatorHasProblem() {
		UserDTO user = UserDTOBuilder.newDtoUser().withRole("ROLE_ADMIN").now();
		Response<UserDTO> createUserResponse = userService.createUser(user);
		error.checkThat("Create user admin with user creator is null", CollectionUtils.isEmpty(createUserResponse.getErrors()), is(false));
		
		UserDTO userCreator = new UserDTO();
		user.setUserCreator(userCreator);
		createUserResponse = userService.createUser(user);
		error.checkThat("Create user admin with user creator have null role", CollectionUtils.isEmpty(createUserResponse.getErrors()), is(false));
	}
	

}
