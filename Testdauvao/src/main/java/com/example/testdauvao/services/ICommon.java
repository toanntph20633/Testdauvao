package com.example.testdauvao.services;

import com.example.testdauvao.models.SubCategoryCustom;

import java.util.List;

public interface ICommon<T,S> {
    List<T> selectAll(int page);
    String save(T t);
    String update(T t,S s);
    String delete(T t);

}
