/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tripledes;

import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author Shamika Algawatta
 */
public class MainWindow extends javax.swing.JFrame {

    /**
     * Creates new form MainWindow
     */
    public MainWindow() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        EncBtn = new javax.swing.JButton();
        DecBtn = new javax.swing.JButton();
        OpenBtn = new javax.swing.JButton();
        PathLbl = new javax.swing.JLabel();
        TopicLbl = new javax.swing.JLabel();
        Chooselbl = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        EncBtn.setText("Encrypt");
        EncBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EncBtnActionPerformed(evt);
            }
        });

        DecBtn.setText("Decrypt");
        DecBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DecBtnActionPerformed(evt);
            }
        });

        OpenBtn.setText("Open");
        OpenBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OpenBtnActionPerformed(evt);
            }
        });

        TopicLbl.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        TopicLbl.setText("Triple DES Encryption");

        Chooselbl.setText("Choose the file");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(TopicLbl)
                        .addContainerGap(71, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(PathLbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(EncBtn)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(DecBtn)))
                        .addGap(87, 87, 87))))
            .addGroup(layout.createSequentialGroup()
                .addGap(155, 155, 155)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(OpenBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Chooselbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(TopicLbl)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                .addComponent(Chooselbl)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(OpenBtn)
                .addGap(18, 18, 18)
                .addComponent(PathLbl)
                .addGap(52, 52, 52)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(DecBtn)
                    .addComponent(EncBtn))
                .addGap(45, 45, 45))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
String path="";
String pathdir="";
    private void OpenBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OpenBtnActionPerformed
       
       JFileChooser jc=new JFileChooser();
        jc.setCurrentDirectory(new java.io.File("."));
        jc.setDialogTitle("Open a file to Encrypt or Decrypt");
        jc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
         int returnVal = jc.showOpenDialog(this);

        if (returnVal == JFileChooser.APPROVE_OPTION) {
        path=jc.getSelectedFile().getAbsolutePath();
        pathdir=jc.getCurrentDirectory().getAbsolutePath();
        PathLbl.setText(path);
    }//GEN-LAST:event_OpenBtnActionPerformed
    }
    private void EncBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EncBtnActionPerformed
        if(path.equals("")){
            
             JOptionPane.showMessageDialog(null,"Select a file");
        }
        else{
            
            try {
                TripleDes td = new TripleDes(path);
                long duration=td.Encrypt(pathdir);
               JOptionPane.showMessageDialog(null,"Time duration is "+duration+" ms");
            } catch (FileNotFoundException ex) {
                Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
            }
         
}
    }//GEN-LAST:event_EncBtnActionPerformed

    private void DecBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DecBtnActionPerformed
      if(path.equals("")){
            
             JOptionPane.showMessageDialog(null,"Select a file");
        }
        else{
           
          try {
              TripleDes  td = new TripleDes(path);
                          long duration=td.Decrypt(pathdir);
                        JOptionPane.showMessageDialog(null,"Time duration is "+duration+" ms");


          } catch (FileNotFoundException ex) {
              Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
          }
}
    }//GEN-LAST:event_DecBtnActionPerformed
    
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
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainWindow().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Chooselbl;
    private javax.swing.JButton DecBtn;
    private javax.swing.JButton EncBtn;
    private javax.swing.JButton OpenBtn;
    private javax.swing.JLabel PathLbl;
    private javax.swing.JLabel TopicLbl;
    // End of variables declaration//GEN-END:variables
}
