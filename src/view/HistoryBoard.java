/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import control.UpdateData;
import model.Player;
import java.awt.Color;
import static java.awt.Color.BLACK;
import static java.awt.Color.blue;
import static java.awt.Color.green;
import static java.awt.Color.red;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Font;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

/**
 *
 * @author User
 */
public class HistoryBoard extends javax.swing.JFrame {

    
    private static UpdateData systemDataController;
    private static DefaultTableModel model;
    private static HistoryBoard scoreBoardInstance;
    private static int oldSize = 0;
    /**
     * Creates new form MainFrame
     */
    HistoryBoard() {
        
                try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(HistoryBoard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HistoryBoard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HistoryBoard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HistoryBoard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
                
                
        
        initComponents();
        this.setResizable(false);
        back.setCursor(new Cursor(Cursor.HAND_CURSOR)); 
        
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
        

systemDataController = UpdateData.getInstance();


DefaultTableCellRenderer renderer = new DefaultTableCellRenderer(){
    @Override
    public Component getTableCellRendererComponent(JTable arg0,Object arg1, boolean arg2, boolean arg3, int arg4, int arg5) {
         Component tableCellRendererComponent = super.getTableCellRendererComponent(arg0, arg1, arg2, arg3, arg4, arg5);
         int align = DefaultTableCellRenderer.CENTER;
        ((DefaultTableCellRenderer)tableCellRendererComponent).setHorizontalAlignment(align);
         return tableCellRendererComponent;
    }
};
playersDetails.getColumnModel().getColumn(0).setCellRenderer(renderer);
playersDetails.getColumnModel().getColumn(1).setCellRenderer(renderer);
playersDetails.getColumnModel().getColumn(2).setCellRenderer(renderer);





scrollPane.setOpaque(false);
scrollPane.getViewport().setOpaque(false);


playersDetails.getTableHeader().setFont(new Font("SansSerif", Font.BOLD, 26));
playersDetails.getTableHeader().setOpaque(false);
playersDetails.getTableHeader().setBackground(new Color(0, true));
playersDetails.getTableHeader().setForeground(Color.BLACK);
//playersDetails.getTableHeader().getColumnModel().getColumn(0).setCellRenderer(renderer);

  model =(DefaultTableModel)playersDetails.getModel();

  updateScoreBoard();

    }
    
    
    public static HistoryBoard getInstance(){
        if(scoreBoardInstance == null)
            scoreBoardInstance = new HistoryBoard();
        
        return scoreBoardInstance;
    }

         public void restartFrame(){
        scoreBoardInstance = null;
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
        back = new javax.swing.JLabel();
        back.setText("back <-\r\n");
        jLabel2 = new javax.swing.JLabel();
        scrollPane = new javax.swing.JScrollPane();
        playersDetails = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Monopoly");
        setMaximumSize(new java.awt.Dimension(1000, 600));
        setMinimumSize(new java.awt.Dimension(1000, 600));
        setPreferredSize(new java.awt.Dimension(1000, 600));
        getContentPane().setLayout(null);

        logoTitle.setBackground(new java.awt.Color(255, 0, 51));
        logoTitle.setFont(new java.awt.Font("Gabriola", 2, 115)); // NOI18N
        logoTitle.setForeground(new java.awt.Color(255, 255, 255));
        logoTitle.setText("Scores History");
        getContentPane().add(logoTitle);
        logoTitle.setBounds(170, 30, 660, 100);

        back.setBackground(new java.awt.Color(255, 255, 255));
        back.setFont(new java.awt.Font("Segoe UI Black", 1, 24)); // NOI18N
        back.setForeground(new java.awt.Color(255, 255, 255));
      //  back.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/homeicon.png"))); // NOI18N
        back.setToolTipText("Go Home");
        back.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                backMouseClicked(evt);
            }
        });
        getContentPane().add(back);
        back.setBounds(31, 150, 92, 70);

        jLabel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        getContentPane().add(jLabel2);
        jLabel2.setBounds(181, 180, 630, 320);

        playersDetails.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(51, 0, 153), new java.awt.Color(0, 0, 153), new java.awt.Color(0, 0, 102), new java.awt.Color(0, 51, 102)));
        playersDetails.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        playersDetails.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "      User Name", "         Degree", "     Score"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        playersDetails.setRowHeight(50);
        playersDetails.setRowMargin(4);
        playersDetails.getTableHeader().setReorderingAllowed(false);
        scrollPane.setViewportView(playersDetails);
        if (playersDetails.getColumnModel().getColumnCount() > 0) {
            playersDetails.getColumnModel().getColumn(0).setResizable(false);
            playersDetails.getColumnModel().getColumn(1).setResizable(false);
            playersDetails.getColumnModel().getColumn(2).setResizable(false);
        }

        getContentPane().add(scrollPane);
        scrollPane.setBounds(180, 180, 630, 320);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/login.jpg"))); 
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 994, 592);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>                        

    private void backMouseClicked(java.awt.event.MouseEvent evt) {                                  

     //   Menu mf = new  Menu(control.Main.file,control.Main.dataFile);
        this.setVisible(false);
     //   mf.setVisible(true);
       
        
    }                                 

    
    public static void updateScoreBoard(){
        
        model.setRowCount(0);
        System.out.println("\nhereeeeeeeeeeeeeeeee+++ "+ systemDataController.getAllPlayers());
         if(systemDataController.getAllPlayers().size()>0){
        ArrayList<Player> playersSorted = new ArrayList<Player>(systemDataController.getAllPlayers());
        Collections.sort(playersSorted, new Comparator<Player>() {
        @Override public int compare(Player p1, Player p2) {
          return (int) (p2.getBestscore() - p1.getBestscore()); // Descending
        }
        });
	
        for(int i=0  ; i <playersSorted.size();i++){
			  playersSorted.get(i).setdegree(i+1);
		  }        
        
        
            for(Player p : playersSorted){
                model.addRow(new Object[]{p.getUsername(),p.getdgree(),p.getBestscore()});
            }
        
        
    }
    
    }


    // Variables declaration - do not modify                     
    private javax.swing.JLabel back;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel logoTitle;
    private javax.swing.JTable playersDetails;
    private javax.swing.JScrollPane scrollPane;
    // End of variables declaration                   
}