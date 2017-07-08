package com.futureTech.dao;


import com.futureTech.entity.MobileTelephone;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Victor on 31.05.2017.
 */
public interface MobileTelephoneDao extends JpaRepository<MobileTelephone, Integer> {
}
