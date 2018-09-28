package model;

public class GailCard extends Card{
	/*
	 * gailcardclass
	 */
	public GailCard(int CardId,String Name)
	{
		super(CardId,Name);
	}

	@Override
	public String Action(Player player) {
	/*	// TODO Auto-generated method stub
	player.setIsinJail(true);
	player.setOkRounded(false);
	return("you are in jail,you can't play next turn");*/
		return null;
	}
	
	
}
