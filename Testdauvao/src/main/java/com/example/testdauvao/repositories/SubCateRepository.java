package com.example.testdauvao.repositories;

import com.example.testdauvao.models.SubCategory;
import com.example.testdauvao.models.SubCategoryCustom;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface  SubCateRepository extends JpaRepository<SubCategory,Long> {
    @Query( "select new com.example.testdauvao.models.SubCategoryCustom(d.id,d.subCateCode,d.category.cateName)  FROM SubCategory d ")
    List<SubCategoryCustom> getAllSubCategoryCustoms(Pageable pageable);


}
