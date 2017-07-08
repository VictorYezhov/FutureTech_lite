package com.futureTech.serviceImpl;

import com.futureTech.dao.TabletDao;
import com.futureTech.entity.Tablet;
import com.futureTech.service.TabletService;
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
public class TabletServiceImpl implements TabletService {

    @Autowired
    TabletDao  tabletDao;

    @Override
    public void save(Tablet tablet,MultipartFile image) {

        ImageSaver.saveImage(tablet,image);
        tabletDao.save(tablet);
    }

    @Override
    public List<Tablet> findAll() {
        return tabletDao.findAll();
    }

    @Override
    public Tablet findOne(int id) {
        return tabletDao.findOne(id);
    }

    @Override
    public void delete(int id) {

        tabletDao.delete(id);
    }

    @Override
    public void update(Tablet tablet) {

        tabletDao.save(tablet);
    }

    @Override
    public Page<Tablet> findAllPages(Pageable pageable) {
        return tabletDao.findAll(pageable);
    }
}
