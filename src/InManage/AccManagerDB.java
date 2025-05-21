/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package InManage;

import InternalPackage.ManagersDB;
import OutsidePackage.login;
import config.Session;
import config.dbconnect;
import java.awt.Color;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.border.Border;



/**
 *
 * @author Administrator
 */
public class AccManagerDB extends javax.swing.JFrame {

    /**
     * Creates new form AccManagerDB
     */
    public AccManagerDB() {
        initComponents();
        loadProfilePicture();
       
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
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        foods_db = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        acc3 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        acc = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        acc1 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        db = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        pfp = new javax.swing.JLabel();
        mgname = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        mgcontact = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        mglname = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        mgemail = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        mgaddress = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        mgtype = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        mgfname = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        u_id = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        changepass = new javax.swing.JPanel();
        jLabel28 = new javax.swing.JLabel();
        logout = new javax.swing.JPanel();
        jLabel26 = new javax.swing.JLabel();
        changepfp = new javax.swing.JPanel();
        jLabel29 = new javax.swing.JLabel();

        jLabel2.setText("jLabel2");

        jLabel7.setText("jLabel7");

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

        foods_db.setBackground(new java.awt.Color(173, 216, 230));
        foods_db.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                foods_dbMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                foods_dbMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                foods_dbMouseExited(evt);
            }
        });
        foods_db.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel11.setText("AREAS");
        foods_db.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 20, -1, 20));
        foods_db.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, -1, -1));

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

        foods_db.add(acc3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 330, 180, 50));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconss/parking-area.png"))); // NOI18N
        foods_db.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        jPanel2.add(foods_db, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 290, 190, 50));

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
        acc.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 20, -1, 20));
        acc.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, -1, -1));

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

        acc.add(acc1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 330, 180, 50));

        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconss/account (1).png"))); // NOI18N
        acc.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 20, -1, -1));

        jPanel2.add(acc, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 340, 190, 50));

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
        db.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 10, -1, 20));

        jLabel19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconss/dashboard.png"))); // NOI18N
        db.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(21, 10, -1, -1));

        jPanel2.add(db, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 250, 190, 40));

        pfp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconss/project-manager (2).png"))); // NOI18N
        jPanel2.add(pfp, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 150, 140));

        mgname.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        mgname.setText("Hello");
        jPanel2.add(mgname, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 160, 120, 40));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 190, 520));

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        mgcontact.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        mgcontact.setText("CONTACT");
        jPanel5.add(mgcontact, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 10, -1, -1));

        jLabel22.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel22.setText("Contact no. :");
        jPanel5.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        jPanel1.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 300, 280, 40));

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        mglname.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        mglname.setText("LAST NAME");
        jPanel6.add(mglname, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 10, -1, -1));

        jLabel21.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel21.setText("Last Name: ");
        jPanel6.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        jPanel1.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 90, 280, 40));

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        mgemail.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        mgemail.setText("EMAIL");
        jPanel7.add(mgemail, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 10, -1, -1));

        jLabel24.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel24.setText("Email:");
        jPanel7.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        jPanel1.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 230, 280, 40));

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));
        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        mgaddress.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        mgaddress.setText("ADDRESS");
        jPanel8.add(mgaddress, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 10, -1, -1));

        jLabel23.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel23.setText("Address:");
        jPanel8.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        jPanel1.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 160, 280, 40));

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));
        jPanel9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        mgtype.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        mgtype.setText("TYPE");
        jPanel9.add(mgtype, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, -1, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setText("Type:");
        jPanel9.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        jPanel1.add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 230, 280, 40));

        jPanel10.setBackground(new java.awt.Color(255, 255, 255));
        jPanel10.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        mgfname.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        mgfname.setText("FIRST NAME");
        jPanel10.add(mgfname, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 10, -1, -1));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel6.setText("First Name: ");
        jPanel10.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        jPanel1.add(jPanel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 160, 280, 40));

        jPanel12.setBackground(new java.awt.Color(255, 255, 255));
        jPanel12.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        u_id.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        u_id.setText("USER ID");
        jPanel12.add(u_id, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, -1, -1));

        jLabel27.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel27.setText("ID:");
        jPanel12.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        jPanel1.add(jPanel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 90, 280, 40));

        jLabel25.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(102, 102, 102));
        jLabel25.setText("PERSONAL INFORMATION");
        jPanel1.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 10, -1, -1));

        changepass.setBackground(new java.awt.Color(173, 216, 230));
        changepass.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                changepassMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                changepassMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                changepassMouseExited(evt);
            }
        });
        changepass.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel28.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(102, 102, 102));
        jLabel28.setText("Change Password");
        changepass.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        jPanel1.add(changepass, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 470, 130, 30));

        logout.setBackground(new java.awt.Color(173, 216, 230));
        logout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                logoutMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                logoutMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                logoutMouseExited(evt);
            }
        });
        logout.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel26.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(102, 102, 102));
        jLabel26.setText("Logout");
        logout.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jPanel1.add(logout, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 470, 90, 30));

        changepfp.setBackground(new java.awt.Color(173, 216, 230));
        changepfp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                changepfpMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                changepfpMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                changepfpMouseExited(evt);
            }
        });

        jLabel29.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(102, 102, 102));
        jLabel29.setText("Change Profile Picture");

        javax.swing.GroupLayout changepfpLayout = new javax.swing.GroupLayout(changepfp);
        changepfp.setLayout(changepfpLayout);
        changepfpLayout.setHorizontalGroup(
            changepfpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, changepfpLayout.createSequentialGroup()
                .addContainerGap(26, Short.MAX_VALUE)
                .addComponent(jLabel29)
                .addGap(28, 28, 28))
        );
        changepfpLayout.setVerticalGroup(
            changepfpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, changepfpLayout.createSequentialGroup()
                .addContainerGap(14, Short.MAX_VALUE)
                .addComponent(jLabel29)
                .addContainerGap())
        );

        jPanel1.add(changepfp, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 300, 170, 40));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 831, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 513, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void acc3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_acc3MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_acc3MouseEntered

    private void acc3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_acc3MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_acc3MouseExited

    private void foods_dbMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_foods_dbMouseClicked
        AreasDB fdb = new AreasDB();
        fdb.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_foods_dbMouseClicked

    private void foods_dbMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_foods_dbMouseEntered
        foods_db.setBackground(lightGray);
    }//GEN-LAST:event_foods_dbMouseEntered

    private void foods_dbMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_foods_dbMouseExited
        foods_db.setBackground(lightBlue);
    }//GEN-LAST:event_foods_dbMouseExited

    private void acc1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_acc1MouseEntered
       acc1.setBackground(lightGray);
    }//GEN-LAST:event_acc1MouseEntered

    private void acc1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_acc1MouseExited
        acc.setBackground(lightBlue);
    }//GEN-LAST:event_acc1MouseExited

    private void accMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_accMouseEntered
        acc.setBackground(lightGray);
    }//GEN-LAST:event_accMouseEntered

    private void accMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_accMouseExited
         acc.setBackground(lightBlue);
    }//GEN-LAST:event_accMouseExited

    private void dbMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dbMouseClicked
        ManagersDB mdb = new ManagersDB();
        mdb.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_dbMouseClicked

    private void dbMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dbMouseEntered
         acc.setBackground(lightGray);
    }//GEN-LAST:event_dbMouseEntered

    private void dbMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dbMouseExited
         acc.setBackground(lightBlue);
    }//GEN-LAST:event_dbMouseExited

    private void jPanel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel1MouseClicked

    private void accMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_accMouseClicked
        
    }//GEN-LAST:event_accMouseClicked

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        Session sess = Session.getInstance();
        mgname.setText(""+sess.getFname());
        u_id.setText(""+sess.getUid());
        mgfname.setText(""+sess.getFname());
        mglname.setText(""+sess.getLname());
        mgemail.setText(""+sess.getEmail());
        mgcontact.setText(""+sess.getContact());
        mgaddress.setText(""+sess.getAddress());
        mgtype.setText(""+sess.getType());
    }//GEN-LAST:event_formWindowActivated

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
       loadProfilePicture();
    }//GEN-LAST:event_formWindowOpened

    private void changepassMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_changepassMouseClicked
        ChangePassword cps = new ChangePassword();
        cps.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_changepassMouseClicked

    private void logoutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logoutMouseClicked
        int choice = JOptionPane.showConfirmDialog(
            null,
            "Are you sure you want to log out?",
            "Logout Confirmation",
            JOptionPane.YES_NO_OPTION
        );

        if (choice == JOptionPane.YES_OPTION) {

            this.dispose();
            login lg = new login();
            lg.setVisible(true);
        }
    }//GEN-LAST:event_logoutMouseClicked

    private void changepfpMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_changepfpMouseClicked
         JFileChooser chooser = new JFileChooser();
