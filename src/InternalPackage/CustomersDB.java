package InternalPackage;


import InCustomer.AccCustomerDB;
import InCustomer.OrderDB;
import config.Session;
import config.dbconnect;
import java.awt.Color;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.border.Border;
import net.proteanit.sql.DbUtils;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Administrator
 */
public class CustomersDB extends javax.swing.JFrame {

    
    public CustomersDB() {
        initComponents();
        displayData();
        loadProfilePicture();       
        displayFoodCounts();
    }

   Color hover = new Color(102,102,102);  
    Color defbutton = new Color(204,204,204);  
    Color lightGray = new Color(211, 211, 211);
    Color lightBlue = new Color(173, 216, 230);
    Border empty = BorderFactory.createEmptyBorder();
    
    void resetButtonColor(JButton button){
        button.setBackground(defbutton);
    }
    
           public void loadProfilePicture() {
    String username = dbconnect.loggedInUsername;

    if (username == null || username.isEmpty()) {
        setDefaultProfilePicture();
        return;
    }

    try (Connection con = dbconnect.getConnection();
         PreparedStatement pst = con.prepareStatement("SELECT profile_picture FROM customer WHERE cs_user = ?")) {

        pst.setString(1, username);
        ResultSet rs = pst.executeQuery();

        if (rs.next()) {
            String imagePath = rs.getString("profile_picture");

            if (imagePath != null && !imagePath.isEmpty()) {
                File imageFile = new File(imagePath);

                if (!imageFile.isAbsolute()) {
                    imageFile = new File("src/" + imagePath);  // fallback
                }

                if (imageFile.exists()) {
                    setProfilePicture(imageFile);
                    return;
                }
            }
        }

    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Error loading profile picture: " + e.getMessage());
    }

    setDefaultProfilePicture(); // fallback to default if anything fails
}

private void setProfilePicture(File imageFile) {
    try {
        BufferedImage img = ImageIO.read(imageFile);
        ImageIcon icon = new ImageIcon(img.getScaledInstance(pfp.getWidth(), pfp.getHeight(), Image.SCALE_SMOOTH));
        pfp.setIcon(icon);
    } catch (IOException e) {
        JOptionPane.showMessageDialog(null, "Error setting profile picture: " + e.getMessage());
        setDefaultProfilePicture();
    }
}

private void setDefaultProfilePicture() {
    try {
        URL defaultImageUrl = getClass().getResource("/pfpimage/default.png");

        if (defaultImageUrl != null) {
            BufferedImage img = ImageIO.read(defaultImageUrl);
            ImageIcon icon = new ImageIcon(img.getScaledInstance(pfp.getWidth(), pfp.getHeight(), Image.SCALE_SMOOTH));
            pfp.setIcon(icon);
        } else {
            JOptionPane.showMessageDialog(null, "Default profile image is missing!", "Warning", JOptionPane.WARNING_MESSAGE);
            pfp.setIcon(null);
        }
    } catch (IOException e) {
        JOptionPane.showMessageDialog(null, "Error loading default image: " + e.getMessage());
        pfp.setIcon(null);
    }
}

public void displayData(){
        
        try{
            dbconnect dbc = new dbconnect();
            ResultSet rs = dbc.getData("SELECT a_id, a_name , a_rate, a_location, a_status FROM area_tbl");           
            cuisine.setModel(DbUtils.resultSetToTableModel(rs));
            
            
        }catch(SQLException ex){
            System.out.println("Errors"+ex.getMessage());
        }
}    

