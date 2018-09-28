package view;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

import control.QuestionControl;

import java.awt.Color;
import java.awt.Font;
import java.awt.HeadlessException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JDesktopPane;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import control.UpdateData;
import model.Answer;
import model.Tags;
import model.Question;






public class EditQuestion extends JFrame {

	private JDesktopPane contentPane;
	DefaultComboBoxModel<String>questionstring=new DefaultComboBoxModel<String>();
	JComboBox <String>comboBoxdif;
	private JTextField QuestionContent;
	JLabel lblContext;
	private JTextField answe1;
	private JTextField answer2;
	JLabel lblNewLabel_1;
	JScrollPane scrollPane;
	private DefaultComboBoxModel<String>Tag;
	private DefaultComboBoxModel<String>D=new DefaultComboBoxModel<String>();
	JComboBox<String> comboBox = new JComboBox<String>(D);
	JList<String>list;
	JLabel lblOption;
	JLabel lblOption_1 ;
	JLabel lblOption_2;
	JLabel lblOption_3;
	public ArrayList<String>tags;
	
	private JTextField idQu;
	 Question Question ;
	   public  HashMap<String,String> optionsforQ ;
	   public ArrayList<Answer> optionsforQ1;
	    String dist;
	    private JLabel logoTitle;
	    int level =0;
	    private JTextField txtTeamName;
	    private JTextField answer3;
	    private JTextField answer4;
	    JCheckBox checkAdd1t;
	    JCheckBox checkAdd1f;
	    JCheckBox checkAdd2t;
	    JCheckBox checkAdd2f;
	    JButton btnNewButton;
	    private JButton btnNewButton_1;
	    private JTextField textdif;
	    private JTextField textField_1;
	    private JTextField textField_2;
	    private JTextField textField_3;
	    private JTextField textField_4;
	    JLabel lblTruefalseOption;
	    private JLabel lblTags;
	    private JButton btnEditTags;
	    private JButton btnNewButton_2;
	    Question q;
	    private boolean edittagselected=false;
	    private JTextField textField;
	    private boolean editdif=false;
	/*public static void main(String[] args) {
	EventQueue.invokeLater(new Runnable() {
		public void run() {
			try {
				EditQuestion frame = new EditQuestion();
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
	public EditQuestion() {
		setTitle("Edit Question");
		setBounds(0, 0, 1286, 650);
		contentPane = new JDesktopPane();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
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
		btnCancel.setBounds(792, 569, 129, 23);
		getContentPane().add(btnCancel);
		
	    
	    for(int i=0;i<QuestionControl.getInstance().getAllQuestions().size();i++)
	    {
	    	questionstring.addElement(QuestionControl.getInstance().getAllQuestions().get(i).getQuestionContext());
	    }
	    		
		comboBox = new JComboBox<String>(questionstring);
		comboBox.setBounds(12, 108, 374, 51);
		contentPane.add(comboBox);
		
		
		JButton btnNewButton = new JButton("");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textField.setVisible(true);
				lblNewLabel_1.setVisible(true);
				QuestionContent.setVisible(true);
				answe1.setVisible(true);
				answer2.setVisible(true);
				answer2.setVisible(true);
				answer3.setVisible(true);
				answer4.setVisible(true);
				lblContext.setVisible(true);
				lblOption.setVisible(true);
				lblOption_1.setVisible(true);
				lblOption_2.setVisible(true);
				lblOption_3.setVisible(true);
				textdif.setVisible(true);
				textField_1.setVisible(true);
				textField_2.setVisible(true);
				textField_3.setVisible(true);
				textField_4.setVisible(true);
				lblTruefalseOption.setVisible(true);
				btnEditTags.setVisible(true);
				
				
				//contentPane.add(scrollPane);
			   // list.setValueIsAdjusting(true);
				
				
				 if(comboBox.getSelectedItem() != null){
					 String selectedqu=comboBox.getSelectedItem().toString();
		                q = QuestionControl.getSpecificQuestion(selectedqu);
		                textdif.setText(q.getdifficulty()+"");;
						QuestionContent.setText(q.getQuestionContext());
						answe1.setText(q.getOptions().get(0).getText());
						if(q.getcorrectanswersIndex().contains(0))
							textField_1.setText("true"+"");
						else
							textField_1.setText("false"+"");
						
						answer2.setText(q.getOptions().get(1).getText());
						if(q.getcorrectanswersIndex().contains(1))
							textField_2.setText("true"+"");
						else
							textField_2.setText("false"+"");
						System.out.println("this is checkkkkkkkkk"+q.getOptions().size());
						if(q.getOptions().size()>=3)
						{
						answer3.setText(q.getOptions().get(2).getText());
						if(q.getcorrectanswersIndex().contains(2))
							textField_3.setText("true"+"");
						else
							textField_3.setText("false"+"");
						}
						else
						{
							
							
							answer3.setText("Add optoin");
							textField_3.setText("True/Flase");
							
						}
						if(q.getOptions().size()>=4)
						{
						answer4.setText(q.getOptions().get(3).getText());
						if(q.getcorrectanswersIndex().contains(3))
							textField_4.setText("true"+"");
						else
							textField_4.setText("false"+"");
						}
						{
							answer4.setText("Add optoin");
							textField_4.setText("True/Flase");
						}
						
						if(q.getTags()!=null && q.getTags().size()>0)
						{
							
							for(int i=0;i<q.getTags().size();i++)
								textField.setText(q.getTags().get(i)+"");
						}
						
					 
					 
					 
						 
						 
						 
						 
						
						
		               
			}
			}
		});
		btnNewButton.setIcon(new ImageIcon(EditQuestion.class.getResource("/images/show detail.png")));
		btnNewButton.setBounds(412, 108, 59, 51);
		contentPane.add(btnNewButton);
		
		tags=new ArrayList<String>();
		optionsforQ1=new ArrayList<Answer>();
		lblNewLabel_1 = new JLabel("Difficulty:");
		lblNewLabel_1.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 15));
		lblNewLabel_1.setForeground(Color.BLACK);
		lblNewLabel_1.setBounds(95, 470, 122, 34);
		contentPane.add(lblNewLabel_1);
		lblNewLabel_1.setVisible(false);
		QuestionContent = new JTextField();
		QuestionContent.setForeground(Color.GRAY);
		QuestionContent.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 15));
		QuestionContent.setHorizontalAlignment(SwingConstants.CENTER);
		QuestionContent.setBounds(187, 222, 453, 34);
		contentPane.add(QuestionContent);
		QuestionContent.setColumns(10);
		QuestionContent.setVisible(false);
		answe1 = new JTextField();
		
		answe1.setForeground(Color.GRAY);
		answe1.setHorizontalAlignment(SwingConstants.CENTER);
		answe1.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 15));
		answe1.setBounds(187, 285, 453, 31);
		contentPane.add(answe1);
		answe1.setColumns(10);
		answe1.setVisible(false);
		answer2 = new JTextField();
		answer2.setHorizontalAlignment(SwingConstants.CENTER);
		answer2.setForeground(Color.GRAY);
		answer2.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 15));
		answer2.setBounds(187, 338, 453, 27);
		contentPane.add(answer2);
		answer2.setColumns(10);
		answer2.setVisible(false);
		answer3 = new JTextField();
		answer3.setForeground(Color.GRAY);
		answer3.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 15));
		answer3.setHorizontalAlignment(SwingConstants.CENTER);
		answer3.setBounds(190, 383, 450, 31);
		contentPane.add(answer3);
		answer3.setColumns(10);
		answer3.setVisible(false);
		answer4 = new JTextField();
		answer4.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 15));
		answer4.setForeground(Color.GRAY);
		answer4.setHorizontalAlignment(SwingConstants.CENTER);
		answer4.setBounds(187, 431, 453, 28);
		contentPane.add(answer4);
		answer4.setColumns(10);
		answer4.setVisible(false);
		 lblContext = new JLabel("Context");
		lblContext.setBounds(99, 231, 56, 16);
		contentPane.add(lblContext);
		lblContext.setVisible(false);
		 lblOption = new JLabel("option1:");
		lblOption.setBounds(99, 292, 56, 16);
		contentPane.add(lblOption);
		lblOption.setVisible(false);
		 lblOption_1 = new JLabel("option2");
		lblOption_1.setBounds(99, 343, 56, 16);
		contentPane.add(lblOption_1);
		lblOption_1.setVisible(false);
		 lblOption_2 = new JLabel("option3:");
		lblOption_2.setBounds(99, 390, 56, 16);
		contentPane.add(lblOption_2);
		lblOption_2.setVisible(false);
		 lblOption_3 = new JLabel("option4");
		lblOption_3.setBounds(99, 437, 56, 16);
		contentPane.add(lblOption_3);
		lblOption_3.setVisible(false);
		textdif = new JTextField();
		textdif.setBounds(187, 476, 116, 22);
		contentPane.add(textdif);
		textdif.setColumns(10);
		textdif.setVisible(false);
		textField_1 = new JTextField();
		textField_1.setBounds(652, 294, 116, 22);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		textField_1.setVisible(false);
		textField_2 = new JTextField();
		textField_2.setBounds(652, 343, 116, 22);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		textField_2.setVisible(false);
		textField_3 = new JTextField();
		textField_3.setBounds(652, 392, 116, 22);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		textField_3.setVisible(false);
		textField_4 = new JTextField();
		textField_4.setBounds(652, 437, 116, 22);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		textField_4.setVisible(false);
		 lblTruefalseOption = new JLabel("true/false option");
		lblTruefalseOption.setBounds(669, 275, 99, 16);
		contentPane.add(lblTruefalseOption);
		lblTruefalseOption.setVisible(false);
		
		scrollPane=new JScrollPane();
		scrollPane.setBounds(430, 470, 150, 100);
		/*****list of tags*******/
		//JComboBox<Tags> comboBox_1 = new JComboBox<Tags>(Tag);
		
	
		
