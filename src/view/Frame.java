package view;

import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.text.BadLocationException;
import javax.swing.text.html.HTMLDocument;
import javax.swing.text.html.HTMLEditorKit;

import control.Consts;
import control.GameControl;
import control.Main;
import control.PlayerInGame;
import control.QuestionControl;
import control.UpdateData;
import model.Board;
import model.Card;
import model.GoToGailCard;
import model.LuckCard;
import model.Player;
import model.Question;
import model.QuestionCard;
import model.StartCard;
import model.SysData;
import model.Tags;
import model.propertycard;

import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.awt.event.ActionEvent;
/*
 * frame
 */
public class Frame extends JFrame {

	static MinMap s;
	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel Label_0;
	private JLabel lblNewLabel_2;
	private JLabel Label_2;
	private JLabel lblNewLabel_3;
	 private JLabel lblNewLabel_4;
		private JTextField payer1;
		private JTextField score1;
		private JTextField payer2;
		private JTextField payer3;
		private JTextField payer4;
		private JTextField score2;
		private JTextField score3;
		private JTextField score4;
		private JButton btnDice;
		
		private StringBuilder sb;
		private HTMLEditorKit editorKit;
		private HTMLDocument doc;
		//JTextPane textPane; 
		//private JPanel panel;
		//DecimalFormat df2; 
		//JScrollPane scrollPane_1;
		//JLabel lblInformation;
	String file;
	 public static GameControl gc;
	 public static UpdateData updatedSystem;
	 public static QuestionControl qc;
	    public static SysData systemData;
	    private ArrayList<String> playersUsernamess;
	    private ArrayList<JLabel> ownsforplayers;
	    private int numberOfPlayersinGame;//number of players in game
	    public boolean gameisfinished;
	    private static HashMap<Card,Player>ownscards=new HashMap<Card,Player>();
	    ArrayList<Card> savecards ;
	    ArrayList<Player> players;
	
	 
	   
	    private ImageIcon player1Image = new ImageIcon(this.getClass().getResource("/images/player11.jpeg"));
	    private ImageIcon player2Image   = new ImageIcon(this.getClass().getResource("/images/player12.jpeg"));
	    private ImageIcon player3Image  = new ImageIcon(this.getClass().getResource("/images/player13.jpeg"));
	    private ImageIcon player4Image  = new ImageIcon(this.getClass().getResource("/images/player14.jpeg"));
	    private ImageIcon blueFlag  = new ImageIcon(this.getClass().getResource("/images/blueFlag.png"));
	    
	    private ImageIcon icon = new ImageIcon(this.getClass().getResource("/images/winner.jpg"));
	    PlayerInGame player1;// reference to playeringame class
	    PlayerInGame player2;
	    PlayerInGame player3;
	    PlayerInGame player4;
	    JLabel player1_inGame ; 
	    JLabel player2_inGame ; 
	    JLabel player3_inGame ; 
	    JLabel player4_inGame ; 
	    JLabel star1_inGame;
	    static JLabel photolabel;
	    private JLabel lblPlayer;
	    private JLabel lblScore;
	    private JLabel lblturn;
	    private int hadplay=1;//count number of players had play in one round
	   
	    private JLabel player1inDT;
	    private JLabel player2inDT;
	    private JLabel player3inDT;
	    private JLabel player4inDT;
	    private JLabel lblNewLabel_5;
	    HashMap<String,JCheckBox> checkBoxes;
	    private DefaultComboBoxModel<String>Tag;
	  
	    JComboBox<String> comboBo;
	    private JTextField iterationNum;
	    private Board B;
	    private JLabel label_7;
	    private JLabel label_9;
	    private JLabel label_11;
	    private JLabel label_13;
	    private JLabel label_14;
	    private JLabel label_16;
	    private JLabel label_18;
	    private JLabel label_19;
	    private JLabel label_21;
	    private JLabel label_23;
	    private JLabel label_24;
	    private JLabel label_26;
	    private JLabel label_27;
	    private JLabel label_29;
	    private JLabel label_31;
	    private JLabel label_32;
	    private JLabel label_34;
	    private JLabel label_35;
	    private JLabel label_37;
	    private JLabel label_39;
	    private JLabel lblNewLabel_7;
	    private JLabel lblNewLabel_8;
	    private JLabel lblNewLabel_9;
	    private JLabel lblNewLabel_10;
	    private JLabel lblNewLabel_11;
	    private JLabel lblNewLabel_12;
	    private JLabel lblNewLabel_13;
	    private JLabel lblNewLabel_14;
	    private JLabel lblNewLabel_15;
	    private JLabel lblNewLabel_16;
	    private JLabel lblNewLabel_17;
	    private JLabel lblNewLabel_18;
	    private JLabel lblNewLabel_19;
	    private JLabel lblNewLabel_20;
	    private JLabel Label_4;
	    private JLabel label_8;
	    private JLabel label_10;
	    private JLabel label_12;
	    private JLabel label_15;
	    private JLabel label_17;
	    private JLabel label_20;
	    private JLabel label_22;
	    private JLabel label_25;
	    private JLabel label_28;
	    private JLabel label_30;
	    private JLabel Label_33;
	    private JLabel Label_36;
	    private JLabel Label_38;
	    private JLabel lblNewLabel_35;
	    private JLabel label_6;
	    private JLabel label_3;
	    private JTextField rej1;
	    private JTextField rej2;
	    private JTextField rej3;
	    private JTextField rej4;
	/**
	 * Create the frame.
	 */
	    
	    
	public Frame(int numberOfPlayers,ArrayList<String> playerNames) {
		
		setSize(1340,745);
		setResizable(false);
		file=Main.file;
		setTitle("Graphics");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		init();
		 updatedSystem = UpdateData.getInstance();
	     systemData = updatedSystem.playersData;
	     gameisfinished=false;
	     qc = QuestionControl.getInstance();
	     gc = new GameControl(Board.getInstance());
         gc.getCurrentGame().setNumberOfPlayers(numberOfPlayers);
         B=Board.getInstance();
         numberOfPlayersinGame=numberOfPlayers;
         playersUsernamess = playerNames; 
         
         
         btnDice.setOpaque(false);
         btnDice.setContentAreaFilled(false);
    btnDice.setBorderPainted(false);
         
         player1_inGame.setVisible(false);//player in board
         player2_inGame.setVisible(false);
         player3_inGame.setVisible(false);
         player4_inGame.setVisible(false);
         player1inDT.setVisible(true);//player in table degree
         player2inDT.setVisible(false);
 	     player3inDT.setVisible(false);
 	     player4inDT.setVisible(false);
 	    star1_inGame.setVisible(false);
 	    checkBoxes = new HashMap<String,JCheckBox>();
 	    
 	   
       
       
       
       JLabel label_5 = new JLabel("");
       label_5.setBounds(496, 660, 23, 27);
       s.add(label_5);
       
       JLabel label_4;
       label_6 = new JLabel("");
       label_6.setBounds(410, 660, 32, 27);
       s.add(label_6);
 	     
 		
 	    this.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);

  	   this.addWindowListener(new java.awt.event.WindowAdapter() {
  	       @Override
  	       public void windowClosing(java.awt.event.WindowEvent windowEvent) {
  	           
  	           if(gc.getCurrentGame().getWinner() == null){
  	              int reply = JOptionPane.showConfirmDialog(null,"Are you sure ? The Game has`nt finished yet", "finish game for you", JOptionPane.YES_NO_OPTION);
  	           if (reply == JOptionPane.YES_OPTION) {
  	               
  	                   setVisible(false);
  	                   Menu m=new Menu(control.Main.file,control.Main.dataFile);
  	                   m.setVisible(true);
  	           }  
  	           }
  	           else{
  	               System.exit(0);
  	           }
  	           

  	       }
  	   });

         
  
