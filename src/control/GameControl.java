package control;
//game 
import java.awt.Frame;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

import javax.naming.spi.DirStateFactory.Result;

import model.Player;
import model.Question;
import control.UpdateData;
import control.PlayerInGame;
import model.Board;
import model.Card;
import model.SysData;
import model.propertycard;

public class GameControl {
	private static ArrayList<Card> cards;
	private static ArrayList<PlayerInGame> playersInGame;
	
	boolean hasWinner = false;
	private Board currentGame;
    private UpdateData updateSystem;
	private SysData systemDB;
	  ArrayList<Player> allPlayers ;
	
	public GameControl(Board game){
		this.currentGame=game;
		currentGame.getCards();
        playersInGame = new ArrayList<PlayerInGame>();
        cards=currentGame.getCards();
        updateSystem=UpdateData.getInstance();
		systemDB = updateSystem.playersData;
		allPlayers=systemDB.getplayer();
                 
	}
	

	public ArrayList<Card> getCards() {
		return cards;
	}


	/**add new user to the users list
 * @return true if added succsesful
 */
/*public boolean addNewUser(String userName, String password,String id){
            
     Player playerToAdd = new Player(userName,password,id);
	if(systemDB.getUsers().get(playerToAdd.getUsername()) == null){//if doesnt already exist
		systemDB.getUsers().put(playerToAdd.getUsername(), playerToAdd);
		return true;
	}
	return false;
                
                
	
}*/

public Board getCurrentGame() {
	return currentGame;
}

public ArrayList<PlayerInGame> getPlayersInGame() {
	Collections.shuffle(playersInGame);
	
	return playersInGame;
}




/**
 * this method connects new player to the game
 * @param player
 * @return true if player is connected
 */
public boolean connectNewPlayer(Player player){
        
            updateSystem=UpdateData.getInstance();
	systemDB = updateSystem.playersData;
            
	if(updateSystem.getAllPlayers().contains(player)){//only if exist in users database
		
		if(currentGame.getPlayers().size() <= currentGame.getNumofplayers()){
		//System.out.println("insert to connect player");
		currentGame.addPlayer(player);
			playersInGame.add(new PlayerInGame(currentGame,player));
		    Collections.shuffle(currentGame.getPlayers());	 
			return true;
		}
	}
	return false;
}

/**
 * this method sets a winner in the game 
 * @param p
 * @return true if player was set as a winner , false otherwise 
 */
public boolean setWinner(Player p){
	if(!hasWinner){
		currentGame.setWinner(p);
          hasWinner = true;
          return true;
	}
	return false;
}
public Player getWinner(){
	return currentGame.getWinner();
}

/**
 * this methods updates the rank table 
 */
public void updateDegree(){
	  Collections.sort(currentGame.getPlayers(), new Comparator<Player>() {
	        @Override public int compare(Player p1, Player p2) {
	            return (int)(p2.getScore() - p1.getScore()); 
	        }
	    });
	  System.out.println("the size of array in gamecontrol"+currentGame.getPlayers().size());
	  for(int i=0  ; i <currentGame.getPlayers().size();i++){
		  currentGame.getPlayers().get(i).setdegree(i+1);
		  System.out.println("player degree"+currentGame.getPlayers().get(i).getdgree());
	  }
}
public  void WantToBuyFromOwner(Player us,propertycard pro)
{
double newprice=Consts.dualForBuy*pro.getPrice();
if(us.getScore()>=newprice &&pro.getOwn()!=null)
{
	pro.getOwn().setscore(pro.getOwn().getScore()+newprice);
	System.out.println("the own of propppp first"+	pro.getOwn());
	pro.getOwn().getProps().remove(pro);
	pro.setOwn(us);
	System.out.println("the own of propppp second"+	pro.getOwn());

	pro.setPrice(newprice);
	us.setscore(us.getScore()-newprice);
	us.addcard(pro);
	
}
}
//this method check the answers of the user and due to the answer difficulty he get or pay money 
public void propaity(PlayerInGame us,propertycard pro,Question qu,boolean answer)
{

	if(answer==true)
	{
		if(qu.getdifficulty()==0)
		{
			pro.setPrice(pro.getPrice()-pro.getPrice()*Consts.discountEasy);
		}
		else
			if(qu.getdifficulty()==1)
			{
				pro.setPrice(pro.getPrice()-pro.getPrice()*Consts.discountMeduim);
			}
			else
				if(qu.getdifficulty()==2)
					pro.setPrice(pro.getPrice()-pro.getPrice()*Consts.discountHard);
		System.out.println("your answered is true");
		System.out.println("THe new price of property"+pro.getPrice());
		us.getPlayer().setscore(us.getPlayer().getScore()-pro.getPrice());
	}
	else
	{
		System.out.println("your answered is false");
		us.getPlayer().setscore(us.getPlayer().getScore()-pro.getPrice());
		us.getPlayer().setRejectionnum(1);
		System.out.println("the number of Rejectionnum"+us.getPlayer().getRejectionnum()+""+us.getPlayer().getUsername());
		view.Frame.rejectionThreeCheck(us);
		System.out.println("your Rejectionnumber is:"+us.getPlayer().getRejectionnum());
		System.out.println("Your score is:"+us.getPlayer().getScore());
		
	}
		
	
}

public void specialproNoOwn(PlayerInGame us,propertycard pro,Question qu,boolean answer)
{
	if(answer==true)
	{
		us.getPlayer().getMyspecial().put(pro,0);
		us.getPlayer().addcard(pro);
		us.getPlayer().setscore(us.getPlayer().getScore()-pro.getPrice());
		pro.setOwn(us.getPlayer());
		System.out.println("i buy ```````````"+us.getPlayer().getUsername());
		
	}  
}


public void questionmethod( HashMap<PlayerInGame,String> otherAnswers)
{        
	
	boolean othersTrue=false;
	int numofTrue=0;
	String resultforcurrentplayer="";
	PlayerInGame currentplayer=null;
	String resultforotherplayer="";
	PlayerInGame otherplayer=null;
    for(PlayerInGame pig : otherAnswers.keySet()){
    	{
    		if(pig.getPlayer().isOkRounded())
    		{
    			
    		currentplayer = pig;
    		System.out.println("the currentplayeris"+currentplayer.getPlayer().getUsername());
    		resultforcurrentplayer = otherAnswers.get(currentplayer);
    		otherAnswers.remove(pig);
    		break;
    		}
    		
    	}
    	
    }
    if(resultforcurrentplayer.equals("false"))
    {
    	//System.out.println("th player score before answer:"+currentplayer.getPlayer().getScore());
    	currentplayer.getPlayer().setscore(currentplayer.getPlayer().getScore()-Consts.anwerquescard);
    	//System.out.println("th player score after answer:"+currentplayer.getPlayer().getScore());
    	currentplayer.getPlayer().setRejectionnum(1);
    	view.Frame.rejectionThreeCheck(currentplayer);
    	
    	
    	 for(PlayerInGame pig : otherAnswers.keySet()){
    		 otherplayer = pig;
    		 resultforotherplayer = otherAnswers.get(otherplayer);
    	    	 if(resultforotherplayer.equals("false"))
    	    	 {
    	    		 otherplayer.getPlayer().setRejectionnum(1);
    	    		 view.Frame.rejectionThreeCheck(otherplayer);
    	    		 
    	    	 }
    	    	 
    	    		 
    	   
    	
    }
    }
    
    if(resultforcurrentplayer.equals("true"))
    {
    	//System.out.println("itsssssssss trueeeeeeeeeeee");
    
    	
		 for(PlayerInGame pig : otherAnswers.keySet())
		 {
			 otherplayer = pig;
			 resultforotherplayer = otherAnswers.get(otherplayer);
	    	 if(resultforotherplayer.equals("true"))
	    	 {
	    		 othersTrue=true;
		    		numofTrue++;
	    	 }
	    	 
		 }
 
		 if(othersTrue==false)
		 {
			 currentplayer.getPlayer().setscore(currentplayer.getPlayer().getScore()+Consts.trueanwerquescard);
			 for(PlayerInGame pig : otherAnswers.keySet())
			 {
				 otherplayer = pig;
				 
				 otherplayer.getPlayer().setRejectionnum(1);
				 view.Frame.rejectionThreeCheck(otherplayer);
				 
			 }
		 }
		  
			
		 
		 if(othersTrue==true &&numofTrue!= otherAnswers.size())
		    {
		    
		    	currentplayer.getPlayer().setscore(currentplayer.getPlayer().getScore()+Consts.anwerquescard);
		    	 for(PlayerInGame pig : otherAnswers.keySet()){ 
		    	  otherplayer = pig;
				 resultforotherplayer = otherAnswers.get(otherplayer);
		   	     if(resultforotherplayer.equals("false"))
		   	     {
		   	    	otherplayer.getPlayer().setRejectionnum(1);
		   	    	view.Frame.rejectionThreeCheck(otherplayer);
		    	 }
		   	     else
		   	     {
		   	    	 if(resultforotherplayer.equals("true"))
		   	    		otherplayer.getPlayer().setscore(otherplayer.getPlayer().getScore()+Consts.lessthan3playeranswertrue);
		   	     }
		   	     
		    }
		    }
		 
		 if(othersTrue==true &&numofTrue== otherAnswers.size())
		    {
		    	
		    	
		    	 for(PlayerInGame pig : otherAnswers.keySet()){ 
		    	  otherplayer = pig;
				 resultforotherplayer = otherAnswers.get(otherplayer);
		   	   
		   	    	
		   	    		otherplayer.getPlayer().setscore(otherplayer.getPlayer().getScore()+Consts.morethan3playeranswertrue);
		   	     
		    }
		    }
		    
	
	}
    
    
	
    
    
    
   
		    
		 
		    
		    
		    		
		    		
		    		
		    	
	}
	
	



public static void luck(PlayerInGame us,Question qu1,Question qu2,boolean hardanswer2 ,boolean  medanswer1)
{
	Random generator = new Random();
	int high=250000000;
	int low=10000;
	 int index =0;
	int hardqu=0;
	int meduimqu=0;
 
if(medanswer1==true)
	meduimqu=1; 

	
if(hardanswer2==true)
      hardqu=1;


if(hardqu==1 && meduimqu==1)
{
index=generator.nextInt(high-low)+low;
us.getPlayer().setscore(us.getPlayer().getScore()+index);
System.out.println("your two anwer is true");
}
if(hardqu==1 && meduimqu==0)
{
us.getPlayer().setscore(us.getPlayer().getScore()-50000);
us.getPlayer().setRejectionnum(1);
view.Frame.rejectionThreeCheck(us);
System.out.println("the number of Rejectionnum"+us.getPlayer().getRejectionnum()+""+us.getPlayer().getUsername());
System.out.println("your hard anwer is true");
}
if(hardqu==0 && meduimqu==1)
{

us.getPlayer().setscore(us.getPlayer().getScore()-25000);
}		
}


public void specialproHasOwn(PlayerInGame playerController, propertycard card, Question q, boolean answer, Player own) {
	if(answer==true)
	{
		playerController.getPlayer().getMyspecial().put(card, 0);
		playerController.getPlayer().addcard(card);
		own.getProps().remove(card);
		own.getMyspecial().remove(card);
		playerController.getPlayer().setscore(playerController.getPlayer().getScore()-card.getPrice());
		own.setscore(own.getScore()+card.getPrice());
		card.setOwn(playerController.getPlayer());
		System.out.println(playerController.getPlayer().getUsername()+"buy+++++++++++ from"+ own.getUsername());
		
	}  	
}





}
