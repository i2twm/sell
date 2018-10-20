package com.i2twm.dao;

import com.i2twm.entity.ProductCategory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.List;

/**
 * @author i2twmx@gmail.com
 * @date 2018/10/21 0:07
 */


@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductCategoryDaoTest {

    @Autowired
    private ProductCategoryDao productCategoryDao;

    @Test
    public void findOne(){
        ProductCategory productCategory = productCategoryDao.findById(1).get();
        System.out.println(productCategory.toString());
    }
    @Test
    @Transactional
    public void saveTest(){
        ProductCategory productCategory =new ProductCategory("男生最爱",5);
        ProductCategory result = productCategoryDao.save(productCategory);
        Assert.assertNotEquals(null,result);

    }
    @Test
    public void update(){
        ProductCategory productCategory = productCategoryDao.findById(2).get();
        productCategory.setCategoryType(12);
        productCategoryDao.save(productCategory);
    }
    @Test
    public void findByCategoryTypeInTest() {
        List<Integer> list = Arrays.asList(2,3,4);

        List<ProductCategory> result = productCategoryDao.findByCategoryTypeIn(list);
        Assert.assertNotEquals(0, result.size());
    }
}