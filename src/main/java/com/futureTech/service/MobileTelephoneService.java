package com.futureTech.service;


import com.futureTech.entity.MobileTelephone;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * Created by Victor on 31.05.2017.
 */
public interface MobileTelephoneService {

    void save(MobileTelephone mobileTelephone, MultipartFile image) throws Exception;

    List<MobileTelephone> findAll();

    Page<MobileTelephone> findAllPages (Pageable pageable);

    MobileTelephone findOne(int id);

    void delete(int  id);

    void update(MobileTelephone telephone);

}
