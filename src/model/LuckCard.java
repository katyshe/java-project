package model;
/*
 * luck card
 */
public class LuckCard extends Card{

	public LuckCard(int CardId,String Name)
	{
		super(CardId,Name);
	}

	@Override
	public String Action(Player player) {
		// TODO Auto-generated method stub
		return("now you must answer two questions...");
	}
	
}
