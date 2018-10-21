package com.i2twm.service;

import com.i2twm.entity.ProductInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * @author i2twmx@gmail.com
 * @date 2018/10/21 12:18
 */
public interface ProductService {
    ProductInfo findOne(String productId);
    /*查询在架商品*/
    List<ProductInfo> findUpAll();

    Page<ProductInfo> findAll(Pageable pageable);

    ProductInfo save(ProductInfo productInfo);




}
