/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package InManage;

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
public class ChangePassword extends javax.swing.JFrame {

    /**
     * Creates new form ChangePassword
     */
    public ChangePassword() {
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
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        newpass1 = new javax.swing.JPasswordField();
        oldpass = new javax.swing.JPasswordField();
        jPasswordField3 = new javax.swing.JPasswordField();
        newpass = new javax.swing.JPasswordField();
        cancel = new javax.swing.JPanel();
        Cancel = new javax.swing.JLabel();
        save = new javax.swing.JPanel();
        Cancel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(173, 216, 230));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 350, 30));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 102, 102));
        jLabel1.setText("CHANGE PASSWORD");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 30, 220, 40));

        jLabel13.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel13.setText("Type Old Password*");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 100, -1, -1));

        jLabel14.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel14.setText("Type New Password*");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 180, -1, -1));

        jLabel16.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel16.setText("Re-Type New Password*");
        jPanel1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 260, -1, -1));

        newpass1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newpass1ActionPerformed(evt);
            }
        });
        jPanel1.add(newpass1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 290, 240, 40));
        jPanel1.add(oldpass, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 130, 240, 40));

        jPasswordField3.setText("jPasswordField1");
        jPanel1.add(jPasswordField3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 130, 240, 40));

        newpass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newpassActionPerformed(evt);
            }
        });
        jPanel1.add(newpass, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 210, 240, 40));

        cancel.setBackground(new java.awt.Color(173, 216, 230));
        cancel.addHierarchyListener(new java.awt.event.HierarchyListener() {
            public void hierarchyChanged(java.awt.event.HierarchyEvent evt) {
                cancelHierarchyChanged(evt);
            }
        });
        cancel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cancelMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                cancelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                cancelMouseExited(evt);
            }
        });
        cancel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Cancel.setForeground(new java.awt.Color(153, 153, 153));
        Cancel.setText("Cancel");
        cancel.add(Cancel, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jPanel1.add(cancel, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 350, 100, 30));

        save.setBackground(new java.awt.Color(173, 216, 230));
        save.addHierarchyListener(new java.awt.event.HierarchyListener() {
            public void hierarchyChanged(java.awt.event.HierarchyEvent evt) {
                saveHierarchyChanged(evt);
            }
        });
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

        Cancel1.setForeground(new java.awt.Color(153, 153, 153));
        Cancel1.setText("Save");
        save.add(Cancel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, -1, -1));

        jPanel1.add(save, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 350, 100, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 340, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 399, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void newpass1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newpass1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_newpass1ActionPerformed

    private void newpassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newpassActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_newpassActionPerformed

    private void cancelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cancelMouseClicked
         AccManagerDB amdb = new AccManagerDB();
        this.dispose();
        amdb.setVisible(true);

    }//GEN-LAST:event_cancelMouseClicked

    private void cancelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cancelMouseEntered
        cancel.setBackground(lightGray);
    }//GEN-LAST:event_cancelMouseEntered

    private void cancelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cancelMouseExited
        cancel.setBackground(lightBlue);
    }//GEN-LAST:event_cancelMouseExited

    private void cancelHierarchyChanged(java.awt.event.HierarchyEvent evt) {//GEN-FIRST:event_cancelHierarchyChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_cancelHierarchyChanged

    private void saveHierarchyChanged(java.awt.event.HierarchyEvent evt) {//GEN-FIRST:event_saveHierarchyChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_saveHierarchyChanged

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
            AccManagerDB amb = new AccManagerDB();
            amb.setVisible(true);
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
            java.util.logging.Logger.getLogger(ChangePassword.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ChangePassword.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ChangePassword.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ChangePassword.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ChangePassword().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Cancel;
    private javax.swing.JLabel Cancel1;
    private javax.swing.JPanel cancel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPasswordField jPasswordField3;
    private javax.swing.JPasswordField newpass;
    private javax.swing.JPasswordField newpass1;
    private javax.swing.JPasswordField oldpass;
    private javax.swing.JPanel save;
    // End of variables declaration//GEN-END:variables
}
