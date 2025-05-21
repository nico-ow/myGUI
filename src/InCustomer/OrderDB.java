/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package InCustomer;

import InCustomer.*;
import InternalPackage.CustomersDB;
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

/**
 *
 * @author Administrator
 */
public class OrderDB extends javax.swing.JFrame {

    /**
     * Creates new form OrderDB
     */
    public OrderDB() {
        initComponents();
        loadProfilePicture();
        displayData();
        displayOrderStats();
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
            ResultSet rs = dbc.getData("SELECT t_id, a_id , t_hour, t_due, t_status FROM transaction_tbl");           
            order.setModel(DbUtils.resultSetToTableModel(rs));
            
            
        }catch(SQLException ex){
            System.out.println("Errors"+ex.getMessage());
        }
        
    }

    public void displayOrderStats() {
       try {
           dbconnect dbc = new dbconnect();

           // Successful Orders
           ResultSet successRs = dbc.getData("SELECT COUNT(*) AS successful FROM transaction_tbl WHERE t_status = 'Done'");
           if (successRs.next()) {
               int successful = successRs.getInt("successful");
               succ_ord.setText("<html><center>Successful Orders<br><br>" + successful + "</center></html>");
           }

           // Pending Orders
           ResultSet pendingRs = dbc.getData("SELECT COUNT(*) AS pending FROM transaction_tbl WHERE t_status = 'Pending'");
           if (pendingRs.next()) {
               int pending = pendingRs.getInt("pending");
               pend_ord.setText("<html><center>Pending Orders<br><br>" + pending + "</center></html>");
           }

       } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null, "SQL Error: " + ex.getMessage());
       }
   }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        orderdb = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        acc3 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        accdb = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        acc1 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        db = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        csname = new javax.swing.JLabel();
        pfp = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        order = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        pend_ord = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        succ_ord = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel1MouseClicked(evt);
            }
        });
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 153, 153));
        jLabel3.setText("Order List");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 220, -1, -1));

        jPanel2.setBackground(new java.awt.Color(173, 216, 230));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        orderdb.setBackground(new java.awt.Color(173, 216, 230));
        orderdb.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                orderdbMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                orderdbMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                orderdbMouseExited(evt);
            }
        });
        orderdb.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        orderdb.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, -1, -1));

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

        orderdb.add(acc3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 330, 180, 50));

        jLabel28.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel28.setText("TRANSACTION");
        orderdb.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 20, -1, 20));

        jLabel29.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconss/payment-gateway.png"))); // NOI18N
        orderdb.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(13, 10, -1, -1));

        jPanel2.add(orderdb, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 290, 190, 50));

        accdb.setBackground(new java.awt.Color(173, 216, 230));
        accdb.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                accdbMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                accdbMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                accdbMouseExited(evt);
            }
        });
        accdb.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel4.setText("ACCOUNT");
        accdb.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 20, -1, 20));
        accdb.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, -1, -1));

        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconss/account (1).png"))); // NOI18N
        accdb.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(18, 18, -1, -1));

        acc1.setBackground(new java.awt.Color(204, 204, 204));
        acc1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                acc1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                acc1MouseExited(evt);
            }
        });
        acc1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setFont(new java.awt.Font("Lucida Sans Unicode", 1, 18)); // NOI18N
        jLabel5.setText("ACCOUNT");
        acc1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 20, -1, 20));
        acc1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, -1, -1));

        jLabel18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICONS/account1-removebg-preview (1).png"))); // NOI18N
        acc1.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        accdb.add(acc1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 330, 180, 50));

        jPanel2.add(accdb, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 340, 190, 50));

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
        db.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 20, -1, 20));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconss/dashboard.png"))); // NOI18N
        db.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 17, -1, -1));

        jPanel2.add(db, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 240, 190, 50));

        csname.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        csname.setText("Hello ");
        jPanel2.add(csname, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 170, 120, 30));

        pfp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconss/customer-service.png"))); // NOI18N
        jPanel2.add(pfp, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 150, 140));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 190, 520));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane1.setViewportView(order);

        jPanel3.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 650, 230));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 250, 670, 250));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pend_ord.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        pend_ord.setText("Transactions to Approve");
        jPanel4.add(pend_ord, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 180, -1));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICONS/pending.png"))); // NOI18N
        jPanel4.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 10, -1, 30));

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 90, 230, 120));

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        succ_ord.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        succ_ord.setText("Successfull Transactions");
        jPanel5.add(succ_ord, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, -1, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICONS/order.png"))); // NOI18N
        jPanel5.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 10, -1, -1));

        jPanel1.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 90, 190, 120));

        jPanel6.setBackground(new java.awt.Color(173, 216, 230));
        jPanel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel6MouseClicked(evt);
            }
        });
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(102, 102, 102));
        jLabel8.setText("REFRESH");
        jPanel6.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        jPanel1.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 170, 90, 30));

        jPanel7.setBackground(new java.awt.Color(173, 216, 230));
        jPanel7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel7MouseClicked(evt);
            }
        });
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(102, 102, 102));
        jLabel9.setText("ADD");
        jPanel7.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jPanel1.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 170, 90, 30));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 22)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(102, 102, 102));
        jLabel10.setText("TRANSACTION  DASHBOARD");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 10, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 880, 513));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void acc3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_acc3MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_acc3MouseEntered

    private void acc3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_acc3MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_acc3MouseExited

    private void orderdbMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_orderdbMouseClicked

    }//GEN-LAST:event_orderdbMouseClicked

    private void orderdbMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_orderdbMouseEntered
         orderdb.setBackground(lightGray);
    }//GEN-LAST:event_orderdbMouseEntered

    private void orderdbMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_orderdbMouseExited
        orderdb.setBackground(lightBlue);
    }//GEN-LAST:event_orderdbMouseExited

    private void acc1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_acc1MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_acc1MouseEntered

    private void acc1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_acc1MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_acc1MouseExited

    private void accdbMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_accdbMouseClicked
        AccCustomerDB acb = new AccCustomerDB();
        acb.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_accdbMouseClicked

    private void accdbMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_accdbMouseEntered
         accdb.setBackground(lightGray);
    }//GEN-LAST:event_accdbMouseEntered

    private void accdbMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_accdbMouseExited
        accdb.setBackground(lightBlue);
    }//GEN-LAST:event_accdbMouseExited

    private void dbMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dbMouseClicked
        CustomersDB cdb = new CustomersDB();
        cdb.setVisible(true);
        this.dispose();
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
        csname.setText(""+sess.getFname());
    }//GEN-LAST:event_formWindowActivated

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        loadProfilePicture();
    }//GEN-LAST:event_formWindowOpened

    private void jPanel7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel7MouseClicked
        AddOrder ao = new AddOrder();
        ao.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jPanel7MouseClicked

    private void jPanel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel6MouseClicked
         displayData();
    }//GEN-LAST:event_jPanel6MouseClicked

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
            java.util.logging.Logger.getLogger(OrderDB.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(OrderDB.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(OrderDB.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(OrderDB.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new OrderDB().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel acc1;
    private javax.swing.JPanel acc3;
    private javax.swing.JPanel accdb;
    private javax.swing.JLabel csname;
    private javax.swing.JPanel db;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
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
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable order;
    private javax.swing.JPanel orderdb;
    private javax.swing.JLabel pend_ord;
    private javax.swing.JLabel pfp;
    private javax.swing.JLabel succ_ord;
    // End of variables declaration//GEN-END:variables
}
