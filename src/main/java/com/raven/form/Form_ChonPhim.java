/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.raven.form;

import com.raven.DAO.GheDao;
import com.raven.DAO.NgayChieuDao;
import com.raven.DAO.PhimDao;
import com.raven.DAO.PhongDao;
import com.raven.DAO.XuatChieuDao;
import com.raven.main.Main;
import com.raven.model.ChiTietGhe;
import com.raven.model.Model_Phim;
import com.raven.model.NgayChieu;
import com.raven.model.Phim;
import com.raven.model.PhongChieu;
import com.raven.model.ThanhToan;
import com.raven.model.XuatChieu;
import java.awt.event.ItemEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Daokh
 */
public class Form_ChonPhim extends javax.swing.JPanel {

    /**
     * Creates new form Form_ChonPhim
     */
    NgayChieuDao daoNgay;
    XuatChieuDao daoXuatChieu;
    String ngayChieu;
    List<NgayChieu> listGio = new ArrayList<>();
    List<Phim> listPhim = new ArrayList<>();
    Model_Phim mp;
    int index;

    public Form_ChonPhim() {
        initComponents();
        daoNgay = new NgayChieuDao();
        daoXuatChieu = new XuatChieuDao();
        cboGio.removeAllItems();

    }

    public void FillGio() {
        listGio = daoNgay.SelectGioBatDau(ngayChieu);
        cboGio.removeAllItems();
        listGio.forEach(s -> {
            cboGio.addItem(s.getGioBatDau());
        });
    }
 public static Object readObj(String path) throws FileNotFoundException, IOException, ClassNotFoundException {

        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path));
        if (ois == null) {
            return null;
        }
        return ois.readObject();
    }

    public static void writeObj(String path, Object data) throws FileNotFoundException, IOException {
        try (
                 FileOutputStream fos = new FileOutputStream(path);  ObjectOutputStream oos = new ObjectOutputStream(fos);) {
            oos.writeObject(data);
        }
    }
    public void FillPhim() {
        mp = new Model_Phim();
        int stt = listGio.get(index).getStt();
        listPhim = daoXuatChieu.SelectTenPhim(stt, ngayChieu);
        pnlPhim.removeAll();
        listPhim.forEach(s -> {
            mp = new Model_Phim(s.getTenPhim(), s.getMaPhim());
            pnlPhim.add(mp);
            PhongChieu phg = new PhongDao().SelectPhong(s.getMaPhim(), ngayChieu, listGio.get(index).getStt());
            List<ChiTietGhe> listGheCV = new PhongDao().SelectGheInVe(ngayChieu, listGio.get(index).getStt(), s.getMaPhim());

            mp.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    ThanhToan tt = new ThanhToan();
                    tt.setMaPhim(s.getMaPhim());
                    tt.setSTT(listGio.get(index).getStt());
                    tt.setMaPhong(phg.getMaPhong());
                    tt.setNgayChieu(ngayChieu);
                    try {
                        writeObj("temp.txt",tt);
                    } catch (IOException ex) {
                        Logger.getLogger(Form_ChonPhim.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    Main.mainF.removeAll();
                    Main.mainF.add(new Form_ChoNgoi(phg, listGio.get(index).getGioBatDau(), listGheCV));
                    Main.mainF.repaint();
                    Main.mainF.revalidate();
                }
            });
        });
        pnlPhim.repaint();
        pnlPhim.revalidate();
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
        pnlPhim = new javax.swing.JPanel();
        dcNgayChieu = new com.toedter.calendar.JDateChooser();
        cboGio = new javax.swing.JComboBox<>();

        setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        pnlPhim.setLayout(new javax.swing.BoxLayout(pnlPhim, javax.swing.BoxLayout.LINE_AXIS));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlPhim, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlPhim, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        dcNgayChieu.setDateFormatString("yyyy-MM-dd");
        dcNgayChieu.addHierarchyListener(new java.awt.event.HierarchyListener() {
            public void hierarchyChanged(java.awt.event.HierarchyEvent evt) {
                dcNgayChieuHierarchyChanged(evt);
            }
        });
        dcNgayChieu.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                dcNgayChieuPropertyChange(evt);
            }
        });

        cboGio.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cboGio.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cboGioItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(dcNgayChieu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cboGio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 126, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(dcNgayChieu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboGio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void dcNgayChieuHierarchyChanged(java.awt.event.HierarchyEvent evt) {//GEN-FIRST:event_dcNgayChieuHierarchyChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_dcNgayChieuHierarchyChanged

    private void dcNgayChieuPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_dcNgayChieuPropertyChange
        // TODO add your handling code here:
        SimpleDateFormat fm = new SimpleDateFormat("YYYY-MM-dd");
        if (dcNgayChieu.getDate() != null) {
            Date date = dcNgayChieu.getDate();
            ngayChieu = fm.format(date);
            FillGio();
        }

    }//GEN-LAST:event_dcNgayChieuPropertyChange

    private void cboGioItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cboGioItemStateChanged
        // TODO add your handling code here:
        if (evt.getStateChange() == ItemEvent.SELECTED) {
            if (cboGio.getSelectedIndex() >= 0) {
                index = cboGio.getSelectedIndex();
                FillPhim();
            }
        }
    }//GEN-LAST:event_cboGioItemStateChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cboGio;
    private com.toedter.calendar.JDateChooser dcNgayChieu;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel pnlPhim;
    // End of variables declaration//GEN-END:variables
}
