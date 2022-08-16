/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.testdauvao.models;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author acer
 */
@Entity
@Table(name = "product")
public class Product implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "subcate_id", nullable = true)
    private SubCategory subCategory;
    @Column(name = "produce_name", nullable = true, length = 100)
    private String produceName;
    @Column(name = "color", nullable = true, length = 50)
    private String Color;
    @Column(name = "quantity", nullable = true)
    private Long Quantity;
    @Column(name = "sell_price", nullable = true)
    private Double sellPrice;
    @Column(name = "origin_price", nullable = true)
    private Double originPrice;
    @Column(name = "description", nullable = true, length = 1000)
    private long Description;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "status_id", nullable = true)
    private Status status;
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "product_brand",
            joinColumns = {
                @JoinColumn(name = "product_id")},
            inverseJoinColumns = {
                @JoinColumn(name = "brand_id")})
    private List<Brand> brands;

    public Product(long id, SubCategory subCategory, String produceName, String Color, long Quantity, double sellPrice, double originPrice, long Description, Status status) {
        this.id = id;
        this.subCategory = subCategory;
        this.produceName = produceName;
        this.Color = Color;
        this.Quantity = Quantity;
        this.sellPrice = sellPrice;
        this.originPrice = originPrice;
        this.Description = Description;
        this.status = status;
    }

    public Product(SubCategory subCategory, String produceName, String Color, long Quantity, double sellPrice, double originPrice, long Description, Status status) {
        this.subCategory = subCategory;
        this.produceName = produceName;
        this.Color = Color;
        this.Quantity = Quantity;
        this.sellPrice = sellPrice;
        this.originPrice = originPrice;
        this.Description = Description;
        this.status = status;
    }

    public Product() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public SubCategory getSubCategory() {
        return subCategory;
    }

    public void setSubCategory(SubCategory subCategory) {
        this.subCategory = subCategory;
    }

    public String getProduceName() {
        return produceName;
    }

    public void setProduceName(String produceName) {
        this.produceName = produceName;
    }

    public String getColor() {
        return Color;
    }

    public void setColor(String Color) {
        this.Color = Color;
    }

    public long getQuantity() {
        return Quantity;
    }

    public void setQuantity(long Quantity) {
        this.Quantity = Quantity;
    }

    public double getSellPrice() {
        return sellPrice;
    }

    public void setSellPrice(double sellPrice) {
        this.sellPrice = sellPrice;
    }

    public double getOriginPrice() {
        return originPrice;
    }

    public void setOriginPrice(double originPrice) {
        this.originPrice = originPrice;
    }

    public long getDescription() {
        return Description;
    }

    public void setDescription(long Description) {
        this.Description = Description;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Product{" + "id=" + id + ", subCategory=" + subCategory + ", produceName=" + produceName + ", Color=" + Color + ", Quantity=" + Quantity + ", sellPrice=" + sellPrice + ", originPrice=" + originPrice + ", Description=" + Description + ", status=" + status + '}';
    }

}
