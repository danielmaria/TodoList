package br.com.todolist;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import br.com.todolist.entity.StickyNote;
import br.com.todolist.entity.User;
import br.com.todolist.repository.UserRepository;
import br.com.todolist.security.enums.RoleEnum;

@SpringBootApplication
public class TodoListApplication {
	
	@Autowired
	private UserRepository userRepository;

	public static void main(String[] args) {
		SpringApplication.run(TodoListApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner commandLineRunner() {
		return args -> {
			System.out.println("### Project is running ###");
			List<StickyNote> stickNotes = new ArrayList<>();
			StickyNote stickyNote = new StickyNote();
			User regularUser = new User();
			stickyNote.setNote("Teste");
			stickyNote.setUserCreated(regularUser);
			stickNotes.add(stickyNote);
			
			regularUser.setEmail("user@email.com.br");
			regularUser.setName("User");
			regularUser.setPassword("123456");
			regularUser.setRole(RoleEnum.ROLE_USER);
			regularUser.setStickyNotes(stickNotes);
			userRepository.save(regularUser);
			
			User adminUser = new User();
			adminUser.setEmail("admin@email.com.br");
			adminUser.setName("User");
			adminUser.setPassword("123456");
			adminUser.setRole(RoleEnum.ROLE_ADMIN);
//			adminUser.setStickyNotes(stickNotes);
			adminUser.getFriendUsers().add(regularUser);
			userRepository.save(adminUser);
			
		};
	}

}
