package control;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Map;
import java.util.Random;

import model.Board;
import model.Card;
import model.LuckCard;
import model.Player;
import model.propertycard;
import model.Question;
import model.user;

public class actions {
	
	

private static ArrayList<Question>allQuestions;
private static ArrayList<Question> easy;
private static ArrayList<Question> meduim;
private static ArrayList<Question> hard;



public static void initqustion(){
	allQuestions=new ArrayList<Question>();
	easy=new ArrayList<Question>();
	meduim=new ArrayList<Question>();
	hard=new ArrayList<Question>();
	
	
}

	public static ArrayList<Question> getEasy() {
	return easy;
}

public static ArrayList<Question> getMeduim() {
	return meduim;
}
//this method return an array of the hard questons 
public static ArrayList<Question> getHard() {
	return hard;
}

	public static ArrayList<Question> getAllQuestions() {
	return allQuestions;
}

	// this method add a Question accordering to the difficulty
    public static boolean addQuestion(Question Q)
    {
    	if(Q.getdifficulty()==1)
    	{
    		if(!easy.contains(Q))
    		{
    			easy.add(Q);
    			allQuestions.add(Q);
    			return true;
    		}
    	return false;	
    	}
    	if(Q.getdifficulty()==2)
    	{
    		if(!meduim.contains(Q))
    		{
    			meduim.add(Q);
    			allQuestions.add(Q);
    			return true;
    		}
    		return false;
    	}
    	if(Q.getdifficulty()==3)
    	{
    		if(!hard.contains(Q))
    		{
    			hard.add(Q);
    			allQuestions.add(Q);
    			return true;
    		}
    		return false;
    	}
    	return false;
    	
    }
    
    // this method checks if the user is broke (have no money)
	public  static boolean IsBroke(Player p){
		if(p.getScore()==0 && p.getProps().isEmpty())
			return true;
		if(p.getScore()<Consts.broke && !p.getProps().isEmpty())
			return true;
		return false;
		
	}
	
	
	
