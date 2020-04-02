package daoLayer;
import java.util.List;

import entity.Player;
import exceptionPackage.PlayerDaoImplException;
import exceptionPackage.PlayerNotFoundException;
public interface DaoLayer {
	



		 public void addPlayerInDataBase(String playerName, int runScored, int ballTaken) throws PlayerDaoImplException;

		public void deleteFromDataBase(String playerName) throws PlayerNotFoundException, PlayerDaoImplException;

		public void updateInDataBase(String playerName, int runScored, int ballTaken) throws PlayerNotFoundException, PlayerDaoImplException;

		public List<Player> WriteFileFronDatabase(List<Player> list) throws PlayerDaoImplException;

		public List<Player> topThreeStrike(List<Player> list) throws PlayerDaoImplException;

	}



