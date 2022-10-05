/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.raven.form;


import com.raven.DAO.NhanVienDao;
import java.awt.Color;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author TRA
 */
public class Form_DoiMatKhau extends javax.swing.JPanel {

    /**
     * Creates^ new form Form_QuenMatKhau
     */
    
    public Form_DoiMatKhau() {
        initComponents();
        lblMat1.setIcon(new ImageIcon("src/com.raven.image/c.eye.png"));
        lblMat4.setIcon(new ImageIcon("src/com.raven.image/o.eye.png"));
        lblMat2.setIcon(new ImageIcon("src/com.raven.image/c.eye.png"));
        lblMat3.setIcon(new ImageIcon("src/com.raven.image/o.eye.png"));

        lblMat1.setVisible(false);
        lblMat2.setVisible(false);
     
  
    }
     public static void DoiMatKhau(){
        com.raven.sendEmail.EmailMain.GuiEmail("khaiminh0401@gmail.com");

        String maXacThuc = JOptionPane.showInputDialog(null, "Nhập mã xác thực email");

        if (maXacThuc.equals("")) {
            JOptionPane.showMessageDialog(null, "Chưa nhập mã xác thực");
        } else {
            if (maXacThuc.equals(com.raven.sendEmail.EmailMain.maxt)) {
                JOptionPane.showMessageDialog(null, "Đã nhập chính xác!");
                Form_DoiMatKhau doimk = new Form_DoiMatKhau();
                doimk.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(null, "Nhập không chính xác!");
            }
        }
    }


