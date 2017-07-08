package com.futureTech.serviceImpl;

import com.futureTech.dao.PCDao;
import com.futureTech.entity.PC;
import com.futureTech.service.PCService;
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
public class PCServiceImpl implements PCService {

    @Autowired
    PCDao pcDao;

    @Override
    public void save(PC pc,MultipartFile image) {

        ImageSaver.saveImage(pc,image);
        pcDao.save(pc);
    }

    @Override
    public List<PC> findAll() {
        return pcDao.findAll();
    }

    @Override
    public PC findOne(int id) {
        return pcDao.findOne(id);
    }

    @Override
    public void delete(int id) {

        pcDao.delete(id);
    }

    @Override
    public void update(PC pc) {

        pcDao.save(pc);
    }

    @Override
    public Page<PC> findAllPages(Pageable pageable) {
        return pcDao.findAll(pageable);
    }
}
