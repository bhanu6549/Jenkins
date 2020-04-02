package service.serviceImpl;

import service.Service;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import daoLayer.DaoLayer;
import daoLayer.daoLayerImpl.DaoLayerImpl;
import entity.Player;
import exceptionPackage.PlayerDaoImplException;
import exceptionPackage.PlayerNotFoundException;
import exceptionPackage.ServicePlayerImplException;
public class ServiceImpl implements Service{
	DaoLayer playerDao=new DaoLayerImpl();

	public void addPlayer(String playerName, int runScored, int ballTaken) throws ServicePlayerImplException {
		
			try {
				playerDao.addPlayerInDataBase(playerName,runScored,ballTaken);
			} catch (PlayerDaoImplException e) {
				throw new ServicePlayerImplException(e);
			}
	
		
	}

	public void deletePlayer(String playerName) throws ServicePlayerImplException {
		try {
			playerDao.deleteFromDataBase(playerName);
		} catch (PlayerDaoImplException e) {
			throw new ServicePlayerImplException(e);
		}
		
	}

	public void update(String playerName, int runScored, int ballTaken) throws ServicePlayerImplException {
		try {
			playerDao.updateInDataBase(playerName,runScored,ballTaken);
		} catch (PlayerNotFoundException e) {
			throw new ServicePlayerImplException(e);
			
		} catch (PlayerDaoImplException e) {
			throw new ServicePlayerImplException(e);

		}
		
	}

	public void writeFile() throws PlayerDaoImplException, IOException {
		List<Player> list=new ArrayList<Player>();
		FileWriter fw=null;
		try {
			list=playerDao.WriteFileFronDatabase(list);
			fw=new FileWriter("D://PlayerStrikeList.txt");
			for (Player player : list) {
				double runScore=(double)player.getRunScored();
				 double balltaken=(double)player.getBallTaken();	
				 double strike=(runScore/balltaken)*100;
				String s="";
				s=s+strike+"  ";
				fw.write(player.getPlayerName()+" " +s+"\n");
				//System.out.println("written success fully");
				
			}
			
			
		} catch (Exception e) {
			throw new PlayerDaoImplException(e);
		}
		finally {
		fw.close();
		}
		
	}

	public void topThreeStrike() throws ServicePlayerImplException {
		List<Player> list=new ArrayList<Player>();
		try {
			list=playerDao.topThreeStrike(list);
			double arr[]=new double[list.size()];
			int k=0;
			for (Player player : list) {
				double runScore=(double)player.getRunScored();
				 double balltaken=(double)player.getBallTaken();	
				 double strike=(runScore/balltaken)*100;
				arr[k++]=strike;
				
			}
			for(int i=0;i<arr.length;i++)
			{
				for(int j=i+1;j<arr.length;j++)
				{
					if(arr[i]<arr[j])
					{
						double temp= arr[i];
						arr[i]=arr[j];
						arr[j]=temp;
					}
				}
			}
			if(arr.length>2)
			{
				System.out.println("top three Strike"+" "+arr[0]+" "+arr[1]+" "+arr[2]);
			}
			else
			{
				System.out.println("you have less then three player");
			}
		} catch (PlayerDaoImplException e) {
			throw new ServicePlayerImplException(e);
		}
		
	}


}