         for(int i=0;i<playersUsernamess.size();i++){
        	 System.out.println(playersUsernamess.get(i).toString());
        	 for(int j=0;j<systemData.getplayer().size();j++)
        	 {
        		 
        		 if( systemData.getplayer().get(j).getUsername().equals(playersUsernamess.get(i)))
        		 {
        			 
                         gc.connectNewPlayer(systemData.getplayer().get(j));
        		 }
        	 }
         }
        // System.out.println("the number of players"+playersUsernamess.size());
         gc.updateDegree();
         /*----------nuber of player in game   -----------*/
         
         
     /*    if(numberOfPlayers == 1){
        	 
        	 for(PlayerInGame pj : gc.getPlayersInGame()){
                 
                 if(pj.getPlayer().getdgree()==1){
                        player1 = pj;
                        player1inDT.setText(player1.getPlayer().getUsername());
                        score1.setText(""+player1.getPlayer().getScore());
                        player1inDT.setVisible(true);
                        
                        
                        
                        player1_inGame.setVisible(true);
                 }
        	 }
      }*/
         if(numberOfPlayers == 2)
         {
        	   for(PlayerInGame pj : gc.getPlayersInGame()){
        		   System.out.println("is=ts degree of player:"+pj.getPlayer().getdgree());
                   if(pj.getPlayer().getdgree()==1){
                          player1 = pj;
                          player1inDT.setText(player1.getPlayer().getUsername());
                          player1inDT.setVisible(true);
                          player1_inGame.setVisible(true);
                          pj.getPlayer().setPcolor(Color.green.toString());
                          System.out.println("the player color"+pj.getPlayer().getPcolor());
                   }
                          
                      
                   if(pj.getPlayer().getdgree()==2)
                   {
                            player2 = pj;
                   player2inDT.setText(player2.getPlayer().getUsername());
                   player2inDT.setVisible(true);
                   player2_inGame.setVisible(true);
                   pj.getPlayer().setPcolor(Color.blue.toString());
                   }
        	   }
                   
          }
         
         if(numberOfPlayers == 3)
         {
        	 
         for(PlayerInGame pj : gc.getPlayersInGame()){
        	
        	 
        	 if(pj.getPlayer().getdgree()==1){
                 player1 = pj;
                 player1inDT.setText(player1.getPlayer().getUsername());
                 player1inDT.setVisible(true);
                 player1_inGame.setVisible(true);
                 pj.getPlayer().setPcolor(Color.green.toString());
          }
          if(pj.getPlayer().getdgree()==2)
          {
                   player2 = pj;
                   player2inDT.setText(player2.getPlayer().getUsername());
                   player2inDT.setVisible(true);
                   player2_inGame.setVisible(true);
                   pj.getPlayer().setPcolor(Color.blue.toString());
          }  
          
         if(pj.getPlayer().getdgree()==3){
        	 player3 = pj;
        	 player3inDT.setText(player3.getPlayer().getUsername());
        	 player3inDT.setVisible(true);
        	 player3_inGame.setVisible(true);
        	 pj.getPlayer().setPcolor(Color.PINK.toString());
         }
             

       
    }
         }
         
  
         
         if(numberOfPlayers == 4)
         {
        	 
         for(PlayerInGame pj : gc.getPlayersInGame()){
        	 System.out.println("its four playersssssssssssssss"+pj.getPlayer().getdgree());
        	 
        	 if(pj.getPlayer().getdgree()==1){
                 player1 = pj;
                 player1inDT.setText(player1.getPlayer().getUsername());
                 player1inDT.setVisible(true);
                 player1_inGame.setVisible(true);
          }
          if(pj.getPlayer().getdgree()==2)
          {
                   player2 = pj;
                   player2inDT.setText(player2.getPlayer().getUsername());
                   player2inDT.setVisible(true);
                   player2_inGame.setVisible(true);
          }  
          
         if(pj.getPlayer().getdgree()==3)
         {
             player3 = pj;
             player3inDT.setText(player3.getPlayer().getUsername());
             player3inDT.setVisible(true);
             player3_inGame.setVisible(true);
         }
         if(pj.getPlayer().getdgree()==4)
         {
             player4 = pj;
             player4inDT.setText(player4.getPlayer().getUsername());
             player4inDT.setVisible(true);
             player4_inGame.setVisible(true);
         }

       
    }
         }
         
        
         btnDice.setCursor(new Cursor(Cursor.HAND_CURSOR));
         
         iterationNum = new JTextField();
         iterationNum.setBounds(1263, 115, 41, 31);
         s.add(iterationNum);
         iterationNum.setColumns(10);
         iterationNum.setText("0");
         
         JLabel lblIterationNumber = new JLabel("Iteration Number :");
         lblIterationNumber.setFont(new Font("Tempus Sans ITC", Font.BOLD | Font.ITALIC, 12));
         lblIterationNumber.setBounds(1129, 115, 124, 31);
         s.add(lblIterationNumber);
         
         Label_0 = new JLabel("New label");
         Label_0.setBounds(908, 611, 56, 16);
         s.add(Label_0);
         Label_0.setVisible(false);
         Label_2 = new JLabel("New label");
         Label_2.setBounds(691, 660, 56, 16);
         s.add(Label_2);
         Label_2.setVisible(false);
         JLabel Label_1 = new JLabel("");
         Label_1.setBounds(811, 660, 23, 27);
         s.add(Label_1);
         Label_1.setVisible(false);
         JLabel label_3;
         label_3 = new JLabel("");
         label_3.setBounds(635, 660, 23, 27);
         s.add(label_3);
         label_3.setVisible(false);
         
         label_7 = new JLabel("");
         
         label_7.setBounds(340, 660, 23, 27);
         s.add(label_7);
         label_7.setVisible(false);
         
         label_9 = new JLabel("");
        
         label_9.setBounds(186, 660, 23, 27);
         s.add(label_9);
         label_9.setVisible(false);
         
         label_11 = new JLabel("");
         label_11.setBounds(0, 548, 23, 25);
         s.add(label_11);
         label_11.setVisible(false);
         
         label_13 = new JLabel("");
         label_13.setBounds(0, 432, 23, 25);
         s.add(label_13);
         label_13.setVisible(false);
         
         label_14 = new JLabel("");
    
         label_14.setBounds(0, 378, 23, 25);
         s.add(label_14);
         label_14.setVisible(false);
         
         label_16 = new JLabel("");
         
         label_16.setBounds(0, 264, 23, 25);
         s.add(label_16);
         label_16.setVisible(false);
         
         label_18 = new JLabel("");
       
         label_18.setBounds(0, 150, 23, 25);
         s.add(label_18);
         label_18.setVisible(false);
         
         label_19 = new JLabel("");
        
         label_19.setBounds(0, 94, 23, 25);
         s.add(label_19);
         label_19.setVisible(false);
         
         label_21 = new JLabel("");
         label_21.setBounds(132, 0, 23, 16);
         s.add(label_21);
         label_21.setVisible(false);
         
         label_23 = new JLabel("");
         label_23.setBounds(284, 0, 23, 16);
         s.add(label_23);
         label_23.setVisible(false);
         
         label_24 = new JLabel("");
         label_24.setBounds(363, 0, 23, 16);
         s.add(label_24);
         label_24.setVisible(false);
         
         label_26 = new JLabel("");
         label_26.setBounds(522, 0, 23, 16);
         s.add(label_26);
         label_26.setVisible(false);
         
