package com.futureTech.service;

import com.futureTech.entity.Commodity;


import java.util.List;

/**
 * Created by Victor on 14.06.2017.
 */
public interface CommodityService {


    List<Commodity> findAll();

    Commodity findOne(int id);

    void  delete(int id);

    List<Commodity> doFilter(double startPrice, double endPrice);

    List<Commodity> search(String name);

    List<Commodity> findCommoditiesByPrices( double startPrice, double endPrice);

}
