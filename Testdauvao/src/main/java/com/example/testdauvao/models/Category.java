
package com.example.testdauvao.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;


@Entity
@Table(name = "category")
public class Category implements Serializable {
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",nullable = false)
    private Long id;
    @Column(name = "cate_code",nullable = true,length = 20)
    private String cateCode;
    @Column(name = "cate_name",nullable = true,length = 50)
    private String cateName;

    public Category(long id, String cateCode, String cateName) {
        this.id = id;
        this.cateCode = cateCode;
        this.cateName = cateName;
    }

    public Category() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCateCode() {
        return cateCode;
    }

    public void setCateCode(String cateCode) {
        this.cateCode = cateCode;
    }

    public String getCateName() {
        return cateName;
    }

    public void setCateName(String cateName) {
        this.cateName = cateName;
    }

    @Override
    public String toString() {
        return "Category{" + "id=" + id + ", cateCode=" + cateCode + ", cateName=" + cateName + '}';
    }
    
    
}
