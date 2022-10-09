/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.raven.main;

import com.raven.DAO.NhanVienDao;
import com.raven.model.NhanVien;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author Daokh
 */
public class RunMain {
    public static void main(String[] args) {
         NhanVienDao dao = new NhanVienDao();

        try {
            if (new File("savetk.txt").length() != 0) {
                NhanVien list_temp = (NhanVien) DangNhap.readObj("savetk.txt");
                dao.Select().stream().filter(s -> s.getSoDT().equalsIgnoreCase(list_temp.getSoDT())).forEach(s -> NhanVienDao.setMaNV(s.getMaNV()));
                Main main = new Main();
                main.show();
                return;
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        DangNhap dn = new DangNhap();
        dn.show();
    }
}
