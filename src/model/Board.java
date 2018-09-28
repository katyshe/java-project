package model;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;

import model.Board;
import model.Player;
import model.Question;
import control.UpdateData;

/*
 * board class
 */
public class Board {
	/**
	 * var that count the number of rounds
	 */
	public  int numrounds;
	
	private static  int currentplayerindex;
	
	private static int numofplayers;
	private Player winner;
	private static Board instance;
	
	private static ArrayList<Card>cards;
	private static ArrayList <Player>players;
	private static HashMap<Integer,Question> questions;
	UpdateData updateSystem;

	public Board(){
		numrounds=0;
		numofplayers=0;
		currentplayerindex=0;
		players = new ArrayList<Player>();
		questions = new HashMap<Integer,Question>() ;
        updateSystem = UpdateData.getInstance();
       // cards = updateSystem.systemData.getSquareBoard();
        initboard();
	}
	
	public static Board getInstance() {
		if(instance == null){
			instance = new Board();
			return instance;
		}
		else
			return instance;
	}
	
public static void initboard()
{
	cards=new ArrayList<Card>();
			{
		 cards.add(new StartCard(0,"GO!"));
		 cards.add(new propertycard(1,"Marvin Gardens.",60000,PropertyCardColor.yellow));//easy
		 cards.add(new LuckCard(2,"Community Chest"));
		 cards.add(new propertycard(3,"Kentucky Ave.",200000,PropertyCardColor.red));//easy
		 cards.add(new QuestionCard(4,"chance"));
		 cards.add(new propertycard(5,"Kings Cross Station",2500000,PropertyCardColor.yellow));//hard
		 cards.add(new propertycard(6,"The Angel Islington",230000,PropertyCardColor.green));//easy
		 cards.add(new propertycard(7,"Euston Road",400000,PropertyCardColor.red));//medium
		 cards.add(new LuckCard(8,"Community Chest"));
		 cards.add(new propertycard(9,"Pentonville Road",150000,PropertyCardColor.green));//easy
		 cards.add(new GailCard(10,"Jail"));
		 cards.add(new propertycard(11,"Pall Mall",2100000,PropertyCardColor.red));//hard
		 cards.add(new QuestionCard(12,"chance"));
		 cards.add(new propertycard(13,"Electric Company",3000000,PropertyCardColor.yellow));//hard
		 cards.add(new propertycard(14,"Whitehall",100000,PropertyCardColor.red));//easy
		 cards.add(new QuestionCard(15,"chance"));
		 cards.add(new propertycard(16,"Northumberland Avenue",900000,PropertyCardColor.green));//medium
		 cards.add(new LuckCard(17,"Community Chest"));
		 cards.add(new propertycard(18,"Marylebone Station",3000000,PropertyCardColor.green));//hard
		 cards.add(new propertycard(19,"Bow Street",750000,PropertyCardColor.yellow));//medium
		 cards.add(new QuestionCard(20,"chance"));
		 cards.add(new propertycard(21,"Marlborough Street",950000,PropertyCardColor.red));//medium
		 cards.add(new QuestionCard(22,"chance"));
		 cards.add(new propertycard(23,"Vine Street",240000,PropertyCardColor.red));//easy
		 cards.add(new propertycard(24,"Strand",2400000,PropertyCardColor.red));//hard
		 cards.add(new LuckCard(25,"Community Chest"));
		 cards.add(new propertycard(26,"Fleet Street",70000,PropertyCardColor.green));//easy
		 cards.add(new propertycard(27,"Trafalgar Square",1500000,PropertyCardColor.yellow));//medium
		 cards.add(new LuckCard(28,"Community Chest"));
         cards.add(new propertycard(29,"Fenchurch Station",1900000,PropertyCardColor.yellow));//medium
         cards.add(new GoToGailCard(30,"Go To Jail"));
         cards.add(new propertycard(31,"Leicester Square",100000,PropertyCardColor.green));//easy
		 cards.add(new propertycard(32,"Coventry Street",3600000,PropertyCardColor.green));//hard
		 cards.add(new LuckCard(33,"Community Chest"));
		 cards.add(new propertycard(34,"Water Works",4600000,PropertyCardColor.green));//hard
		 cards.add(new propertycard(35,"Picadilly",600000,PropertyCardColor.yellow));//meduim
		 cards.add(new QuestionCard(36,"chance"));
		 cards.add(new propertycard(37,"Regent Street",60000,PropertyCardColor.yellow));//easy,
		 cards.add(new QuestionCard(38,"chance"));
		cards.add(new propertycard(39,"Oxford Street",6900000,PropertyCardColor.yellow));//hard
};
		
	}
public void setNumberOfPlayers(int x){
    this.numofplayers=x;
}

public  int getNumofplayers() {
	return numofplayers;
}
/**
 * add player to the player list if the nuber of player less than 4
 * @param player
 * @return
 */

public boolean addPlayer(Player player) {
	if(player!=null )
	{
		//System.out.println("the number of player in add player"+numofplayers);
		if(!players.contains(player) && numofplayers<=4)
		{
			//System.out.println("insert to  if in add palyer");
			players.add(player);
			System.out.println("The player added");
			return true;
		}
	}
	return false;
}

public  int getNumrounds() {
	return this.numrounds;
}

public void increasingNumrounds() {
	this.numrounds++;
}

public void setWinner(Player p){
	this.winner=p;
}
public Player getWinner(){
	return winner;
}
public void resetGame(){
    instance = null;
}
	
public static int getCurrentplayerindex() {
	return currentplayerindex;
}
public static void setCurrentplayerindex(int currentplayerindex) {
	Board.currentplayerindex = currentplayerindex;
}



	
	public ArrayList<Player> getPlayers() {
	return players;
}
	public ArrayList<Card> getCards() {
		return cards;
	}
	
	public HashMap<Integer,Question> getQuestions(){
		return this.questions;
	}
	
	public boolean addQuestions(Question q){
		questions.put(q.getId(),q);
		return true;
	}
	
	public boolean editQuestion(Question q){
		questions.put(q.getId(), q);
		return true;
		
	}
	/**
	 * //this method checks the end of the game
	// if the rounds number is 50 or there is just one player left
	
	 * @return true if the game not finished
	 */
		public boolean NotEndGame()
		{
			if(getNumrounds()<50){
				//increasingNumrounds();
				return true;
			}
				
			return false;
		}
		


	
	
	

}
