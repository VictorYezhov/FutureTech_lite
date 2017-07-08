package com.futureTech.serviceImpl;

import com.futureTech.dao.CommodityDao;
import com.futureTech.dao.OrdersDao;
import com.futureTech.entity.Commodity;
import com.futureTech.entity.Orders;
import com.futureTech.entity.User;
import com.futureTech.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Victor on 31.05.2017.
 */
@Service
public class OrdersServiceImpl implements OrdersService {

    @Autowired
    OrdersDao ordersDao;

    @Autowired
    CommodityDao commodityDao;

    @Override
    public void save(Orders orders) {

        ordersDao.save(orders);
    }

    @Override
    public List<Orders> findAll() {
        return ordersDao.findAll();
    }

    @Override
    public Orders findOne(int id) {
        return ordersDao.findOne(id);
    }

    @Override
    public void delete(int id) {

        ordersDao.delete(id);
    }

    @Override
    public void update(Orders orders) {

        ordersDao.save(orders);
    }

    @Override
    public void deleteCommodityFromOrder(int orderId, int commodityId) {

        Orders order=ordersDao.findOne(orderId);

        Commodity commodity = commodityDao.findOne(commodityId);

        boolean remove=order.getCommoditySet().remove(commodity);

        if(remove) {
            System.out.println("REMOVE");
        }
        ordersDao.save(order);

    }

    @Override
    public List<Orders> findOrderByUser(User user) {
        return ordersDao.findOrdersByUser(user);
    }
}