         label_27 = new JLabel("");
         label_27.setBounds(599, 0, 23, 16);
         s.add(label_27);
         label_27.setVisible(false);
         
         label_29 = new JLabel("");
         label_29.setBounds(755, 0, 23, 16);
         s.add(label_29);
         label_29.setVisible(false);
         
         label_31 = new JLabel("");
         label_31.setBounds(941, 94, 23, 16);
         s.add(label_31);
         label_31.setVisible(false);
         
         label_32 = new JLabel("");
         label_32.setBounds(941, 150, 23, 16);
         s.add(label_32);
         label_32.setVisible(false);
         
         label_34 = new JLabel("");
         label_34.setBounds(941, 264, 23, 16);
         s.add(label_34);
         label_34.setVisible(false);
         
         label_35 = new JLabel("");
         label_35.setBounds(941, 321, 23, 16);
         s.add(label_35);
         label_35.setVisible(false);
         
         label_37 = new JLabel("");
         label_37.setBounds(941, 432, 23, 16);
         s.add(label_37);
         label_37.setVisible(false);
         
         label_39 = new JLabel("");
         label_39.setBounds(941, 548, 23, 16);
         s.add(label_39);
         label_39.setVisible(false);
         
        
         
         Label_4 = new JLabel("New label");
         Label_4.setBounds(528, 650, 56, 16);
         s.add(Label_4);
         Label_4.setVisible(false);
         label_8 = new JLabel("New label");
         label_8.setBounds(225, 660, 56, 16);
         s.add(label_8);
         label_8.setVisible(false);
         label_10 = new JLabel("New label");
         label_10.setBounds(38, 650, 56, 16);
         s.add(label_10);
         label_10.setVisible(false);
         label_12 = new JLabel("New label");
         label_12.setBounds(38, 517, 56, 16);
         s.add(label_12);
         label_12.setVisible(false);
         label_15 = new JLabel("New label");
         label_15.setBounds(38, 340, 56, 16);
         s.add(label_15);
         label_15.setVisible(false);
         label_17 = new JLabel("New label");
         label_17.setBounds(5, 225, 56, 16);
         s.add(label_17);
         label_17.setVisible(false);
         label_20 = new JLabel("New label");
         label_20.setBounds(22, 36, 56, 16);
         s.add(label_20);
         label_20.setVisible(false);
         label_22 = new JLabel("New label");
         label_22.setBounds(214, 36, 56, 16);
         s.add(label_22);
         label_22.setVisible(false);
         label_25 = new JLabel("New label");
         label_25.setBounds(447, 24, 56, 16);
         s.add(label_25);
         label_25.setVisible(false);
         label_28 = new JLabel("New label");
         label_28.setBounds(691, 24, 56, 16);
         s.add(label_28);
         label_28.setVisible(false);
         label_30 = new JLabel("New label");
         label_30.setBounds(846, 24, 56, 16);
         s.add(label_30);
         label_30.setVisible(false);
         Label_33 = new JLabel("New label");
         Label_33.setBounds(900, 216, 56, 16);
         s.add(Label_33);
         Label_33.setVisible(false);
         Label_36 = new JLabel("New label");
         Label_36.setBounds(889, 399, 56, 16);
         s.add(Label_36);
         Label_36.setVisible(false);
         Label_38 = new JLabel("New label");
         Label_38.setBounds(888, 521, 56, 16);
         s.add(Label_38);
         Label_38.setVisible(false);
    
         ownsforplayers=new ArrayList<JLabel>();
         ownsforplayers.add(Label_0);
         ownsforplayers.add(Label_1);
         ownsforplayers.add(Label_2);
         ownsforplayers.add(label_3);
         ownsforplayers.add(Label_4);
         ownsforplayers.add(label_5);
         ownsforplayers.add(label_6);
         ownsforplayers.add(label_7);
         ownsforplayers.add(label_8);
         ownsforplayers.add(label_9);
         ownsforplayers.add(label_10);
         ownsforplayers.add(label_11);
         ownsforplayers.add(label_12);
         ownsforplayers.add(label_13);
         ownsforplayers.add(label_14);
         ownsforplayers.add(label_15);
         ownsforplayers.add(label_16);
         ownsforplayers.add(label_17);
         ownsforplayers.add(label_18);
         ownsforplayers.add(label_19);
         ownsforplayers.add(label_20);
         ownsforplayers.add(label_21);
         ownsforplayers.add(label_22);
         ownsforplayers.add(label_23);
         ownsforplayers.add(label_24);
         ownsforplayers.add(label_25);
         ownsforplayers.add(label_26);
         ownsforplayers.add(label_27);
         ownsforplayers.add(label_28);
         ownsforplayers.add(label_29);
         ownsforplayers.add(label_30);
         ownsforplayers.add(label_31);
         ownsforplayers.add(label_32);
         ownsforplayers.add(Label_33);
         ownsforplayers.add(label_34);
         ownsforplayers.add(label_35);
         ownsforplayers.add(Label_36);
         ownsforplayers.add(label_37);
         ownsforplayers.add(Label_38);
         ownsforplayers.add(label_39);
         
         JLabel lblRejection = new JLabel("rejection");
         lblRejection.setFont(new Font("Tempus Sans ITC", Font.BOLD | Font.ITALIC, 15));
         lblRejection.setBounds(1217, 423, 86, 25);
         s.add(lblRejection);
         
         rej1 = new JTextField();
         rej1.setFont(new Font("Tahoma", Font.BOLD, 18));
         rej1.setEnabled(false);
         rej1.setColumns(10);
         rej1.setBounds(1228, 459, 66, 29);
         s.add(rej1);
         
         rej2 = new JTextField();
         rej2.setFont(new Font("Tahoma", Font.BOLD, 18));
         rej2.setEnabled(false);
         rej2.setColumns(10);
         rej2.setBounds(1226, 513, 67, 29);
         s.add(rej2);
         
         rej3 = new JTextField();
         rej3.setFont(new Font("Tahoma", Font.BOLD, 18));
         rej3.setEnabled(false);
         rej3.setColumns(10);
         rej3.setBounds(1228, 556, 65, 29);
         s.add(rej3);
         
         rej4 = new JTextField();
         rej4.setFont(new Font("Tahoma", Font.BOLD, 18));
         rej4.setEnabled(false);
         rej4.setColumns(10);
         rej4.setBounds(1226, 596, 67, 34);
         s.add(rej4);
        
         
         
         
         
		UpdateTable();
		
	  for(int j=0;j<B.getCards().size();j++)
	  {
		  ownscards.put(B.getCards().get(j), null);
	  }
	  players = new ArrayList<Player>(ownscards.values()); 
	  savecards = new ArrayList<Card>(ownscards.keySet());
        //  gc.getCurrentGame().increasingNumrounds(); 
          
	
		
		
	}
	
