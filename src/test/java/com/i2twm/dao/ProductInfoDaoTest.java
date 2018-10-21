package com.i2twm.dao;

import com.i2twm.entity.ProductInfo;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @author i2twmx@gmail.com
 * @date 2018/10/21 12:01
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductInfoDaoTest {

    @Autowired
    private ProductInfoDao dao;

    @Test
    public void save(){

        ProductInfo info = new ProductInfo();
        info.setProductId("123456");
        info.setProductName("皮蛋粥");
        info.setProductPrice(new BigDecimal(3.2));
        info.setProductStock(100);
        info.setProductDescription("很好喝的粥");
        info.setProductIcon("http://www.baidu.com/zhou.jpg");
        info.setProductStatus(0);
        info.setCategoryType(2);
        ProductInfo result = dao.save(info);
        Assert.assertNotNull(result);

    }


    @Test
    public void findByProductStatus() {
        List<ProductInfo> result = dao.findByProductStatus(0);
        Assert.assertNotEquals(0,result.size());
        System.out.println(result);

    }
}