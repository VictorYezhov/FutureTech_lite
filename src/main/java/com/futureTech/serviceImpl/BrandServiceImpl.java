package com.futureTech.serviceImpl;

import com.futureTech.dao.BrandDao;
import com.futureTech.entity.Brand;
import com.futureTech.service.BrandService;
import com.futureTech.validator.BrandValidator.BrandValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * Created by Victor on 31.05.2017.
 */
@Service
public class BrandServiceImpl implements BrandService {

    @Autowired
    BrandDao brandDao;

    @Autowired
    BrandValidator brandValidator;
    @Override
    public void save(Brand brand, MultipartFile image) throws Exception {

        brandValidator.validate(brand);
        brandDao.saveAndFlush(brand);

        ImageSaver.saveImage(brand, image);

        brandDao.save(brand);
    }

    @Override
    public List<Brand> findAll() {
        return brandDao.findAll();
    }

    @Override
    public Brand findOne(int id) {
        return brandDao.findOne(id);
    }

    @Override
    public void delete(int id) {

        brandDao.delete(id);
    }

    @Override
    public List<Brand> findAllByOrderByName() {
        return brandDao.findAllByOrderByName();
    }

    @Override
    public void update(Brand brand) {

        brandDao.save(brand);
    }
}
