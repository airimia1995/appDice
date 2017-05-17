package appDice.jsp.model.repository;



import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import appDice.jsp.model.Game;
import appDice.jsp.model.User;

public interface GameRepository extends CrudRepository<Game, Integer> {

	@Query("Select max(h) from Game h where h.user =:user ")
	Game findLastGame(@Param("user") User user);
	
}
