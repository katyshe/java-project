package model;

public class GoToGailCard extends Card {
	/*
	 * gotogail class
	 */
	public GoToGailCard  (int CardId,String Name)
	{
		super(CardId,Name);
	}

	@Override
	public String Action(Player player) {
		// TODO Auto-generated method stub
		
		return ("do you want to paid 100000 and go out of gail??");
		
	}
	
	

}
