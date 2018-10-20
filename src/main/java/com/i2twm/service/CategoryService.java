package com.i2twm.service;

import com.i2twm.entity.ProductCategory;

import java.util.List;

/**
 * 类目
 * @author i2twmx@gmail.com
 * @date 2018/10/21 1:17
 */
public interface CategoryService {

    ProductCategory findOne(Integer categoryId);

    List<ProductCategory> findAll();

    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);

    ProductCategory save(ProductCategory productCategory);
}
