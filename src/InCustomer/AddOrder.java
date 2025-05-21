/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package InCustomer;

import InCustomer.*;
import config.Session;
import config.dbconnect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author Administrator
 */
public class AddOrder extends javax.swing.JFrame {

    /**
     * Creates new form AddOrder
     */
    public AddOrder() {
        initComponents();
        displayData();
        
    }

    public void displayData(){
        
        try{
            dbconnect dbc = new dbconnect();
            ResultSet rs = dbc.getData("SELECT f_id, f_name , f_price, f_status FROM food_tbl");           
            cuisine.setModel(DbUtils.resultSetToTableModel(rs));
            
            
        }catch(SQLException ex){
            System.out.println("Errors"+ex.getMessage());
        }
        
    }
    
   public void displayProductDetails() {
    try {
        String productIdText = p_id.getText().trim();
        String quantityText = p_quantity.getText().trim();

        if (productIdText.isEmpty() || quantityText.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please enter both Product ID and Quantity first.");
            return; 
        }

        int productId = Integer.parseInt(productIdText);
        int quantity = Integer.parseInt(quantityText);

        dbconnect dbc = new dbconnect();
        ResultSet rs = dbc.getData("SELECT f_id, f_name, f_price, f_category FROM food_tbl WHERE f_id = " + productId);

        if (rs.next()) {
            String id = rs.getString("f_id");
            String name = rs.getString("f_name");
            double price = rs.getDouble("f_price");
            double totalPrice = price * quantity;

            f_id.setText("Area ID: " + id);
            f_name.setText("Area Code: " + name);
            f_quantity.setText("Hour/Hours: " + quantity);
            total.setText("Total Amount: " + totalPrice);
        } else {
            JOptionPane.showMessageDialog(null, "Parking Area not found!");
        }

    } catch (NumberFormatException ex) {
        JOptionPane.showMessageDialog(null, "Invalid input. Please enter valid numbers for Area ID and Time.");
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "SQL Error: " + ex.getMessage());
    }
}
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        f_id = new javax.swing.JLabel();
        f_name = new javax.swing.JLabel();
        f_quantity = new javax.swing.JLabel();
        total = new javax.swing.JLabel();
        p_quantity = new javax.swing.JTextField();
        p_id = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        cuisine = new javax.swing.JTable();
        jPanel6 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();

        jLabel1.setText("jLabel1");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        jLabel6.setText("jLabel6");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel1MouseClicked(evt);
            }
        });
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 153, 153));
        jLabel3.setText("Choose your favorite parking area");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, -1, 30));

        jPanel2.setBackground(new java.awt.Color(173, 216, 230));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        f_id.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        f_id.setForeground(new java.awt.Color(102, 102, 102));
        f_id.setText("Area ID:");
        jPanel2.add(f_id, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        f_name.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        f_name.setForeground(new java.awt.Color(102, 102, 102));
        f_name.setText("Area Code:");
        jPanel2.add(f_name, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, -1, -1));

        f_quantity.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        f_quantity.setForeground(new java.awt.Color(102, 102, 102));
        f_quantity.setText("Hour/Hours:");
        jPanel2.add(f_quantity, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, -1, -1));

        total.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        total.setForeground(new java.awt.Color(102, 102, 102));
        total.setText("Total Price:");
        jPanel2.add(total, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, -1, -1));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 330, 600, 130));
        jPanel1.add(p_quantity, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 80, 140, 40));
        jPanel1.add(p_id, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 150, 140, 40));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        jLabel2.setText("Hour/Hours");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 60, -1, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        jLabel4.setText("Area ID");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 130, -1, 20));

        jPanel3.setBackground(new java.awt.Color(173, 216, 230));
        jPanel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel3MouseClicked(evt);
            }
        });
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(102, 102, 102));
        jLabel5.setText("INSERT");
        jPanel3.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 220, 70, 30));

        jPanel4.setBackground(new java.awt.Color(173, 216, 230));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane2.setViewportView(cuisine);

        jPanel4.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 440, 220));

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 460, 240));

        jPanel6.setBackground(new java.awt.Color(173, 216, 230));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel1.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 530, 650, 20));

        jPanel7.setBackground(new java.awt.Color(173, 216, 230));
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel1.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 650, 20));

        jPanel8.setBackground(new java.awt.Color(173, 216, 230));
        jPanel8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel8MouseClicked(evt);
            }
        });
        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        jLabel7.setText("PROCEED");
        jPanel8.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        jPanel1.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 480, 100, 30));

        jPanel9.setBackground(new java.awt.Color(173, 216, 230));
        jPanel9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel9MouseClicked(evt);
            }
        });
        jPanel9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        jLabel8.setText("CANCEL");
        jPanel9.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        jPanel1.add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 480, 90, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 549, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jPanel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel1MouseClicked

    private void jPanel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel3MouseClicked
        displayProductDetails();
    }//GEN-LAST:event_jPanel3MouseClicked

    private void jPanel8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel8MouseClicked
        try {
    dbconnect dbc = new dbconnect();
    Connection conn = dbc.getConnection();

    // Insert into order_tbl
    String sql = "INSERT INTO order_tbl (f_id, c_id, o_quantity, o_due, o_status) VALUES (?, ?, ?, ?, ?)";
    PreparedStatement pst = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

    // Get data from input fields
    int foodId = Integer.parseInt(f_id.getText().replace("Food ID: ", "").trim());
    int quantity = Integer.parseInt(f_quantity.getText().replace("Quantity: ", "").trim());
    double due = Double.parseDouble(total.getText().replace("Total Price: ", "").trim());
    String status = "Pending";

    // Get customer ID from session (assumed)
    Session sess = Session.getInstance();
    String userId = sess.getUid();  // This should match the c_id (customer.id)

    if (userId == null || userId.trim().isEmpty()) {
        JOptionPane.showMessageDialog(null, "Customer not logged in. Cannot place order.");
        return;
    }

    int customerId = Integer.parseInt(userId); // Convert to int

    // Set values into query
    pst.setInt(1, foodId);
    pst.setInt(2, customerId);  
    pst.setInt(3, quantity);
    pst.setDouble(4, due);
    pst.setString(5, status);

    int rows = pst.executeUpdate();

    if (rows > 0) {
        ResultSet keys = pst.getGeneratedKeys();
        int lastOrderId = -1;
        if (keys.next()) {
            lastOrderId = keys.getInt(1);
        }

        // Log the action
        String actions = "Added New Order! Order ID: " + lastOrderId;

        PreparedStatement logPst = conn.prepareStatement(
            "INSERT INTO logs (id, actions, date) VALUES (?, ?, ?)"
        );
        logPst.setInt(1, customerId);
        logPst.setString(2, actions);
        logPst.setTimestamp(3, Timestamp.valueOf(LocalDateTime.now()));
        logPst.executeUpdate();

        JOptionPane.showMessageDialog(null, "Order placed successfully!");

        // Clear inputs after inserting
        f_id.setText("");
        f_name.setText("");
        f_quantity.setText("");
        total.setText("");

        // Redirect back to OrderDB or refresh page
        OrderDB odb = new OrderDB();
        this.dispose();
        odb.setVisible(true);
    }

} catch (SQLException e) {
    JOptionPane.showMessageDialog(null, "SQL Error: " + e.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
} catch (NumberFormatException ex) {
    JOptionPane.showMessageDialog(null, "Insert Order First! " + ex.getMessage(), "Input Error", JOptionPane.ERROR_MESSAGE);
}
    }//GEN-LAST:event_jPanel8MouseClicked

    private void jPanel9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel9MouseClicked
        int confirm = JOptionPane.showConfirmDialog(null, "Are you sure you want to cancel?", "Confirm Cancel", JOptionPane.YES_NO_OPTION);

    if (confirm == JOptionPane.YES_OPTION) {
        OrderDB odb = new OrderDB();
        odb.setVisible(true);
        this.dispose();
}
    }//GEN-LAST:event_jPanel9MouseClicked

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
            java.util.logging.Logger.getLogger(AddOrder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddOrder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddOrder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddOrder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddOrder().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable cuisine;
    private javax.swing.JLabel f_id;
    private javax.swing.JLabel f_name;
    private javax.swing.JLabel f_quantity;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField p_id;
    private javax.swing.JTextField p_quantity;
    private javax.swing.JLabel total;
    // End of variables declaration//GEN-END:variables
}
