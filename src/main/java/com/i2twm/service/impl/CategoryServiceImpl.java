package com.i2twm.service.impl;

import com.i2twm.dao.ProductCategoryDao;
import com.i2twm.entity.ProductCategory;
import com.i2twm.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author i2twmx@gmail.com
 * @date 2018/10/21 1:21
 */

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private ProductCategoryDao dao;
    @Override
    public ProductCategory findOne(Integer categoryId) {
       return dao.findById(categoryId).get();
    }

    @Override
    public List<ProductCategory> findAll() {
        return dao.findAll();
    }

    @Override
    public List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList) {
        return dao.findByCategoryTypeIn(categoryTypeList);
    }

    @Override
    public ProductCategory save(ProductCategory productCategory) {
        return dao.save(productCategory);
    }
}
