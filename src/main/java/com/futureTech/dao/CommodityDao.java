package com.futureTech.dao;

import com.futureTech.entity.Commodity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by Victor on 06.06.2017.
 */
public interface CommodityDao extends JpaRepository<Commodity, Integer> {

    Commodity findByName(String name);

    @Query("select c from Commodity  c where  c.name like  CONCAT('%',:name,'%')")
    List<Commodity> findCommoditiesByName(@Param("name")String name);

    @Query("select  c from  Commodity  c where  c.price between  :startPrice and  :endPrice")
    List<Commodity> findCommoditiesByPrices(@Param("startPrice") double startPrice, @Param("endPrice") double endPrice);

    @Query("select max(c.price)  from  Commodity c")
    double findCommodityWitMaxPrice();

}
