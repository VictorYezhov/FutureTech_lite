package com.futureTech.dao;

import com.futureTech.entity.Brand;
import com.futureTech.entity.MP3;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Victor on 31.05.2017.
 */
public interface MP3Dao extends JpaRepository<MP3, Integer> {
}
