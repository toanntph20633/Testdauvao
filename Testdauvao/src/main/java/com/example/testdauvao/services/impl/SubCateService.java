package com.example.testdauvao.services.impl;

import com.example.testdauvao.models.Category;
import com.example.testdauvao.models.SubCategory;
import com.example.testdauvao.models.SubCategoryCustom;
import com.example.testdauvao.repositories.CateRepository;
import com.example.testdauvao.repositories.SubCateRepository;
import com.example.testdauvao.services.ICommon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SubCateService implements ICommon<SubCategory, Long> {
    @Autowired
    private SubCateRepository subCateRepository;

    @Autowired
    private CateRepository cateRepository;

    @Override
    public List<SubCategory> selectAll(int page) {
        return null;
    }

    @Override
    public String save(SubCategory subCategory) {
        String check = check(subCategory);
        if (!check.equals("")) {
            return check;
        }
        subCateRepository.save(subCategory);
        return "";
    }

    @Override
    public String update(SubCategory subCategory1, Long id) {
        String check = check(subCategory1);
        if (!check.equals("")) {
            return check;
        }
        SubCategory subCategory2 = subCateRepository.findById(id).map(subCategory3 ->
        {
            subCategory3.setCategory(subCategory1.getCategory());
            subCategory3.setSubCateCode(subCategory1.getSubCateCode());
            subCategory3.setSubCateName(subCategory1.getSubCateName());
            return subCategory3;
        }).orElseGet(() -> {
            return null;
        });
        if (subCategory2 == null) return "Không tồn tại SubCate";
        subCateRepository.save(subCategory2);
        return "";
    }

    @Override
    public String delete(SubCategory subCategory) {
        return null;
    }

    public String check(SubCategory subCategory){
        if ("".equals(subCategory.getSubCateCode())
                || "".equals(subCategory.getSubCateName()))
            return "Không được trống";
        if (!subCategory.getSubCateCode().matches("^SA[0-9]{4}$")) return "Code không hợp lệ";
        if (!subCategory.getSubCateName().matches("^[A-Za-z]+$")) return "Name không hợp lệ";
        Optional<Category> category = cateRepository.findById(subCategory.getCategory().getId());
        if (!category.isPresent()) {
            return "Không tìm thấy id này";
        }
        return "";
    }

    public List<SubCategoryCustom> selectAllCustom(int page) {
        return subCateRepository.getAllSubCategoryCustoms(PageRequest.of(page, 5));
    }
}
