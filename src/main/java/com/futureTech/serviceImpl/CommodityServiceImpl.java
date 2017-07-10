package com.futureTech.serviceImpl;

import com.futureTech.dao.CommodityDao;
import com.futureTech.entity.Commodity;
import com.futureTech.service.CommodityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Victor on 14.06.2017.
 */
@Service
public class CommodityServiceImpl implements CommodityService{

    @Autowired
    CommodityDao commodityDao;



    @Override
    public List<Commodity> findAll() {
        return commodityDao.findAll();
    }

    @Override
    public Commodity findOne(int id) {
        return commodityDao.findOne(id);
    }

    @Override
    public void delete(int id) {
        commodityDao.delete(id);
    }

    @Override
    public List<Commodity> doFilter(double startPrice, double endPrice) {

        return findCommoditiesByPrices(startPrice,endPrice);
    }

    @Override
    public List<Commodity> search(String name) {
        return commodityDao.findCommoditiesByName(name);
    }

    @Override
    public List<Commodity> findCommoditiesByPrices(double startPrice, double endPrice) {
        return commodityDao.findCommoditiesByPrices(startPrice,endPrice);
    }

    @Override
    public double findCommodityWitMaxPrice() {

        return commodityDao.findCommodityWitMaxPrice();
    }
}
