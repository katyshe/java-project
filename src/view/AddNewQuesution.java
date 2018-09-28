package view;
//add new question 
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JDesktopPane;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import control.QuestionControl;
import control.UpdateData;
import model.Answer;
import model.Tags;
import model.Question;
/**
 * add a new questin to json 
 * @author Katy Sh
 *
 */

public class AddNewQuesution extends javax.swing.JFrame  {

	private JDesktopPane contentPane;
	private JTextField QuestionContent;
	private JTextField txtRightAnswer;
	private JTextField txtWrongAnswer;
	JScrollPane scrollPane;
	private DefaultComboBoxModel<String>D=new DefaultComboBoxModel<String>();
	private DefaultComboBoxModel<String>Tag=new DefaultComboBoxModel<String>();
	JList<String>list;
	 Question Question ;
	   public  HashMap<String,String> optionsforQ ;
	   public ArrayList<Answer> optionsforQ1;
	   public ArrayList<String>tags;
	    String dist;
	    private JLabel logoTitle;
	    int level =0;
	    private JTextField txtTeamName;
	    private JTextField txtAdditionalOption;
	    private JTextField txtAdditionalOption_1;
	    JCheckBox checkAdd1t;
	    JCheckBox checkAdd1f;
	    JCheckBox checkAdd2t;
	    JCheckBox checkAdd2f;
	    JButton btnNewButton;
	    private JButton btnNewButton_1;
	    private boolean moreoptionselected=false;//check if the more option button has selected
	    
