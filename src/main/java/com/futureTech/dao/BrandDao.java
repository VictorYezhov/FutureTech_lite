package com.futureTech.dao;

import com.futureTech.entity.Brand;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by Victor on 31.05.2017.
 */
public interface BrandDao extends JpaRepository<Brand, Integer> {

    List<Brand> findAllByOrderByName();
    Brand findByName(String name);
}
