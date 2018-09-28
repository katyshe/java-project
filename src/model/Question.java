package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
/*
 * question class
 */
public class Question implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private int difficulty;
	private String text;
	private boolean isMultipleChoice;
	//private static int numofanswers;
	private String team;
	private static int count = 0;
	
	/**the Question's options*/
	private ArrayList<Answer> answers;
	
	/**List of indexes of correct answers*/
	private ArrayList<Integer> correctanswersIndex;

	private ArrayList<String>tags;
	
	
	
	
	public Question( String text,int difficulty,boolean isMultipleChoice,String team) {
		this.id = count++;
		this.text = text;
		this.setdifficulty(difficulty);
		this.isMultipleChoice=isMultipleChoice;
		this.setTeam(team);
		this.tags=new ArrayList<String>();
		this.answers=new ArrayList<Answer>();
		this.correctanswersIndex = new ArrayList<Integer>();
	}
	

	public Question(int id) {
		//this.id = id;
		this.answers = new ArrayList<Answer>();	
		this.correctanswersIndex = new ArrayList<Integer>();
	}
	
	public Question() {
		this.id = count++;
		this.answers = new ArrayList<Answer>();
	   this.correctanswersIndex = new ArrayList<Integer>();
	}
	
	
	/**
	 * sets and gets
	 * @return
	 */
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public void setTeam(String team) {
		this.team = team;
	}
	
	public String getTeam() {
		return team;
	}

	public int getdifficulty() {
		return difficulty;
	}
	public void setdifficulty(int difficulty) {
		if(difficulty>=0 && difficulty<3)
			this.difficulty = difficulty;
		else
			this.difficulty= -1;
	}
	
	public boolean isMultipleChoice() {
		return isMultipleChoice;
	}


	public void setMultipleChoice(boolean isMultipleChoice) {
		this.isMultipleChoice = isMultipleChoice;
	}
	public void setQuestionContext(String questionContext) {
		this.text = questionContext;
	}

	public String getQuestionContext() {
		return text;
	}
	
	/**
	 * @return Question's options array list
	 */
	public ArrayList<Answer> getOptions() {
		return answers;
	}

	/**
	 * @return Question's correctanswersIndex array list
	 */
	public ArrayList<Integer> getcorrectanswersIndex() {
		return correctanswersIndex;
	}
	

	/**
	 * add new option to the Question's 'options' array list.
	 * IF the option is not null and  IF option not already exist insert and return true
	 * @param option
	 * @return true or false
	 */
	public boolean addOption(String option ,boolean isMultiple){
		if(option!=null){
			if(!answers.contains(option)){
				Answer a=new Answer(option, isMultiple);
				answers.add(a);
				return true;
			}
		}
		return false;
	}
	
	/**
	 * add new tag to a  question
	 * @param tag
	 * @return
	 */
		public boolean addtags(String tag)
		{

			System.out.println("daaaaa   " +tag);
			if(!tags.contains(tag))
			{
				tags.add(tag);
				return true;
			}
			return false;
		}
		
	public  ArrayList<String> getTags() {
		return tags;
	}
	/**
	 * remove an option from the 'options' array list by given index
	 * IF the given index is in range
	 * @param optionIndex
	 * @return true or false
	 */
	 
	public boolean removeOptionByIndex(int optionIndex){
		if(optionIndex>=0 && optionIndex<answers.size()){
			answers.remove(optionIndex);
				return true;
		}
		return false;
	}
	
	/**
	 * by giving an optionString - return the index in the 'options' array list.
	 * IF the optionString exist >> Otherwise return (-1)
	 * @param optionText
	 * @return index of given optionString
	 */
	public int getOptionIndex(String optionString){
		for(int i=0;i<answers.size();i++)
		{
			if(answers.get(i).getText().equals(optionString))
			{
				System.out.println("the hero is "+i);
				return i;
			}
		}
		
		return-1;
		
	}
	
	/**
	 * add the correct  optionIndex to the 'answersIndex' array list.
	 * @param optionIndex
	 * @return true or false
	 */
	public boolean addCorrectAnswerIndex(Integer optionIndex){
		
		if(optionIndex!=null){
		
			if(optionIndex>=0 && optionIndex<answers.size()){

				if(!correctanswersIndex.contains(optionIndex)){
					correctanswersIndex.add(optionIndex);
					return true;
				}
			}
		}
		return false;
		
	}
	
	/**
	 * remove optionIndex from the 'answersIndex' array list.
	 * @param optionIndexToRemove
	 * @return true or false
	 */
	public boolean removeIndexOption(Integer optionIndexToRemove){
		if(correctanswersIndex.contains(optionIndexToRemove)){
			correctanswersIndex.remove(optionIndexToRemove);
			return true;
		}
		return false;
	}
	


	


	public void setTags(ArrayList<String> tags) {
		this.tags = tags;
	}


	@Override
	public String toString() {
		return "Question [id=" + id + ", difficulty=" + difficulty + ", questionContext=" + text
				+ ", isMultipleChoice=" + isMultipleChoice + ", team=" + team + ", options=" + answers + ", tags="
				+ tags + "]";
	}


	public void setOptions(ArrayList<Answer> options2) {
		// TODO Auto-generated method stub
		
		this.answers=options2;
		
//		for(int i=0;i<options2.size();i++){
//			this.answers.add(options2.get(i));
//		}
		//this.answers=options2;
	}


	
	

}