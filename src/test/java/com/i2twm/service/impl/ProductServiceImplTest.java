package com.i2twm.service.impl;

import com.i2twm.entity.ProductInfo;
import com.i2twm.enums.PruductStatusEnum;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @author i2twmx@gmail.com
 * @date 2018/10/21 12:39
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductServiceImplTest {

    @Autowired
    private ProductServiceImpl service;
    @Test
    public void findOne() {
        ProductInfo info = service.findOne("123456");
        Assert.assertNotNull(info);
    }

    @Test
    public void findUpAll() {
        List<ProductInfo> l = service.findUpAll();
        Assert.assertEquals(1,l.size());
    }

    @Test
    public void findAll() {
        PageRequest request = PageRequest.of(0,2);
        Page<ProductInfo> productInfoPage = service.findAll(request);
        System.out.println(productInfoPage.getTotalElements());
        System.out.println(productInfoPage.toString());
    }

    @Test
    public void save() {
        ProductInfo info = new ProductInfo();
        info.setProductId("123458");
        info.setProductName("皮皮虾");
        info.setProductPrice(new BigDecimal(4.2));
        info.setProductStock(200);
        info.setProductDescription("很好吃的虾");
        info.setProductIcon("http://www.baidu.com/zhou.jpg");
        info.setProductStatus(PruductStatusEnum.DOWN.getCode());
        info.setCategoryType(2);
        ProductInfo result = service.save(info);
        Assert.assertNotNull(result);
    }
}