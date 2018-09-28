package model;
//prop card
import java.security.acl.Owner;

public class propertycard extends Card {
	/*
	 * proparity
	 */
	
	private Player own;
	private double price;
	private int protype;
	private PropertyCardColor colorcard;
	private double rent;
	
	public propertycard(int CardId,String Name,int price,PropertyCardColor colorcard){
		super(CardId,Name);
		//this.own=null;
		this.colorcard=colorcard;
		this.price=price;
		this.rent=0.15*price;
		this.protype=prolevel(price);
	}
	
	

	public PropertyCardColor getColorcard() {
		return colorcard;
	}

	public void setColorcard(PropertyCardColor colorcard) {
		this.colorcard = colorcard;
	}

	public double getRent() {
		return rent;
	}

	public void setRent(double rent) {
		this.rent = rent;
	}

	public  int prolevel(double price)
	{
		if(price>=50000 &&price<250000)
			return 0;
		if(price>=250000 &&price<2000000)
			return 1;
		else
			return 2;
	}
	public int  getProType()
	{
		return this.protype;
	}
	
	public Player getOwn() {
		if(own!=null)
			return own;
		return null;
	}
	public void setOwn(Player own) {
		this.own = own;
	}
	
	public double getPrice() {
		return price;
	}
	public void setPrice(double d) {
		this.price = d;
	}

	@Override
	public String Action(Player player) {
		// TODO Auto-generated method stub
		if(own!=null && own.getId()!=player.getId())
		{
			return ("you stood on a property for another player do you want to buy it by 150% of its price?? ");
		}
		else
		if(own==null)	
			return("do you want to buy this proprety??");
		else
			return("you already own this property:))");
			
	}
	

}