		contentPane.add(scrollPane);
	   // list.setValueIsAdjusting(true);
		
		
		
		scrollPane.setVisible(false);
		lblTags = new JLabel("tags:");
		lblTags.setBounds(388, 470, 56, 16);
		contentPane.add(lblTags);
		
		btnEditTags = new JButton("edit tags");
		btnEditTags.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textField.setVisible(false);
				scrollPane.setVisible(true);
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
				list=new JList<String>(Tag);
				
				scrollPane.setViewportView(list);
				edittagselected=true;
			}
		});
		btnEditTags.setBounds(584, 476, 97, 25);
		contentPane.add(btnEditTags);
		btnEditTags.setVisible(false);
		
		JButton btnSaveChanges = new JButton("save changes");
		btnSaveChanges.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int count=0,count2=0;
				Question newQ =new Question();
				if(QuestionContent.getText().length()<1)
		             JOptionPane.showMessageDialog(rootPane, "Please insert a question");
				else
				{
					if(answe1.getText().length()>1 && textField_1.getText().equals("true"))
					{
						System.out.println("its entered");
						count++;
					}
					else
						if(answe1.getText().length()>1 && textField_1.getText().equals("false"))
							count2++;
					if(answer2.getText().length()>1 && textField_2.getText().equals("true"))
						count++;
					else
						if(answer2.getText().length()>1 && textField_2.getText().equals("false"))
							  count2++;
							
					if(answer3.getText().length()>1 && textField_3.getText().equals("true"))
						count++;
					else
						if(answer3.getText().length()>1 && textField_3.getText().equals("false"))
						     count2++;
					if(answer4.getText().length()>1 && textField_4.getText().equals("true"))
						count++;
					else
						if(answer4.getText().length()>1 && textField_4.getText().equals("false"))
							count2++;
					
					System.out.println("the number of corect answer "+count+""+count2);
					if(count<1 || count2<1)
						 JOptionPane.showMessageDialog(rootPane, "there must be one correct answer and one wrong anwer atleast");
					else
					{
					if(count>3 && count2>3)
						JOptionPane.showMessageDialog(rootPane, "there must be one correct answer and one wrong anwer atleast");
					else
					{
						newQ.setId(q.getId());      
			            newQ.setTeam(q.getTeam());
			           newQ.setQuestionContext(QuestionContent.getText());
			           if(editdif)
			           {
			           if(D.getSelectedItem().toString().equals("Easy")){
			                   level=0;
			                   }
			           if(D.getSelectedItem().toString().equals("Medium")){
			                   level=1;
			           }
			           if(D.getSelectedItem().toString().equals("Hard")){
			                   level=2;
			           }		           
			           }
			           else
			           {
			        	  if(textdif.getText().equals("0"))
			        			  level=0;
			        	  if(textdif.getText().equals("1"))
			        		    level=1;
			        	  if(textdif.getText().equals("2"))
			        		     level=2;  
			           }
			           newQ.setdifficulty(level);
			           Answer A1 =new Answer();
			           A1.setText(answe1.getText());
			           if(textField_1.getText().equals("true"))
			              A1.setIsCorrect(true);
			           else
			        	   A1.setIsCorrect(false);
			           
			           Answer A2 =new Answer();
			           A2.setText(answer2.getText());
			           if(textField_2.getText().equals("true"))
			        	   A2.setIsCorrect(true);
			           else
			        	   A2.setIsCorrect(false);
			           
			           Answer A3 =new Answer();
			           A3.setText(answer3.getText());
			           if(textField_3.getText().equals("true"))
			        	   A3.setIsCorrect(true);
			           else
			        	   A3.setIsCorrect(false);
			           
			           Answer A4 =new Answer();
			           A4.setText(answer4.getText());
			           if(textField_4.getText().equals("true"))
			        	   A4.setIsCorrect(true);
			           else
			        	   A4.setIsCorrect(false);
			           
			           
			           optionsforQ1.add(A1);
			           optionsforQ1.add(A2);
			           optionsforQ1.add(A3);
			           optionsforQ1.add(A4);
			           for(int i=0;i<optionsforQ1.size();i++)
			           {
			        	   if(optionsforQ1.get(i).getText().equals("Add optoin")||optionsforQ1.get(i).getText().equals(""))
			        		   optionsforQ1.remove(optionsforQ1.get(i));
			           }
			           newQ.setOptions(optionsforQ1);
			           
			           ArrayList<String> correctOption = new ArrayList<String>();
			         
			                for(int i=0;i<optionsforQ1.size();i++){
			               	 if(optionsforQ1.get(i).getIsCorrect().equals(true)){
			               		 correctOption.add(optionsforQ1.get(i).getText());
			               		 newQ.addCorrectAnswerIndex(i);
			               	 }
			                }
			                System.out.println("correctoption size:"+correctOption.size());
			                
			                boolean multiple = false;
			                if(correctOption.size()>=2)
			                {
			               	 multiple=true;
			               	System.out.println("after edit multitiple"+multiple);
			                }
			                else {
			                if(correctOption.size()<=1)	
			                {
			               	 multiple=false;
			               	System.out.println("after edit multitiple"+multiple);
			                }
			                }
			                System.out.println("mulitiple is"+multiple);
			               newQ.setMultipleChoice(multiple);
			               if(edittagselected)
			               {
			               Object [] selectedIx=list.getSelectedValues();
			               
			               ArrayList<String> selectedValues = new ArrayList<String>(list.getSelectedValuesList());
			               
			               for(int i=0;i<selectedValues.size();i++)
			               {
			            	   
			                 tags.add(selectedValues.get(i));
			               }
			              
			              
			               }
			               else
			               {
			            	    String cleared = "";
			            	    cleared = textField.getText().replaceAll("\\\\","");
			            	    cleared=cleared.replaceAll("\"", "");
			            	    
			                System.out.println("its cleared:"+cleared); 	
			            	  tags.add(cleared);
			               	 
			               }
			               newQ.setTags(tags);   
			                   try {
			       				QuestionControl.getInstance().updateAnExistingQuestion(newQ);
				                JOptionPane.showMessageDialog(null, "Question was updeted Successfully");
				                Menu m = new Menu(control.Main.file,control.Main.dataFile);
								m.setVisible(true);
			       			} catch (IOException e) {
			       				// TODO Auto-generated catch block
			       				e.printStackTrace();
			       			}
		
			           
						
					}
					}
				}
				
			
			}
		});
		btnSaveChanges.setBounds(792, 531, 127, 25);
		contentPane.add(btnSaveChanges);
		 btnNewButton_2 = new JButton("edit\r\n");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textdif.setVisible(false);
				editdif=true;
				
				D.addElement("Easy");

				D.addElement("Medium");

				D.addElement("Hard");
				comboBoxdif.setBounds(187, 476, 116, 22);
				contentPane.add(comboBoxdif);
			}
		});
		btnNewButton_2.setBounds(310, 475, 56, 25);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("remove question");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String selectqu=comboBox.getSelectedItem().toString();
	            Question Q = QuestionControl.getSpecificQuestion(selectqu);
				try {
					QuestionControl.getInstance().removeQuestion(Q);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
                JOptionPane.showMessageDialog(null, "Question was Removed Successfully");
                Menu m = new Menu(control.Main.file,control.Main.dataFile);
				m.setVisible(true);
			}
		});
		btnNewButton_3.setBounds(792, 493, 129, 25);
		contentPane.add(btnNewButton_3);
		
		textField = new JTextField();
		textField.setBounds(430, 470,  150, 100);
		contentPane.add(textField);
		textField.setColumns(10);
		textField.setVisible(false);
		
		JLabel lblNewLabel_2 = new JLabel(" ");
		lblNewLabel_2.setIcon(new ImageIcon(AddNewQuesution.class.getResource("/images/login.jpg")));
		lblNewLabel_2.setBounds(0, 0, 1268, 601);
		contentPane.add(lblNewLabel_2);
		
		
		
		
		
		
		
		
		
		
		
		

		
		
		
		
		
		
		
	}
}