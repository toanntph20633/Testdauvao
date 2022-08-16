/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.testdauvao.models;

import lombok.Data;

/**
 *
 * @author acer
 */
@Data
public class ProductCustom {
    private Long Id;
    private String subCateName;
    private String productName;
    private String Color;
    private Long Quantity;
    private Double sellPrice;
    private Double originPrice;
    private String statusName;
    private String brandName;
}
