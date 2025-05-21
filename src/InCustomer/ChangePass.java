/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package InCustomer;

import InCustomer.*;
import config.Session;
import config.dbconnect;
import config.passwordHasher;
import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.border.Border;

/**
 *
 * @author Administrator
 */
public class ChangePass extends javax.swing.JFrame {

    /**
     * Creates new form ChangePass
     */
    public ChangePass() {
        initComponents();
    }

   Color hover = new Color(153,153,153);  
    Color defbutton = new Color(102,102,102);
    Color lightGray = new Color(211, 211, 211);
    Color lightBlue = new Color(173, 216, 230);
    
    Border empty = BorderFactory.createEmptyBorder();
    
    void resetButtonColor(JButton button){
        button.setBackground(defbutton);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        newpass1 = new javax.swing.JPasswordField();
        oldpass = new javax.swing.JPasswordField();
        newpass = new javax.swing.JPasswordField();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        save = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 102, 102));
        jLabel1.setText("CHANGE PASSWORD");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 30, 190, 40));

        jPanel2.setBackground(new java.awt.Color(173, 216, 230));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 310, 30));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconss/logout (2).png"))); // NOI18N
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 350, -1, -1));

        newpass1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newpass1ActionPerformed(evt);
            }
        });
        jPanel1.add(newpass1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 280, 220, 30));

        oldpass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                oldpassActionPerformed(evt);
            }
        });
        jPanel1.add(oldpass, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 120, 220, 30));
        jPanel1.add(newpass, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 200, 220, 30));

        jLabel13.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel13.setText("Type Old Password*");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 100, -1, -1));

        jLabel14.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel14.setText("Type New Password*");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 180, -1, -1));

        jLabel16.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel16.setText("Re-Type New Password*");
        jPanel1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 260, -1, -1));

        save.setBackground(new java.awt.Color(173, 216, 230));
        save.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                saveMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                saveMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                saveMouseExited(evt);
            }
        });
        save.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setForeground(new java.awt.Color(102, 102, 102));
        jLabel3.setText("Save");
        save.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jPanel1.add(save, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 330, 90, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 386, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        AccCustomerDB amdb = new AccCustomerDB();
        this.dispose();
        amdb.setVisible(true);
    }//GEN-LAST:event_jLabel2MouseClicked

    private void newpass1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newpass1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_newpass1ActionPerformed

    private void oldpassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_oldpassActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_oldpassActionPerformed

    private void saveMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_saveMouseClicked
         try {          
    dbconnect dbc = new dbconnect();
    Session sess = Session.getInstance();

    // Ensure password fields are initialized
    if (oldpass == null || newpass == null || newpass1 == null) {
        JOptionPane.showMessageDialog(null, "Error: Password fields not initialized!", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    String query = "SELECT cs_pass FROM customer WHERE id = '" + sess.getUid() + "'";    
    ResultSet rs = dbc.getData(query);

    if (rs.next()) {
        String storedPasswordHash = rs.getString("cs_pass");  // Password stored in DB
        
        String oldInput = new String(oldpass.getPassword()); 
        String oldHash = passwordHasher.hashPassword(oldInput); // Hash user input

        if (storedPasswordHash.equals(oldHash)) {    
            String newInput = new String(newpass.getPassword()); 
            String confirmInput = new String(newpass1.getPassword());

            if (newInput.length() < 8) {
                JOptionPane.showMessageDialog(null, "New password must be at least 8 characters long!", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            if (!newInput.equals(confirmInput)) {
                JOptionPane.showMessageDialog(null, "New password and confirm password do not match!", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            String newpassHash = passwordHasher.hashPassword(newInput); 
            
            String updateQuery = "UPDATE customer SET cs_pass = '" + newpassHash + "' WHERE id = '" + sess.getUid() + "'";  
            dbc.updateData(updateQuery);

            String actions = "Password Change!";
            try (Connection conn = dbc.getConnection();
                 PreparedStatement logStmt = conn.prepareStatement(
                     "INSERT INTO logs (id, actions, date) VALUES (?, ?, ?)")) {

                logStmt.setString(1, sess.getUid());
                logStmt.setString(2, actions);
                logStmt.setTimestamp(3, Timestamp.valueOf(LocalDateTime.now()));
                logStmt.executeUpdate();
            }

            JOptionPane.showMessageDialog(null, "Password updated successfully!");
            AccCustomerDB acb = new AccCustomerDB();
            acb.setVisible(true);
            this.dispose(); // if you're inside a JFrame or JDialog

        } else {    
            JOptionPane.showMessageDialog(null, "Old Password is Incorrect!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    } else {
        JOptionPane.showMessageDialog(null, "User not found!");
    }    
} catch (SQLException ex) {
    System.out.println("Error: " + ex.getMessage());
}
    }//GEN-LAST:event_saveMouseClicked

    private void saveMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_saveMouseEntered
        save.setBackground(lightGray);
    }//GEN-LAST:event_saveMouseEntered

    private void saveMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_saveMouseExited
        save.setBackground(lightBlue);
    }//GEN-LAST:event_saveMouseExited

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
            java.util.logging.Logger.getLogger(ChangePass.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ChangePass.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ChangePass.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ChangePass.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ChangePass().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPasswordField newpass;
    private javax.swing.JPasswordField newpass1;
    private javax.swing.JPasswordField oldpass;
    private javax.swing.JPanel save;
    // End of variables declaration//GEN-END:variables
}
