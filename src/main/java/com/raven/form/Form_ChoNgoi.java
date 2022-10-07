/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.raven.form;

import com.raven.DAO.GheDao;
import com.raven.DAO.PhongDao;
import com.raven.model.ChiTietGhe;
import com.raven.model.Model_Ghe;
import com.raven.model.PhongChieu;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author Daokh
 */
public class Form_ChoNgoi extends javax.swing.JPanel {

    PhongDao daoPhong;
    GheDao daoGhe;
    List<PhongChieu> ListPhong = new ArrayList<>();
    List<ChiTietGhe> ListGhe = new ArrayList<>();

    /**
     * Creates new form Form_ChoNgoi
     */
    public Form_ChoNgoi() {
        initComponents();
//        daoPhong = new PhongDao();
//        daoGhe = new GheDao();
//        ListPhong = daoPhong.Select();
//        ListGhe = daoGhe.Select();
//        ListPhong.stream().forEach(s -> {
//            cboPhong.addItem(s.getTenPhong());
//        });
    }
    Color cl;
    List<ChiTietGhe> List;
    List<ChiTietGhe> List2;
    String maphongString;
    List<ChiTietGhe> listGheCV;

    public Form_ChoNgoi(String maphongString, String gio, List<ChiTietGhe> listGheCV) {
        initComponents();
        this.listGheCV = listGheCV;

        this.maphongString = maphongString;
        daoPhong = new PhongDao();
        daoGhe = new GheDao();
        ListPhong = daoPhong.Select();
        ListPhong.stream().forEach(s -> {
            cboPhong.addItem(s.getTenPhong());
        });
//        SodoGhe();
//        ListPhong.stream().forEach(s -> {
//            if (s.getMaPhong().equalsIgnoreCase(maphongString)) {
//                cboPhong.setSelectedItem(s.getTenPhong());
//                
//            }
//        });
        ListGhe = daoGhe.Select(ListPhong.get(cboPhong.getSelectedIndex()).getMaPhong());

        System.out.println("abc");

        lblGio.setText(gio);
    }
    List<Model_Ghe> lModel = new ArrayList<>();
    Model_Ghe ghe;

    public void SodoGhe() {
        List = ListGhe.stream().limit(96).collect(Collectors.toList());
        for (ChiTietGhe s : List) {
            if (Character.compare(s.getTenGhe().charAt(0), 'H') == 0) {
                cl = Color.PINK;
            } else {
                cl = Color.GREEN;
            }

            ghe = new Model_Ghe(cl, s.getTenGhe());
            ghe.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {

                    if (e.getComponent().getBackground().equals(Color.YELLOW)) {
                        if (Character.compare(s.getTenGhe().charAt(0), 'H') == 0) {
                            e.getComponent().setBackground(Color.PINK);
                        } else {
                            e.getComponent().setBackground(Color.GREEN);
                        }
                    } else {
                        e.getComponent().setBackground(Color.YELLOW);
                    }
                }

            });
            Sodochongoi3.add(ghe);
            lModel.add(ghe);

        }
        if (cboPhong.getSelectedIndex() >= 5) {
            List2 = ListGhe.stream().skip(96).collect(Collectors.toList());
            for (ChiTietGhe s : List2) {
                if (Character.compare(s.getTenGhe().charAt(0), 'J') == 0) {
                    cl = Color.RED;
                }
                ghe = new Model_Ghe(cl, s.getTenGhe());
                lModel.add(ghe);
                ghe.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        if (e.getComponent().getBackground().equals(Color.YELLOW)) {
                            if (Character.compare(s.getTenGhe().charAt(0), 'H') == 0) {
                                e.getComponent().setBackground(Color.PINK);
                            } else if (Character.compare(s.getTenGhe().charAt(0), 'J') == 0) {
                                e.getComponent().setBackground(Color.RED);
                            } else {
                                e.getComponent().setBackground(Color.GREEN);
                            }
                        } else {
                            e.getComponent().setBackground(Color.YELLOW);
                        }
                    }
                });
                Sodochongoivip.add(ghe);
                            lModel.add(ghe);

            }

        }
        for (ChiTietGhe g : listGheCV) {
            for (int i = 0; i < ListGhe.size(); i++) {
                if (g.getMaCTGhe() == ListGhe.get(i).getMaCTGhe()) {
                    lModel.get(i).setBackground(Color.GRAY);
                    lModel.get(i).setEnabled(false);
                }
            }
        }
        Sodochongoivip.repaint();
        Sodochongoivip.revalidate();
        Sodochongoi3.repaint();
        Sodochongoi3.revalidate();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        cboPhong = new javax.swing.JComboBox<>();
        Sodochongoi3 = new javax.swing.JPanel();
        Sodochongoivip = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lblGio = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setText("Tên Phòng");

        cboPhong.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cboPhongItemStateChanged(evt);
            }
        });
        cboPhong.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cboPhongMouseClicked(evt);
            }
        });

        Sodochongoi3.setBackground(new java.awt.Color(255, 255, 255));
        Sodochongoi3.setFocusCycleRoot(true);
        Sodochongoi3.setPreferredSize(new java.awt.Dimension(3, 3));
        Sodochongoi3.setLayout(new java.awt.GridLayout(8, 12, 1, 1));

        Sodochongoivip.setBackground(new java.awt.Color(255, 255, 255));
        Sodochongoivip.setLayout(new java.awt.GridLayout(1, 14, 1, 1));

        jPanel5.setBackground(new java.awt.Color(255, 102, 255));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 45, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 36, Short.MAX_VALUE)
        );

        jPanel6.setBackground(new java.awt.Color(0, 204, 51));

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 45, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 36, Short.MAX_VALUE)
        );

        jPanel4.setBackground(new java.awt.Color(255, 51, 51));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 45, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 36, Short.MAX_VALUE)
        );

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("Ghế Thường");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("Ghế Đôi");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setText("Ghế Vip");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(cboPhong, javax.swing.GroupLayout.PREFERRED_SIZE, 331, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(72, 72, 72)
                                .addComponent(lblGio, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(Sodochongoi3, javax.swing.GroupLayout.PREFERRED_SIZE, 699, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(Sodochongoivip, javax.swing.GroupLayout.PREFERRED_SIZE, 746, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(25, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cboPhong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblGio, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Sodochongoi3, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Sodochongoivip, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel2)))
                    .addComponent(jLabel4)
                    .addComponent(jLabel3))
                .addContainerGap(41, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cboPhongMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cboPhongMouseClicked
//        Sodochongoi3.removeAll();
//        SodoGhe();
    }//GEN-LAST:event_cboPhongMouseClicked

    private void cboPhongItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cboPhongItemStateChanged
        // TODO add your handling code here:
        Sodochongoi3.removeAll();
        Sodochongoivip.removeAll();
                ListGhe = daoGhe.Select(ListPhong.get(cboPhong.getSelectedIndex()).getMaPhong());

        SodoGhe();

    }//GEN-LAST:event_cboPhongItemStateChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Sodochongoi3;
    private javax.swing.JPanel Sodochongoivip;
    private javax.swing.JComboBox<String> cboPhong;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JLabel lblGio;
    // End of variables declaration//GEN-END:variables
}
