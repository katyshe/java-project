package model;
import java.awt.Color;
//player class
import java.util.ArrayList;
import java.util.HashMap;

public class Player extends user implements java.io.Serializable{
	
	private String id;
	private double score;
    private double bestscore;
 	private ArrayList<Card>owns;// all propirty for user
	
	private boolean okRounded = false;
	private int rejectionnum;
	/**num of win games*/
	private int numofwinningGames;
	private int degree;
	private String pcolor;
	private HashMap<propertycard, Integer> myspecial;

	//public int TOTAL_NUMBER_OF_TILES = 40;

	
	
	

	public Player(String username,String password,String id)
	{

		super(username,password);
		this.bestscore=0;
		this.score=500000;
		this.numofwinningGames=0;
		this.rejectionnum=0;
		owns=new ArrayList<Card>();
		this.id=id;
		this.degree=0;
        myspecial=new HashMap<propertycard,Integer>();

	}
	
	public Player(String username,String password)
	{
		super(username,password);
		owns=new ArrayList<Card>();
		this.bestscore=0;
		this.score=500000;
		this.numofwinningGames=0;
        myspecial=new HashMap<propertycard,Integer>();

		this.degree=0;
	}
	
	
	
	
	public HashMap<propertycard, Integer> getMyspecial() {
		return myspecial;
	}

	public void setMyspecial(HashMap<propertycard, Integer> myspecial) {
		this.myspecial = myspecial;
	}

	/**
	 * getter and setter
	 * @return
	 */
	
	
	public int getdgree(){
		return this.degree;
	}
	
	public void setdegree(int degree) {
		this.degree = degree;
	}
	public void updatedegree(int d){
		degree = d;
	}
	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}
	
	public void setnumWinningGames(int value){
		numofwinningGames += value;
	}

	public int getWinningGames() {
		return numofwinningGames;
	}
	
	/**
	 * add own for this player
	 * @param card
	 * @return
	 */
	public boolean addcard(Card card)
	{
		if(!owns.contains(card))
		{
			owns.add(card);
			
			System.out.println("card name "+card.getName());
			System.out.println("the owner of the propatty "+this.getUsername());

			return true;
		}
		return false;
		   
	}
	/**
	 * number of rejection of this player
	 * @return
	 */
	public int getRejectionnum() {
		return rejectionnum;
	}



	public void setRejectionnum(int rejectionnum) {
		this.rejectionnum += rejectionnum;
	}
	
	public double getScore() {
		System.out.println("print score in player"+score);
		return score;
	}


	


/**
 * true if the player turn
 * @return
 */
	public boolean isOkRounded() {
		return okRounded;
	}



	public void setOkRounded(boolean okRounded) {
		this.okRounded = okRounded;
	}



	public boolean haveproprity(Card T){
		if(owns.contains(T))
			return false;
		return true;
	}
	
	
	public ArrayList getProps(){
		return  owns;
	}
	
	public void setscore(double i){
		
		score= i;
	}
   
    public void setbestscore()
    {
     if(this.score>this.bestscore)
      
       this.bestscore=this.score;
      }



	public double getBestscore() {
		return bestscore;
	}
	
	public String getPcolor() {
		return pcolor;
	}

	public void setPcolor(String pcolor) {
		this.pcolor = pcolor;
	}
}