public void init (){
	setLocationRelativeTo(null);
	getContentPane().setLayout(new GridLayout (1,1,0,0));
	s = new MinMap();
	getContentPane().add(s);
	s.setLayout(null);
	
		
		payer1 = new JTextField();
		payer1.setForeground(Color.BLACK);
		payer1.setFont(new Font("Tahoma", Font.BOLD, 18));
		payer1.setEnabled(false);
		payer1.setBounds(1046, 459, 76, 29);
		payer1.setColumns(10);
		
		score1 = new JTextField();
		score1.setFont(new Font("Tahoma", Font.BOLD, 15));
		score1.setEnabled(false);
		score1.setBounds(1132, 459, 86, 31);
		score1.setColumns(10);
		lblturn = new JLabel("Turn");
		lblturn.setFont(new Font("Tempus Sans ITC", Font.BOLD | Font.ITALIC, 15));
		lblturn.setBounds(1005, 423, 41, 25);
		s.add(lblturn);
		lblScore = new JLabel("Score");
		lblScore .setFont(new Font("Tempus Sans ITC", Font.BOLD | Font.ITALIC, 15));
		lblScore .setBounds(1151, 423, 56, 25);
		s.add(lblScore);
		lblPlayer= new JLabel("Player");
		lblPlayer.setBounds(1056, 421, 76, 29);
		s.add(lblPlayer);
		lblPlayer.setFont(new Font("Tempus Sans ITC", Font.BOLD | Font.ITALIC, 15));
		
		
		JSeparator separator = new JSeparator();
		separator.setForeground(UIManager.getColor("CheckBoxMenuItem.selectionBackground"));
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setForeground(Color.BLACK);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setForeground(Color.BLACK);
		  JLabel lblInformation = new JLabel("Information:");
	         lblInformation.setBounds(635, 216, 138, 16);
	         s.add(lblInformation);
	         
	         JScrollPane scrollPane = new JScrollPane();
	         scrollPane.setBounds(621, 242, 211, 363);
	         s.add(scrollPane);
	         
	         JTextPane textPane  = new JTextPane();
	         textPane.setContentType("text/html");
	         textPane.setEditable(false);
	         textPane.setText("DisPlay information :");
	         scrollPane.setColumnHeaderView(textPane);
		
		 doc = (HTMLDocument)textPane.getDocument();
	 	    editorKit = (HTMLEditorKit)textPane.getEditorKit();
	 	    
	 
		payer2 = new JTextField();
		payer2.setFont(new Font("Tahoma", Font.BOLD, 18));
		payer2.setEnabled(false);
		payer2.setBounds(1046, 513, 76, 29);
		payer2.setColumns(10);
		
		payer3 = new JTextField();
		payer3.setEnabled(false);
		payer3.setBounds(1046, 556, 76, 29);
		payer3.setColumns(10);
		
		payer4 = new JTextField();
		payer4.setEnabled(false);
		payer4.setBounds(1046, 596, 76, 34);
		payer4.setColumns(10);
		
		score2 = new JTextField();
		score2.setFont(new Font("Tahoma", Font.BOLD, 15));
		score2.setEnabled(false);
		score2.setBounds(1132, 513, 86, 29);
		score2.setColumns(10);
		
		score3 = new JTextField();
		score3.setFont(new Font("Tahoma", Font.BOLD, 15));
		score3.setEnabled(false);
		score3.setBounds(1132, 556, 86, 29);
		score3.setColumns(10);
		
		score4 = new JTextField();
		score4.setFont(new Font("Tahoma", Font.BOLD, 15));
		score4.setEnabled(false);
		score4.setBounds(1132, 596, 86, 34);
		score4.setColumns(10);
		s.add(payer1);
		s.add(payer2);
		s.add(payer3);
		s.add(payer4);
		s.add(score1);
		s.add(score2);
		s.add(score3);
		s.add(score4);
		

		
		
		
		
		
		
		//s.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{turn2, turn3, turn1, turn4, payer2, payer3, payer4, score2, score3, score4, lblNewLabel_3, lblNewLabel_1, lblNewLabel_4, lblNewLabel_5, payer1, lblNewLabel_6, score1, lblNewLabel, lblNewLabel_2, btnplay}));
		
		 player1_inGame = new JLabel();
	     player1_inGame.setSize(32, 44);
	     player1_inGame.setIcon(player1Image);
	     player1_inGame.setLocation(903,660);
	     s.add(player1_inGame);
		
		     player2_inGame = new JLabel();
		     player2_inGame.setSize(32, 42);
		     player2_inGame.setIcon(player2Image);
		     player2_inGame.setLocation(932,624);
		     s.add(player2_inGame);
		     player3_inGame = new JLabel();
		     player3_inGame.setSize(32, 44);
		     player3_inGame.setIcon(player3Image);
		     player3_inGame.setLocation(903,624);
		     s.add(player3_inGame);
		     
		     player4_inGame = new JLabel();
		     player4_inGame.setSize(39, 53);
		     player4_inGame.setIcon(player4Image);
		     player4_inGame.setLocation(932,651);
		     s.add(player4_inGame);
		     
		     /////////////
		      star1_inGame = new JLabel();
		     star1_inGame.setSize(39, 53);
		     star1_inGame.setIcon(blueFlag);
		     star1_inGame.setLocation(932,651);
		     s.add(star1_inGame);
		     /////////////////
		    
		     player1inDT = new JLabel(" ");
		     player1inDT.setBounds(1005, 459, 41, 31);
	         s.add(player1inDT);
	         player1inDT.setIcon(player1Image);
	
	         player2inDT = new JLabel(" ");
		     player2inDT.setBounds(1005, 514, 32, 31);
	         s.add(player2inDT);
	         player2inDT.setIcon(player2Image);
	         
	         player3inDT = new JLabel(" ");
		     player3inDT.setBounds(1005, 557, 32, 31);
	         s.add(player3inDT);
	         player3inDT.setIcon(player3Image);
	         
	         player4inDT = new JLabel(" ");
		     player4inDT.setBounds(1005, 604, 32, 31);
	         s.add(player4inDT);
	         player4inDT.setIcon(player4Image);
	         
	         lblNewLabel = new JLabel(" ");
	     	lblNewLabel.setBounds(5, 608, 129, 99);
	     	lblNewLabel.setIcon(new ImageIcon(Frame.class.getResource("/images/inJail.png")));
	     	s.add(lblNewLabel);
	     	lblNewLabel_1 = new JLabel(" ");
	     	lblNewLabel_1.setBounds(132, 91, 491, 514);
	     	lblNewLabel_1.setIcon(new ImageIcon(Frame.class.getResource("/images/mapp.png")));
	     	s.add(lblNewLabel_1);
	     	lblNewLabel_2 = new JLabel(" ");
	     	lblNewLabel_2.setBounds(835, 608, 129, 91);
	     	lblNewLabel_2.setIcon(new ImageIcon(Frame.class.getResource("/images/gooo.png")));
	     	s.add(lblNewLabel_2);
	     	lblNewLabel_3 = new JLabel(" ");
	     	lblNewLabel_3.setBounds(844, 3, 129, 88);
	     	lblNewLabel_3.setIcon(new ImageIcon(Frame.class.getResource("/images/gojail.png")));
	     	s.add(lblNewLabel_3);
	     	 lblNewLabel_7 = new JLabel("");
	         lblNewLabel_7.setIcon(new ImageIcon(Frame.class.getResource("/images/cardl1.PNG")));
	         lblNewLabel_7.setBounds(680, 618, 76, 86);
	         s.add(lblNewLabel_7);
	         
	         lblNewLabel_8 = new JLabel("");
	         lblNewLabel_8.setIcon(new ImageIcon(Frame.class.getResource("/images/cardl1.PNG")));
	         lblNewLabel_8.setBounds(214, 627, 67, 72);
	         s.add(lblNewLabel_8);
	         
	         lblNewLabel_9 = new JLabel("");
	         lblNewLabel_9.setIcon(new ImageIcon(Frame.class.getResource("/images/cardl12.PNG")));
	         lblNewLabel_9.setBounds(5, 204, 100, 59);
	         s.add(lblNewLabel_9);
	         
	         lblNewLabel_10 = new JLabel("New label");
	         lblNewLabel_10.setIcon(new ImageIcon(Frame.class.getResource("/images/cardl3.PNG")));
	         lblNewLabel_10.setBounds(447, 3, 67, 65);
	         s.add(lblNewLabel_10);
	         
	         lblNewLabel_11 = new JLabel("New label");
	         lblNewLabel_11.setIcon(new ImageIcon(Frame.class.getResource("/images/cardl3.PNG")));
	         lblNewLabel_11.setBounds(680, 3, 67, 65);
	         s.add(lblNewLabel_11);
	         
	         lblNewLabel_12 = new JLabel("New label");
	         lblNewLabel_12.setIcon(new ImageIcon(Frame.class.getResource("/images/cardl4.PNG")));
	         lblNewLabel_12.setBounds(880, 204, 76, 59);
	         s.add(lblNewLabel_12);
	         
	         lblNewLabel_13 = new JLabel("");
	         lblNewLabel_13.setIcon(new ImageIcon(Frame.class.getResource("/images/question.PNG")));
	         lblNewLabel_13.setBounds(522, 603, 76, 96);
	         s.add(lblNewLabel_13);
	         
	         lblNewLabel_14 = new JLabel("");
	         lblNewLabel_14.setIcon(new ImageIcon(Frame.class.getResource("/images/question2.PNG")));
	         lblNewLabel_14.setBounds(5, 494, 112, 53);
	         s.add(lblNewLabel_14);
	         
	         lblNewLabel_15 = new JLabel("New label");
	         lblNewLabel_15.setIcon(new ImageIcon(Frame.class.getResource("/images/question2.PNG")));
	         lblNewLabel_15.setBounds(5, 321, 112, 55);
	         s.add(lblNewLabel_15);
	         
	         lblNewLabel_16 = new JLabel("");
	         lblNewLabel_16.setIcon(new ImageIcon(Frame.class.getResource("/images/question2.PNG")));
	         lblNewLabel_16.setBounds(5, 0, 129, 91);
	         s.add(lblNewLabel_16);
	         
	         lblNewLabel_17 = new JLabel("New label");
	         lblNewLabel_17.setIcon(new ImageIcon(Frame.class.getResource("/images/question3.PNG")));
	         lblNewLabel_17.setBounds(214, 3, 76, 88);
	         s.add(lblNewLabel_17);
	         
	         lblNewLabel_18 = new JLabel("New label");
	         lblNewLabel_18.setIcon(new ImageIcon(Frame.class.getResource("/images/question4.PNG")));
	         lblNewLabel_18.setBounds(844, 378, 112, 58);
	         s.add(lblNewLabel_18);
	         
	         lblNewLabel_19 = new JLabel("New label");
	         lblNewLabel_19.setIcon(new ImageIcon(Frame.class.getResource("/images/question4.PNG")));
	         lblNewLabel_19.setBounds(844, 494, 120, 53);
	         s.add(lblNewLabel_19);
	
	 btnDice = new JButton("");
	 btnDice.addActionListener(new ActionListener() {
	 	public void actionPerformed(ActionEvent arg0) {
	 		rollctionPerformed();
	 	}
	 });
	 btnDice.setIcon(new ImageIcon(Frame.class.getResource("/images/DiceC.png")));
	 btnDice.setBounds(708, 108, 86, 88);
	s.add(btnDice);
	
	
	
	
	
	
	setVisible(true);
	}

