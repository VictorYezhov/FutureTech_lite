package com.futureTech.service;

import com.futureTech.entity.MP3;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * Created by Victor on 31.05.2017.
 */
public interface MP3Service {

    void save(MP3 mp3,MultipartFile image);

    List<MP3> findAll();

    Page<MP3> findAllPages(Pageable pageable);

    MP3 findOne(int id);

    void delete(int  id);

    void update(MP3 mp3);

}