int result = chooser.showOpenDialog(null);

if (result == JFileChooser.APPROVE_OPTION) {
    File selectedFile = chooser.getSelectedFile();
    String filename = selectedFile.getAbsolutePath();

    // Set the image to the existing JLabel (pfp)
    ImageIcon ii = new ImageIcon(new ImageIcon(filename)
            .getImage().getScaledInstance(pfp.getWidth(), pfp.getHeight(), Image.SCALE_SMOOTH));
    pfp.setIcon(ii); // Update the JLabel

    // Define the target directory within the NetBeans project (src/pfpimage)
    File destination = new File("src/pfpimage", selectedFile.getName());

    // Ensure the directory exists
    destination.getParentFile().mkdirs();

    // Save the image
    try (InputStream fis = new FileInputStream(selectedFile);
         OutputStream fos = new FileOutputStream(destination)) {
        byte[] buffer = new byte[1024];
        int bytesRead;
        while ((bytesRead = fis.read(buffer)) != -1) {
            fos.write(buffer, 0, bytesRead);
        }

        // Now update the database with the relative image path
        String username = dbconnect.loggedInUsername; // Use logged-in username

        try {
            Connection con = dbconnect.getConnection(); // Get DB connection
            String sql = "UPDATE customer SET profile_picture = ? WHERE cs_user = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            String relativePath = "pfpimage/" + selectedFile.getName(); // Store relative path
            pst.setString(1, relativePath); 
            pst.setString(2, username); 
            pst.executeUpdate();
            con.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error saving image path: " + e.getMessage());
            return;
        }

        JOptionPane.showMessageDialog(null, "Profile Picture Updated Successfully!");
    } catch (IOException e) {
        JOptionPane.showMessageDialog(null, "Error saving image: " + e.getMessage());
    }
}
    }//GEN-LAST:event_changepfpMouseClicked

    private void changepfpMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_changepfpMouseEntered
        changepfp.setBackground(lightGray);
    }//GEN-LAST:event_changepfpMouseEntered

    private void changepfpMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_changepfpMouseExited
       changepfp.setBackground(lightBlue);
    }//GEN-LAST:event_changepfpMouseExited

    private void changepassMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_changepassMouseEntered
