package control;

import static control.UpdateData.QuestionData;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;

import javax.lang.model.util.Types;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonIOException;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;

import control.Main;
import control.UpdateData;
import model.Question;
import model.user;
import model.Answer;
import model.Player;
import model.SysData;


public class UpdateData {

    private static UpdateData update;
    public static SysData playersData;
   static ArrayList<Player> allPlayers ;
    public static SysData QuestionData; 
    static JsonObject obj0 = new JsonObject();
	// static	 JsonArray  AllQList =new JsonArray(); 
	// static ArrayList<Question> allQuestions=new ArrayList<>();
	 static ArrayList<Question> loadQuestions=new ArrayList<>();
	 public static FileWriter file;
	 public static FileWriter dataFile;
	 
    private UpdateData(){
        QuestionData = Main.systemData;
        
        
        playersData=Main.systemplayerData;
        allPlayers =playersData.getplayer();
        try {
        	loadPlayers();
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
       // systemData=new SysData();
        //user admin = new user("Admin","Admin");
        //systemData.getUsers().put("Admin", admin);
    }
    
    
    
    public static UpdateData getInstance(){
     
        if(update == null){
            update = new UpdateData();
        }
        return update;
    }
    
    
    
    
    public boolean addNewUser(Player p) throws IOException{
                    
                    
                    
                    
			if(!allPlayers.contains(p)){
				allPlayers.add(p);
			    writeObject(Main.dataFile,playersData);
				return true;
			}
			return false;
                        
	
		}
    
    
    public boolean checkPlayerDetails(String userName, String password){
        for(int i=0;i<allPlayers.size();i++)
        {
        	if(allPlayers.get(i).getUsername().equals(userName))
        		if(allPlayers.get(i).getPassword().equals(password))
        			   return true;
        }
        
           
             
        
        return false;
    }
    
        public boolean checkPlayerUserName(String userName){
        	for(int i=0;i<allPlayers.size();i++)
            {
            	if(allPlayers.get(i).getUsername().equals(userName))
                return true;
            }
        
        return false;
        }
        
        
        public Player getPlayerDetails(String username){
        	for(int i=0;i<allPlayers.size();i++)
            {
        		if(allPlayers.get(i).getUsername().equals(username))
        			return allPlayers.get(i);
        			
            }
        	return null;
        }
    
        
        public ArrayList<Player> getAllPlayers(){
            
           
            return allPlayers;
        }
        
   
        public void writeObject(String fileName ,SysData database) throws IOException {
      
        System.out.println("******************************");
        if(fileName=="playersDb.json"){
        	 try {
        		 dataFile = new FileWriter("playersDb.json");
     		} catch (IOException e2) {
     			// TODO Auto-generated catch block
     			e2.printStackTrace();
     		}
         
         
     		 
     		// obj0.add("questions",AllQList);
     		// allQuestions.add(q);
     			Gson gson = new Gson();
        Type type1 = new TypeToken<ArrayList<Player>>() {}.getType();
        JsonArray json1 = (JsonArray) gson.toJsonTree(playersData.getplayer(), type1);
     	
              obj0.add("Players", json1);
              try {
            	  dataFile.write(obj0.toString());
     			} catch (IOException e) {
     				// TODO Auto-generated catch block
     				e.printStackTrace();
     			}
     	    	 try {
     	    		dataFile.flush();
     			} catch (IOException e) {
     				// TODO Auto-generated catch block
     				e.printStackTrace();
     			}
     	    	dataFile.close();}
        
        
        
        else  
        	if(fileName=="questions.json"){
            System.out.println("********************jsoooooooooooon**********");
        try {
    			file = new FileWriter("questions.json");
    		} catch (IOException e2) {
    			// TODO Auto-generated catch block
    			e2.printStackTrace();
    		}
        
        
    		 
    		// obj0.add("questions",AllQList);
    		// allQuestions.add(q);
    			Gson gson1 = new Gson();
       Type type = new TypeToken<ArrayList<Question>>() {}.getType();
       JsonArray json = (JsonArray) gson1.toJsonTree(QuestionData.getQuestions(), type);
    	
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
    	    	 file.close();}
        }
            
           
        
      /*  public void updatePlayerDetails(Player p ) throws IOException{
            
        if(systemData.getUsers().get(p.getUsername()) != null){
            
            systemData.getUsers().put(p.getUsername(), p);
            writeObject(Main.dataFile,systemData);
        }
                  
        }*/
        
        public ArrayList<Integer> getAllQuestions(){
            ArrayList<Integer> questionsIDS = new ArrayList<Integer>();
            
            for(Question q : QuestionData.getQuestions())
                questionsIDS.add(q.getId());
            
            return questionsIDS;
        }
        
        public Question getSpecificQuestion(String id){
            
            int idConverted = Integer.parseInt(id);
            for(Question e : QuestionData.getQuestions()){
                if(e.getId() == idConverted)
                    return e;
            }
            
            return null;
            
        }
       static public ArrayList<Player> loadPlayers() throws JsonIOException, JsonSyntaxException, FileNotFoundException {
			
    		
    			JsonParser parser = new JsonParser();
    			 JsonElement jsontree = parser.parse(new FileReader("playersDb.json"));
    		        JsonObject je = jsontree.getAsJsonObject();
    		        JsonArray ja = je.getAsJsonArray("Players");
    		       
    		        for (Object o : ja)
    		        {
    		        	//Question qu=new Question();
    		        	 
    		        	 JsonObject palyer = (JsonObject) o;
    			            String username= palyer.get("username").getAsString();
    			            String password=palyer.get("password").getAsString();		            
    			            Player p=new Player(username,password);
    			            		allPlayers.add(p);
    			            
    			            
    		          }
    		        
    		       System.out.println("****** sam7 ***** " + allPlayers);
    		        
    				return allPlayers;
    	}
        
    
}