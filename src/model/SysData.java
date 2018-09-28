package model;

import java.util.ArrayList;
import java.util.HashMap;

import model.Question;
import model.user;
//sys data class
public class SysData implements java.io.Serializable{
   
    
		private static SysData instance;
		
		/**Stores all users*/
	    static ArrayList<Player> users;
		/**Stores all Questions*/
		 static ArrayList<Question> questions;
		//private ArrayList<Question> questions;
	
		/* stores all the cards in the game**/
		private ArrayList<Card> cardBoard;
	
                
		public SysData(){
			users= new ArrayList<Player>();
			questions = new ArrayList<Question>();
			cardBoard = new ArrayList<Card>();
		}
	
		/**
		 * The method creates this class's instance & provides access to it, by returning a reference (singleton).
		 * @return reference to this class's only instance (singleton).
		 */
		public static SysData getInstance() {
			if(instance == null){
				instance = new SysData();
				return instance;
			}
			else
				return instance;
		}

	//***************************************** Getters & Setters ***********************************
		/** 
		 * @return the users.
		 */
		public ArrayList<Player> getplayer() {
			return users;
		}

		/**
		 * @return the questions
		 */
		public ArrayList<Question> getQuestions() {
			return questions;
		}
		
		public void setQuestions(ArrayList<Question>  qe) {
			SysData.questions=qe;
		}
	
		/**
		 * @return the square board
		 */
		public ArrayList<Card> getSquareBoard(){
			return cardBoard;
		}
}