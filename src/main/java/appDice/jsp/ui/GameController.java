package appDice.jsp.ui;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;

import org.springframework.ui.ModelMap;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import appDice.jsp.bussines.GameService;
import appDice.jsp.bussines.UserService;
import appDice.jsp.model.Game;
;

@Controller
public class GameController {

	
	@Autowired
	private UserService userService;
	@Autowired
    private GameService gameService;
	
	
	@RequestMapping(value ={ "/" }, method = RequestMethod.GET)
	public String game( ModelMap model) {
		model.addAttribute("user",userService.findByEmail(SecurityContextHolder.getContext().getAuthentication().getName()));
        try{
        	Game game =  gameService.findLastGame(); 	
        	
        	if(game.getComputerScore() > game.getUserScore())
        	    model.addAttribute("lastGameWinner","The computer won the last game, play again to win!");
        	else if(game.getComputerScore() < game.getUserScore())
        		model.addAttribute("lastGameWinner", "You won the last game");
        	else if(game.getComputerScore() == game.getUserScore())
        		model.addAttribute("lastGameWinner", "It was equal, play again to win!");
        	
        	model.addAttribute("lastGame", game);
        }
        catch(Exception e){
        	
        	model.addAttribute("error", "Oh, you are new here, lets play!");
        }
		return "game";
	}

	
	
	@RequestMapping(value = "/",
			method = RequestMethod.POST,
			consumes=MediaType.APPLICATION_JSON_VALUE)
	public String signedUp(@RequestBody Game game)  {
	    gameService.save(game);
	    
	   
	    return "game";
	}
 
	
}
