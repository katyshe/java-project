package view;
// help frame
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import control.GameControl;
import control.PlayerInGame;
import control.QuestionControl;
import model.Board;
import model.Card;
import model.LuckCard;
import model.Question;
import model.QuestionCard;
import model.propertycard;
import javax.swing.ImageIcon;

public class HelpFramAddQuestion extends JFrame {
	private static QuestionControl qc;
	private JPanel contentPane;
	private GameControl gc;
	private Card Card;
	private PlayerInGame PlayerController;
	HashMap<String,JCheckBox> checkBoxes;
	JButton okButton;
	Question Q;
	Question Q2;
	 private boolean flag;
	 private boolean itsokbutton=false;
	 private boolean answer1=false,answer2=false;
	 private   HashMap<PlayerInGame,String> Answers=new HashMap<PlayerInGame,String>();
	 private int numberOfPlayers;
	 private HashMap<String,Boolean> answersCheck;
private int c=0;
	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HelpFramAddQuestion frame = new HelpFramAddQuestion();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	public boolean getFlag() {
		return flag;
	}
	public void setFlag(boolean flag) {
		this.flag = flag;
	}
	/**
	 * Create the frame.
	 */
	public HelpFramAddQuestion( Question q ,Question q2, Card card,PlayerInGame playerController, final int numofplayers,HashMap<String,Boolean> answerz,GameControl gcc) {
	
		setTitle(playerController.getPlayer().getUsername()+""+"answer :");
		
		
		if(q!=null)
		{
		
		itsokbutton=false;
		this.Q=q;
		this.Q2=q2;
		this.Card=card;
		this.PlayerController=playerController;
		this.flag=false;
		this.numberOfPlayers=numofplayers;
		this.answersCheck=answerz;
		 this.gc = gcc;
		 
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		setSize(900,500);
        	
			checkBoxes=new HashMap<String,JCheckBox>();
		String raw =
				"<html><head></head><body><div>" +

				""+"<h><FONT style=\"font-weight: bold; font-size: 18px;\"> "+Q.getQuestionContext()+"<br>("+Q.getdifficulty()+")"+"</FONT></h>" +
				"<br>" +
				"</div></body></html>";
		 for(int i=0;i<Q.getOptions().size();i++)
	         System.out.println(Q.getOptions().get(i).getText());

				JPanel panel=new JPanel();
				panel.setOpaque(true);
				panel.setBackground(Color.LIGHT_GRAY);
				panel.setLayout(null);
				contentPane.add(panel);

				JLabel questionTitle = new JLabel(raw);
				questionTitle.setSize(600, 80);
				questionTitle.setLocation(100, 20);
				panel.add(questionTitle); 

				

				int width=0,height=80;
				Font checkBoxFont = new Font("Arial",Font.BOLD,22);

				for(int i=0;i<Q.getOptions().size();i++){

				height+=40;

				JCheckBox box = new JCheckBox();


				JLabel jl = new JLabel(Q.getOptions().get(i).getText());
				jl.setSize(600, 30);
				jl.setFont(checkBoxFont);


				box.setFont(checkBoxFont);
				box.setSize(20, 20);

				box.setLocation(50, height);      
				   jl.setLocation(50+30, height-5);

				panel.add(box);
				panel.add(jl);

				checkBoxes.put(jl.getText(), box);
				}
				/*for(String o:checkBoxes.keySet())
				{
					if(checkBoxes.get(o).isSelected())
						c++;
						
				}*/
				 okButton = new JButton("OK");
				okButton.setFont(checkBoxFont);
				okButton.setSize(200, 50);
				okButton.setLocation(300, 380);

				panel.add(okButton);
				okButton.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent arg0){
						if(Card instanceof propertycard)
						checkanswerPro(Q);
						if(Card instanceof QuestionCard)
							checkanswerQUES(Q);
						
							if(Card instanceof LuckCard)
							{
								checkq1(Q);
								if(Q2!=null)
								{
									c=0;
									setBounds(100, 100, 450, 300);
									contentPane = new JPanel();
									contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
									contentPane.setLayout(new BorderLayout(0, 0));
									setContentPane(contentPane);
									setSize(900,500);
							        	
										checkBoxes=new HashMap<String,JCheckBox>();
									String raw =
											"<html><head></head><body><div>" +

											""+"<h><FONT style=\"font-weight: bold; font-size: 18px;\"> "+Q2.getQuestionContext()+"<br>("+Q2.getdifficulty()+")"+"</FONT></h>" +
											"<br>" +
											"</div></body></html>";
									 for(int i=0;i<Q2.getOptions().size();i++)
								         System.out.println(Q2.getOptions().get(i).getText());

											JPanel panel=new JPanel();
											panel.setOpaque(true);
											panel.setBackground(Color.LIGHT_GRAY);
											panel.setLayout(null);
											contentPane.add(panel);

											JLabel questionTitle = new JLabel(raw);
											questionTitle.setSize(600, 80);
											questionTitle.setLocation(100, 20);
											panel.add(questionTitle); 

											

											int width=0,height=80;
											Font checkBoxFont = new Font("Arial",Font.BOLD,22);

											for(int i=0;i<Q2.getOptions().size();i++){

											height+=40;

											JCheckBox box = new JCheckBox();


											JLabel jl = new JLabel(Q2.getOptions().get(i).getText());
											jl.setSize(600, 30);
											jl.setFont(checkBoxFont);


											box.setFont(checkBoxFont);
											box.setSize(20, 20);

											box.setLocation(50, height);      
											   jl.setLocation(50+30, height-5);

											panel.add(box);
											panel.add(jl);

											checkBoxes.put(jl.getText(), box);
											}
//											for(String o:checkBoxes.keySet())
//											{
//												if(checkBoxes.get(o).isSelected())
//													c++;
//													
//											}
											 okButton = new JButton("OK");
											okButton.setFont(checkBoxFont);
											okButton.setSize(200, 50);
											okButton.setLocation(300, 380);

											panel.add(okButton);

											
											okButton.addActionListener(new ActionListener(){
												public void actionPerformed(ActionEvent arg0){
													
													if(Card instanceof propertycard)
													checkanswerPro(Q2);
												
														if(Card instanceof LuckCard)
														{
															setVisible(false);
		
															checkq2(Q2);
															
													    
														}
													
												}
											});
											
											 
									}
								}
					
							}
					
					
					
					
					}
				);
				
				
		}

	
		
		
				//JOptionPane jd;
				//jd.add(panel);

				
	

	
	}
	private void checkanswerQUES(Question q)
	{
		String flags="false";
		ArrayList<String> selectedAnswers = new ArrayList<String>();

		String s = " ";
		for(String jcb : checkBoxes.keySet()){
		if(checkBoxes.get(jcb).isSelected()){
		selectedAnswers.add(jcb);
		}
		}
		setEnabled(false);
		setVisible(false);
		qc=QuestionControl.getInstance();
		if(qc.checkAnswers(q, selectedAnswers)){
			this.setFlag(true);
flags="true";
			System.out.println("my answer in check answer"+flag);

		JOptionPane.showMessageDialog(null,"<html><head></head><body>" +
		"<h><FONT style=\"font-weight: bold; font-size: 18px;color:green;\"> "+"CORRECT!"+"</FONT></h><br>"
		+ "<h><FONT style=\"font-weight: bold; font-size: 16px;\"> "+"You earned "+"</FONT></h>" +
		"<h><FONT style=\"font-weight: bold; font-size: 18px;color:green;\"> "+"</FONT></h>"+
		"<h><FONT style=\"font-weight: bold; font-size: 18px;\"> Points!</FONT></h>"+
		"</body></html>", "Result", JOptionPane.INFORMATION_MESSAGE, null);

		answersCheck.put(PlayerController.getPlayer().getUsername(), true);

		helperMethodUtility();
		}else{
			flags="false";
			this.setFlag(false);
			System.out.println("my answer in check answer"+flag);
		JOptionPane.showMessageDialog(null,
		"<html><head></head><body>" +
		"<h><FONT style=\"font-weight: bold; font-size: 18px;color:red;\"> "+"FALSE!"+"</FONT></h><br>"
		+ "<h><FONT style=\"font-weight: bold; font-size: 16px;\"> "+"You lost "+"</FONT></h>" +
		"<h><FONT style=\"font-weight: bold; font-size: 18px;color:red;\"> "+"</FONT></h>"+
		"<h><FONT style=\"font-weight: bold; font-size: 18px;\"> Points!</FONT></h>"+
		"</body></html>", "Result", JOptionPane.INFORMATION_MESSAGE, null);
		
		answersCheck.put(PlayerController.getPlayer().getUsername(), false);
		
		helperMethodUtility();
		}
				
		}
	
	private void helperMethodUtility(){
		
		System.out.println("IDSS   "+answersCheck.keySet());
		if(numberOfPlayers > 0){
			PlayerInGame pc = null;		
			for(PlayerInGame p : gc.getPlayersInGame()){
				System.out.println("PLAYER IN GAME TEST " + p.getPlayer().getUsername());
				if(!answersCheck.containsKey(p.getPlayer().getUsername())){
					pc=p;
				
					break;
				}
			}
					
			if(pc == null){
				System.out.println("heeeeeeeeeeeeeey im here ");
				return;	
			}
				
			
			HelpFramAddQuestion hfaq = new HelpFramAddQuestion(Q,Q2,Card,pc,--numberOfPlayers,answersCheck,gc);
			hfaq.setVisible(true);
			
		}else{
			
			
			HashMap<PlayerInGame,String> hashToSend = new HashMap<PlayerInGame,String>();
			
			

			for(String ids : answersCheck.keySet()){
				for(PlayerInGame pp : gc.getPlayersInGame()){
					if(pp.getPlayer().getUsername() == ids){
						hashToSend.put(pp, (answersCheck.get(ids) ? "true":"false"));
						break;
					}
				}
				
				System.out.println("*&*^$ PLayer : "+ids +" Answer : "+answersCheck.get(ids));
			}
	
			gc.questionmethod(hashToSend);
			
		}
	}
	
	private void checkanswerPro(Question q)
	{
		ArrayList<String> selectedAnswers = new ArrayList<String>();

		String s = " ";
		for(String jcb : checkBoxes.keySet()){
		if(checkBoxes.get(jcb).isSelected()){
		selectedAnswers.add(jcb);
		}
		}
		setEnabled(false);
		setVisible(false);
		qc=QuestionControl.getInstance();
		if(qc.checkAnswers(q, selectedAnswers)){
			System.out.println("the card owner is&%$#%^&%$#@!:"+((propertycard)Card).getOwn());
			if(Card.getCardId()==23||Card.getCardId()==14)
		    	if(((propertycard)Card).getOwn()==null)
			{
				gc.specialproNoOwn(PlayerController,(propertycard) Card, Q, true);
				JOptionPane.showMessageDialog(null,
						"<html><head></head><body>" +
						"<h><FONT style=\"font-weight: bold; font-size: 18px;color:green;\"> "+"Correct!"+"</FONT></h><br>"
						+ "<h><FONT style=\"font-weight: bold; font-size: 16px;\"> "+"You Get a discount"+"</FONT></h>" +
						"<h><FONT style=\"font-weight: bold; font-size: 18px;color:red;\"> "+"</FONT></h>"+
						"<h><FONT style=\"font-weight: bold; font-size: 18px;\"> Points!</FONT></h>"+
						"</body></html>", "Result the price of pro"+((propertycard)Card).getPrice(), JOptionPane.INFORMATION_MESSAGE, null);
			}
			else
			
				if(Card.getCardId()==23||Card.getCardId()==14) 
				if( ((propertycard)Card).getOwn()!=null)
					if(((propertycard)Card).getOwn()!=PlayerController.getPlayer())
				{
					gc.specialproHasOwn(PlayerController, (propertycard) Card, Q, true,((propertycard)Card).getOwn());
					JOptionPane.showMessageDialog(null,
							"<html><head></head><body>" +
							"<h><FONT style=\"font-weight: bold; font-size: 18px;color:green;\"> "+"Correct!"+"</FONT></h><br>"
							+ "<h><FONT style=\"font-weight: bold; font-size: 16px;\"> "+"You Get a discount"+"</FONT></h>" +
							"<h><FONT style=\"font-weight: bold; font-size: 18px;color:red;\"> "+"</FONT></h>"+
							"<h><FONT style=\"font-weight: bold; font-size: 18px;\"> Points!</FONT></h>"+
							"</body></html>", "Result the price of pro"+((propertycard)Card).getPrice(), JOptionPane.INFORMATION_MESSAGE, null);
					
				}
			
			else
			{
			
			
			this.setFlag(true);

			System.out.println("my answer in check answer"+flag);
			gc.propaity(PlayerController, (propertycard)Card, Q, true);
			JOptionPane.showMessageDialog(null,
					"<html><head></head><body>" +
					"<h><FONT style=\"font-weight: bold; font-size: 18px;color:green;\"> "+"Correct!"+"</FONT></h><br>"
					+ "<h><FONT style=\"font-weight: bold; font-size: 16px;\"> "+"You Get a discount"+"</FONT></h>" +
					"<h><FONT style=\"font-weight: bold; font-size: 18px;color:red;\"> "+"</FONT></h>"+
					"<h><FONT style=\"font-weight: bold; font-size: 18px;\"> Points!</FONT></h>"+
					"</body></html>", "Result the price of pro"+((propertycard)Card).getPrice(), JOptionPane.INFORMATION_MESSAGE, null);

	    	
			}

		
		}
			if(!qc.checkAnswers(q, selectedAnswers)){
			if(Card.getCardId()==23||Card.getCardId()==14)
			{
				JOptionPane.showMessageDialog(null,
						"<html><head></head><body>" +
						"<h><FONT style=\"font-weight: bold; font-size: 18px;color:red;\"> "+"FALSE!"+"</FONT></h><br>"
						+ "<h><FONT style=\"font-weight: bold; font-size: 16px;\"> "+"You lost "+"</FONT></h>" +
						"<h><FONT style=\"font-weight: bold; font-size: 18px;color:red;\"> "+"</FONT></h>"+
						"<h><FONT style=\"font-weight: bold; font-size: 18px;\"> Points!</FONT></h>"+
						"</body></html>", "Result is false ", JOptionPane.INFORMATION_MESSAGE, null);
			}
			else
			{
			this.setFlag(false);
			System.out.println("my answer in check answer"+flag);
			gc.propaity(PlayerController, (propertycard)Card, Q, false);
		JOptionPane.showMessageDialog(null,
		"<html><head></head><body>" +
		"<h><FONT style=\"font-weight: bold; font-size: 18px;color:red;\"> "+"FALSE!"+"</FONT></h><br>"
		+ "<h><FONT style=\"font-weight: bold; font-size: 16px;\"> "+"You lost "+"</FONT></h>" +
		"<h><FONT style=\"font-weight: bold; font-size: 18px;color:red;\"> "+"</FONT></h>"+
		"<h><FONT style=\"font-weight: bold; font-size: 18px;\"> Points!</FONT></h>"+
		"</body></html>", "Result the price of pro"+((propertycard)Card).getPrice(), JOptionPane.INFORMATION_MESSAGE, null);
		
			}
			}
		System.out.println("the flag in help methos is"+flag);
		
		
		}
	private void checkq1(Question q1)
	{
		ArrayList<String> selectedAnswers = new ArrayList<String>();

		String s = " ";
		for(String jcb : checkBoxes.keySet()){
		if(checkBoxes.get(jcb).isSelected()){
		selectedAnswers.add(jcb);
		}
		}
		qc=QuestionControl.getInstance();
		if(qc.checkAnswers(q1, selectedAnswers))
			answer1=true;
	    else
	    	answer1=false;
	}
	private void checkq2(Question q2)
	{
		ArrayList<String> selectedAnswers = new ArrayList<String>();

		String s = " ";
		for(String jcb : checkBoxes.keySet()){
		if(checkBoxes.get(jcb).isSelected()){
		selectedAnswers.add(jcb);
		}
		}
		setEnabled(false);
		setVisible(false);
		qc=QuestionControl.getInstance();
		if(qc.checkAnswers(q2, selectedAnswers))
			answer2=true;
	    else
	    	answer2=false;
		
		checkanswer2(Q,Q2);
	}
	private void checkanswer2(Question q1,Question q2)
	{		
		if(answer1==true &&answer2==true )
		{
			JOptionPane.showMessageDialog(null,"<html><head></head><body>" +
		"<h><FONT style=\"font-weight: bold; font-size: 18px;color:green;\"> "+"your two answers is CORRECT!"+"</FONT></h><br>"
		+ "<h><FONT style=\"font-weight: bold; font-size: 16px;\"> "+"You earned "+"</FONT></h>" +
		"<h><FONT style=\"font-weight: bold; font-size: 18px;color:green;\"> "+"</FONT></h>"+
		"<h><FONT style=\"font-weight: bold; font-size: 18px;\"> Points!</FONT></h>"+
		"</body></html>", "Result", JOptionPane.INFORMATION_MESSAGE, null);
		}
		if(answer1==false)
		{
			JOptionPane.showMessageDialog(null,
					"<html><head></head><body>" +
					"<h><FONT style=\"font-weight: bold; font-size: 18px;color:red;\"> "+"you answer for question 1 is FALSE!"+"</FONT></h><br>"
					+ "<h><FONT style=\"font-weight: bold; font-size: 16px;\"> "+"You lost "+"</FONT></h>" +
					"<h><FONT style=\"font-weight: bold; font-size: 18px;color:red;\"> "+"</FONT></h>"+
					"<h><FONT style=\"font-weight: bold; font-size: 18px;\"> Points!</FONT></h>"+
					"</body></html>", "Result", JOptionPane.INFORMATION_MESSAGE, null);	
		}
	    	


		else{
		if(answer2==false)
		{
		JOptionPane.showMessageDialog(null,
		"<html><head></head><body>" +
		"<h><FONT style=\"font-weight: bold; font-size: 18px;color:red;\"> "+"you answer for question 2 is FALSE!"+"</FONT></h><br>"
		+ "<h><FONT style=\"font-weight: bold; font-size: 16px;\"> "+"You lost "+"</FONT></h>" +
		"<h><FONT style=\"font-weight: bold; font-size: 18px;color:red;\"> "+"</FONT></h>"+
		"<h><FONT style=\"font-weight: bold; font-size: 18px;\"> Points!</FONT></h>"+
		"</body></html>", "Result", JOptionPane.INFORMATION_MESSAGE, null);
		
		}
		}
		gc.luck(PlayerController, q1, q2, answer1, answer2);


		}
	
	
	
	
	
}