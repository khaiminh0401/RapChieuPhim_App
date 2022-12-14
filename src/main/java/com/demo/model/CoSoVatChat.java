/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author hohoa
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CoSoVatChat {
    private String tencn;
    private String tenphong;
    private String macsvc;
    private String tencsvc;
    private String hinh;
    private int soluong;
    private int trangthai;

    public CoSoVatChat(String macsvc, String tencn, String tenphong, String tencsvc, int soluong, int trangthai) {
        this.macsvc = macsvc;
        this.tencn = tencn;
        this.tenphong = tenphong;
        this.tencsvc = tencsvc;
        this.soluong = soluong;
        this.trangthai = trangthai;
    }
    
}
