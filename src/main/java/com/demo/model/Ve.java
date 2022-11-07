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
public class Ve {
    private int IdVe;
    private double TongGiaVe;
    private double ThueVAT;
    private int MaKH;
    private int MaCTGhe;
    private String MaNV;

    public Ve(double TongGiaVe, double ThueVAT, int MaCTGhe, String MaNV) {
        this.TongGiaVe = TongGiaVe;
        this.ThueVAT = ThueVAT;
        this.MaCTGhe = MaCTGhe;
        this.MaNV = MaNV;
    }
    
}