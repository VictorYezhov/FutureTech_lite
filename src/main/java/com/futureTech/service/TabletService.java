package com.futureTech.service;

import com.futureTech.entity.Tablet;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * Created by Victor on 31.05.2017.
 */
public interface TabletService {

    void save(Tablet tablet, MultipartFile image);

    List<Tablet> findAll();

    Page<Tablet> findAllPages(Pageable pageable);

    Tablet findOne(int id);

    void delete(int  id);

    void update(Tablet tablet);

}