changepass.setBackground(lightGray);    }//GEN-LAST:event_changepassMouseEntered

    private void changepassMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_changepassMouseExited
changepass.setBackground(lightBlue);    }//GEN-LAST:event_changepassMouseExited

    private void logoutMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logoutMouseEntered
        changepfp.setBackground(lightGray);
    }//GEN-LAST:event_logoutMouseEntered

    private void logoutMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logoutMouseExited
        changepfp.setBackground(lightBlue);
    }//GEN-LAST:event_logoutMouseExited

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
            java.util.logging.Logger.getLogger(AccManagerDB.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AccManagerDB.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AccManagerDB.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AccManagerDB.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AccManagerDB().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel acc;
    private javax.swing.JPanel acc1;
    private javax.swing.JPanel acc3;
    private javax.swing.JPanel changepass;
    private javax.swing.JPanel changepfp;
    private javax.swing.JPanel db;
    private javax.swing.JPanel foods_db;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JPanel logout;
    private javax.swing.JLabel mgaddress;
    private javax.swing.JLabel mgcontact;
    private javax.swing.JLabel mgemail;
    private javax.swing.JLabel mgfname;
    private javax.swing.JLabel mglname;
    private javax.swing.JLabel mgname;
    private javax.swing.JLabel mgtype;
    private javax.swing.JLabel pfp;
    private javax.swing.JLabel u_id;
    // End of variables declaration//GEN-END:variables
}
