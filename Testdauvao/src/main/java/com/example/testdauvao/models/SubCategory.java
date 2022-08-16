/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.testdauvao.models;

import com.sun.istack.NotNull;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

/**
 * @author acer
 */
@Entity
@Table(name = "sub_category")
public class SubCategory implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name = "sub_cate_code", nullable = true, length = 20)
    @NotEmpty(message = "Không được trống Code")
    private String subCateCode;
    @Column(name = "sub_cate_name", nullable = true, length = 50)
    @NotEmpty(message = "Không được trống Name")
    private String subCateName;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cate_id", nullable = true)
    private Category category;

    public SubCategory() {
    }

    public SubCategory(long id, String subCateCode, String subCateName, Category category) {
        this.id = id;
        this.subCateCode = subCateCode;
        this.subCateName = subCateName;
        this.category = category;
    }

    public SubCategory(String subCateCode, String subCateName, Category category) {
        this.subCateCode = subCateCode;
        this.subCateName = subCateName;
        this.category = category;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getSubCateCode() {
        return subCateCode;
    }

    public void setSubCateCode(String subCateCode) {
        this.subCateCode = subCateCode;
    }

    public String getSubCateName() {
        return subCateName;
    }

    public void setSubCateName(String subCateName) {
        this.subCateName = subCateName;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "SubCategory{" + "id=" + id + ", subCateCode=" + subCateCode + ", subCateName=" + subCateName + ", category=" + category + '}';
    }


}
