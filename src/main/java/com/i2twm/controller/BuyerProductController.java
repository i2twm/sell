package com.i2twm.controller;

import com.i2twm.VO.ProductInfoVO;
import com.i2twm.VO.ProductVO;
import com.i2twm.VO.ResultVO;
import com.i2twm.entity.ProductCategory;
import com.i2twm.entity.ProductInfo;
import com.i2twm.service.CategoryService;
import com.i2twm.service.ProductService;
import com.i2twm.utils.ResultVOUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 买家商品
 * @author i2twmx@gmail.com
 * @date 2018/10/21 13:01
 */
@RestController
@RequestMapping("/buyer/product")
public class BuyerProductController {
    @Autowired
    private ProductService productService;
    @Autowired
    private CategoryService categoryService;
    @GetMapping("/list")
    public ResultVO list(){

        //1查询所有上架商品
        List<ProductInfo> productInfoList = productService.findUpAll();
        //2查类目(一次性查询)


//        List<Integer> categoryTypeList = new ArrayList<>();
//        for (ProductInfo productInfo :productInfoList){
//            categoryTypeList.add(productInfo.getCategoryType());
//        }
        List<Integer> categoryTypeList = productInfoList.stream()
                .map(e -> e.getCategoryType())
                .collect(Collectors.toList());

        List<ProductCategory> productCategoryList = categoryService.findByCategoryTypeIn(categoryTypeList);
        //3数据拼装
        List<ProductVO> productVOList = new ArrayList<>();
        for (ProductCategory productCategory :productCategoryList){
            ProductVO productVO  = new ProductVO();
            productVO.setCategoryName(productCategory.getCategoryName());
            productVO.setCategoryType(productCategory.getCategoryType());

            List<ProductInfoVO> productInfoVOList = new ArrayList<>();
            for (ProductInfo productInfo :productInfoList){
                if (productInfo.getCategoryType().equals(productCategory.getCategoryType())){
                    ProductInfoVO productInfoVO = new ProductInfoVO();
                    BeanUtils.copyProperties(productInfo,productInfoVO);
                    productInfoVOList.add(productInfoVO);
                }
            }
            productVO.setProductInfoVOList(productInfoVOList);
            productVOList.add(productVO);
        }



        return ResultVOUtil.success(productVOList);

    }
}
