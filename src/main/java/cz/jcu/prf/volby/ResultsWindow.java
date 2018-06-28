package cz.jcu.prf.volby;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author User
 */
public class ResultsWindow extends javax.swing.JFrame {

    private int totalVotes;
    private ElectionService es;
    /**
     * Creates new form ResultsWindow
     * @param lw
     */
    
    
    public ResultsWindow(ElectionService es) {
        initComponents();
        this.es = es;
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        
        totalVotes = es.getTotalVotes();
        
        barArea_jPanel.setLayout(new FlowLayout(FlowLayout.CENTER,40,0));

        for(Candidate i:es.getCanditates()){
            insertBar(i);
        }
        
        addWindowListener(exitListener); //REGISTER LISTENER
        
    }
    /*
    public static void main(String[] args) {
        ResultsWindow k = new ResultsWindow(null);
        k.setVisible(true);
    }
    */
    public void insertBar(Candidate i){
        JPanel wrapPanel = new JPanel();
            wrapPanel.setPreferredSize(new Dimension(180, 450));
            wrapPanel.setLayout(new BorderLayout());

            float percent = 100/(float)totalVotes*(float)i.getCountVotes();
            
            //Přidá procenta nahoru
            JLabel percentageLabel = new JLabel(percent + " %");
            percentageLabel.setFont(new Font("Segoe UI", Font.BOLD, 15));
            percentageLabel.setHorizontalAlignment(SwingConstants.CENTER);
            //percentageLabel.setAlignmentX(percentageLabel.CENTER_ALIGNMENT);
            JPanel percentagePanel = new JPanel();
            percentagePanel.setPreferredSize(new Dimension(180, 30));
            wrapPanel.add(percentageLabel,BorderLayout.NORTH);
            
            //Přidá bar doprostřed
            JPanel centerFillPanel = new JPanel(new BorderLayout());
            wrapPanel.add(centerFillPanel,BorderLayout.CENTER);
            JPanel bottomFillPanel = new JPanel(new FlowLayout());
            centerFillPanel.add(bottomFillPanel,BorderLayout.SOUTH);
            
            int heightOfBar = (int)percent * 4;
            
            JPanel barPanel = new JPanel();
            barPanel.setPreferredSize(new Dimension(80, heightOfBar));  //400 je 100 %
            barPanel.setBackground(Color.red);
            bottomFillPanel.add(barPanel);
            
            //Přidá jméno kandidáta dolů
            JLabel nameLabel = new JLabel();
            nameLabel.setText(i.getFullName());
            nameLabel.setFont(new Font("Segoe UI", Font.PLAIN, 15));
            nameLabel.setHorizontalAlignment(SwingConstants.CENTER);
            wrapPanel.add(nameLabel,BorderLayout.SOUTH);
            
            barArea_jPanel.add(wrapPanel);
    }
    
    WindowListener exitListener = new WindowAdapter() {

    @Override
    public void windowClosing(WindowEvent e) {
        //Zavře okno
        dispose();
    }
};

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        electionTitle = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        barArea_jPanel = new javax.swing.JPanel();
        buttonBack = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);

        electionTitle.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        electionTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        electionTitle.setText("Prezidentské volby 2018");
        electionTitle.setToolTipText("");
        electionTitle.setName(""); // NOI18N

        barArea_jPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jScrollPane1.setViewportView(barArea_jPanel);

        buttonBack.setText("Zpět");
        buttonBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonBackActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 272, Short.MAX_VALUE)
                        .addComponent(electionTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 403, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 273, Short.MAX_VALUE))
                    .addComponent(jScrollPane1)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(buttonBack, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(electionTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 502, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(buttonBack)
                .addGap(7, 7, 7))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonBackActionPerformed
        //Zavře okno, ale otevře nové LoginWindow
        new LoginWindow(es).setVisible(true);
        dispose();
    }//GEN-LAST:event_buttonBackActionPerformed

    /**
     * @param args the command line arguments
     */
   /* public static void main(String args[]) {*/
        /* Set the Nimbus look and feel */
        /*//<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Ja*va SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        /*try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ResultsWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ResultsWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ResultsWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ResultsWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }*/
        //</editor-fold>

        /* Create and display the form */
        /*java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ResultsWindow(null).setVisible(true);
            }
        });
    }*/

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel barArea_jPanel;
    private javax.swing.JButton buttonBack;
    private javax.swing.JLabel electionTitle;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
