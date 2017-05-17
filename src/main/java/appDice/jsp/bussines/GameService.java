package appDice.jsp.bussines;



import appDice.jsp.model.Game;


public interface GameService {
	public Game save(Game game);
	
	Game findLastGame( );
}
