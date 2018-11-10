package com.i2twm.dao;

import com.i2twm.entity.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author i2twmx@gmail.com
 * @date 2018/10/21 17:54
 */
public interface OrderDetailDao extends JpaRepository<OrderDetailDao,String> {


    List<OrderDetail> findByOrderId(String orderId);

}
