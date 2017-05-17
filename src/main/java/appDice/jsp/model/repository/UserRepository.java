package appDice.jsp.model.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import appDice.jsp.model.User;


public interface UserRepository extends CrudRepository<User, Integer> {
	List<User> findAll();
	User findByEmail(String email);
}

