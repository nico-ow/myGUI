package OutsidePackage;


import config.dbconnect;
import config.passwordHasher;
import java.awt.Color;
import java.awt.Font;
import java.awt.HeadlessException;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Arrays;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.border.Border;


public class regform extends javax.swing.JFrame {

   List<String> existingUsernames = Arrays.asList("cs_user");
   List<String> existingEmails = Arrays.asList("cs_email");
   
    
    
    public regform() {
        initComponents();
        noteaddress.setText("Optional");
    noteaddress.setForeground(new Color(153, 153, 153));
    }
    
    

    Color hover = new Color(153,153,153);  
    Color defbutton = new Color(102,102,102);  
    
    Border empty = BorderFactory.createEmptyBorder();
    
    void resetButtonColor(JButton button){
        button.setBackground(defbutton);
    }
    Color lightGray = new Color(211, 211, 211);
    Color lightBlue = new Color(173, 216, 230);
    Color charcoal = new Color(28, 28, 28);
    Color teal = new Color(0, 128, 128);
    
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jSpinner1 = new javax.swing.JSpinner();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        logintext = new javax.swing.JLabel();
        reguname = new javax.swing.JTextField();
        fname = new javax.swing.JTextField();
        email = new javax.swing.JTextField();
        contact = new javax.swing.JTextField();
        address = new javax.swing.JTextField();
        noteaddress = new javax.swing.JTextField();
        lname = new javax.swing.JTextField();
        regconfirmpass = new javax.swing.JPasswordField();
        regpass = new javax.swing.JPasswordField();
        type = new javax.swing.JComboBox<>();
        cancel = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        signup = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

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

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setText("Confirm Password*");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 250, -1, -1));

        jLabel17.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel17.setText("Username*");
        jPanel2.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 250, -1, -1));

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel15.setText("Contact Number*");
        jPanel2.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 170, -1, -1));

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel14.setText("Email Address*");
        jPanel2.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 90, -1, -1));

        jLabel20.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel20.setText("Password*");
        jPanel2.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 250, -1, -1));

        jLabel19.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel19.setText("Note Address*");
        jPanel2.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 170, -1, -1));

        jLabel18.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel18.setText("Address*");
        jPanel2.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 170, -1, -1));

        jLabel16.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel16.setText("Last Name*");
        jPanel2.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 90, -1, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("Type*");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 320, -1, -1));

        jLabel21.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel21.setText("First Name*");
        jPanel2.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 90, -1, -1));

        logintext.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        logintext.setForeground(new java.awt.Color(173, 216, 230));
        logintext.setText("Signup");
        jPanel2.add(logintext, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 20, -1, -1));
        jPanel2.add(reguname, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 270, 180, 30));

        fname.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                fnameFocusLost(evt);
            }
        });
        jPanel2.add(fname, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 110, 180, 30));
        jPanel2.add(email, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 110, 180, 30));
        jPanel2.add(contact, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 190, 180, 30));
        jPanel2.add(address, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 190, 180, 30));
        jPanel2.add(noteaddress, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 190, 180, 30));

        lname.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                lnameFocusLost(evt);
            }
        });
        jPanel2.add(lname, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 110, 180, 30));
        jPanel2.add(regconfirmpass, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 270, 180, 30));
        jPanel2.add(regpass, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 270, 180, 30));

        type.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select", "Manager", "Customer", " " }));
        jPanel2.add(type, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 340, 180, 30));

        cancel.setBackground(new java.awt.Color(173, 216, 230));
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

        jLabel2.setForeground(new java.awt.Color(102, 102, 102));
        jLabel2.setText("Cancel");
        cancel.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(29, 7, -1, -1));

        jPanel2.add(cancel, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 340, 100, 30));

        signup.setBackground(new java.awt.Color(173, 216, 230));
        signup.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                signupMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                signupMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                signupMouseExited(evt);
            }
        });
        signup.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 102, 102));
        jLabel1.setText("Sign Up");
        signup.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(29, 7, -1, -1));

        jPanel2.add(signup, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 340, 100, 30));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 70, 660, 420));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconss/Screenshot 2025-05-18 181530.png"))); // NOI18N
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(-30, 0, 910, 590));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jPanel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel1MouseClicked

    private void signupMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_signupMouseClicked
        dbconnect dbc = new dbconnect();
        boolean isValid = true;

    String username = reguname.getText().trim();
    String emails = email.getText().trim();

    StringBuilder errorMessages = new StringBuilder();

    // First Name Validation
    if (fname.getText().isEmpty()) {
        fname.setBorder(BorderFactory.createLineBorder(Color.RED));
        errorMessages.append("First name is required.\n");
        isValid = false;
    } else {
        fname.setBorder(BorderFactory.createLineBorder(Color.GRAY));
    }

    // Last Name Validation
    if (lname.getText().isEmpty()) {
        lname.setBorder(BorderFactory.createLineBorder(Color.RED));
        errorMessages.append("Last name is required.\n");
        isValid = false;
    } else {
        lname.setBorder(BorderFactory.createLineBorder(Color.GRAY));
    }

    // Email Validation
    if (email.getText().isEmpty()) {
        email.setBorder(BorderFactory.createLineBorder(Color.RED));
        errorMessages.append("Email is required.\n");
        isValid = false;
    } else {
        email.setBorder(BorderFactory.createLineBorder(Color.GRAY));
    }

    // Check if Email already exists in the list
    if (existingEmails.contains(email.getText())) {
        email.setBorder(BorderFactory.createLineBorder(Color.RED));
        errorMessages.append("Email is already registered.\n");
        isValid = false;
    }

    // Email Format Validation
    if (!email.getText().matches("^[a-zA-Z0-9._%+-]+@[a-zAZ0-9.-]+\\.[a-zA-Z]{2,6}$")) {
        email.setBorder(BorderFactory.createLineBorder(Color.RED));
        errorMessages.append("Email must be in the format 'username@domain.com'.\n");
        isValid = false;
    } else {
        email.setBorder(BorderFactory.createLineBorder(Color.GRAY));
    }

    // Contact Number Validation
    if (contact.getText().isEmpty()) {
        contact.setBorder(BorderFactory.createLineBorder(Color.RED));
        errorMessages.append("Contact number is required.\n");
        isValid = false;
    } else {
        contact.setBorder(BorderFactory.createLineBorder(Color.GRAY));
    }

    String contactNumber = contact.getText().trim();
    if (!contactNumber.matches("\\d{11}")) {
        contact.setBorder(BorderFactory.createLineBorder(Color.RED));
        errorMessages.append("Contact number must contain exactly 11 digits.\n");
        isValid = false;
    } else {
        contact.setBorder(BorderFactory.createLineBorder(Color.GRAY));
    }

    // Username Validation
    if (username.isEmpty()) {
        reguname.setBorder(BorderFactory.createLineBorder(Color.RED));
        errorMessages.append("Username is required.\n");
        isValid = false;
    } else {
        reguname.setBorder(BorderFactory.createLineBorder(Color.GRAY));
    }

    // Check if Username already exists
    if (existingUsernames.contains(username)) {
        reguname.setBorder(BorderFactory.createLineBorder(Color.RED));
        errorMessages.append("Username is already taken.\n");
        isValid = false;
    }

    // Password Length Validation
    if (regpass.getPassword().length < 8) {
        regpass.setBorder(BorderFactory.createLineBorder(Color.RED));
        errorMessages.append("Password must contain at least 8 characters.\n");
        isValid = false;
    } else {
        regpass.setBorder(BorderFactory.createLineBorder(Color.GRAY));
    }

    // Password Match Validation
    if (!String.valueOf(regpass.getPassword()).equals(String.valueOf(regconfirmpass.getPassword()))) {
        regconfirmpass.setBorder(BorderFactory.createLineBorder(Color.RED));
        errorMessages.append("Passwords do not match.\n");
        isValid = false;
    } else {
        regpass.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        regconfirmpass.setBorder(BorderFactory.createLineBorder(Color.GRAY));
    }

    // Address Validation
    if (address.getText().isEmpty()) {
        address.setBorder(BorderFactory.createLineBorder(Color.RED));
        errorMessages.append("Address is required.\n");
        isValid = false;
    } else {
        address.setBorder(BorderFactory.createLineBorder(Color.GRAY));
    }

    // Account Type Validation
    if (type.getSelectedIndex() == 0) {
        type.setBorder(BorderFactory.createLineBorder(Color.RED));
        errorMessages.append("Account type must be selected.\n");
        isValid = false;
    } else {
        type.setBorder(BorderFactory.createLineBorder(Color.GRAY));
    }

    // Password Empty Check
    if (regpass.getPassword().length == 0) {
        regpass.setBorder(BorderFactory.createLineBorder(Color.RED));
        errorMessages.append("Password is required.\n");
        isValid = false;
    } else {
        regpass.setBorder(BorderFactory.createLineBorder(Color.GRAY));
    }

    // Confirm Password Empty Check
    if (regconfirmpass.getPassword().length == 0) {
        regconfirmpass.setBorder(BorderFactory.createLineBorder(Color.RED));
        errorMessages.append("Confirm password is required.\n");
        isValid = false;
    } else {
        regconfirmpass.setBorder(BorderFactory.createLineBorder(Color.GRAY));
    }

    try {
        // Final Validation Check (Do this before inserting into the database)
        if (!isValid) {
            JOptionPane.showMessageDialog(null, errorMessages.toString(), "Error", JOptionPane.ERROR_MESSAGE);
            return; // Stop execution if validation fails
        }

        // Hash the password properly
        char[] passwordChars = regpass.getPassword();
        String pass = passwordHasher.hashPassword(new String(passwordChars));
        Arrays.fill(passwordChars, ' '); // Clear password from memory for security

        // Set the default profile picture
        String profilePicture = "pfpimage/default.jpg";  // Set the path to the default profile picture

        // SQL Query with profile picture path
        String sql = "INSERT INTO customer (cs_fname, cs_lname, cs_email, cs_contact, cs_user, cs_pass, cs_address, cs_type, cs_status, profile_picture) "
                + "VALUES ('" + fname.getText().replace("'", "''") + "','" 
                + lname.getText().replace("'", "''") + "','" 
                + email.getText().replace("'", "''") + "','" 
                + contact.getText().replace("'", "''") + "','" 
                + reguname.getText().replace("'", "''") + "','" 
                + pass + "','"  // Use hashed password instead of plain text
                + address.getText().replace("'", "''") + "','" 
                + type.getSelectedItem().toString().replace("'", "''") + "','Pending', ?)";

        // Database Insertion
        try (PreparedStatement pst = dbc.getConnection().prepareStatement(sql)) {
            pst.setString(1, profilePicture); // Set the profile picture column
            int result = pst.executeUpdate();

            if (result == 1) {
                JOptionPane.showMessageDialog(null, "Registration Completed", "Success", JOptionPane.INFORMATION_MESSAGE);
                login lg = new login();
                this.dispose();
                lg.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(null, "Database insertion failed. Please try again.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Database Error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

    } catch (HeadlessException ex) { // Catch general exceptions to avoid unexpected crashes
        Logger.getLogger(regform.class.getName()).log(Level.SEVERE, "Unexpected error", ex);
        JOptionPane.showMessageDialog(null, "An unexpected error occurred: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }
    }//GEN-LAST:event_signupMouseClicked

    private void cancelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cancelMouseClicked
        login lg = new login(); 
        this.dispose();
        lg.setVisible(true);
        
    }//GEN-LAST:event_cancelMouseClicked

    private void cancelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cancelMouseEntered
        cancel.setBackground(lightGray);
    }//GEN-LAST:event_cancelMouseEntered

    private void cancelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cancelMouseExited
         cancel.setBackground(lightBlue);
    }//GEN-LAST:event_cancelMouseExited

    private void signupMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_signupMouseEntered
        signup.setBackground(lightGray);
    }//GEN-LAST:event_signupMouseEntered

    private void signupMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_signupMouseExited
       signup.setBackground(lightBlue);
    }//GEN-LAST:event_signupMouseExited

    private void fnameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_fnameFocusLost
      
    }//GEN-LAST:event_fnameFocusLost

    private void lnameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_lnameFocusLost
   
    }//GEN-LAST:event_lnameFocusLost


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
            java.util.logging.Logger.getLogger(regform.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(regform.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(regform.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(regform.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new regform().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField address;
    private javax.swing.JPanel cancel;
    private javax.swing.JTextField contact;
    private javax.swing.JTextField email;
    private javax.swing.JTextField fname;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSpinner jSpinner1;
    private javax.swing.JTextField lname;
    private javax.swing.JLabel logintext;
    private javax.swing.JTextField noteaddress;
    private javax.swing.JPasswordField regconfirmpass;
    private javax.swing.JPasswordField regpass;
    private javax.swing.JTextField reguname;
    private javax.swing.JPanel signup;
    private javax.swing.JComboBox<String> type;
    // End of variables declaration//GEN-END:variables
}
