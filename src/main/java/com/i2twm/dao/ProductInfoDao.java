package com.i2twm.dao;

import com.i2twm.entity.ProductInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * 商品
 * @author i2twmx@gmail.com
 * @date 2018/10/21 11:54
 */
public interface ProductInfoDao extends JpaRepository<ProductInfo,String> {
    List<ProductInfo> findByProductStatus(Integer productStatus);
}
