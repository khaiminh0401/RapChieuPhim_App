package com.raven.component;

import com.raven.event.EventMenuSelected;
import com.raven.form.Form_Home;
import com.raven.model.Model_Menu;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Menu extends javax.swing.JPanel {

    private EventMenuSelected event;

    public void addEventMenuSelected(EventMenuSelected event) {
        this.event = event;
        listMenu1.addEventMenuSelected(event);
    }

    public Menu() {
        initComponents();
        setOpaque(false);
        listMenu1.setOpaque(false);
        init();
    }

    private void init() {
        System.out.println(listMenu1.getParent().getParent());
        
        listMenu1.addItem(new Model_Menu("1", "Trang chủ", Model_Menu.MenuType.MENU));
        listMenu1.addItem(new Model_Menu("2", "Quản lý lịch chiếu", Model_Menu.MenuType.MENU));
//        listMenu1.addItem(new Model_Menu("4", "Quản lý phòng", Model_Menu.MenuType.MENU));
        listMenu1.addItem(new Model_Menu("3", "Quản lý TOPPING", Model_Menu.MenuType.MENU));
        listMenu1.addItem(new Model_Menu("4", "Đặt vé", Model_Menu.MenuType.MENU));
        listMenu1.addItem(new Model_Menu("5", "Phản Hồi", Model_Menu.MenuType.MENU));

        listMenu1.addItem(new Model_Menu("6", "Người dùng", Model_Menu.MenuType.TITLE));
        listMenu1.addItem(new Model_Menu("7", "Đổi mật khẩu", Model_Menu.MenuType.MENU));
        listMenu1.addItem(new Model_Menu("8", "Đăng xuất", Model_Menu.MenuType.MENU));
        listMenu1.addItem(new Model_Menu("9", "Thoát", Model_Menu.MenuType.MENU));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelMoving = new javax.swing.JPanel();
        Riseofkingdom = new javax.swing.JLabel();
        listMenu1 = new com.raven.swing.ListMenu<>();

        panelMoving.setOpaque(false);

        Riseofkingdom.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        Riseofkingdom.setForeground(new java.awt.Color(255, 255, 255));
        Riseofkingdom.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/logo2.png"))); // NOI18N
        Riseofkingdom.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                RiseofkingdomMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout panelMovingLayout = new javax.swing.GroupLayout(panelMoving);
        panelMoving.setLayout(panelMovingLayout);
        panelMovingLayout.setHorizontalGroup(
            panelMovingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMovingLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(Riseofkingdom)
                .addContainerGap(32, Short.MAX_VALUE))
        );
        panelMovingLayout.setVerticalGroup(
            panelMovingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelMovingLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(Riseofkingdom)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelMoving, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(listMenu1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelMoving, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(listMenu1, javax.swing.GroupLayout.DEFAULT_SIZE, 473, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents
    private Form_Home home;
    private void RiseofkingdomMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RiseofkingdomMouseClicked
//        home = new Form_Home();
        
    }//GEN-LAST:event_RiseofkingdomMouseClicked

    @Override
    protected void paintChildren(Graphics grphcs) {
        Graphics2D g2 = (Graphics2D) grphcs;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        GradientPaint g = new GradientPaint(0, 0, Color.decode("#DC143C"), 0, getHeight(), Color.decode("#800000"));
        g2.setPaint(g);
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), 15, 15);
        g2.fillRect(getWidth() - 20, 0, getWidth(), getHeight());
        super.paintChildren(grphcs);
    }

    private int x;
    private int y;

    public void initMoving(JFrame fram) {
        panelMoving.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent me) {
                x = me.getX();
                y = me.getY();
            }

        });
        panelMoving.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent me) {
                fram.setLocation(me.getXOnScreen() - x, me.getYOnScreen() - y);
            }
        });
    }
        
    
            
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Riseofkingdom;
    private com.raven.swing.ListMenu<String> listMenu1;
    private javax.swing.JPanel panelMoving;
    // End of variables declaration//GEN-END:variables
}