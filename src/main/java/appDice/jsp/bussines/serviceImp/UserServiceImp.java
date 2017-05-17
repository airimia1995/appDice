package appDice.jsp.bussines.serviceImp;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import appDice.jsp.bussines.UserService;
import appDice.jsp.model.repository.UserRepository;
import appDice.jsp.model.User;




@Component
public class UserServiceImp implements UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public User save(User user) {
		 user.setUserType("user");
	     BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
	     user.setPassword(encoder.encode(user.getPassword()));
	     user.setActive(false);
	     user.setLastSessionStart(new Date());
		return userRepository.save(user);
	}

	@Override
	public List<User> findAll() {
		// TODO Auto-generated method stub
		return userRepository.findAll();
	}

	@Override
	public User findByEmail(String email) {
		// TODO Auto-generated method stub
		return userRepository.findByEmail(email);
	}

	@Override
	public User create(User user) {
		// TODO Auto-generated method stub
		return userRepository.save(user);
	}

}
