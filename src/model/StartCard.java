package model;
/*
 * start card class
 */
public class StartCard extends Card {
	
	public StartCard (int CardId,String Name)
	{
		super(CardId,Name);
	}

	@Override
	public String Action(Player player) {
		player.setscore(player.getScore()+500000);
		return("your score is 500000");
		
	}
	
	

}
