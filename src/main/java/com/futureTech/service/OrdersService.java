package com.futureTech.service;

import com.futureTech.entity.Orders;
import com.futureTech.entity.User;

import java.util.List;

/**
 * Created by Victor on 31.05.2017.
 */
public interface OrdersService {

    void save(Orders orders);

    List<Orders> findAll();

    Orders findOne(int id);

    void delete(int  id);

    void update(Orders orders);

    void deleteCommodityFromOrder(int orderId, int commodityId);

    List<Orders> findOrderByUser(User user);

}
