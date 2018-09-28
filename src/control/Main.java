package control;

import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Scanner;


import model.SysData;
import view.Menu;
import model.Board;
import model.Card;
import model.GailCard;
import model.GoToGailCard;
import model.LuckCard;
import model.Player;
import model.QuestionCard;
import model.Question;
//main 
public class Main {
	public static SysData systemData ;
	public static SysData systemplayerData;
	   
	public static String file="questions.json";
	 public static String dataFile= "playersDb.json";

	public static void main(String[] args) {
    {
    	
    	
  
    	 //systemData=SysData.getInstance();
        ObjectInputStream input = null;
         
         try{
                input=new ObjectInputStream(new FileInputStream(file));
                systemData=(SysData) input.readObject();
                }
           catch(Exception e){
               systemData=SysData.getInstance();
                }
      
         
        if(systemData == null)
        	 systemData=SysData.getInstance();
         
         
      
    	
    
    	
    	////////////////////////////////
        ObjectInputStream input2 = null;
        
        try{
               input2=new ObjectInputStream(new FileInputStream(dataFile));
               systemplayerData=(SysData)input2.readObject();
               }
          catch(Exception e){
        	  systemplayerData=SysData.getInstance();
               }
         
        if(systemData == null)
        	systemplayerData=SysData.getInstance();
        
        
       new Menu(file,dataFile).setVisible(true);
   	
    }
	}
}
   
 

