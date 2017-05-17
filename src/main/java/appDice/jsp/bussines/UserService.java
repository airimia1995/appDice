package appDice.jsp.bussines;

import java.util.List;

import appDice.jsp.model.User;



public interface UserService {

	public User save(User user);
	
	public List<User> findAll();
	
	public User findByEmail(String email);
	
	public User create(User user);
}
