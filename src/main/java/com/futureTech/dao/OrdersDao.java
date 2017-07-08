package com.futureTech.dao;

import com.futureTech.entity.Brand;
import com.futureTech.entity.Orders;
import com.futureTech.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by Victor on 31.05.2017.
 */
public interface OrdersDao extends JpaRepository<Orders, Integer> {

    List<Orders> findOrdersByUser(User user);

}
