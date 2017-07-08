package com.futureTech.service;

import com.futureTech.entity.PC;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * Created by Victor on 31.05.2017.
 */
public interface PCService {

    void save(PC pc,MultipartFile image);

    List<PC> findAll();

    Page<PC> findAllPages(Pageable pageable);

    PC findOne(int id);

    void delete(int  id);

    void update(PC pc);
}
