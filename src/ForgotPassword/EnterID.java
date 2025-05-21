/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ForgotPassword;

import OutsidePackage.login;
import config.dbconnect;
import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Administrator
 */
public class EnterID extends javax.swing.JFrame {

    /**
     * Creates new form EnterID
     */
    public EnterID() {
        initComponents();
    }
    Color lightGray = new Color(211, 211, 211);
    Color lightBlue = new Color(173, 216, 230);
    Color charcoal = new Color(28, 28, 28);
    Color teal = new Color(0, 128, 128);
   
        
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        proceed = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        id = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("Enter your account ID*");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 150, -1, -1));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(153, 153, 153));
        jLabel1.setText("Find Your Account");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 40, -1, -1));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconss/logout (2).png"))); // NOI18N
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 200, -1, 30));

        jPanel2.setBackground(new java.awt.Color(173, 216, 230));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 490, 30));

        proceed.setBackground(new java.awt.Color(173, 216, 230));
        proceed.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                proceedMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                proceedMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                proceedMouseExited(evt);
            }
        });
        proceed.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setForeground(new java.awt.Color(153, 153, 153));
        jLabel4.setText("Proceed");
        proceed.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(17, 7, -1, -1));

        jPanel1.add(proceed, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 200, 80, 30));
        jPanel1.add(id, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 100, 250, 40));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 480, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        login lg = new login();
        lg.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel3MouseClicked

    private void proceedMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_proceedMouseClicked
       String enteredUserId = id.getText().trim(); // Get user input

if (enteredUserId.isEmpty()) {
    JOptionPane.showMessageDialog(null, "Please enter a User ID!", "Warning", JOptionPane.WARNING_MESSAGE);
    return;
}

try (Connection conn = dbconnect.getConnection();
     PreparedStatement pst = conn.prepareStatement("SELECT cs_user FROM customer WHERE id = ?")) {

    pst.setString(1, enteredUserId);
    ResultSet rs = pst.executeQuery();

    if (rs.next()) {
        JOptionPane.showMessageDialog(null, "User ID Exists!\nUsername: " + rs.getString("cs_user"),
                                      "Success", JOptionPane.INFORMATION_MESSAGE);

     
        Verification vf = new Verification(enteredUserId); 
        vf.setVisible(true);
        this.dispose(); // Close current window
        
    } else {
        JOptionPane.showMessageDialog(null, "User ID doesn't exist!", "Failed", JOptionPane.ERROR_MESSAGE);
    }

} catch (SQLException ex) {
    ex.printStackTrace();
    JOptionPane.showMessageDialog(null, "SQL Error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }
    }//GEN-LAST:event_proceedMouseClicked

    private void proceedMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_proceedMouseEntered
       proceed.setBackground(lightGray);
    }//GEN-LAST:event_proceedMouseEntered

    private void proceedMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_proceedMouseExited
        proceed.setBackground(lightBlue);
    }//GEN-LAST:event_proceedMouseExited

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
            java.util.logging.Logger.getLogger(EnterID.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EnterID.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EnterID.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EnterID.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EnterID().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField id;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel proceed;
    // End of variables declaration//GEN-END:variables
}
