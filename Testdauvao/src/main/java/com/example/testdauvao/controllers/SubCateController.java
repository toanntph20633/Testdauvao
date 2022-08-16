package com.example.testdauvao.controllers;

import com.example.testdauvao.models.Product;
import com.example.testdauvao.models.SubCategory;
import com.example.testdauvao.models.SubCategoryCustom;
import com.example.testdauvao.services.impl.SubCateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/SubCate")
public class SubCateController {
    @Autowired
    SubCateService subCateService;

    @GetMapping("getAll/{page}")
    ResponseEntity<Object> getAll(@PathVariable int page) {
        List<SubCategoryCustom> list = subCateService.selectAllCustom(page);
        if (list.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new String("Mảng rỗng"));
        }
        return ResponseEntity.status(HttpStatus.OK).body(list);
    }

    @PostMapping("save")
    ResponseEntity<Object> save(@Valid @RequestBody SubCategory subCategory) {
            String check = subCateService.save(subCategory);
            if(!check.equals("")){
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(check);
            }
        return ResponseEntity.status(HttpStatus.CREATED).body(new String("Thêm thành công"));
    }
}
