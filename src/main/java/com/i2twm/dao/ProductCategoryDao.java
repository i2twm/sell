package com.i2twm.dao;

import com.i2twm.entity.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * 类目
 * @author i2twmx@gmail.com
 * @date 2018/10/21 0:06
 */
public interface ProductCategoryDao extends JpaRepository<ProductCategory,Integer> {

    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);
}
