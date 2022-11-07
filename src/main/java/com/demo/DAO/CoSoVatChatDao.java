/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.demo.DAO;

import com.demo.model.CoSoVatChat;
import com.raven.DAO.ConnectDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author hohoa
 */
public class CoSoVatChatDao {
    static Connection con = ConnectDB.getConnection();
    static Statement st = null;
    static PreparedStatement pst = null;
    static ResultSet rs;

    public void Insert(CoSoVatChat csvc) {
        try {
            pst = con.prepareStatement("insert into csvc values(?,?,?)");
            pst.setString(1, csvc.getMacsvc());
            pst.setString(2, csvc.getTencsvc());
            pst.setString(3, csvc.getHinh());
            rs = pst.executeQuery();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    public CoSoVatChat SelectById(int macsvc){
        CoSoVatChat c = new CoSoVatChat();
        try {
            st = con.createStatement();
            rs = st.executeQuery("select csvc.*, ct_csvc.soluong, ct_csvc.maphong from csvc join ct_csvc on csvc.macsvc = ct_csvc.macsvc where csvc.macsvc = "+ macsvc);
            while (rs.next()) {                
                c.setMacsvc(rs.getString("macsvc"));
                c.setTencsvc(rs.getString("tencsvc"));
                c.setHinh(rs.getString("hinh"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return c;
    }
    
    public void Update(int macsvc, String tencsvc, String hinh) throws SQLException {
        PreparedStatement st = con.prepareStatement("update csvc set tencsvc = ?, hinh = ?  where macsvc =?");
        st.setInt(1, macsvc);
        st.setString(2, tencsvc);
        st.setString(3, hinh);
        st.executeUpdate();
    }

    public void Delete(String macsvc) {
        try {
            PreparedStatement pt = con.prepareStatement("delete from csvc where macsvc = ?");
            pt.setString(1, macsvc);
            pt.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