    public boolean checkValidate(String MK, int index) {
        if (index == 1) {
            if (String.valueOf(txtNhapMatKhauMoi.getPassword()).length() == 0) {
                txtNhapMatKhauMoi.setBackground(Color.yellow);
                lblMKM.setText("Chưa nhập mật khẩu");
                return false;
            } else {
                txtNhapMatKhauMoi.setBackground(Color.white);
                lblMKM.setText("");
            }
        }

        if (index == 2) {
            if (String.valueOf(txtXacNhanMatKhau.getPassword()).length() == 0) {
                txtXacNhanMatKhau.setBackground(Color.yellow);
                lblXNMK.setText("Chưa nhập mật khẩu");
                return false;
            } else if (!String.valueOf(txtXacNhanMatKhau.getPassword()).equals(String.valueOf(txtNhapMatKhauMoi.getPassword()))) {
                txtXacNhanMatKhau.setBackground(Color.yellow);
                lblXNMK.setText("Mật khẩu không khớp");
                return false;
            } else {
                txtXacNhanMatKhau.setBackground(Color.white);
                lblXNMK.setText("");
            }
        }
        return true;

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblDoiMatKhau = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        lblNhapMatKhauMoi = new javax.swing.JLabel();
        lblXacNhanMatKhau = new javax.swing.JLabel();
        txtNhapMatKhauMoi = new javax.swing.JPasswordField();
        txtXacNhanMatKhau = new javax.swing.JPasswordField();
        btnOk = new javax.swing.JButton();
        lblMKM = new javax.swing.JLabel();
        lblXNMK = new javax.swing.JLabel();
        lblMat1 = new javax.swing.JLabel();
        lblMat2 = new javax.swing.JLabel();
        lblMat3 = new javax.swing.JLabel();
        lblMat4 = new javax.swing.JLabel();

        jPanel1.setBackground(new java.awt.Color(255, 0, 0));

        lblDoiMatKhau.setBackground(new java.awt.Color(255, 255, 255));
        lblDoiMatKhau.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblDoiMatKhau.setForeground(new java.awt.Color(255, 255, 255));
        lblDoiMatKhau.setText("ĐỔI MẬT KHẨU");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(129, 129, 129)
                .addComponent(lblDoiMatKhau)
                .addContainerGap(132, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(lblDoiMatKhau)
                .addContainerGap(25, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 204));

        lblNhapMatKhauMoi.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblNhapMatKhauMoi.setText("Nhập mật khẩu mới");

        lblXacNhanMatKhau.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblXacNhanMatKhau.setText("Xác nhận mật khẩu");

        txtNhapMatKhauMoi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtNhapMatKhauMoiMousePressed(evt);
            }
        });
        txtNhapMatKhauMoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNhapMatKhauMoiActionPerformed(evt);
            }
        });

        txtXacNhanMatKhau.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtXacNhanMatKhauMousePressed(evt);
            }
        });
        txtXacNhanMatKhau.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtXacNhanMatKhauActionPerformed(evt);
            }
        });

        btnOk.setBackground(new java.awt.Color(255, 0, 0));
        btnOk.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnOk.setForeground(new java.awt.Color(255, 255, 255));
        btnOk.setText("OK");
        btnOk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOkActionPerformed(evt);
            }
        });

        lblMat1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblMat1MouseClicked(evt);
            }
        });

        lblMat2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblMat2MouseClicked(evt);
            }
        });

        lblMat3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblMat3MouseClicked(evt);
            }
        });

        lblMat4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblMat4MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(lblMKM, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtXacNhanMatKhau, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
                                    .addComponent(lblXacNhanMatKhau, javax.swing.GroupLayout.Alignment.LEADING))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lblMat1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(lblXNMK, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lblNhapMatKhauMoi, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtNhapMatKhauMoi, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addComponent(lblMat2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(163, 163, 163)
                        .addComponent(btnOk)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                    .addContainerGap(363, Short.MAX_VALUE)
                    .addComponent(lblMat3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(7, 7, 7)))
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                    .addContainerGap(357, Short.MAX_VALUE)
                    .addComponent(lblMat4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(13, 13, 13)))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(lblNhapMatKhauMoi)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNhapMatKhauMoi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblMat2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblXNMK, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(lblXacNhanMatKhau)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtXacNhanMatKhau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblMat1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblMKM, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnOk)
                .addGap(14, 14, 14))
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addGap(47, 47, 47)
                    .addComponent(lblMat3, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(162, Short.MAX_VALUE)))
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                    .addContainerGap(144, Short.MAX_VALUE)
                    .addComponent(lblMat4, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(65, 65, 65)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnOkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOkActionPerformed
        // TODO add your handling code here:
        if (txtNhapMatKhauMoi.getText().equals(txtXacNhanMatKhau.getText())) {
            try {
                NhanVienDao.UpdateNhanVien(txtXacNhanMatKhau.getText());
                JOptionPane.showMessageDialog(this, "Đổi mật khẩu thành công");
                this.setVisible(false);
            } catch (SQLException ex) {
                Logger.getLogger(Form_DoiMatKhau.class.getName()).log(Level.SEVERE, null, ex);

            }
        }
    }//GEN-LAST:event_btnOkActionPerformed

    private void txtNhapMatKhauMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNhapMatKhauMoiActionPerformed
        // TODO add your handling code here:
        checkValidate(String.valueOf(txtNhapMatKhauMoi.getPassword()), 1);
    }//GEN-LAST:event_txtNhapMatKhauMoiActionPerformed

    private void txtNhapMatKhauMoiMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtNhapMatKhauMoiMousePressed
        // TODO add your handling code here:
        checkValidate(String.valueOf(txtNhapMatKhauMoi.getPassword()), 1);
    }//GEN-LAST:event_txtNhapMatKhauMoiMousePressed

    private void txtXacNhanMatKhauActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtXacNhanMatKhauActionPerformed
        // TODO add your handling code here:
        checkValidate(String.valueOf(txtXacNhanMatKhau.getPassword()), 2);
    }//GEN-LAST:event_txtXacNhanMatKhauActionPerformed

    private void txtXacNhanMatKhauMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtXacNhanMatKhauMousePressed
        // TODO add your handling code here:
        checkValidate(String.valueOf(txtXacNhanMatKhau.getPassword()), 2);

    }//GEN-LAST:event_txtXacNhanMatKhauMousePressed

    private void lblMat1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblMat1MouseClicked
        // TODO add your handling code here:
        txtXacNhanMatKhau.setEchoChar((char) 0);
        lblMat1.setVisible(false);
        lblMat1.setEnabled(false);
        lblMat4.setVisible(true);
        lblMat4.setEnabled(true);
    }//GEN-LAST:event_lblMat1MouseClicked

    private void lblMat4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblMat4MouseClicked
        // TODO add your handling code here:
        txtXacNhanMatKhau.setEchoChar((char) 8226);
        lblMat1.setVisible(true);
        lblMat1.setEnabled(true);
        lblMat4.setVisible(false);
        lblMat4.setEnabled(false);
    }//GEN-LAST:event_lblMat4MouseClicked

    private void lblMat2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblMat2MouseClicked
        // TODO add your handling code here:
        txtXacNhanMatKhau.setEchoChar((char) 0);
        lblMat2.setVisible(false);
        lblMat2.setEnabled(false);
        lblMat3.setVisible(true);
        lblMat3.setEnabled(true);
    }//GEN-LAST:event_lblMat2MouseClicked

    private void lblMat3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblMat3MouseClicked
        // TODO add your handling code here:
        txtXacNhanMatKhau.setEchoChar((char) 8226);
        lblMat2.setVisible(true);
        lblMat2.setEnabled(true);
        lblMat3.setVisible(false);
        lblMat3.setEnabled(false);
    }//GEN-LAST:event_lblMat3MouseClicked

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
            java.util.logging.Logger.getLogger(Form_DoiMatKhau.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Form_DoiMatKhau.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Form_DoiMatKhau.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Form_DoiMatKhau.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Form_DoiMatKhau().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnOk;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lblDoiMatKhau;
    private javax.swing.JLabel lblMKM;
    private javax.swing.JLabel lblMat1;
    private javax.swing.JLabel lblMat2;
    private javax.swing.JLabel lblMat3;
    private javax.swing.JLabel lblMat4;
    private javax.swing.JLabel lblNhapMatKhauMoi;
    private javax.swing.JLabel lblXNMK;
    private javax.swing.JLabel lblXacNhanMatKhau;
    private javax.swing.JPasswordField txtNhapMatKhauMoi;
    private javax.swing.JPasswordField txtXacNhanMatKhau;
    // End of variables declaration//GEN-END:variables

}