	// when a player stands on the luck tile he gets 2 Questions,
	// a med one and a hard one
	public static void luck(Player us,Question qu1,Question qu2,boolean medanswer1,boolean hardanswer2)
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
	us.setscore(us.getScore()+index);
	System.out.println("your two anwer is true");
}
if(hardqu==1 && meduimqu==0)
{
	us.setscore(us.getScore()-50000);
	us.setRejectionnum(1);
	System.out.println("your hard anwer is true");
}
if(hardqu==0 && meduimqu==0)
{
	System.out.println("your two answer is false");
	us.setscore(us.getScore()-25000);
}		
	}
	public static boolean checkMultQUE(Question qu ,int []Answers)
	{
		
		for(int j=0;j<qu.getcorrectanswersIndex().size();j++)
		for(int i=0;i<Answers.length;i++)
			if(qu.getcorrectanswersIndex().get(j)==(Answers[i]))
				return false;
		return true;
					
		
	}
	
	//this method check the answers of the user
	public static boolean checkNotMultQUE(Question qu,int answer)
	{
		return qu.getcorrectanswersIndex().contains(answer); 
	}
	
	
	//send a random Question of med level to the user
	public static Question MeduimQuestion()
	{
		Question Qu=null;
		Random generator = new Random();
		
		 int index = generator.nextInt(meduim.size());
		  Qu=meduim.get(index);
		  return Qu;
		
	}

	//send a random Question of hard level to the user
	public static Question hardQuestion()
	{
		System.out.println("gooooooooooooooooooo");
		Random generator = new Random();
		 Question Qu=null;
		 System.out.println(hard.size());
		 int index = generator.nextInt(hard.size());
		  Qu=hard.get(index);
		  return Qu;
		
	}
	
	// if the user is standing on the property tile and intersted into buying it
	public static Question proportytileToBuy(Player us,Card pro)
	{
		Random generator = new Random();
		System.out.println("asalaaaaaaaaaa");
		int level=((propertycard)pro).getProType();
		System.out.println(level);
		 Question Qu=null;
	
		if(level==1){
		 int index = generator.nextInt(easy.size());
		  Qu=easy.get(index);
		}
		 
		if(level==2){
			 int index = generator.nextInt(meduim.size());
			  Qu=meduim.get(index);
			}
		else
		{
			int index = generator.nextInt(hard.size());
			  Qu=hard.get(index);
		}
	
	
		
		
		

	return Qu;

	}
	
	
	
	// this method check the answers of the user and due to the answer difficulty he get or pay money 
	public static void checkAnswer(Player us,Card pro,Question qu,String answer)
	{
		propertycard property=(propertycard)pro;
		if(qu.getcorrectanswersIndex().contains(answer))
		{
			if(qu.getdifficulty()==1)
				property.setPrice(property.getPrice()-property.getPrice()*Consts.discountEasy);
			else
				if(qu.getdifficulty()==2)
					property.setPrice(property.getPrice()-property.getPrice()*Consts.discountMeduim);	
				else
					if(qu.getdifficulty()==3)
						property.setPrice(property.getPrice()-property.getPrice()*Consts.discountHard);
			System.out.println("your answered is true");
			System.out.println("THe new price of property"+property.getPrice());
			us.setscore(us.getScore()-property.getPrice());
		}
		else
		{
			System.out.println("your answered is false");
			us.setscore(us.getScore()-property.getPrice());
			us.setRejectionnum(us.getRejectionnum()+1);
			System.out.println("your Rejectionnumber is:"+us.getRejectionnum());
			System.out.println("Your score is:"+us.getScore());
			
		}
			
		
	}
	
	public static void checkmulitipleAnswer(Player us,propertycard pro,Question qu,int [] answers)
	{
		if(checkMultQUE(qu,answers))
		{
			if(qu.getdifficulty()==1)
				pro.setPrice(pro.getPrice()*Consts.discountEasy);
			else
				if(qu.getdifficulty()==2)
				  pro.setPrice(pro.getPrice()*Consts.discountMeduim);	
				else
					if(qu.getdifficulty()==3)
					  pro.setPrice(pro.getPrice()*Consts.discountHard);	
			
		}
		else
		{
			us.setscore(us.getScore()-pro.getPrice());
			us.setRejectionnum(us.getRejectionnum()+1);
		}
			
		
	}
	
	
	// when the user stand on go to jail tile
	/*public static void GoToJail(String answer,Player us )//answer 0 the player want to paid 100,0000 to Get out of jail
	{
		if(answer.equals("yes"))
		{
			us.setscore(us.getScore()-Consts.Outofjail);
		}
		else
		{
			us.setOkRounded(false);
			us.setIsinJail(true);
		}
	}
	
	public static void userRejectionToJail(Player us){
		if(us.getRejectionnum()>3){
		us.setIsinJail(true);
		us.setOkRounded(false);
		us.setRejectionnum(-us.getRejectionnum());
		}
		
		
	}*/
	
	////send a random Question from one level to the user
	public static Question RandomQuestioncard(String Tag)
	{    
		System.out.println(Tag);
		ArrayList <Question>spacificTag=new ArrayList<Question>();
		for(int i=0;i<allQuestions.size();i++)
		{
			System.out.println("ssssssssssssssssssssss");
			for(int j=0;j<allQuestions.get(i).getTags().size();j++)
			{
				System.out.println("sssssjjjjjjjjjjjjjjjjjjjjjj");
				if(allQuestions.get(i).getTags().get(j).equals(Tag))
				{
					spacificTag.add(allQuestions.get(i));
					System.out.println("aaaaaaaaaaaaaaaaa");
					
				}
			}
		}
		Question Qu=null;
		Random generator =null;
		generator= new Random();
		int index;
		
		 index = generator.nextInt(spacificTag.size());
		  Qu=spacificTag.get(index);
	
		  return Qu;
	}
	//for Question not mulitiple
	public static void Questioncardque(String tag,Question Q,ArrayList<Player> players, int[]answers){
		int idofplayerturn=0;
		int count=0; //number of player not in her turn that has answered true answer
		for(int i=0;i<players.size();i++)
		{
			if(i!=idofplayerturn)
			{
				if(checkNotMultQUE(Q,answers[i]))
					count++;
				else
					players.get(i).setRejectionnum(-1);
			}
		}
		for(int i=0;i<players.size();i++)
		{
			if(players.get(i).isOkRounded()==true)
				idofplayerturn=i;
		}
		if(!checkNotMultQUE(Q,answers[idofplayerturn]))
		{
		players.get(idofplayerturn).setscore(players.get(idofplayerturn).getScore()-Consts.anwerquescard);
		players.get(idofplayerturn).setRejectionnum(1);
		System.out.println("your answer is false");
		System.out.println(players.get(idofplayerturn).getScore());
		System.out.println(players.get(idofplayerturn).getRejectionnum());
		}
		else
		{
			if(count==0)
				players.get(idofplayerturn).setscore(players.get(idofplayerturn).getScore()+Consts.trueanwerquescard);
		    else
		     if(count<3)
		     {
		    	 players.get(idofplayerturn).setscore(players.get(idofplayerturn).getScore()+50000);
		    	 for(int i=0;i<players.size();i++)
		 		{
		 			if(i!=idofplayerturn)
		 			{
		 				if(checkNotMultQUE(Q,answers[i]))
		 					players.get(i).setscore(players.get(i).getScore()+Consts.lessthan3playeranswertrue);
		 			}
		 		}
		     }
		     else
		     {
		    	 for(int i=0;i<players.size();i++)
			 		{
			 			if(i!=idofplayerturn)
			 			{
			 				if(checkNotMultQUE(Q,answers[i]))
			 					players.get(i).setscore(players.get(i).getScore()+Consts.morethan3playeranswertrue);
			 			}
			 		}
		     }
		  System.out.println("your answer is true");
		  System.out.println(players.get(idofplayerturn).getScore());
		    
		}		
				
		
		
			
	}  
	
	public static void Questioncardmulitpileue(String tag,Question Q,ArrayList<Player> players, ArrayList<int[]>answers ){
		int idofplayerturn=0;
		int count=0; //number of player not in her turn that has answered true answer
		for(int i=0;i<players.size();i++)
		{
			if(i!=idofplayerturn)
			{
				if(checkMultQUE(Q,answers.get(i)))
					count++;
				else
					players.get(i).setRejectionnum(-1);
			}
		}
		for(int i=0;i<players.size();i++)
		{
			if(players.get(i).isOkRounded()==true)
				idofplayerturn=i;
		}
		if(!checkMultQUE(Q,answers.get(idofplayerturn)))
		{
		players.get(idofplayerturn).setscore(players.get(idofplayerturn).getScore()-Consts.anwerquescard);
		players.get(idofplayerturn).setRejectionnum(-1);
		System.out.println("your answer is false");
		System.out.println(players.get(idofplayerturn).getScore());
		System.out.println(players.get(idofplayerturn).getRejectionnum());
		}
		else
		{
			if(count==0)
				players.get(idofplayerturn).setscore(players.get(idofplayerturn).getScore()+Consts.trueanwerquescard);
		    else
		     if(count<3)
		     {
		    	 players.get(idofplayerturn).setscore(players.get(idofplayerturn).getScore()+50000);
		    	 for(int i=0;i<players.size();i++)
		 		{
		 			if(i!=idofplayerturn)
		 			{
		 				if(checkMultQUE(Q,answers.get(i)))
		 					players.get(i).setscore(players.get(i).getScore()+Consts.lessthan3playeranswertrue);
		 			}
		 		}
		     }
		     else
		     {
		    	 for(int i=0;i<players.size();i++)
			 		{
			 			if(i!=idofplayerturn)
			 			{
			 				if(checkMultQUE(Q,answers.get(i)))
			 					players.get(i).setscore(players.get(i).getScore()+Consts.morethan3playeranswertrue);
			 			}
			 		}
		     }
		    	 
			System.out.println("your answer is true");
			  System.out.println(players.get(idofplayerturn).getScore());
		}		
				
		
		
			
	}   
}