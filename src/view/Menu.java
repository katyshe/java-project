package view;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.border.EmptyBorder;
/*
 * log
 */
public class Menu  extends javax.swing.JFrame {

	private JDesktopPane contentPane;
	private ArrayList<String>PLayersNmaes;
	
	/**
	 * Launch the application.
	 * 
	 */
	/*public static void main(String[] args) {
		try {
			Menu frame = new Menu();
			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
				
			
	}*/
	
	

	/**
	 * Create the frame.
	 */
	public Menu(String File ,String dataFile) {
		setTitle("monopoly game");
		setBounds(0, 0, 1323, 770);
		
		contentPane = new JDesktopPane();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("START GAME");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LodingGame plgf =LodingGame .getInstance();
		        plgf.setVisible(true);
		        setVisible(false);
		        
		        
				
			}
		});
		btnNewButton.setBounds(130, 55, 182, 38);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("VIEW PROFILE");
		btnNewButton_1.setBounds(130, 104, 182, 37);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("View Score\u2019s history");
		btnNewButton_2.setBounds(130, 152, 182, 34);
		contentPane.add(btnNewButton_2);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HistoryBoard hb=new HistoryBoard();
				hb.setVisible(true);
			//	setVisible(false);
			}
		});
		
		
		JButton btnNewButton_3 = new JButton("Rules And Instructions");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_3.setBounds(130, 199, 182, 34);
		contentPane.add(btnNewButton_3);
		
		JButton btnAdminPanel = new JButton("Admin Panel");
		btnAdminPanel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddNewQuesution qu=new AddNewQuesution();
				qu.setVisible(true);
				setVisible(false);
			}
		});
		btnAdminPanel.setBounds(130, 240, 182, 34);
		contentPane.add(btnAdminPanel);
		
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
		btnCancel.setBounds(312, 560, 182, 38);
		getContentPane().add(btnCancel);
		
		
		
		JButton btnRegestir = new JButton("Regestir");
		btnRegestir.setBounds(165, 292, 97, 25);
		btnRegestir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegisterFrame r=new RegisterFrame();
				
				r.setVisible(true);
				setVisible(false);
				 
			}
		});
		contentPane.add(btnRegestir);
		JLabel lblMenu = new JLabel("Menu");
		lblMenu.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblMenu.setBounds(174, 13, 182, 22);
		contentPane.add(lblMenu);
		
		JLabel lblNewLabel_1 = new JLabel(" ");
		lblNewLabel_1.setIcon(new ImageIcon(Menu.class.getResource("/images/background.jpg")));
		lblNewLabel_1.setBounds(0, 0, 1300, 720);
		contentPane.add(lblNewLabel_1);
		
		
		
		
		
		
		 
	}
}