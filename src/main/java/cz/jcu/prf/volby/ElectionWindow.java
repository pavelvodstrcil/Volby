/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.jcu.prf.volby;

import java.awt.Font;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.List;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;

/**
 *
 * @author User
 * 
 */
public class ElectionWindow extends javax.swing.JFrame {

    
    private int height = 10;
    private List<Candidate> candi;
    private ButtonGroup candiGroup = new ButtonGroup();
    
    Person loggedPerson;
    LoginWindow lw;
    ElectionService esm;
    private ElectionDao ed = ElectionDaoImplementaion.getInstance();
    /**
     * Creates new form ElectionWindow
     */
    public ElectionWindow(LoginWindow lw) {
        initComponents();
        if (lw!=null)
            this.lw = lw;
        esm = new ElectionServiceImplementation();
        
         addWindowListener(exitListener); //REGISTER LISTENER
         
         candi = esm.getCanditates();
         //Populate logged person
         String[] personParam = ed.getPerson(lw.loginField().getText());
         loggedPerson = new Person(Integer.parseInt(personParam[0]), personParam[1], personParam[2], 0);
         //set login user
         nameLabel.setText(loggedPerson.getName());
         surnameLabel.setText(loggedPerson.getSurname());
         
         generateRadioButtons();
         
    }
    
    WindowListener exitListener = new WindowAdapter() {

    @Override
    public void windowClosing(WindowEvent e) {
        //Povolí předchozí okno
        lw.setEnabled(true);
        //Zavře okno
        dispose();
    }
};
    
    public void generateRadioButtons()
    {
        Font  f1  = new Font(Font.SERIF, Font.PLAIN,  18);
        for(int i = 0; i < candi.size(); i++)
        {
            JRadioButton button1 = new JRadioButton(candi.get(i).getFullName());
            button1.setName(Long.toString(candi.get(i).getID()));
            button1.setSize(300, 18);
            button1.setFont(f1);
            button1.setLocation(5 ,height );
            height = height + 30;
            candiPanel.add(button1);
            
            candiGroup.add(button1);
            //System.out.println(candi.get(i).getName());
            
        }
      
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        logoutButton = new javax.swing.JButton();
        nameLabel = new javax.swing.JLabel();
        surnameLabel = new javax.swing.JLabel();
        voteButton = new javax.swing.JButton();
        candiPanel = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Volební okno");
        setResizable(false);

        logoutButton.setText("Odhlásit");
        logoutButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutButtonActionPerformed(evt);
            }
        });

        nameLabel.setText("jLabel1");

        surnameLabel.setText("jLabel2");

        voteButton.setText("Hlasovat");
        voteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                voteButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout candiPanelLayout = new javax.swing.GroupLayout(candiPanel);
        candiPanel.setLayout(candiPanelLayout);
        candiPanelLayout.setHorizontalGroup(
            candiPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 269, Short.MAX_VALUE)
        );
        candiPanelLayout.setVerticalGroup(
            candiPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 179, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(150, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(nameLabel)
                            .addComponent(surnameLabel))
                        .addGap(71, 71, 71)
                        .addComponent(logoutButton)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(voteButton)
                        .addGap(185, 185, 185))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(candiPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(47, 47, 47))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(nameLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(surnameLabel))
                    .addComponent(logoutButton, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(candiPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(22, 22, 22)
                .addComponent(voteButton)
                .addGap(29, 29, 29))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void logoutButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutButtonActionPerformed
        lw.setEnabled(true);
        this.dispose();
    }//GEN-LAST:event_logoutButtonActionPerformed

    private void voteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_voteButtonActionPerformed
        // projít všechny prvky ve skupině voličů (zaškrtávátek)
        for (Enumeration<AbstractButton> buttons = candiGroup.getElements(); buttons.hasMoreElements();) {
            // přiřadit tlačítko
            AbstractButton button = buttons.nextElement();
            // pokud je nějaký volič vybraný, toho chceme volit
            if (button.isSelected()) {
                try {
                    // pomocí tlačítka si vrať ID vybraného kandidáta
                    esm.vote(loggedPerson.getID(), Long.parseLong(button.getName()));
                    // zobraz okno o potvrzení
                    JOptionPane.showMessageDialog(this, "Váš hlas byl odevzdán!", "Odevzdáno", JOptionPane.DEFAULT_OPTION);
                    return;
                } catch (DuplicateVoteException ex) {
                    JOptionPane.showMessageDialog(this, "Už jste hlasovali!", "Varování", JOptionPane.WARNING_MESSAGE);
                    return;
                } catch (NotFoundException ex) {
                    JOptionPane.showMessageDialog(this, "Vybraná osoba nebyla naleznuta", "Varování", JOptionPane.WARNING_MESSAGE);
                    return;
                }
            }
        }
        JOptionPane.showMessageDialog(this, "Nikdo nebyl zvolen", "Varování", JOptionPane.WARNING_MESSAGE);
    }//GEN-LAST:event_voteButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel candiPanel;
    private javax.swing.JButton logoutButton;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JLabel surnameLabel;
    private javax.swing.JButton voteButton;
    // End of variables declaration//GEN-END:variables
}
