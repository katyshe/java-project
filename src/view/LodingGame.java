package view;
//loding class
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import control.UpdateData;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LodingGame extends JFrame {

	private JPanel contentPane;
	 String usernameT;
	    String passwordT;
	    String prevFrame;
	    int connectedPlayers=0;
	    private static LodingGame instance;
	    private HashMap<String,JTextField> userNames;
	    private HashMap<String,JLabel> playerLabelsIDDS;
	    boolean player1Clicked,player2clicked,player3clicked,player4clicked;
	     UpdateData checker;
	    
	     
	     private ArrayList<String> connectedPlayersNames;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LodingGame frame = new LodingGame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
*/
	/**
	 * Create the frame.
	 */
	public LodingGame() {
		
		    

		   

		        initComponents();
		        this.setResizable(false);
		        userNames = new HashMap<String,JTextField>();
		                playerLabelsIDDS= new HashMap<String,JLabel>();
		                
		       
		        
		        
		         username1.setForeground(Color.gray);
		         username2.setForeground(Color.gray);
		         username3.setForeground(Color.gray);
		         username4.setForeground(Color.gray);
		  
		  
		        Font font1 = new Font("Serif", Font.BOLD, 20);
		        username2.setHorizontalAlignment(SwingConstants.CENTER);
		     
		        
		        
		         username1.setHorizontalAlignment(SwingConstants.CENTER);
		         username2.setHorizontalAlignment(SwingConstants.CENTER);
		         username3.setHorizontalAlignment(SwingConstants.CENTER);
		         username4.setHorizontalAlignment(SwingConstants.CENTER);
		         
		            username1.setFont(font1);
		            username2.setFont(font1);
		            username3.setFont(font1);
		            username4.setFont(font1);
		 
		 
		        username1.setText("User Name");
		        username2.setText("User Name");
		        username3.setText("User Name");
		         username4.setText("User Name");
		   

		       
		        
		        
		        userNames.put("username1", username1);
		         userNames.put("username2", username2);
		          userNames.put("username3", username3);
		           userNames.put("username4", username4);
		           
		         playerLabelsIDDS.put("player1", player1);
		         playerLabelsIDDS.put("player2", player2);
		          playerLabelsIDDS.put("player3", player3);
		           playerLabelsIDDS.put("player4", player4);
		           
		           
		           
		          
		           
		           
		           connectedPlayersNames = new ArrayList<String>();
		           this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

		       	   this.addWindowListener(new java.awt.event.WindowAdapter() {
		       	       @Override
		       	       public void windowClosing(java.awt.event.WindowEvent windowEvent) {
		       	           
		       	         int reply = JOptionPane.showConfirmDialog(null, "Are you sure you want to exit?","message",JOptionPane.YES_NO_OPTION);
		       	           if (reply == JOptionPane.YES_OPTION) {
		       	              Menu m=new Menu(control.Main.file,control.Main.dataFile);
		       	              m.setVisible(true);
		       	              setVisible(false);
		       	           }  
		       	       }
		       	   });
		           
		           
		           

		    }
		       public void restartFrame(){
		        instance = null;
		    }
		    
		    public void resetAllFields(){
		        
		      userNames = new HashMap<String,JTextField>();
		                playerLabelsIDDS= new HashMap<String,JLabel>();
		                
		     
		        
		         username1.setForeground(Color.gray);
		         username2.setForeground(Color.gray);
		         username3.setForeground(Color.gray);
		         username4.setForeground(Color.gray);
		  
		  
		        Font font1 = new Font("Serif", Font.BOLD, 20);
		        username2.setHorizontalAlignment(SwingConstants.CENTER);
		     
		        
		        
		         username1.setHorizontalAlignment(SwingConstants.CENTER);
		         username2.setHorizontalAlignment(SwingConstants.CENTER);
		         username3.setHorizontalAlignment(SwingConstants.CENTER);
		         username4.setHorizontalAlignment(SwingConstants.CENTER);
		         
		            username1.setFont(font1);
		            username2.setFont(font1);
		            username3.setFont(font1);
		            username4.setFont(font1);
		 
		 
		        username1.setText("User Name");
		        username2.setText("User Name");
		        username3.setText("User Name");
		         username4.setText("User Name");
		   

		       
		        
		        
		        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		        userNames.put("username1", username1);
		         userNames.put("username2", username2);
		          userNames.put("username3", username3);
		           userNames.put("username4", username4);
		           
		         playerLabelsIDDS.put("player1", player1);
		         playerLabelsIDDS.put("player2", player2);
		          playerLabelsIDDS.put("player3", player3);
		           playerLabelsIDDS.put("player4", player4);
		           
		           
		           connectedPlayersNames = new ArrayList<String>();
		    }
		    public static LodingGame getInstance(){
		        
		        if(instance == null){
		            instance = new LodingGame();
		        }
		        
		        return instance;
		    }
		    
		    public void updateConnectedPlayers(){
		        
		        connectedPlayers++;
		    }
		    
		    public int getConnectedPlayers(){
		        return connectedPlayers;
		    }
		    
		    public void resetConnectedPlayers(){
		        this.connectedPlayers=0;
		    }

		    /**
		     * This method is called from within the constructor to initialize the form.
		     * WARNING: Do NOT modify this code. The content of this method is always
		     * regenerated by the Form Editor.
		     */
		    @SuppressWarnings("unchecked")
		    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
		    private void initComponents() {

		        logoTitle = new javax.swing.JLabel();
		        username2 = new javax.swing.JTextField();
		        username1 = new javax.swing.JTextField();
		        username3 = new javax.swing.JTextField();
		        username4 = new javax.swing.JTextField();
		        doneLabel = new javax.swing.JLabel();
		        player1 = new javax.swing.JLabel();
		        player4 = new javax.swing.JLabel();
		        player3 = new javax.swing.JLabel();
		        player2 = new javax.swing.JLabel();
		        jLabel1 = new javax.swing.JLabel();

		        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
		        setTitle("Monopoly Game");
		        setMaximumSize(new java.awt.Dimension(1200, 600));
		        setMinimumSize(new java.awt.Dimension(1200, 600));
		        setPreferredSize(new java.awt.Dimension(1200, 600));
		        getContentPane().setLayout(null);

		        logoTitle.setBackground(new java.awt.Color(255, 255, 255));
		        logoTitle.setFont(new java.awt.Font("Gabriola", 2, 115)); // NOI18N
		        logoTitle.setText("Monopoly Game");
		        getContentPane().add(logoTitle);
		        logoTitle.setBounds(170, 20, 660, 140);

		        username2.addFocusListener(new java.awt.event.FocusAdapter() {
		            public void focusGained(java.awt.event.FocusEvent evt) {
		                username2FocusGained(evt);
		            }
		            public void focusLost(java.awt.event.FocusEvent evt) {
		                username2FocusLost(evt);
		            }
		        });
		        username2.addActionListener(new java.awt.event.ActionListener() {
		            public void actionPerformed(java.awt.event.ActionEvent evt) {
		                username2ActionPerformed(evt);
		            }
		        });
		        getContentPane().add(username2);
		        username2.setBounds(260, 240, 220, 40);

		        username1.addFocusListener(new java.awt.event.FocusAdapter() {
		            public void focusGained(java.awt.event.FocusEvent evt) {
		                username1FocusGained(evt);
		            }
		            public void focusLost(java.awt.event.FocusEvent evt) {
		                username1FocusLost(evt);
		            }
		        });
		     
		        getContentPane().add(username1);
		        username1.setBounds(260, 164, 220, 40);

		        username3.addFocusListener(new java.awt.event.FocusAdapter() {
		            public void focusGained(java.awt.event.FocusEvent evt) {
		                username3FocusGained(evt);
		            }
		            public void focusLost(java.awt.event.FocusEvent evt) {
		                username3FocusLost(evt);
		            }
		        });
		        username3.addActionListener(new java.awt.event.ActionListener() {
		            public void actionPerformed(java.awt.event.ActionEvent evt) {
		                username3ActionPerformed(evt);
		            }
		        });
		        getContentPane().add(username3);
		        username3.setBounds(260, 300, 220, 40);

		        username4.addFocusListener(new java.awt.event.FocusAdapter() {
		            public void focusGained(java.awt.event.FocusEvent evt) {
		                username4FocusGained(evt);
		            }
		            public void focusLost(java.awt.event.FocusEvent evt) {
		                username4FocusLost(evt);
		            }
		        });
		        username4.addActionListener(new java.awt.event.ActionListener() {
		            public void actionPerformed(java.awt.event.ActionEvent evt) {
		                username4ActionPerformed(evt);
		            }
		        });
		        getContentPane().add(username4);
		        username4.setBounds(260, 360, 220, 40);

		       

		        player1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
		        player1.setIcon(new ImageIcon(LodingGame.class.getResource("/images/aplayer.png")));
		        player1.addMouseListener(new java.awt.event.MouseAdapter() {
		            public void mouseClicked(java.awt.event.MouseEvent evt) {
		                player1MouseClicked(evt);
		            }
		        });
		        getContentPane().add(player1);
		        player1.setBounds(488, 137, 75, 80);

		        player4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
		        player4.setIcon(new ImageIcon(LodingGame.class.getResource("/images/aplayer.png")));
		        player4.addMouseListener(new java.awt.event.MouseAdapter() {
		            public void mouseClicked(java.awt.event.MouseEvent evt) {
		                player4MouseClicked(evt);
		            }
		        });
		        getContentPane().add(player4);
		        player4.setBounds(492, 334, 160, 80);

		        player3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
		        player3.setIcon(new ImageIcon(LodingGame.class.getResource("/images/aplayer.png")));
		        player3.addMouseListener(new java.awt.event.MouseAdapter() {
		            public void mouseClicked(java.awt.event.MouseEvent evt) {
		                player3MouseClicked(evt);
		            }
		        });
		        getContentPane().add(player3);
		        player3.setBounds(492, 275, 160, 80);

		        player2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
		        player2.setIcon(new ImageIcon(LodingGame.class.getResource("/images/aplayer.png")));
		        player2.addMouseListener(new java.awt.event.MouseAdapter() {
		            public void mouseClicked(java.awt.event.MouseEvent evt) {
		                player2MouseClicked(evt);
		            }
		        });
		        getContentPane().add(player2);
		        player2.setBounds(492, 212, 160, 80);
		        
		        JButton btnNewButton = new JButton("New button");
		        btnNewButton.addActionListener(new ActionListener() {
		        	public void actionPerformed(ActionEvent arg0) {
		        		doneLabelMouseClicked();
		        	}
		        });
		           btnNewButton.setIcon(new ImageIcon(LodingGame.class.getResource("/images/loginbtn.jpg")));
		           btnNewButton.setBounds(357, 450, 123, 46);
		           getContentPane().add(btnNewButton);

		           JButton btnRegister = new JButton("Register");
		           btnRegister.addActionListener(new ActionListener() {
		           	public void actionPerformed(ActionEvent arg0) {
		           		
		           		RegisterFrame r=new RegisterFrame();
						r.setVisible(true);
		           	}
		           });
		         
		           btnRegister.setBounds(234, 447, 123, 49);
		           getContentPane().add(btnRegister);
		           
		        jLabel1.setIcon(new ImageIcon(LodingGame.class.getResource("/images/login.jpg"))); // NOI18N
		        getContentPane().add(jLabel1);
		        jLabel1.setBounds(12, 0, 1194, 565);

		        pack();
		        setLocationRelativeTo(null);
		    }                      

		                        

		    private void username2FocusLost(java.awt.event.FocusEvent evt) {                                    

		        username2.setForeground(Color.gray);
		        if (username2.getText().length() < 1) {
		            username2.setText("User Name");
		        } else {
		            username2.setForeground(Color.black);
		        }


		    }                                   

		    private void username2FocusGained(java.awt.event.FocusEvent evt) {                                      

		        username2.setForeground(Color.black);

		        if (username2.getText().equals("User Name")) {
		            username2.setText("");
		        }


		    }                                     

		    private void username2ActionPerformed(java.awt.event.ActionEvent evt) {                                          
		      
		        
		        
		    }                                         

		    private void username1FocusGained(java.awt.event.FocusEvent evt) {                                      

		        username1.setForeground(Color.black);

		        if (username1.getText().equals("User Name")) {
		            username1.setText("");
		        }
		        
		        
		    }                                     

		    private void username1FocusLost(java.awt.event.FocusEvent evt) {                                    


		        
		        username1.setForeground(Color.gray);
		        if (username1.getText().length() < 1) {
		            username1.setText("User Name");
		        } else {
		            username1.setForeground(Color.black);
		        }
		        
		        
		        
		    }                                   

		    
		    
		    
		                                         

		    private void username3FocusGained(java.awt.event.FocusEvent evt) {                                      
		              username3.setForeground(Color.black);

		        if (username3.getText().equals("User Name")) {
		            username3.setText("");
		        }
		    }                                     

		    private void username3FocusLost(java.awt.event.FocusEvent evt) {                                    
		              username3.setForeground(Color.gray);
		        if (username3.getText().length() < 1) {
		            username3.setText("User Name");
		        } else {
		            username3.setForeground(Color.black);
		        }
		    }                                   

		    
		    
		    
		    
		    private void username3ActionPerformed(java.awt.event.ActionEvent evt) {                                          
		        // TODO add your handling code here:
		    }                                         

		    
		    
		    
		    private void username4FocusGained(java.awt.event.FocusEvent evt) {                                      
		             username4.setForeground(Color.black);

		        if (username4.getText().equals("User Name")) {
		            username4.setText("");
		        }
		    }                                     

		    private void username4FocusLost(java.awt.event.FocusEvent evt) {                                    
		              username4.setForeground(Color.gray);
		        if (username4.getText().length() < 1) {
		            username4.setText("User Name");
		        } else {
		            username4.setForeground(Color.black);
		        }
		    }                                   

		    private void username4ActionPerformed(java.awt.event.ActionEvent evt) {                                          
		        // TODO add your handling code here:
		    }                                         

		    
		    
		    
		    
		                                 

		    private void player1MouseClicked(java.awt.event.MouseEvent evt) {                                     

		     if(username1.getText().equals("User Name") || username1.getText().equals("") ){
		          
		            JOptionPane.showMessageDialog(rootPane, "You need to enter a username first");
		            
		           
		        }
		        else{
		         
		         if(!player1Clicked){
		             
		             
		              checker = UpdateData.getInstance();
		             
		             if(checker.checkPlayerUserName(username1.getText())){
		                 
		                 if(!connectedPlayersNames.contains(username1.getText())){
		                         connectPlayer(username1.getText(),"username1","player1");
		                 }
		                 else{
		               JOptionPane.showMessageDialog(rootPane, "Sorry , Player is already connected");
		              username1.setForeground(Color.gray);
		                  username1.setText("User Name");
		                 }
		                 
		              
		                  
		                  
		                  
		             }
		             else{
		                 JOptionPane.showMessageDialog(rootPane, "Sorry , Username doesnt exist");
		              username1.setForeground(Color.gray);
		            username1.setText("User Name");
		             }
		             
		             
		                       
		                        
		                        
		                        
		           
		              
		         }
		         

		            
		        }
		        
		        
		    }                                    

		    private void player4MouseClicked(java.awt.event.MouseEvent evt) {                                     

		    if(username4.getText().equals("User Name")|| username4.getText().equals("") ){
		                
		            JOptionPane.showMessageDialog(rootPane, "You need to enter a username first");
		             
		          }
		          else{
		        
		        if(!player4clicked){
		            
		                       checker = UpdateData.getInstance();
		             
		             if(checker.checkPlayerUserName(username4.getText())){
		                 
		                 
		                 if(!connectedPlayersNames.contains(username4.getText())){
		                        connectPlayer(username4.getText(),"username4","player4");
		                 }
		                 else{
		               JOptionPane.showMessageDialog(rootPane, "Sorry , Player is already connected");
		              username4.setForeground(Color.gray);
		                  username4.setText("User Name");
		                 }
		                 
		                 
		                 
		                          
		             }
		             else{
		                 JOptionPane.showMessageDialog(rootPane, "Sorry , Username doesnt exist");
		                               username4.setForeground(Color.gray);
		            username4.setText("User Name");
		             }
		             
		             
		                   
		            
		        }
		  
		          }
		    }                                    

		    private void player3MouseClicked(java.awt.event.MouseEvent evt) {                                     

		       if(username3.getText().equals("User Name")|| username3.getText().equals("") ){
		                    
		            JOptionPane.showMessageDialog(rootPane, "You need to enter a username first");
		            
		            
		         
		          }
		          else{   
		           
		         if(!player3clicked){
		             
		                   if(checker.checkPlayerUserName(username3.getText())){
		                       
		                       
		                 if(!connectedPlayersNames.contains(username3.getText())){
		                        connectPlayer(username3.getText(),"username3","player3"); 
		                 }
		                 else{
		               JOptionPane.showMessageDialog(rootPane, "Sorry , Player is already connected");
		              username3.setForeground(Color.gray);
		                  username3.setText("User Name");
		                 }
		                 
		                 
		                 
		                          
		                      }
		                  else{
		                        JOptionPane.showMessageDialog(rootPane, "Sorry , Username doesnt exist");
		                        
		                                      username3.setForeground(Color.gray);
		            username3.setText("User Name");
		            
		                      }
		                                
		                                
		       
		        }
		               
		              
		          }
		    }                                    

		    private void player2MouseClicked(java.awt.event.MouseEvent evt) {                                     

		          if(username2.getText().equals("User Name")|| username2.getText().equals("") ){
		              
		            JOptionPane.showMessageDialog(rootPane, "You need to enter a username first");
		            
		          }
		          else{   
		         if(!player2clicked){
		             
		              if(checker.checkPlayerUserName(username2.getText())){
		                  
		                 if(!connectedPlayersNames.contains(username2.getText())){
		                         connectPlayer(username2.getText(),"username2","player2"); 
		                 }
		                 else{
		               JOptionPane.showMessageDialog(rootPane, "Sorry , Player is already connected");
		              username2.setForeground(Color.gray);
		                  username2.setText("User Name");
		                 }
		                  
		                  
		                         
		                      }
		                  else{
		                        JOptionPane.showMessageDialog(rootPane, "Sorry , Username doesnt exist");
		                                      username2.setForeground(Color.gray);
		            username2.setText("User Name");
		                      }
		             
		             
		                  
		           
		            
		        }
		      
		          }
		    }                                    

		    private void doneLabelMouseClicked() {                                       

		            
		        if(connectedPlayers<2){
		            JOptionPane.showMessageDialog(rootPane, "You need to add atleast two  players.");
		        }
		        else {
		            JOptionPane.showMessageDialog(rootPane, "Game Started!!!");
		            
		            Frame gf = new Frame(connectedPlayers,connectedPlayersNames);
		            this.setVisible(false);
		            gf.setVisible(true);
		            
		            
		            
		        }
		        
		        
		        
		        
		        
		    }                                      

		    
		    public void loginResponse(String usernamee,String inputID,String playerlabelIDD,boolean response){
		      

		         userNames.get(inputID).setText(usernamee);
		         userNames.get(inputID).setEnabled(false);
		         updateFinishedFlag(playerlabelIDD,response);
		         connectedPlayersNames.add(usernamee);
		         
		         
		         
		    }
		    
		    
		    private void connectPlayer(String user,String inputID,String playerLabelID){
		        LoginFrame loginframe =LoginFrame.getInstance();
		          loginframe.assignPlayer(user,inputID,playerLabelID,"PreloadingGameFrame");
		        this.setVisible(false);
		        loginframe.setVisible(true);
		      
		        
		    }
		    
		    private void updateFinishedFlag(String labelID,boolean flag){
		        
		        switch(labelID){
		            case "player1" :
		                player1Clicked=flag;
		                break;
		            case "player2":
		                  player2clicked=flag;
		                  
		            break;
		           case "player3" :
		                player3clicked=flag;
		                
		                break;
		            case "player4":
		                  player4clicked=flag;

		            break;
		        }
		        
		    }
		    private javax.swing.JLabel doneLabel;
		    private javax.swing.JLabel jLabel1;
		    private javax.swing.JLabel logoTitle;
		    private javax.swing.JLabel player1;
		    private javax.swing.JLabel player2;
		    private javax.swing.JLabel player3;
		    private javax.swing.JLabel player4;
		    private javax.swing.JTextField username1;
		    private javax.swing.JTextField username2;
		    private javax.swing.JTextField username3;
		    private javax.swing.JTextField username4;
}