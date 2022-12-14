/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.raven.DAO;


import com.raven.model.ChiTietGhe;
import com.raven.model.Ghe;
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
 * @author TRA
 */
public class GheDao {

    static Connection con = ConnectDB.getConnection();
    static Statement st = null;
    static PreparedStatement pst = null;
    static ResultSet rs;

    public void Insert(Ghe gh) {
        try {
            pst = con.prepareStatement("insert into Ghe values(?,?,?)");
            int kq = pst.executeUpdate();
            System.out.println(kq);
        } catch (SQLException ex) {
            Logger.getLogger(GheDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public Ghe SelectById(int MaGheCT){
        Ghe g = new Ghe();
        try {
            st = con.createStatement();
            rs = st.executeQuery("select Ghe.* from Ghe join ChiTietGhe on ChiTietGhe.MaGhe = Ghe.MaGhe where MaCTGhe = "+MaGheCT);
            while (rs.next()) {                
                g.setMaGhe(rs.getString(1));
                g.setTenGhe(rs.getString(2));
                g.setMaLoai(rs.getInt(3));
            }
        } catch (SQLException ex) {
            Logger.getLogger(GheDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return g;
    }
    public List<ChiTietGhe> Select(String maphong, int stt) {
        List<ChiTietGhe> list = new ArrayList<>();
        try {
            st = con.createStatement();
            rs = st.executeQuery("select ChiTietGhe.maphong,TenGhe,MaCTGhe,Ghe.MaGhe,(loaighe.phuthu+ xuatchieu.giaxuatchieu) as gia from ChiTietGhe join Ghe on Ghe.MaGhe=ChiTietGhe.MaGhe join loaighe ON loaighe.maloai = Ghe.maloai join phongchieu ON phongchieu.maphong = ChiTietGhe.maphong join xuatchieu ON xuatchieu.maphong = phongchieu.maphong where ChiTietGhe.MaPhong = '"+maphong+"' and xuatchieu.stt ="+stt+";");
            while (rs.next()) {
                list.add(new ChiTietGhe(rs.getString(1), rs.getString(2),rs.getInt(3),rs.getString(4),rs.getDouble(5)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(GheDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public void Update(String TenGhe, int MaLoai, String MaGhe) throws SQLException {
        PreparedStatement st = con.prepareStatement("update Phim set TenGhe = ?, MaLoai = ?  where MaGhe =?");
        st.setString(1, TenGhe);
        st.setInt(2, MaLoai);
        st.setString(3, MaGhe);
        st.executeUpdate();
    }

    public void Delete(String MaGhe) {
        try {
            PreparedStatement pt = con.prepareStatement("delete from Ghe where MaGhe = ?");
            pt.setString(1, MaGhe);
            pt.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