public void UpdateTable(){
	int degree;
    for(int i=0;i<gc.getCurrentGame().getPlayers().size();i++){
    	
         degree=gc.getCurrentGame().getPlayers().get(i).getdgree();
         if(degree==1)
         {  	
            	payer1.setText(gc.getCurrentGame().getPlayers().get(i).getUsername());
            	score1.setText(gc.getCurrentGame().getPlayers().get(i).getScore()+"");
             	rej1.setText(gc.getCurrentGame().getPlayers().get(i).getRejectionnum()+"");
            	System.out.println("in frameeeeeeeeeeeeeeee"+gc.getCurrentGame().getPlayers().get(i).getScore()+"");
         }
         if(degree==2)
         {
            	payer2.setText(gc.getCurrentGame().getPlayers().get(i).getUsername());
            	score2.setText(gc.getCurrentGame().getPlayers().get(i).getScore()+"");
            	rej2.setText(gc.getCurrentGame().getPlayers().get(i).getRejectionnum()+"");
            	System.out.println("in frameeeeeeeeeeeeeeee"+gc.getCurrentGame().getPlayers().get(i).getScore()+"");
         }
         if(degree==3)
         {
            	payer3.setText(gc.getCurrentGame().getPlayers().get(i).getUsername());
            	score3.setText(gc.getCurrentGame().getPlayers().get(i).getScore()+"");
            	rej3.setText(gc.getCurrentGame().getPlayers().get(i).getRejectionnum()+"");
         }     
         if(degree==4)
         {
            	payer4.setText(gc.getCurrentGame().getPlayers().get(i).getUsername());
            	score4.setText(gc.getCurrentGame().getPlayers().get(i).getScore()+"");
            	rej4.setText(gc.getCurrentGame().getPlayers().get(i).getRejectionnum()+"");
         }
        }
    }
    


private void rollctionPerformed() {   
	
	if(hadplay ==numberOfPlayersinGame){
		gc.getCurrentGame().increasingNumrounds();
    	iterationNum.setText(gc.getCurrentGame().getNumrounds()+"");
	}
    
    if(hadplay >numberOfPlayersinGame)
    {
    	hadplay=1;
    	
    }
    
        if(hadplay==1)
        {
        player1_inGame.setVisible(true);
        player1.getPlayer().setOkRounded(true);
        if(player4!=null&&player4.getPlayer().isOkRounded())
        {
        	player4.getPlayer().setOkRounded(false);	
        }
        if(player2!=null&& player2.getPlayer().isOkRounded())
        {
        	player2.getPlayer().setOkRounded(false);	
        }
        if(player3!=null&& player3.getPlayer().isOkRounded())
        {
        	player3.getPlayer().setOkRounded(false);	
        }
        MovePlayerInGame(player1,player1_inGame);
        photolabel=player1_inGame;
        }
       if(hadplay==2)
       {
        player2_inGame.setVisible(true);
        player2.getPlayer().setOkRounded(true);
        if( player1!=null&&player1.getPlayer().isOkRounded())
        {
        	player1.getPlayer().setOkRounded(false);	
        }
        if(player4!=null&& player4.getPlayer().isOkRounded())
        {
        	player4.getPlayer().setOkRounded(false);	
        }
        if(player3!=null&& player3.getPlayer().isOkRounded())
        {
        	player3.getPlayer().setOkRounded(false);	
        }
        MovePlayerInGame(player2,player2_inGame);
        photolabel=player2_inGame;
         }
        if(hadplay==3)
        {
        player3_inGame.setVisible(true);
        player3.getPlayer().setOkRounded(true);
        if(player1!=null&& player1.getPlayer().isOkRounded())
        {
        	player1.getPlayer().setOkRounded(false);	
        }
        if(player2!=null&& player2.getPlayer().isOkRounded())
        {
        	player2.getPlayer().setOkRounded(false);	
        }
        if( player4!=null&&player4.getPlayer().isOkRounded())
        {
        	player4.getPlayer().setOkRounded(false);	
        }
        MovePlayerInGame(player3,player3_inGame);
        photolabel=player3_inGame;
        }
        if(hadplay==4)
        {
        player4_inGame.setVisible(true);
        player4.getPlayer().setOkRounded(true);
        if(player1!=null&& player1.getPlayer().isOkRounded())
        {
        	player1.getPlayer().setOkRounded(false);	
        }
        if( player2!=null&&player2.getPlayer().isOkRounded())
        {
        	player2.getPlayer().setOkRounded(false);	
        }
        if( player3!=null&&player3.getPlayer().isOkRounded())
        {
        	player3.getPlayer().setOkRounded(false);	
        }
        MovePlayerInGame(player4,player4_inGame);
        photolabel=player4_inGame;
        }
        hadplay++; 
        
    }  
    
    


