package com.futureTech.dao;

import com.futureTech.entity.Brand;
import com.futureTech.entity.Tablet;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Victor on 31.05.2017.
 */
public interface TabletDao extends JpaRepository<Tablet, Integer> {

}
