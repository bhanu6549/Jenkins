package daoLayer.daoLayerImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import daoLayer.DaoLayer;
import entity.Player;
import exceptionPackage.PlayerDaoImplException;
import exceptionPackage.PlayerNotFoundException;
import utility.JdbcConnection;

public class DaoLayerImpl implements DaoLayer {
	public void addPlayerInDataBase(String playerName, int runScored, int ballTaken) throws PlayerDaoImplException  {
		Connection con=JdbcConnection.getConnection();
		String qry="Insert into Player (PlayerName, RunScored, BallTaken) values(?,?,?)";
		try {
			PreparedStatement stm=con.prepareStatement(qry);
			stm.setString(1, playerName);
			stm.setInt(2, runScored);
			stm.setInt(3, ballTaken);
			int rs=stm.executeUpdate();
			if(rs>0)
			{
				System.out.println("Insert Success");
			}
		} catch (SQLException e) {
			
			throw new PlayerDaoImplException(e);
		}
			finally {
			JdbcConnection.closeConneection(con);
			}
	
		
	}

	public void deleteFromDataBase(String playerName) throws PlayerDaoImplException {
		Connection con=JdbcConnection.getConnection();
		String qry="delete from player where PlayerName=?";
		try {
			PreparedStatement stm=con.prepareStatement(qry);
			stm.setString(1, playerName);
			int rs=stm.executeUpdate();
			if(rs>0)
			{
				System.out.println("Delete Success");
				
			}
			else
			{
				throw new PlayerNotFoundException("Playername is not their in database");
			}
		} catch (SQLException e) {
			throw new PlayerDaoImplException(e);
		}
		finally
		{
			JdbcConnection.closeConneection(con);
		}
		
	}

	public void updateInDataBase(String playerName, int runScored, int ballTaken) throws PlayerDaoImplException {
		Connection con=JdbcConnection.getConnection();
		if(con!=null)
		{
			System.out.println("Connected");
		}
		String qry="update Player set RunScored=?,BallTaken=? where PlayerName=?";
		try {
			PreparedStatement stm=con.prepareStatement(qry);
			stm.setInt(1, runScored);
			stm.setInt(2, ballTaken);
			stm.setString(3, playerName);
			int rs=stm.executeUpdate();
			if(rs>0)
			{
				System.out.println("Update success");
			}
			else
			{
				throw new PlayerNotFoundException("player is not present");
			}
		} catch (SQLException e) {
			throw new PlayerDaoImplException(e);
		}
		finally {
			JdbcConnection.closeConneection(con);
		}
		
	}

	public List<Player> WriteFileFronDatabase(List<Player> list) throws PlayerDaoImplException {
		Connection con=JdbcConnection.getConnection();
		String qry="select * from player";
		try {
			PreparedStatement stm=con.prepareStatement(qry);
			ResultSet rs=stm.executeQuery();
			while(rs.next())
			{
				Player p1 =new Player(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getInt(4));
				list.add(p1);
			}
			
			
		} catch (SQLException e) {
			throw new PlayerDaoImplException(e);
		}
		return list;
	}

	public List<Player> topThreeStrike(List<Player> list) throws PlayerDaoImplException {
		
		Connection con=JdbcConnection.getConnection();
		String qry="select * from player";
		try {
			PreparedStatement stm=con.prepareStatement(qry);
			ResultSet rs=stm.executeQuery();
			while(rs.next())
			{
				Player p1 =new Player(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getInt(4));
				list.add(p1);
			}
			
			
		} catch (SQLException e) {
			throw new PlayerDaoImplException(e);
		}
		return list;
	}


}
