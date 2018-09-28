package model;

public abstract class Card {
	/*
	 * card class
	 */
	
	private int CardId;
	private String Name;
	public Card(int CardId,String Name)
	{
		this.CardId=CardId;
		this.Name=Name;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public int getCardId() {
		return CardId;
	}

	public void setCardId(int cardId) {
		CardId = cardId;
	}
	
	public abstract String Action(Player player);
	
	
}
