package com.example.testdauvao.controllers;

import com.example.testdauvao.models.Product;
import com.example.testdauvao.models.SubCategory;
import com.example.testdauvao.models.SubCategoryCustom;
import com.example.testdauvao.services.impl.SubCateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path = "/api/v1/SubCate")
public class SubCateController {
    @Autowired
    SubCateService subCateService;

    @GetMapping("getAll")
    ResponseEntity<Object> getAlll() {
        List<SubCategory> list = subCateService.selectAll(0);
        if (list.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new String("Mảng rỗng"));
        }
        return ResponseEntity.status(HttpStatus.OK).body(list);
    }

    @GetMapping("getAll/{page}")
    ResponseEntity<Object> getAll(@PathVariable int page) {
        List<SubCategoryCustom> list = subCateService.selectAllCustom(page);
        if (list.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new String("Mảng rỗng"));
        }
        return ResponseEntity.status(HttpStatus.OK).body(list);
    }

    @PostMapping("save")
    ResponseEntity<Object> save(@Validated @RequestBody SubCategory subCategory) {
        String check = subCateService.save(subCategory);
            if(!check.equals("")){
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(check);
            }
        return ResponseEntity.status(HttpStatus.CREATED).body("Thêm thành công");
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }
}
