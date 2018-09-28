package control;

import java.util.HashMap;
import java.util.Random;


import model.Board;
import model.Card;
import model.Player;
//player
public class PlayerInGame {

	
	private int diceResult;
	private Board currentGame;
	private Random rand ;
	private Player player;
	private int currentPosition;
	private int playerDegree;
	private boolean  isinJail;
	private int numofroundingail;//how many rounded in gail
	
	public PlayerInGame (Board g , Player player){
		this.currentGame=g;
		this.player=player;
		System.out.println("PL A YER "+player.getUsername());
		this.currentPosition=0;
         rand = new Random();
         this.isinJail=false;
         this.numofroundingail=0;
	}
	
	

	/**
	 *  Rolls the Dice
	 * @return number between 1 and 6 
	 */
	public int rolling(){
		/*normal roling*/
		/*int firstDiceNumber = rand.nextInt(6) + 1;
        int secondDiceNumber =rand.nextInt(6) + 1;
        int totalPositionToMove = firstDiceNumber+secondDiceNumber;
        return totalPositionToMove ;*/
		
		
		/*stop in property the player can buy*/
		int totalPositionToMove=23;
		return totalPositionToMove;
	
		/*stop in luck card */
	     /*int totalPositionToMove=8;
		return totalPositionToMove;*/
		
		
		/*stop in question card */
	 /*int totalPositionToMove=4;
				return totalPositionToMove;*/
		
		
		
		/*stop in go to gail card directly*/
		/*  int totalPositionToMove=30;
		return totalPositionToMove;*/
        
	}
	public int getcurrentPosition(){
		return this.currentPosition;
	}
        
     public void setcurrentPosition(int x){
            this.currentPosition=x;
        }
    
     public int getPlayerDegree() {
 		return playerDegree;
 	}
 	public void setPlayerDegree(int playerDegree) {
 		this.playerDegree = playerDegree;
 	}
 	
 	public boolean isIsinJail() {
		return isinJail;
	}

 	public int getNumofroundingail() {
		return numofroundingail;
	}
	public void setNumofroundingail(int numofroundingail) {
		this.numofroundingail = numofroundingail;
	}

	public void setIsinJail(boolean isinJail) {
		this.isinJail = isinJail;
	}
     /**
 	 * this method moves the player forward/backward IFF the game is not finished yet
 	 * @param steps
 	 * @return
 	 */
 	/*public boolean movePlayer(int steps){
 		// check if game not finished
 		if(currentGame.NotEndGame()){ 		
                  this.currentPosition+=steps;
 		
 		return true;
 		}
 		
 		return false;
 	}*/
    public Player getPlayer(){
        return player;
    }
 	
 	/**
	 * this method updates the player total score
	 * @param score
	 */
	public void updateScore(double score){
		double temp= player.getScore();
		temp +=score;
		player.setscore(temp);
	}
	public int getDiceResult() {
		return diceResult;
	}

	public void setDiceResult(int diceResult) {
		this.diceResult = diceResult;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}
	
	
     
	
	
}