package appDice.jsp.bussines.serviceImp;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import appDice.jsp.bussines.GameService;
import appDice.jsp.model.Game;

import appDice.jsp.model.repository.GameRepository;
import appDice.jsp.model.repository.UserRepository;

@Component
public class GameServiceImp implements GameService {

	@Autowired
	private GameRepository gameRepository;

	@Autowired
	private UserRepository userRepository;
	

	
	@Override
	public Game save(Game game) {
		Date date  = new Date();
		game.setDate(date);
		game.setUser(userRepository.findByEmail( SecurityContextHolder.getContext().getAuthentication().getName()));
		return gameRepository.save(game);
	}


	@Override
	public Game findLastGame() {
		
		return gameRepository.findLastGame(userRepository.findByEmail( SecurityContextHolder.getContext().getAuthentication().getName()));
	}
}