    public void displayFoodCounts() {
        try {
            dbconnect dbc = new dbconnect();
            ResultSet rs = dbc.getData("SELECT a_location, COUNT(*) AS count FROM area_tbl GROUP BY a_location");

            int underCount = (0);
            int groundCount = (0);
            int secondCount = (0);
            int gardenCount = (0);

            while (rs.next()) {
                String category = rs.getString("a_location");
                int count = rs.getInt("count");

                if ("under".equalsIgnoreCase(category)) {
                    underCount = count;
                } else if ("ground".equalsIgnoreCase(category)) {
                    groundCount = count;
                } else if ("second".equalsIgnoreCase(category)) {
                    secondCount = count;
                } else if ("garden".equalsIgnoreCase(category)) {
                    gardenCount = count;
                }
            }

            // Example: Update labels in your GUI (make sure these labels exist!)
            MealsLabel.setText("UNDER GROUNDS: " + underCount);
            DrinksLabel.setText("GROUND FLOORS:" + groundCount);
            SnacksLabel.setText("SECOND FLOORS: " + secondCount);
            DessertLabel.setText("GRADEN AEAS: " + gardenCount);

        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        acc = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        acc2 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        acc3 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        db = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        cs_name = new javax.swing.JLabel();
        pfp = new javax.swing.JLabel();
        cs_order = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        cuisine = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        MealsLabel = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        DrinksLabel = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        SnacksLabel = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        DessertLabel = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel1MouseClicked(evt);
            }
        });
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(173, 216, 230));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        acc.setBackground(new java.awt.Color(173, 216, 230));
        acc.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                accMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                accMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                accMouseExited(evt);
            }
        });
        acc.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel4.setText("ACCOUNT");
        acc.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 20, -1, 20));
        acc.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, -1, -1));

        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconss/account (1).png"))); // NOI18N
        acc.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 16, -1, -1));

        acc2.setBackground(new java.awt.Color(204, 204, 204));
        acc2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                acc2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                acc2MouseExited(evt);
            }
        });
        acc2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel11.setFont(new java.awt.Font("Lucida Sans Unicode", 1, 18)); // NOI18N
        jLabel11.setText("ACCOUNT");
        acc2.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 20, -1, 20));
        acc2.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, -1, -1));

        jLabel19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICONS/account1-removebg-preview (1).png"))); // NOI18N
        acc2.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        acc3.setBackground(new java.awt.Color(204, 204, 204));
        acc3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                acc3MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                acc3MouseExited(evt);
            }
        });
        acc3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel12.setFont(new java.awt.Font("Lucida Sans Unicode", 1, 18)); // NOI18N
        jLabel12.setText("ACCOUNT");
        acc3.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 20, -1, 20));
        acc3.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, -1, -1));

        jLabel20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICONS/account1-removebg-preview (1).png"))); // NOI18N
        acc3.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        acc2.add(acc3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 390, 180, 50));

        acc.add(acc2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 380, 180, 50));

        jPanel2.add(acc, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 340, 180, 50));

        db.setBackground(new java.awt.Color(173, 216, 230));
        db.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                dbMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                dbMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                dbMouseExited(evt);
            }
        });
        db.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("DASHBOARD");
        db.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, -1, 20));
        db.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, -1, -1));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconss/dashboard.png"))); // NOI18N
        db.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 16, -1, -1));

        jPanel2.add(db, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 240, 180, 50));

        cs_name.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        cs_name.setText("Hello");
        jPanel2.add(cs_name, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 170, 120, -1));

        pfp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconss/customer-service.png"))); // NOI18N
        jPanel2.add(pfp, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 140, 140));

        cs_order.setBackground(new java.awt.Color(173, 216, 230));
        cs_order.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cs_orderMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                cs_orderMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                cs_orderMouseExited(evt);
            }
        });
        cs_order.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel5.setText("TRANSACTION");
        cs_order.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, -1, 20));
        cs_order.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, -1, -1));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconss/payment-gateway.png"))); // NOI18N
        cs_order.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(8, 10, -1, -1));

        jPanel2.add(cs_order, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 290, 180, 50));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 180, 560));

        jPanel3.setBackground(new java.awt.Color(173, 216, 230));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane1.setViewportView(cuisine);

        jPanel3.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 640, 250));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 230, 660, 270));
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 130, -1, -1));

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        MealsLabel.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        MealsLabel.setText("UNDER GROUNDS");
        jPanel5.add(MealsLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 160, -1));

        jPanel1.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 80, 170, 40));

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        DrinksLabel.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        DrinksLabel.setText("GROUND FLOORS");
        jPanel6.add(DrinksLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 160, -1));

        jPanel1.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 140, 170, 40));

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        SnacksLabel.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        SnacksLabel.setText("SECOND FLOORS");
        jPanel7.add(SnacksLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 160, -1));

        jPanel1.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 80, 160, 40));

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));
        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        DessertLabel.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        DessertLabel.setText("GARDEN AREAS");
        jPanel8.add(DessertLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 150, -1));

        jPanel1.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 140, 160, 40));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 153, 153));
        jLabel9.setText("Choose your favorite parking area");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 200, -1, -1));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 22)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(102, 102, 102));
        jLabel8.setText("CUSTOMER'S DASHBOARD");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 10, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 863, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 513, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void accMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_accMouseEntered
        acc.setBackground(lightGray);
    }//GEN-LAST:event_accMouseEntered

    private void accMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_accMouseExited
        acc.setBackground(lightBlue);
    }//GEN-LAST:event_accMouseExited

    private void dbMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dbMouseClicked
        
    }//GEN-LAST:event_dbMouseClicked

    private void dbMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dbMouseEntered
        db.setBackground(lightGray);
    }//GEN-LAST:event_dbMouseEntered

    private void dbMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dbMouseExited
        db.setBackground(lightBlue);
    }//GEN-LAST:event_dbMouseExited

    private void jPanel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel1MouseClicked

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
       Session sess = Session.getInstance();     
        cs_name.setText("" +sess.getFname()); 
    }//GEN-LAST:event_formWindowActivated

    private void cs_orderMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cs_orderMouseEntered
        cs_order.setBackground(lightGray);
    }//GEN-LAST:event_cs_orderMouseEntered

    private void cs_orderMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cs_orderMouseExited
        cs_order.setBackground(lightBlue);
    }//GEN-LAST:event_cs_orderMouseExited

    private void acc3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_acc3MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_acc3MouseEntered

    private void acc3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_acc3MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_acc3MouseExited

    private void acc2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_acc2MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_acc2MouseEntered

    private void acc2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_acc2MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_acc2MouseExited

    private void accMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_accMouseClicked
       AccCustomerDB acb = new AccCustomerDB();
       acb.setVisible(true);
       this.dispose();
    }//GEN-LAST:event_accMouseClicked

    private void cs_orderMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cs_orderMouseClicked
       OrderDB odb = new OrderDB();
       odb.setVisible(true);
       this.dispose();
    }//GEN-LAST:event_cs_orderMouseClicked

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
       loadProfilePicture();
    }//GEN-LAST:event_formWindowOpened

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
            java.util.logging.Logger.getLogger(CustomersDB.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CustomersDB.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CustomersDB.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CustomersDB.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CustomersDB().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel DessertLabel;
    private javax.swing.JLabel DrinksLabel;
    private javax.swing.JLabel MealsLabel;
    private javax.swing.JLabel SnacksLabel;
    private javax.swing.JPanel acc;
    private javax.swing.JPanel acc2;
    private javax.swing.JPanel acc3;
    private javax.swing.JLabel cs_name;
    private javax.swing.JPanel cs_order;
    private javax.swing.JTable cuisine;
    private javax.swing.JPanel db;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
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
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel pfp;
    // End of variables declaration//GEN-END:variables
}
