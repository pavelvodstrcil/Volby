package cz.jcu.prf.volby;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.sql.Wrapper;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.text.GapContent;

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

    /**
     * Creates new form ResultsWindow
     */
    public ResultsWindow() {
        initComponents();
        for (int i = 0; i < 3; i++) {
            JPanel wrapPanel = new JPanel();
            wrapPanel.setPreferredSize(new Dimension(180, 450));
            wrapPanel.setLayout(new BorderLayout());
            wrapPanel.setBackground(new Color(77,126,175));
           
            JLabel percentageLabel = new JLabel("45 %");
            percentageLabel.setFont(new Font("Segoe UI", Font.BOLD, 15));
            percentageLabel.setHorizontalAlignment(SwingConstants.CENTER);
            JPanel percentagePanel = new JPanel();
            percentagePanel.setPreferredSize(new Dimension(180, 30));

            
            wrapPanel.add(percentageLabel, BorderLayout.NORTH);
            
            JPanel barPanel = new JPanel();
            barPanel.setPreferredSize(new Dimension(80, 350));
            barPanel.setBackground(Color.red);
            
            JPanel centerPanel = new JPanel();
            centerPanel.setLayout(new FlowLayout());
            centerPanel.add(barPanel);
            barPanel.setAlignmentY(BOTTOM_ALIGNMENT);
            wrapPanel.add(centerPanel,BorderLayout.CENTER);

            JLabel nameLabel = new JLabel();
            nameLabel.setText("Klement Gottwald");
            nameLabel.setFont(new Font("Segoe UI", Font.PLAIN, 15));
            nameLabel.setHorizontalAlignment(SwingConstants.CENTER);
            wrapPanel.add(nameLabel, BorderLayout.SOUTH);
            
            barArea_jPanel.add(wrapPanel);
        }
    }
    
    public void insertBar(){
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        electionTitle = new javax.swing.JLabel();
        barArea_jPanel = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        electionTitle.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        electionTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        electionTitle.setText("Prezidentské volby 2018");
        electionTitle.setToolTipText("");
        electionTitle.setName(""); // NOI18N

        barArea_jPanel.setBackground(new java.awt.Color(235, 214, 214));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 220, Short.MAX_VALUE)
                        .addComponent(electionTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 403, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 220, Short.MAX_VALUE))
                    .addComponent(barArea_jPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(electionTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(barArea_jPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 470, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
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
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ResultsWindow().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel barArea_jPanel;
    private javax.swing.JLabel electionTitle;
    // End of variables declaration//GEN-END:variables
}
