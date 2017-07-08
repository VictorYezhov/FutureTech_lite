package com.futureTech.dao;

import com.futureTech.entity.Brand;
import com.futureTech.entity.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by Victor on 31.05.2017.
 */
public interface UserDao extends JpaRepository<User, Integer> {


    /*left join fetch o.commodityList*/
    @Query("select u from User u left join fetch u.orders o where u.id=:id")
    User findUserWithOrder(@Param("id") int id);

    User findByName(String name);
    User findByEmail(String email);
    List<User> findAllByOrderByName();

    @Query("select u from User u where u.uuid=:uuid")
    User findByUuid(@Param("uuid") String uuid);



}
