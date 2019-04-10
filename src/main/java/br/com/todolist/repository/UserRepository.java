package br.com.todolist.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import br.com.todolist.entity.User;

@RepositoryRestResource
public interface UserRepository extends JpaRepository<User, Long> {
	User findByEmail(String email);
}
