package model;
//answer
import java.io.Serializable;

public class Answer  implements Serializable{
  
	private String text;
	private Boolean isCorrect;
	
	public Answer(String text ,Boolean isCorrect){
		this.text=text;
		this.isCorrect=isCorrect;
		
	}

	

	public Answer() {
		// TODO Auto-generated constructor stub
		
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Boolean getIsCorrect() {
		return isCorrect;
	}

	public void setIsCorrect(Boolean isCorrect) {
		this.isCorrect = isCorrect;
	}
}
