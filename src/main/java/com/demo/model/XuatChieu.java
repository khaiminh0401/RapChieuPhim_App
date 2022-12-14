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
@NoArgsConstructor
@AllArgsConstructor
public class XuatChieu {
    private int Stt;
    private String Ngay;
    private String MaPhong;
    private String MaPhim;
    private double GiaXuatChieu;
}
