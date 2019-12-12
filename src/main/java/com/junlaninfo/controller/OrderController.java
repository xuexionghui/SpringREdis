package com.junlaninfo.controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.junlaninfo.dao.OrderMapper;
import com.junlaninfo.entity.OrderEntity;
import com.junlaninfo.utils.RedisUtils;

@RestController
public class OrderController {
    @Autowired
    private OrderMapper orderMapper;
    @Autowired
    private RedisUtils redisUtils;

    @RequestMapping("/saveOrder")
    public String saveOrder() {
        // 1.生成token
        String orderToken = UUID.randomUUID().toString();
        String orderId = System.currentTimeMillis() + "";
        //2. 将该token存放到redis中
        redisUtils.setString(orderToken, orderId, 5L);
        OrderEntity orderEntity = new OrderEntity(null, "蚂蚁课堂永久会员", orderId, orderToken);
        int result = orderMapper.insertOrder(orderEntity);
        return result > 0 ? "success" : "fail";
    }
}
