package control;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Random;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonIOException;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;

import model.Question;
import model.Answer;
import model.Board;
import model.SysData;
import static control.UpdateData.QuestionData;

public class QuestionControl {
	private static SysData sysDB;
	private static QuestionControl Q;
	private static QuestionControl qc;
	private Board currentGame;
	 private ArrayList<Question> questions;
	 private Random generator ;
	 private boolean flag;
	 public HashMap<Integer,Question> questionstouse; 
	    private  HashMap<Integer,Question> hard;
	    private  HashMap<Integer,Question> medium;
	    private  HashMap<Integer,Question> easy;
	  
	    
		 static JsonObject obj0 = new JsonObject();
		 static	 JsonArray  AllQList =new JsonArray(); 
		 
		  static ArrayList<Question> allQuestions;
		 static ArrayList<Question> loadQuestions=new ArrayList<>();
		 public static FileWriter file;
		 
		 private QuestionControl(){
			// SysData.getInstance();
		    	sysDB = Main.systemData;
		        currentGame=Board.getInstance();
		        
		      //  questions = sysDB.getQuestions();
		       
		        hard=new HashMap<Integer,Question>();
		        medium=new HashMap<Integer,Question>();
		        easy=new HashMap<Integer,Question>();
		     //   questionstouse=new HashMap<Integer,Question>();
		        allQuestions=sysDB.getQuestions();
		        try {
					loadQuestions();
				} catch (JsonIOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (JsonSyntaxException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		       // for(Question q : questions){
		     //   	questionstouse.put(q.getId(), q);
		       //  allQuestions.add(q);}
		        AddQuesionBylevel();
		        

		    }
		 
		 public static QuestionControl getInstance(){
		        if(Q == null){
		            Q = new QuestionControl();
		        }
		        
		        return Q;
		    }
		 
		 
	/*	public static void  updateFile() {
			
			try {
				file = new FileWriter("questions.json");
			} catch (IOException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
			 
			 
			 obj0.add("questions",AllQList);
			// allQuestions.add(q);
				Gson gson1 = new Gson();
	   Type type = new TypeToken<ArrayList<Question>>() {}.getType();
	   JsonArray json = (JsonArray) gson1.toJsonTree(allQuestions, type);
		
	         obj0.add("questions", json);
	         try {
					file.write(obj0.toString());
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		    	 try {
					file.flush();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

		}
*/
		
	////////////////////////////////////	

		
		public static boolean addQuestion(Question question) {
			if(question!=null){
				 return allQuestions.add(question);
				 
			}
			return false;
		}
		
	/*	public static boolean removeQuestion(Question question) {
			if(question!=null && allQuestions.remove(question))
					return true;
			return false;
				
		}	*/

		public boolean editQuestion(Question question) {
			if(question!=null && allQuestions.contains(question)) {
				allQuestions.remove(question);
				allQuestions.add(question);
				return true;
			}
			return false;
		}
		
	static public ArrayList<Question> loadQuestions() throws JsonIOException, JsonSyntaxException, FileNotFoundException {
			
		int index;
			JsonParser parser = new JsonParser();
			 JsonElement jsontree = parser.parse(new FileReader("questions.json"));
		        JsonObject je = jsontree.getAsJsonObject();
		        JsonArray ja = je.getAsJsonArray("questions");
		       
		        for (Object o : ja)
		        {
		        	//Question qu=new Question();
		        	 Question qu=new Question();
		        	 JsonObject question = (JsonObject) o;
			            int id = question.get("id").getAsInt();
			            qu.setId(id);
			            int difficul=question.get("difficulty").getAsInt();		            
			            qu.setdifficulty(difficul);
			            String questionContext=question.get("text").getAsString();
			            qu.setQuestionContext(questionContext);
			            boolean isMultipleChoice=question.get("isMultipleChoice").getAsBoolean();
			            qu.setMultipleChoice(isMultipleChoice);
			            String team=question.get("team").getAsString();
			            qu.setTeam(team);
			            
			        /*    ArrayList<String> tags=new ArrayList<String>();
			            JsonArray tagsJson=question.getAsJsonArray("tags");
			           // tags=null;
			            for(Object o1: tagsJson) {
			            	 JsonElement tagsElement = (JsonElement) o1;
			            	 String tagText = tagsElement.getAsString();
			 	           tags.add(tagText);
			            }
			            qu.setTags(tags);*/
			            
			            ArrayList<Answer> options=new ArrayList<Answer>();
			            JsonArray answerJson=new JsonArray();
			            answerJson=question.getAsJsonArray("answers");
			        //   System.out.println(" - - ---- - - im a hero -- - - - -" + question.toString());
			        //   System.out.println(" - - ---- - - im a zero -- - - - -" + answerJson.toString());
			            for(Object o1: answerJson) {
			         
			            //	 JsonElement answerElement = (JsonElement) o1;
			            	 Answer answer=new Answer();
			            	//String ans=answerElement.getAsString();
			            	 JsonObject answer2 = (JsonObject) o1;
			            	 
			            	 
			            	 String textA = answer2.get("text").getAsString();
			            	 answer.setText(textA);
			 	           boolean isCorrect = answer2.get("isCorrect").getAsBoolean();
				            answer.setIsCorrect(isCorrect);
				           
				              options.add(answer);
				       /*     for( int i=0; i<options.size();i++){
				            System.out.println(options.get(i).getText());
				            
				            }*/
				            
				            
				            
			                }
			            ArrayList<String> TAGS=new ArrayList<String>();
			            JsonArray TagsJson=new JsonArray();
			            TagsJson=question.getAsJsonArray("tags");
			           System.out.println(" - - ---- - - im a zero -- - - - -" + TagsJson);
			           if(TagsJson!=null)
			           {
			            for(Object o2: TagsJson) {
			         
			            	 JsonElement TagElement = (JsonElement) o2;
			            	 //Answer answer=new Answer();
			            	//String ans=answerElement.getAsString();
			            	 //JsonObject tag = (JsonObject) o2;
			            	//String textA = tag.get("").getAsString();			           
				            TAGS.add(o2.toString());
				            
				       
			            }
			           }
			           qu.setTags(TAGS);
			   	    Collections.shuffle(options);	 
			            qu.setOptions(options);
			            System.out.println("the option in question control"+qu.getOptions());
			            for(int i=0;i<qu.getOptions().size();i++)
				           {
				        	   Answer a=qu.getOptions().get(i);
				        	   if(a.getIsCorrect())
					            {
				        		  // System.out.println("its correct option:"+a);
					            	index=qu.getOptionIndex(a.getText());
					            	System.out.println("its index"+index);
					            	qu.addCorrectAnswerIndex(index);
					            } 
				           }
			            System.out.println("the correct answer in question control"+qu.getcorrectanswersIndex());
			            allQuestions.add(qu);
			            
			            
		          }
		        
		       System.out.println("**** sam7 *** " + allQuestions);
		        
				return allQuestions;
	}
	    
	    
	    
	    
	    
	   
	    
	
	
	
	
	
	


   	/**
 * this method adds a new question 
 * @param q
 * @return
 */
public boolean addNewQuestion(Question q){
	
	if(!currentGame.getQuestions().containsKey(q.getId()))
	{
		currentGame.addQuestions(q);
		return true;
	}
	return false;
}


/**
 * this method edit/updates an existing question
 * @param q
 * @return true if question was edited
 * @throws IOException 
 */
/*
public boolean updateAnExistingQuestion(Question questionToUpdate ) throws IOException{
	if(allQuestions.contains(questionToUpdate)){
//	if(questionstouse.containsKey(questionToUpdate.getId())){
                Question oldQuestion = null;
                for(Question q : QuestionData.getQuestions()){
                    if(q.getId() == questionToUpdate.getId()){
                        oldQuestion = q;
                        break;
                    }
                }
                removeQuestion(oldQuestion);
                addQuesitonToDB(questionToUpdate);
                AddQuesionBylevel();
                return true;
	}
	return false;
}
    


//**
 * this method edit/updates an existing question
 * @param q
 * @return true if question was edited
 * @throws IOException 
 */
public boolean updateAnExistingQuestion(Question questionToUpdate ) throws IOException{
	
	//if(allQuestions.contains(questionToUpdate)){
	for(int i=0;i<allQuestions.size();i++)
	{
		if(allQuestions.get(i).getId()==questionToUpdate.getId())
		{
		System.out.println("contain in all question *************");
                Question oldQuestion = null;
                        oldQuestion = allQuestions.get(i);
                        System.out.println("this is the question to delete"+oldQuestion);
                        removeQuestion(oldQuestion);
            
                        QuestionData.getQuestions().add(questionToUpdate);
                        addQuesitonToDB(questionToUpdate);
                       // AddQuesionBylevel();
                        return true;
                        
       }
   }
         
	
	return false;
}

public boolean removeQuestion(Question q) throws IOException {
	if(q != null){
		allQuestions.remove(q);
	QuestionData.setQuestions(new ArrayList<Question>(allQuestions));
	UpdateData.getInstance().writeObject(Main.file, QuestionData);
     AddQuesionBylevel();
	return true;
}
return false;
}

public static Question getSpecificQuestion(String context){
    
    for(Question e :getAllQuestions()){
        if(e.getQuestionContext().equals(context))
            return e;
    }
    
    return null;
    
}

public void addQuesitonToDB(Question q) throws IOException{
	//QuestionData.getQuestions().add(q);
   // questionstouse.put(q.getId(),q);
    allQuestions.add(q);
    AddQuesionBylevel();
    UpdateData.getInstance().writeObject(Main.file,QuestionData);
    
    
}
	
	 public  void AddQuesionBylevel()
	    {
		
	     if(allQuestions != null)
	    	for(Question Q:allQuestions)
	    	{
	    		System.out.println(Q);
	    	if(Q.getdifficulty()==0)
	    		{
                easy.put(Q.getId(), Q);
	    		}
	    	if(Q.getdifficulty()==1)
	    	{
	    		 medium.put(Q.getId(), Q);
	    	}
	    	if(Q.getdifficulty()==2)
	    	{
	    		 hard.put(Q.getId(), Q);
	    	}
	    	
	    }
        }
	 
	 /**
		 * this method pops-up a questions to the user
		 * @return
		 */
		public  Question popRandomQuestion(int dif){
	            Question Qu = null;
	            int randomIndex ;
	            generator=new Random();
	               if(dif==2)
	               {
	                    if(hard.keySet().size()>0){
	                    	
	                    randomIndex = generator.nextInt(hard.keySet().size());
	                    ArrayList<Question> hardOnes = new ArrayList<Question>(hard.values());
	                    Qu = hardOnes.get(randomIndex);
	               }
	               }
	        
	               if(dif==1)
	               {
	            	   if(medium.keySet().size()>0){
	            		   randomIndex = generator.nextInt(medium.keySet().size());
		                    ArrayList<Question> meduimOnes = new ArrayList<Question>(medium.values());
		                    Qu = meduimOnes.get(randomIndex); 
		               
	                     }
	               }

	               if(dif==0)
	               {
	            	   if(easy.keySet().size()>0){
	            		   randomIndex = generator.nextInt(easy.keySet().size());
		                    ArrayList<Question> easyOnes = new ArrayList<Question>(easy.values());
		                    Qu = easyOnes.get(randomIndex);  
		              
	                     }
	               }
	            
	            
	            
			return Qu;
		}
		
		   
    	/**
 * this method checks if the player answered correctly if so it returns true otherwise false
 * @param q
 * @param answers
 * @return
 */
public boolean checkAnswers(Question q ,ArrayList<String> answers){
	
	ArrayList<Integer> answersl = q.getcorrectanswersIndex();
            ArrayList<String> correctAnswers = new ArrayList<String>();
            
            for(int i=0;i<answersl.size();i++){
              correctAnswers.add(q.getOptions().get(answersl.get(i)).getText());
            }
            
            if(answers.size() != correctAnswers.size())
            {
            	
                return false;
            }
            
            for(int j=0;j<correctAnswers.size();j++)
            {
            for(int i=0;i<answers.size();i++)
            {
                if(!correctAnswers.get(j).equals(answers.get(i)))
                {
                	
                    return false;
                }
            }
            }
        	
            return true;
      
	
}


public boolean isFlag() {
			return flag;
		}

		public void setFlag(boolean flag) {
			this.flag = flag;
		}

public static ArrayList<Question> getAllQuestions() {
	return allQuestions;
}

public HashMap<Integer,Question> geteasy(){
    return easy;
}

public HashMap<Integer,Question> getmedium(){
    return medium;
}

public HashMap<Integer,Question> gethard(){
    return hard;
}
public static Question RandomQuestioncard(String Tag)
{    
	String tagcleared;
	System.out.println(Tag);
	ArrayList <Question>spacificTag=new ArrayList<Question>();
	for(int i=0;i<allQuestions.size();i++)
	{
		for(int j=0;j<allQuestions.get(i).getTags().size();j++)
		{
			tagcleared=	allQuestions.get(i).getTags().get(j).replaceAll("\"", "");
			
			System.out.println("the tagggg"+Tag);
			System.out.println("hisssss"+tagcleared);
			if(tagcleared.equals(Tag))
			{
				spacificTag.add(allQuestions.get(i));	
			}
		}
	}
	
	Question Qu=null;
	Random generator =null;
	generator= new Random();
	int index;
	if(spacificTag.size()!=0)
	{
	 index = generator.nextInt(spacificTag.size());
	  Qu=spacificTag.get(index);
	}
	  return Qu;
}
}