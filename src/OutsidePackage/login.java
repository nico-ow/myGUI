package OutsidePackage;


import ForgotPassword.EnterID;
import InCustomer.AccCustomerDB;
import InternalPackage.CustomersDB;
import InternalPackage.Dashboard;
import InternalPackage.ManagersDB;
import config.Session;
import config.dbconnect;
import static config.passwordHasher.hashPassword;
import java.awt.Color;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.border.Border;
import java.sql.*;
import java.time.LocalDateTime;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Administrator
 */
public class login extends javax.swing.JFrame {

    
  
    public login() {
        initComponents();
        
       
    }
    Color lightGray = new Color(211, 211, 211);
    Color lightBlue = new Color(173, 216, 230);
    Color charcoal = new Color(28, 28, 28);
    Color teal = new Color(0, 128, 128);
        
       
public static boolean login(String username, String password) {
    dbconnect db = new dbconnect();
    String query = "SELECT * FROM customer WHERE cs_user = ? AND cs_status = 'active'";

    try (Connection conn = db.getConnection();
         PreparedStatement pstmt = conn.prepareStatement(query)) {

        pstmt.setString(1, username);
        ResultSet resultSet = pstmt.executeQuery();

        if (resultSet.next()) {
            String storedPassword = resultSet.getString("cs_pass");
            String userType = resultSet.getString("cs_type");
            String hashedInputPassword = hashPassword(password);

            // Rehash if old password is plaintext
            if (!storedPassword.matches("[a-fA-F0-9]{64}")) {
                System.out.println("Rehashing old plaintext password...");
                String newHashedPassword = hashPassword(storedPassword);

                try (PreparedStatement updateStmt = conn.prepareStatement(
                        "UPDATE customer SET cs_pass = ? WHERE cs_user = ?")) {
                    updateStmt.setString(1, newHashedPassword);
                    updateStmt.setString(2, username);
                    updateStmt.executeUpdate();
                }

                storedPassword = newHashedPassword;
            }

            if (hashedInputPassword.equals(storedPassword)) {
                JOptionPane.showMessageDialog(null, "Login Successful!");

                // Store logged-in username
                dbconnect.loggedInUsername = username;

                // Load user session details
                Session sess = Session.getInstance();
                sess.setUid(resultSet.getString("id"));
                sess.setFname(resultSet.getString("cs_fname"));
                sess.setLname(resultSet.getString("cs_lname"));
                sess.setEmail(resultSet.getString("cs_email"));
                sess.setContact(resultSet.getString("cs_contact"));
                sess.setAddress(resultSet.getString("cs_address"));
                sess.setUser(username);
                sess.setType(userType);
                sess.setStatus(resultSet.getString("cs_status"));

                String actions = "Log in!";
                try (PreparedStatement logStmt = conn.prepareStatement(
                        "INSERT INTO logs (id, actions, date) VALUES (?, ?, ?)")) {
                    logStmt.setString(1, sess.getUid());
                    logStmt.setString(2, actions);
                    logStmt.setTimestamp(3, Timestamp.valueOf(LocalDateTime.now()));
                    logStmt.executeUpdate();
                }

                // Open appropriate dashboard
                switch (userType.toLowerCase()) {
                    case "customer":
                        new CustomersDB().setVisible(true);
                        break;
                    case "manager":
                        new ManagersDB().setVisible(true);
                        break;
                    case "admin":
                        new Dashboard().setVisible(true);
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "Unknown user type!", "Error", JOptionPane.ERROR_MESSAGE);
                        return false;
                }

                return true;
            } else {
                JOptionPane.showMessageDialog(null, "Wrong Username or Password!", "Error", JOptionPane.ERROR_MESSAGE);
                return false;
            }
        } else {
            JOptionPane.showMessageDialog(null, "User not found or inactive!", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Database Error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        return false;
    }
}
  
  
     Color hover = new Color(153,153,153);  
    Color defbutton = new Color(102,102,102);  
    
    Border empty = BorderFactory.createEmptyBorder();
    
    void resetButtonColor(JButton button){
        button.setBackground(defbutton);
            
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jInternalFrame1 = new javax.swing.JInternalFrame();
        jLabel4 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jTextField6 = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        username = new javax.swing.JTextField();
        logpass = new javax.swing.JPasswordField();
        jLabel6 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        requiredpass = new javax.swing.JLabel();
        requireduser = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        registerbutton = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        login = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();

        jInternalFrame1.setVisible(true);

        javax.swing.GroupLayout jInternalFrame1Layout = new javax.swing.GroupLayout(jInternalFrame1.getContentPane());
        jInternalFrame1.getContentPane().setLayout(jInternalFrame1Layout);
        jInternalFrame1Layout.setHorizontalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jInternalFrame1Layout.setVerticalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jLabel4.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel4.setText("First Name");

        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel7.setText("First Name");

        jTextField6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField6ActionPerformed(evt);
            }
        });

        jButton2.setText("jButton2");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconss/Screenshot 2025-05-18 160305.png"))); // NOI18N

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel1MouseClicked(evt);
            }
        });
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        username.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        username.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                usernameFocusLost(evt);
            }
        });
        jPanel2.add(username, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, 230, 40));

        logpass.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        logpass.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                logpassFocusLost(evt);
            }
        });
        jPanel2.add(logpass, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 90, 230, 40));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jLabel6.setText("Username");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 0, -1, -1));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jLabel9.setText("Password");
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 70, -1, -1));
        jPanel2.add(requiredpass, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 130, 230, 10));
        jPanel2.add(requireduser, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 60, 230, 10));

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconss/ipark-removebg-preview.png"))); // NOI18N
        jLabel10.setText("jLabel10");
        jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 0, -1, -1));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 80, 310, 150));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 28)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(173, 216, 230));
        jLabel3.setText("Login");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 10, -1, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel5.setText("Forgot Password");
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel5MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 360, -1, -1));

        registerbutton.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        registerbutton.setForeground(new java.awt.Color(0, 153, 153));
        registerbutton.setText(" Register here");
        registerbutton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                registerbuttonMouseClicked(evt);
            }
        });
        jPanel1.add(registerbutton, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 360, -1, -1));

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel8.setText("Don't have an account?");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 360, -1, -1));

        login.setBackground(new java.awt.Color(173, 216, 230));
        login.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                loginMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                loginMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                loginMouseExited(evt);
            }
        });
        login.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setForeground(new java.awt.Color(102, 102, 102));
        jLabel2.setText("Login");
        login.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(37, 1, -1, -1));

        jPanel1.add(login, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 240, 100, 20));

        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconss/Screenshot 2025-05-18 160305.png"))); // NOI18N
        jLabel11.setText("jLabel11");
        jPanel4.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(-360, -40, 710, 460));

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 340, 380));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 765, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 379, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void jTextField6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField6ActionPerformed

    private void jPanel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel1MouseClicked
 
    private void registerbuttonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_registerbuttonMouseClicked
       regform rfm = new regform(); 
        this.dispose(); 
        rfm.setVisible(true);
    }//GEN-LAST:event_registerbuttonMouseClicked

    private void loginMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loginMouseClicked
        String user = username.getText();
    String password = new String(logpass.getPassword()); 
   
    if (login(user, password)) {  
      System.out.println("Login successful, loading account info...");
}   else {
      System.out.println("Invalid login credentials.");
}
    }//GEN-LAST:event_loginMouseClicked

    private void loginMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loginMouseEntered
        login.setBackground(lightGray);
    }//GEN-LAST:event_loginMouseEntered

    private void loginMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loginMouseExited
        login.setBackground(lightBlue);
    }//GEN-LAST:event_loginMouseExited

    private void usernameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_usernameFocusLost
       Font smallFont = new Font("Arial", Font.PLAIN, 10);
        username.setFont(smallFont);
        requireduser.setFont(smallFont);

        String user = username.getText();

        if (user.isEmpty()) {
            username.setForeground(Color.RED);
            requireduser.setText("Username is required");
            requireduser.setForeground(Color.RED);
        } else {
            username.setForeground(Color.BLACK);
            requireduser.setText("");
        }

        username.repaint();
    }//GEN-LAST:event_usernameFocusLost

    private void logpassFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_logpassFocusLost
        Font smallFont = new Font("Arial", Font.PLAIN, 10);
        logpass.setFont(smallFont);
        requiredpass.setFont(smallFont);

        String user = logpass.getText();

        if (user.isEmpty()) {
            logpass.setForeground(Color.RED);
            requiredpass.setText("Password is required");
            requiredpass.setForeground(Color.RED);
        } else {
            logpass.setForeground(Color.BLACK);
            requiredpass.setText("");
        }

        logpass.repaint();
    }//GEN-LAST:event_logpassFocusLost

    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked
       EnterID eid = new EnterID();
       eid.setVisible(true);
       this.dispose();
    }//GEN-LAST:event_jLabel5MouseClicked

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
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton2;
    private javax.swing.JInternalFrame jInternalFrame1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JPanel login;
    private javax.swing.JPasswordField logpass;
    private javax.swing.JLabel registerbutton;
    private javax.swing.JLabel requiredpass;
    private javax.swing.JLabel requireduser;
    private javax.swing.JTextField username;
    // End of variables declaration//GEN-END:variables

}
