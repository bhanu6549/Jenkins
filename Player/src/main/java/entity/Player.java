package entity;

public class Player {
	int playerId;
	String playerName;
	int runScored;
	int ballTaken;
	public int getPlayerId() {
		return playerId;
	}
	public void setPlayerId(int playerId) {
		this.playerId = playerId;
	}
	public String getPlayerName() {
		return playerName;
	}
	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}
	public int getRunScored() {
		return runScored;
	}
	public void setRunScored(int runScored) {
		this.runScored = runScored;
	}
	public int getBallTaken() {
		return ballTaken;
	}
	public void setBallTaken(int ballTaken) {
		this.ballTaken = ballTaken;
	}
	public Player(int playerId, String playerName, int runScored, int ballTaken) {
		super();
		this.playerId = playerId;
		this.playerName = playerName;
		this.runScored = runScored;
		this.ballTaken = ballTaken;
	}
	@Override
	public String toString() {
		return "Player [playerId=" + playerId + ", playerName=" + playerName + ", runScored=" + runScored
				+ ", ballTaken=" + ballTaken + "]";
	}
	
	


}
