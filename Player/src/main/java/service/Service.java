package service;
import java.io.IOException;

import exceptionPackage.PlayerDaoImplException;
import exceptionPackage.ServicePlayerImplException;
public interface Service {
	void addPlayer(String playerName, int runScored, int ballTaken) throws ServicePlayerImplException;

	void deletePlayer(String playerName) throws ServicePlayerImplException;

	void update(String playerName, int runScored, int ballTaken) throws ServicePlayerImplException;

	void writeFile() throws PlayerDaoImplException, IOException;

	void topThreeStrike() throws ServicePlayerImplException;


}
