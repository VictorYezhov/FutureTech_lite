package com.futureTech.serviceImpl;

import com.futureTech.dao.MP3Dao;
import com.futureTech.entity.MP3;
import com.futureTech.service.MP3Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * Created by Victor on 31.05.2017.
 */
@Service
public class MP3ServiceImpl implements MP3Service {

    @Autowired
    MP3Dao mp3Dao;
    @Override
    public void save(MP3 mp3,MultipartFile image) {

        ImageSaver.saveImage(mp3,image);
        mp3Dao.save(mp3);

    }

    @Override
    public List<MP3> findAll() {
        return mp3Dao.findAll();
    }

    @Override
    public MP3 findOne(int id) {
        return mp3Dao.findOne(id);
    }

    @Override
    public void delete(int id) {

        mp3Dao.delete(id);
    }

    @Override
    public void update(MP3 mp3) {

        mp3Dao.save(mp3);
    }

    @Override
    public Page<MP3> findAllPages(Pageable pageable) {
        return mp3Dao.findAll(pageable);
    }
}
