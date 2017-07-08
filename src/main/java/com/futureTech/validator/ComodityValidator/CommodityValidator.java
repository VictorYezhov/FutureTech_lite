package com.futureTech.validator.ComodityValidator;

import com.futureTech.dao.CommodityDao;
import com.futureTech.entity.Commodity;
import com.futureTech.validator.Validator;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by Victor on 06.06.2017.
 */
@Component
public class CommodityValidator implements Validator{



    @Autowired
    CommodityDao commodityDao;



    @Override
    public void validate(Object o) throws Exception {



        Commodity commodity = (Commodity) o;

        if(commodity.getBrand()==null)
        {
            throw  new CommodityExeption(CommodityValidatorMessages.EMPTY_BRAND_FIELD);
        } else if(commodity.getName().isEmpty())
        {
            throw new CommodityExeption(CommodityValidatorMessages.EMPTY_NAME_FIELD);
        } else if(commodity.getPrice()==0)
        {
            throw new CommodityExeption(CommodityValidatorMessages.EMPTY_PRICE_FIELD);
        } else if(commodityDao.findByName(commodity.getName())!=null)
        {
            throw  new CommodityExeption((CommodityValidatorMessages.COMMODITY_ALREADY_EXIST));
        }
    }
}
