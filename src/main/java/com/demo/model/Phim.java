/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.raven.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author Daokh
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Phim {

    private String MaPhim;
    private String TenPhim;
    private String DienVien;
    private int NamSX;
    private String Hinh;

    
    private String DaoDien;
    private String QuocGia;
    private String ThoiLuong;
    private String MoTa;
    private String Traller;
    private int stt_xc;
    private String maphong;
    private String tenphong;
    public Phim(String tenphim, String dienvien, int namsx, String hinh, String daodien, String quocgia, String thoiluong, String maphim) {
        this.TenPhim = tenphim;
        this.DienVien = dienvien;
        this.NamSX = namsx;
        this.Hinh = hinh;
        this.DaoDien = daodien;
        this.QuocGia = quocgia;
        this.ThoiLuong = thoiluong;
        this.MaPhim = maphim;
    }
    public Phim(String MaPhim, String TenPhim, String DienVien, int NamSX, String Hinh, String DaoDien, String QuocGia, String ThoiLuong, String MoTa, String Traller) {
        this.MaPhim = MaPhim;
        this.TenPhim = TenPhim;
        this.DienVien = DienVien;
        this.NamSX = NamSX;
        this.Hinh = Hinh;
        this.DaoDien = DaoDien;
        this.QuocGia = QuocGia;
        this.ThoiLuong = ThoiLuong;
        this.MoTa = MoTa;
        this.Traller = Traller;
    }
      
    public Phim(String maPhim, String tenPhim) {
        MaPhim = maPhim;
        TenPhim = tenPhim;
    }

    public Phim(String MaPhim, String TenPhim, int NamSX) {
        this.MaPhim = MaPhim;
        this.TenPhim = TenPhim;
        this.NamSX = NamSX;
    }

}
