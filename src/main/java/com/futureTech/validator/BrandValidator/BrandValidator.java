package com.futureTech.validator.BrandValidator;

import com.futureTech.dao.BrandDao;
import com.futureTech.entity.Brand;
import com.futureTech.validator.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by Victor on 08.06.2017.
 */
@Component
public class BrandValidator  implements Validator{

    @Autowired
    BrandDao  brandDao;


    @Override
    public void validate(Object o) throws Exception {



        Brand brand= (Brand) o;

        if(brandDao.findByName(brand.getName())!=null)
        {
            throw  new BrandExeption(BrandValidatorMessages.BRAND_ALREADY_EXISTS);
        }else if(brand.getName().isEmpty())
        {
            throw new  BrandExeption((BrandValidatorMessages.EMPTY_NAME_FIELD));
        }




    }
}