	/**
	 * Launch the application.
	 */
/*	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddNewQuesution frame = new AddNewQuesution();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the frame.
	 */
	public  AddNewQuesution() {
		// TODO Auto-generated constructor stub
	
		
		
		setTitle("Manage Question");
		setBounds(0, 0, 1286, 650);
		
		
		
		contentPane = new JDesktopPane();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		logoTitle = new JLabel();
        logoTitle.setFont(new Font("Forte", Font.BOLD, 37));
        logoTitle.setBackground(new Color(165, 42, 42));

        logoTitle.setText("Monopoly Game");
        getContentPane().add(logoTitle);
        logoTitle.setBounds(246, 13, 660, 140);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				String ObjButtons[] = { "Yes", "No" };
				int PromptResult = JOptionPane.showOptionDialog(null, "Are you sure you want to exit?", "Confirm Exit",
						JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, ObjButtons, ObjButtons[1]);
				if (PromptResult == JOptionPane.YES_OPTION) {
					dispose();
				}
			}
		});
		btnCancel.setBounds(297, 544, 89, 23);
		getContentPane().add(btnCancel);
		
		JLabel lblNewLabel_1 = new JLabel("Difficulty:");
		lblNewLabel_1.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 15));
		lblNewLabel_1.setForeground(Color.BLACK);
		lblNewLabel_1.setBounds(190, 471, 122, 34);
		contentPane.add(lblNewLabel_1);
		
		JButton btnSave = new JButton("Save");
		btnSave.setBounds(443, 544, 63, 23);
		contentPane.add(btnSave);
		btnSave.addMouseListener(new java.awt.event.MouseAdapter(){
	            public void mouseClicked(java.awt.event.MouseEvent evt){
	                doneLabelMouseClicked(evt);
	                Menu m=new Menu(control.Main.file,control.Main.dataFile);
	                m.setVisible(true); 
	            } 
	        });
		
		QuestionContent = new JTextField();
		QuestionContent.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
            	QuestionContenthide();
			}
		});
		QuestionContent.setForeground(Color.GRAY);
		QuestionContent.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 15));
		QuestionContent.setHorizontalAlignment(SwingConstants.CENTER);
		QuestionContent.setText("Context");
		QuestionContent.setBounds(187, 222, 453, 34);
		contentPane.add(QuestionContent);
		QuestionContent.setColumns(10);
		
		txtRightAnswer = new JTextField();
		txtRightAnswer.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
            	txtRightAnswerhide();
			}
		});
		txtRightAnswer.setForeground(Color.GRAY);
		txtRightAnswer.setHorizontalAlignment(SwingConstants.CENTER);
		txtRightAnswer.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 15));
		txtRightAnswer.setText("Right Answer\r\n");
		txtRightAnswer.setBounds(187, 285, 453, 31);
		contentPane.add(txtRightAnswer);
		txtRightAnswer.setColumns(10);
		
		txtWrongAnswer = new JTextField();
		txtWrongAnswer.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
            	txtWrongAnswerhide();
			}
		});
		txtWrongAnswer.setText("Wrong Answer");
		txtWrongAnswer.setHorizontalAlignment(SwingConstants.CENTER);
		txtWrongAnswer.setForeground(Color.GRAY);
		txtWrongAnswer.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 15));
		txtWrongAnswer.setBounds(187, 338, 453, 27);
		contentPane.add(txtWrongAnswer);
		txtWrongAnswer.setColumns(10);
		

		
		JComboBox<String> comboBox = new JComboBox<String>(D);
		D.addElement("Easy");

		D.addElement("Medium");

		D.addElement("Hard");
		comboBox.setBounds(293, 477,303,23);
		contentPane.add(comboBox);
		
		txtTeamName = new JTextField();
		txtTeamName.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
            	TeamNamehide();
			}
		});
		txtTeamName.setForeground(Color.GRAY);
		txtTeamName.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 15));
		txtTeamName.setHorizontalAlignment(SwingConstants.CENTER);
		txtTeamName.setText("Team Name\r\n");
		txtTeamName.setBounds(443, 174, 197, 22);
		contentPane.add(txtTeamName);
		txtTeamName.setColumns(10);
		
		txtAdditionalOption = new JTextField();
		txtAdditionalOption.setForeground(Color.GRAY);
		txtAdditionalOption.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 15));
		txtAdditionalOption.setHorizontalAlignment(SwingConstants.CENTER);
		txtAdditionalOption.setText("additional option\r\n");
		txtAdditionalOption.setBounds(190, 383, 450, 31);
		contentPane.add(txtAdditionalOption);
		txtAdditionalOption.setColumns(10);
		txtAdditionalOption.setVisible(false);
		
		txtAdditionalOption_1 = new JTextField();
		txtAdditionalOption_1.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 15));
		txtAdditionalOption_1.setForeground(Color.GRAY);
		txtAdditionalOption_1.setHorizontalAlignment(SwingConstants.CENTER);
		txtAdditionalOption_1.setText("additional option\r\n");
		txtAdditionalOption_1.setBounds(187, 431, 453, 28);
		contentPane.add(txtAdditionalOption_1);
		txtAdditionalOption_1.setColumns(10);
		txtAdditionalOption_1.setVisible(false);
		 checkAdd1t = new JCheckBox("True");
		checkAdd1t.setBounds(665, 382, 113, 25);
		contentPane.add(checkAdd1t);
		checkAdd1t.setVisible(false);
		 checkAdd1f = new JCheckBox("False");
		checkAdd1f.setBounds(794, 382, 113, 25);
		contentPane.add(checkAdd1f);
		checkAdd1f.setVisible(false);
		 checkAdd2t = new JCheckBox("True");
		checkAdd2t.setBounds(665, 430, 113, 25);
		contentPane.add(checkAdd2t);
		checkAdd2t.setVisible(false);
		 checkAdd2f = new JCheckBox("False");
		checkAdd2f.setBounds(794, 430, 113, 25);
		contentPane.add(checkAdd2f);
		checkAdd2f.setVisible(false);
		 btnNewButton = new JButton("Add more options\r\n");
		btnNewButton.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 15));
		btnNewButton.setForeground(Color.GRAY);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txtAdditionalOption.setVisible(true);
				txtAdditionalOption_1.setVisible(true);
				checkAdd1t.setVisible(true);
				checkAdd1f.setVisible(true);
				checkAdd2t.setVisible(true);
				checkAdd2f.setVisible(true);
				moreoptionselected=true;
			}
		});
		btnNewButton.setBounds(665, 339, 165, 25);
		contentPane.add(btnNewButton);
		scrollPane=new JScrollPane();
		scrollPane.setBounds(650, 170, 205, 150);
		
		//JComboBox<Tags> comboBox_1 = new JComboBox<Tags>(Tag);
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
	
		list=new JList<String>(Tag);
		contentPane.add(scrollPane);
	    list.setValueIsAdjusting(true);
		
		scrollPane.setViewportView(list);
			
		btnNewButton_1 = new JButton("EditQuestion\r\n");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				EditQuestion frame = new EditQuestion();
				frame.setVisible(true);
			}
		});
		btnNewButton_1.setForeground(Color.GRAY);
		btnNewButton_1.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 15));
		btnNewButton_1.setBounds(511, 543, 129, 25);
		contentPane.add(btnNewButton_1);
		JLabel lblNewLabel_2 = new JLabel(" ");
		lblNewLabel_2.setIcon(new ImageIcon(AddNewQuesution.class.getResource("/images/login.jpg")));
		lblNewLabel_2.setBounds(0, 0, 1268, 601);
		contentPane.add(lblNewLabel_2);			
		
		
		
		
		
		//optionsforQ = new HashMap<String,String>();
		optionsforQ1=new ArrayList<Answer>();
		tags=new ArrayList<String>();
		
		
		
		
	}

  
    private void doneLabelMouseClicked(java.awt.event.MouseEvent evt) {  
    	Question newQ =new Question();
        if(QuestionContent.getText().length()<1)
             JOptionPane.showMessageDialog(rootPane, "Please insert a question");
        else{
      /*   if(idQu.getText().length()<1)
             JOptionPane.showMessageDialog(rootPane, "Please insert a numerical id");*/
        
        	 if(txtRightAnswer.getText().length()<1 ||txtWrongAnswer.getText().length()<1)
        		 JOptionPane.showMessageDialog(null,"There must be two option\n"+"please insert at least two  option");
        	 else{
        		 
       // String str = idQu.getText();
        String teamName=txtTeamName.getText();
      
       
        //    newQ.setId(id);      
            newQ.setTeam(teamName);
           newQ.setQuestionContext(QuestionContent.getText());
                UpdateData usc = UpdateData.getInstance();
                      /*  for(int j: usc.getAllQuestions()){
                        if(j==id){
                        JOptionPane.showMessageDialog(rootPane, "ID already exists");
                        return;
                        }
                        }*/
         
         if(D.getSelectedItem().toString().equals("Easy")){
                 level=0;
                 }
         if(D.getSelectedItem().toString().equals("Medium")){
                 level=1;
         }
         if(D.getSelectedItem().toString().equals("Hard")){
                 level=2;
                 }
         newQ.setdifficulty(level);
         /////////////////////////////////////////////////////////////////////////////////    
     //    optionsforQ.put(txtRightAnswer.getText(), "True");
     //    optionsforQ.put(txtWrongAnswer.getText(),"False");
         Answer trueAnswer1 =new Answer();
         trueAnswer1.setText(txtRightAnswer.getText());
         trueAnswer1.setIsCorrect(true);
         Answer falseAnswer1 =new Answer();
         falseAnswer1.setText(txtWrongAnswer.getText());
         falseAnswer1.setIsCorrect(false);
         optionsforQ1.add(trueAnswer1);
         optionsforQ1.add(falseAnswer1);
         
         
         
         ////???//
        //	 System.out.println(optionsforQ.size());
         
       if(moreoptionselected)
         {
    	   System.out.println("insert to add more question ****************************************************************");
         if(txtAdditionalOption.getText().length()>1)
         {
        	 Answer option3 =new Answer();
        	 option3.setText(txtAdditionalOption.getText());
        	 if(checkAdd1t.isSelected() && checkAdd1f.isSelected())
        	 {
        		 JOptionPane.showMessageDialog(null, "you should selected true or false");
        	 }
        	if(!checkAdd1t.isSelected() && !checkAdd1f.isSelected())	 
        		JOptionPane.showMessageDialog(null, "you should selected true or false");
            if(checkAdd1t.isSelected() && !checkAdd1f.isSelected()){
            	
            	System.out.println("option3 is true..........................");
            	 option3.setIsCorrect(true);
            	optionsforQ1.add(option3);
        	     //  optionsforQ.put(txtAdditionalOption.getText(), "True");
            }
            else
              if(!checkAdd1t.isSelected() && checkAdd1f.isSelected())
              {
            	  option3.setIsCorrect(false);
          	optionsforQ1.add(option3);
          	System.out.println("option3 is false..........................");
              }
            	//  optionsforQ.put(txtAdditionalOption.getText(), "False");
         }
         
         if(txtAdditionalOption_1.getText().length()>1)
         {
        	 Answer option4 =new Answer();
        	 option4.setText(txtAdditionalOption_1.getText());
        	 if(checkAdd2t.isSelected() && checkAdd2f.isSelected())
        	 {
        		 JOptionPane.showMessageDialog(null, "you should selected true or false");
        	 }
        	if(!checkAdd2t.isSelected() && !checkAdd2f.isSelected())	 
        		JOptionPane.showMessageDialog(null, "you should selected true or false");
            if(checkAdd2t.isSelected() && !checkAdd2f.isSelected()){
        	      // optionsforQ.put(txtAdditionalOption_1.getText(), "True");
            	 option4.setIsCorrect(true);
        	optionsforQ1.add(option4);}
            else
              if(!checkAdd2t.isSelected() && checkAdd2f.isSelected())	{
            	  option4.setIsCorrect(false);
              	optionsforQ1.add(option4);
            	//  optionsforQ.put(txtAdditionalOption_1.getText(), "False");
              }
         }
         }
         newQ.setOptions(optionsforQ1);
        
         //////////////////////////////////////////////////////////////////////////////////////////////
         
         ArrayList<String> correctOption = new ArrayList<String>();
    //     ArrayList<String> answers = new ArrayList<String>(optionsforQ.keySet());
         
       /*  for(String k : optionsforQ.keySet()){
             if(optionsforQ.get(k).equals("True"))
            	 correctOption.add(k);
         }*/
        // for(int i=0;i<optionsforQ1.size();i++){
        	// if(optionsforQ1.get(i).getIsCorrect().equals(true)){
        		// correctOption.add(optionsforQ1.get(i).getText());
        		 //newQ.addCorrectAnswerIndex(i);
        	 //}
         //}
         //System.out.println(correctOption.size());
         
         Boolean multiple = false;
         if(correctOption.size()>=1)
        	 multiple=true;
         else {
        	 multiple=false;
         }
        newQ.setMultipleChoice(multiple);
        Object [] selectedIx=list.getSelectedValues();
        if(selectedIx.length!=0)
        {
        for(int i=0;i<selectedIx.length;i++)
        {
          tags.add(list.getSelectedValue());
        }
       
        newQ.setTags(tags);  
        }
        else
        {
        	 newQ.setTags(null);
        }
            try {
				QuestionControl.getInstance().addQuesitonToDB(newQ);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            JOptionPane.showMessageDialog(null, "Question was added Successfully");
            //resetAllFields();
            
            
     
         
        
        		 
        		 
     
        	 }
         }
        }
                                          

                                      

                                      

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {                                      

       // QuestionControl.getInstance().decorateOption(this);
        
//        JEnhancedOptionPane jp = new JEnhancedOptionPane();
//        
//       String input = jp.showInputDialog("Enter an option:", new Object[]{"Correct", "False"});
//        JOptionPane.showMessageDialog(null, input);
   
        
    }                                     

    private void questioncontentActionPerformed(java.awt.event.ActionEvent evt) {                                                
        // TODO add your handling code here:
    }                                               

  
    class JEnhancedOptionPane extends JOptionPane {
    public String showInputDialog(final Object message, final Object[] options)
            throws HeadlessException {
        final JOptionPane pane = new JOptionPane(message, QUESTION_MESSAGE,
                                                 OK_CANCEL_OPTION, null,
                                                 options, null);
        pane.setWantsInput(true);
        pane.setComponentOrientation((getRootFrame()).getComponentOrientation());
        pane.setMessageType(QUESTION_MESSAGE);
        pane.selectInitialValue();
        final String title = UIManager.getString("OptionPane.inputDialogTitle", null);
        final JDialog dialog = pane.createDialog(null, title);
        dialog.setVisible(true);
        dialog.dispose();
        final Object value = pane.getInputValue();
        return (value == UNINITIALIZED_VALUE) ? null : (String) value;
    }
}
    
   
    
    public void setLocalQuestion(Question q){
        this.Question=q;
    }
    public void setDest(String dist2){
        this.dist=dist2;
    }
    
    
    public void initFrame(){
                if(dist.equals("editquestion")){
                	QuestionContent.setText(Question.getQuestionContext());
                	//idQu.setText(Question.getId()+"");
            switch(Question.getdifficulty()){
                case 0:
                    D.setSelectedItem(0);
                    break;
                case 1:
                     D.setSelectedItem(1);
                    break;
                case 2:
                	   D.setSelectedItem(2);
                    break;
            }
            
          // ArrayList<Integer> answersListt = Question.getcorrectanswersIndex();
           //ArrayList<String> correctAnswerss = new ArrayList<String>();
                
             //   for(int i=0;i<answersListt.size();i++){
               //   correctAnswerss.add(localQuestion.getOptionsList().get(answersListt.get(i)));
                //}
                
                /*for(String strrr : localQuestion.getOptionsList())
                {
                    if(correctAnswerss.contains(strrr))
                         optionsforQ.put(strrr, "Correct");
                    else
                        optionsforQ.put(strrr, "False");
                }*/
                   
                
                
             //   idQu.setEditable(false);
                
        }
    }
    
    public void resetAllFields(){
        if(!dist.equals("editquestion")){
            this.setVisible(false);
            AddNewQuesution addas = new AddNewQuesution();
            addas.setVisible(true);
        }
    }
    
    private void QuestionContenthide() {                                     

       if(QuestionContent.getText().equals("Context"))
    	   QuestionContent.setText("");
       
       
       
    }     
    private void txtRightAnswerhide() {                                     
       if(txtRightAnswer.getText().equals("Right Answer"))
    	   txtRightAnswer.setText(""); 
    }
    private void  txtWrongAnswerhide()
    {
    	if(txtWrongAnswer.getText().equals("Wrong Answer"))
    		txtWrongAnswer.setText(""); 
    	
    }
    private void  TeamNamehide()
    {
    	if(txtTeamName.getText().equals("Team Name"))
    		txtTeamName.setText(""); 
    	
    }
}