public void MovePlayerInGame(PlayerInGame playerController,JLabel labelName){
	UpdateTable();
	ArrayList<Card>cards=gc.getCards();
	if(cards==null)
		System.out.println("noooooooooooooooooooo");
	Card c=null;
	int result;
	Question q,q2;
	int numberofcard=39;
		try {
			
			
			 sb = new StringBuilder();
			if(playerController.getPlayer().getMyspecial().size()!=0)
			{
				for(Card sc:playerController.getPlayer().getMyspecial().keySet())
				{
					if(playerController.getPlayer().getMyspecial().get(sc)<2)
					{
						playerController.getPlayer().getMyspecial().put((propertycard) sc,playerController.getPlayer().getMyspecial().get(sc)+1);
					}
					else
					{
						System.out.println("happy birthday asooooll:))))))");
				((propertycard)sc).setPrice(((propertycard)sc).getPrice()*5);
				((propertycard)sc).prolevel(((propertycard)sc).getPrice());
				playerController.getPlayer().getMyspecial().remove(sc);
					}
				}
			}
		 
			 if(numberOfPlayersinGame==1)
				{
					//JOptionPane.showMessageDialog(null,"end of game"+"/n you are the winner\n*****"+playerController.getPlayer().getUsername());
				 //ImageIcon icon = new ImageIcon(Frame.class.getResource("/winner.jpg"));
					JOptionPane.showMessageDialog(null, "end of game"+"/n you are the winner\n\n*****"+playerController.getPlayer().getUsername()+"*******","END GAME", JOptionPane.OK_OPTION, icon);
					this.setVisible(false);
				}
			 System.out.println("koooooooooooool"+playerController.getPlayer().getScore());
				if(playerController.getPlayer().getScore()<0)
						if(playerController.getPlayer().getProps().size()==0)
				{
					gc.getPlayersInGame().remove(playerController);
					numberOfPlayersinGame--;
					if(hadplay==2)
				    {
				     player2_inGame.setVisible(false);
				     player2inDT.setVisible(false);
				    }
					if(hadplay==1)
				    {
				     player1_inGame.setVisible(false);
				     player1inDT.setVisible(false);

				    }
					if(hadplay==3)
				    {
				     player3_inGame.setVisible(false);
				     player3inDT.setVisible(false);

				    }
					if(hadplay==4)
				    {
				     player4_inGame.setVisible(false);
				     player4inDT.setVisible(false);

				    }
					 if(numberOfPlayersinGame==1)
						{
							JOptionPane.showMessageDialog(null,"end of game"+"/n you are the winner");
							this.setVisible(false);

						}
					
				}
				if(playerController.getPlayer().getScore()<=(-100000) &&playerController.getPlayer().getProps().size()!=0)
{
	gc.getPlayersInGame().remove(playerController);
	numberOfPlayersinGame--;
	if(hadplay==2)
    {
     player2_inGame.setVisible(false);
     player2inDT.setVisible(false);

    }
	if(hadplay==1)
    {
     player1_inGame.setVisible(false);
     player1inDT.setVisible(false);

    }
	if(hadplay==3)
    {
     player3_inGame.setVisible(false);
     player3inDT.setVisible(false);

    }
	if(hadplay==4)
    {
     player4_inGame.setVisible(false);
     player4inDT.setVisible(false);

    }
	 if(numberOfPlayersinGame==1)
		{
			JOptionPane.showMessageDialog(null,"end of game"+"/n you are the winner");
			this.setVisible(false);

		}

	
}
				
		if(!gc.getCurrentGame().NotEndGame())
		{
			JOptionPane.showMessageDialog(null,"end of game"+"/n there are no winner");
			this.setVisible(false);
			return;
		}
			 
			 
	  if(playerController.getNumofroundingail()>0&&playerController.getNumofroundingail()<2 )
		{
			JOptionPane.showMessageDialog(null, "you are in jail next time you will play");
			playerController.setNumofroundingail(playerController.getNumofroundingail()+1);
			return;
		} 
	   if(playerController.getNumofroundingail()>2)
	   {
			btnDice.setEnabled(true);
			playerController.setNumofroundingail(0);

	   }   
	   //function that cheak if the game has finished.
	  
	    
	    int dResult = playerController.rolling();
	    int cnt = playerController.getcurrentPosition() +dResult;
	    playerController.setcurrentPosition(cnt);
	    sb.append("<html>player: <font color=blue>"+ playerController.getPlayer().getUsername()+
	    		"</font> <br>Throw dice result is:"+dResult);
	    
	    if(playerController.getcurrentPosition()<numberofcard)
	    {
	      
	      c=cards.get(playerController.getcurrentPosition());
	    }
	    else
	     if(playerController.getcurrentPosition()>numberofcard)
	    {
	   	int bonus=numberofcard-(cnt-dResult);
	   	playerController.setcurrentPosition(cnt-dResult);
	   	dResult=dResult-bonus;
	    	playerController.setcurrentPosition(0);
	    	gc.getCurrentGame().initboard();
	    cnt = playerController.getcurrentPosition() +dResult;
		playerController.setcurrentPosition(cnt-1);
	    }
	    

	    sb.append("</html>");
		   
		   editorKit.insertHTML(doc, doc.getLength(), sb.toString(), 0, 0, null);

			
	    if(cnt>=0 && cnt<=10 )
	    {
	    	 labelName.setLocation((int)s.getShapes()[playerController.getcurrentPosition()][0].x,(int)s.getShapes()[playerController.getcurrentPosition()][0].y);
	    }
	    if(cnt>=11&&cnt<=19)
	    {
	    	labelName.setLocation((int)s.getShapes()[10][playerController.getcurrentPosition()-10].x,(int)s.getShapes()[10][playerController.getcurrentPosition()-10].y);
	    }
	    if(cnt>=20&&cnt<=30)
	    {
	    	labelName.setLocation((int)s.getShapes()[playerController.getcurrentPosition()-20][10].x,(int)s.getShapes()[playerController.getcurrentPosition()-20][10].y);
	    }
	    if(cnt>=31&&cnt<=39)
	    {
	    	labelName.setLocation((int)s.getShapes()[0][playerController.getcurrentPosition()-30].x,(int)s.getShapes()[0][playerController.getcurrentPosition()-30].y);
	    }
	    if(c instanceof propertycard)
	   	{
	    	int card=0;
	    	for(int j=0;j<savecards.size();j++)
	    	{
	    		if(savecards.get(j).equals(c))
	    			card=j;
	    	}
	    	
	    	if(c.getCardId()==23||c.getCardId()==14)
	    	{
	    		if(((propertycard)savecards.get(card)).getOwn()==null)
		   		{
			   		if(playerController.getPlayer().getScore()>=((propertycard) c).getPrice())

		   		   {
			   			//////*******/////
			   			result=	JOptionPane.showConfirmDialog(null,"<html><head></head><body>" +
			   					"<h><FONT style=\"font-weight: bold; font-size: 18px;color:green;\"> "+"propertyname:"+" "+c.getName()+"</FONT></h><br>"
			   					+ "<h><FONT style=\"font-weight: bold; font-size: 18px;color:green;\"> "+"Property price:"+((propertycard)c).getPrice()+"</FONT></h><br>" +
			   					"<h><FONT style=\"font-weight: bold; font-size: 18px;\"> "+"</FONT></h>"+
			   					"<h><FONT style=\"font-weight: bold; font-size: 18px;\"> do you want to buy this special property??!!!</FONT></h>"+
			   					"</body></html>","Question", JOptionPane.YES_NO_OPTION);
		   		    if(result==JOptionPane.YES_OPTION)
		   		    {
		   		    	//System.out.println("print in frame before question:"+playerController.getPlayer().getScore());
		   		    	 QuestionControl qn = QuestionControl.getInstance();
		   		    	 q=qn.popRandomQuestion(1);
		   		    		 HelpFramAddQuestion qo=new HelpFramAddQuestion(q,null,(propertycard)savecards.get(card),playerController,numberOfPlayersinGame,null,gc);
		   		    	    	qo.setVisible(true);
		   		    	    	
		   		    	        //System.out.println("The color of player"+playerController.getPlayer().getPcolor().toString());
		   		    	    	//System.out.println("the owner of"+c.getCardId()+ "now is"+((propertycard)savecards.get(card)).getOwn());
		   		    	    	//System.out.println("the card of the player:"+playerController.getPlayer().getProps().toString());
		   		    }
		   		   }
		   		  
		   		  else
		   			   JOptionPane.showMessageDialog(null, "you can't  buy this property\n"+"you dont have enough money!!");
		   		}
		   		  else{
		   			  if(((propertycard)savecards.get(card)).getOwn()!=playerController.getPlayer())
		   		  {
		   				result=	JOptionPane.showConfirmDialog(null,"<html><head></head><body>" +
		   						"<h><FONT style=\"font-weight: bold; font-size: 18px;color:green;\"> "+"propertyname:"+" "+c.getName()+"</FONT></h><br>"
		   						+ "<h><FONT style=\"font-weight: bold; font-size: 18px;color:green;\"> "+"Property price:"+((propertycard)c).getPrice()+"</FONT></h><br>" +
		   						"<h><FONT style=\"font-weight: bold; font-size: 18px;\"> "+"</FONT></h>"+
		   						"<h><FONT style=\"font-weight: bold; font-size: 18px;\"> the property has an owner/n !!do you want to buy from him??!!</FONT></h>"+
		   						"</body></html>","Question", JOptionPane.YES_NO_OPTION);
		   		 if(result==JOptionPane.YES_OPTION)
		   		 {
		   			 QuestionControl qn = QuestionControl.getInstance();
	   		    	 q=qn.popRandomQuestion(1);
	   		    		 HelpFramAddQuestion qo=new HelpFramAddQuestion(q,null,(propertycard)savecards.get(card),playerController,numberOfPlayersinGame,null,gc);
	   		    	    	qo.setVisible(true);
		   		 }
		   		 else
		   		 {
		   			playerController.getPlayer().setscore(playerController.getPlayer().getScore()-((propertycard)savecards.get(card)).getPrice()*0.15);
		   			((propertycard)savecards.get(card)).getOwn().setscore(((propertycard)savecards.get(card)).getOwn().getScore()+((propertycard)savecards.get(card)).getPrice()*0.15);
		   		 }
		   		  }
		   			  else
		   				
		   				JOptionPane.showMessageDialog(null, "/n you are the owner\n*****"+playerController.getPlayer().getUsername());
		   		  }
	    	}
	    	
	    	else{
	    		if(c.getCardId()!=3 && c.getCardId()!=23)
	    		{
	    	System.out.println("befooore the prop own +++++"+((propertycard) c).getOwn());
	  	  if(((propertycard)savecards.get(card)).getOwn()==null)
	   		{
		   		if(playerController.getPlayer().getScore()>=((propertycard) c).getPrice())

	   		   {
		   			//////*******/////
		   			result=	JOptionPane.showConfirmDialog(null,"<html><head></head><body>" +
		   					"<h><FONT style=\"font-weight: bold; font-size: 18px;color:green;\"> "+"propertyname:"+" "+c.getName()+"</FONT></h><br>"
		   					+ "<h><FONT style=\"font-weight: bold; font-size: 18px;color:green;\"> "+"Property price:"+((propertycard)c).getPrice()+"</FONT></h><br>" +
		   					"<h><FONT style=\"font-weight: bold; font-size: 18px;\"> "+"</FONT></h>"+
		   					"<h><FONT style=\"font-weight: bold; font-size: 18px;\"> do you want to buy this property??!!!</FONT></h>"+
		   					"</body></html>","Question", JOptionPane.YES_NO_OPTION);
	   		    if(result==JOptionPane.YES_OPTION)
	   		    {
	   		    	//System.out.println("print in frame before question:"+playerController.getPlayer().getScore());
	   		    	 QuestionControl qn = QuestionControl.getInstance();
	   		    	 q=qn.popRandomQuestion(((propertycard)savecards.get(card)).prolevel((((propertycard)savecards.get(card))).getPrice()));
	   		    		 HelpFramAddQuestion qo=new HelpFramAddQuestion(q,null,c,playerController,numberOfPlayersinGame,null,gc);
	   		    	    	qo.setVisible(true);
	   		    	    	playerController.getPlayer().addcard(c);
	   		    	    	((propertycard)savecards.get(card)).setOwn(playerController.getPlayer());
	   		    	    	if(playerController.getPlayer().getdgree()==1)
	   		    	    	{
	   		    	    		ownsforplayers.get(c.getCardId()).setIcon(new ImageIcon(Frame.class.getResource("/images/green-home.png")));	
	   		    	    		ownsforplayers.get(c.getCardId()).setVisible(true);
	   		    	    	}
	   		    	    	if(playerController.getPlayer().getdgree()==2)
	   		    	    	{
	   		    	    		ownsforplayers.get(c.getCardId()).setIcon(new ImageIcon(Frame.class.getResource("/images/blueFlag.png")));
	   		    	    		ownsforplayers.get(c.getCardId()).setVisible(true);
	   		    	    	}
	   		    	    	if(playerController.getPlayer().getdgree()==3)
	   		    	    	{
	   		    	    		ownsforplayers.get(c.getCardId()).setIcon(new ImageIcon(Frame.class.getResource("/images/purple-home.png")));
	   		    	    		ownsforplayers.get(c.getCardId()).setVisible(true);
	   		    	    	}
	   		    	    	if(playerController.getPlayer().getdgree()==4)
	   		    	    	{
	   		    	    		ownsforplayers.get(c.getCardId()).setIcon(new ImageIcon(Frame.class.getResource("/images/yellow-home.png")));	
	   		    	    		ownsforplayers.get(c.getCardId()).setVisible(true);
	   		    	    	}
	   		    	        System.out.println("The color of player"+playerController.getPlayer().getPcolor().toString());
	   		    	    	System.out.println("the owner of"+c.getCardId()+ "now is"+((propertycard)savecards.get(card)).getOwn());
	   		    	    	System.out.println("the card of the player:"+playerController.getPlayer().getProps().toString());
	   		    }
	   		   }
	   		  
	   		  else
	   			   JOptionPane.showMessageDialog(null, "you can't  buy this property\n"+"you dont have enough money!!");
	   		}
	   		  else{
	   			  if(((propertycard)savecards.get(card)).getOwn()!=playerController.getPlayer())
	   		  {
	   				result=	JOptionPane.showConfirmDialog(null,"<html><head></head><body>" +
	   						"<h><FONT style=\"font-weight: bold; font-size: 18px;color:green;\"> "+"propertyname:"+" "+c.getName()+"</FONT></h><br>"
	   						+ "<h><FONT style=\"font-weight: bold; font-size: 18px;color:green;\"> "+"Property price:"+((propertycard)c).getPrice()+"</FONT></h><br>" +
	   						"<h><FONT style=\"font-weight: bold; font-size: 18px;\"> "+"</FONT></h>"+
	   						"<h><FONT style=\"font-weight: bold; font-size: 18px;\"> the property has an owner/n !!do you want to buy from him??!!</FONT></h>"+
	   						"</body></html>","Question", JOptionPane.YES_NO_OPTION);
	   		 if(result==JOptionPane.YES_OPTION)
	   		 {
	   			 gc.WantToBuyFromOwner(playerController.getPlayer(),((propertycard)savecards.get(card)));
	   			if(playerController.getPlayer().getdgree()==1)
	    	    	{
	    	    		ownsforplayers.get(c.getCardId()).setIcon(new ImageIcon(Frame.class.getResource("/images/green-home.png")));	
	    	    		ownsforplayers.get(c.getCardId()).setVisible(true);
	    	    	}
	    	    	if(playerController.getPlayer().getdgree()==2)
	    	    	{
	    	    		ownsforplayers.get(c.getCardId()).setIcon(new ImageIcon(Frame.class.getResource("/images/blueFlag.png")));
	    	    		ownsforplayers.get(c.getCardId()).setVisible(true);
	    	    	}
	    	    	if(playerController.getPlayer().getdgree()==3)
	    	    	{
	    	    		ownsforplayers.get(c.getCardId()).setIcon(new ImageIcon(Frame.class.getResource("/images/purple-home.png")));
	    	    		ownsforplayers.get(c.getCardId()).setVisible(true);
	    	    	}
	    	    	if(playerController.getPlayer().getdgree()==4)
	    	    	{
	    	    		ownsforplayers.get(c.getCardId()).setIcon(new ImageIcon(Frame.class.getResource("/images/yellow-home.png")));	
	    	    		ownsforplayers.get(c.getCardId()).setVisible(true);
	    	    	}
	   			 
	   		 }
	   		 else
	   		 {
	   			playerController.getPlayer().setscore(playerController.getPlayer().getScore()-((propertycard)savecards.get(card)).getPrice()*0.15);
	   			((propertycard)savecards.get(card)).getOwn().setscore(((propertycard)savecards.get(card)).getOwn().getScore()+((propertycard)savecards.get(card)).getPrice()*0.15);
	   		 }
	   		  }
	   			  else
	   				
	   				JOptionPane.showMessageDialog(null, " you are the owner\n*****"+playerController.getPlayer().getUsername());
	   		  }
	 	   		 

	   			    
	   	 
	   		
	    	} 
	   	}
	   	}
     /**
      * function that cheak the type of card 
      */
    if(c instanceof LuckCard)
    {
    	JOptionPane.showMessageDialog(null,c.Action(playerController.getPlayer()));
        QuestionControl qn = QuestionControl.getInstance();
        q=qn.popRandomQuestion(2);
        System.out.println(q);
        q2=qn.popRandomQuestion(1);
    	System.out.println(q2); 
        HelpFramAddQuestion qo=new HelpFramAddQuestion(q,q2,c,playerController,numberOfPlayersinGame,null,gc);
    	qo.setVisible(true);
    	   	
    	
//    	boolean answer1;
//    	
//    	if(qo.getFlag().equals("true"))
//    	 answer1=true;
//    	else
//   	 answer1=false;		
//    	System.out.println(answer1);
//
//
//    	
//    	
//    	boolean answer2;
//    	if(qo2.getFlag().equals("true"))
//    	 answer2=true;		
//    	else
//       	 answer2=false;		
//    	System.out.println(answer2);

    	

    	//gc.luck(playerController, q, q2, answer1, answer2);
    	System.out.println("before end onther frame............");

    }
    if(c instanceof GoToGailCard)
    {
    	System.out.println("gail name"+c.getName()+"player position"+playerController.getcurrentPosition());
    	result=JOptionPane.showConfirmDialog(null,c.Action(playerController.getPlayer()),"Message", JOptionPane.YES_NO_OPTION);
		 if(result==JOptionPane.YES_OPTION)
			 playerController.getPlayer().setscore(playerController.getPlayer().getScore()-Consts.Outofjail);
		 else
		 {
			 labelName.setLocation((int)s.getShapes()[10][0].x,(int)s.getShapes()[10][0].y);
			 playerController.setcurrentPosition(10);
			 playerController.getPlayer().setOkRounded(false);
			 playerController.setIsinJail(true);
              playerController.setNumofroundingail( playerController.getNumofroundingail()+1);

				
		 }
    }
    if(c instanceof QuestionCard)
    {
		    HashMap<PlayerInGame,String>otherAnswers=new   HashMap<PlayerInGame,String>();
						Tag=new DefaultComboBoxModel<String>();
						
						Tag.addElement(Tags.Agile.toString());
						Tag.addElement(Tags.ConfigurationManagement.toString());
						Tag.addElement(Tags.CostsandRisks.toString());
						Tag.addElement(Tags.DesignPatterns.toString());
						Tag.addElement(Tags.Maintenance.toString());
						Tag.addElement(Tags.Requirements.toString());
						Tag.addElement(Tags.SOAandCloud.toString());
						Tag.addElement(Tags.SoftwareArchitecture.toString());
						Tag.addElement(Tags.SoftwareTesting.toString());
						Tag.addElement(Tags.TDD.toString());
						comboBo= new JComboBox<String>(Tag);
					
						comboBo.setRenderer(new tagCellRenderer());

		                int result1 = JOptionPane.showConfirmDialog(null, comboBo, "please Select a tag ", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
		                if (result1 == JOptionPane.OK_OPTION) {
		                    String tag =  (String) comboBo.getSelectedItem();
		      		    	 QuestionControl qn = QuestionControl.getInstance();

			q= qn.RandomQuestioncard(tag);
			
			System.out.println("the question is"+q);
			System.out.println("the array of araay"+gc.getPlayersInGame());
			if(q!=null)
			{
			int numberOfPlayers=numberOfPlayersinGame-1;
			HashMap<String,Boolean> questionAnswers = new HashMap<String,Boolean>();
			System.out.println("testttttttt "+questionAnswers.size());
			HelpFramAddQuestion  qs=new HelpFramAddQuestion(q,null,c,playerController,numberOfPlayers,questionAnswers,gc);
			 qs.setVisible(true);
			}
			else
			{
				JOptionPane.showMessageDialog(null, "there is no question for this tag you will win next time");
			}

  

    }
    }
	
} catch (BadLocationException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
} catch (IOException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();

}
		
}
public static class tagCellRenderer extends DefaultListCellRenderer {

    @Override
    public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
        
        super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
     
        return this;
    }

}
/**
 * check if the number of rejection is 3 , if it is the player have to go to jail
 * @param playerController
 */

/**
 * check if the number of rejection is 3 , if it is the player have to go to jail
 * @param playerController
 */
public static void rejectionThreeCheck(PlayerInGame playerController )
{
 	if(playerController.getPlayer().getRejectionnum()==3)
   	{
 		JOptionPane.showMessageDialog(null,"now you have 3 rejections so you must go to gail");
 		photolabel.setLocation((int)s.getShapes()[10][0].x,(int)s.getShapes()[10][0].y);
   		playerController.setcurrentPosition(10);
   		playerController.setNumofroundingail( playerController.getNumofroundingail()+1);
   		playerController.getPlayer().setRejectionnum(-3);
   	}
}
}