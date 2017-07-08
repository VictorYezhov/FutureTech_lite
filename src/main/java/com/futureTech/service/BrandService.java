package com.futureTech.service;

import com.futureTech.entity.Brand;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Victor on 31.05.2017.
 */
public interface BrandService {

    void save(Brand brand, MultipartFile image) throws Exception;

    List<Brand> findAll();

    Brand findOne(int id);

    void delete(int  id);

    void update(Brand brand);

    List<Brand> findAllByOrderByName();

}
