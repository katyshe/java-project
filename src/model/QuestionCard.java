package model;

public class QuestionCard extends Card{
/*
 * question card class
 */
	public QuestionCard(int CardId,String Name)
	{
		super(CardId,Name);
	}

	@Override
	public String Action(Player player) {
		// TODO Auto-generated method stub
		return("please choose an subject :Agile,Design Patterns,Software Testing..");
	}
	
	
	
}
