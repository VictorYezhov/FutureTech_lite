package com.futureTech.serviceImpl;

import com.futureTech.dao.MobileTelephoneDao;
import com.futureTech.entity.MobileTelephone;
import com.futureTech.service.MobileTelephoneService;
import com.futureTech.validator.ComodityValidator.CommodityValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * Created by Victor on 31.05.2017.
 */
@Service
public class MobileTelephoneServiceImpl implements MobileTelephoneService{
    @Autowired
    MobileTelephoneDao mobileTelephoneDao;

    @Autowired
    @Qualifier("commodityValidator")
    CommodityValidator commodityValidator;

    @Override
    public void save(MobileTelephone mobileTelephone, MultipartFile image) throws Exception {

        commodityValidator.validate(mobileTelephone);
        mobileTelephoneDao.saveAndFlush(mobileTelephone);
        ImageSaver.saveImage(mobileTelephone,image);
        mobileTelephoneDao.save(mobileTelephone);
    }

    @Override
    public List<MobileTelephone> findAll() {
        return mobileTelephoneDao.findAll();
    }

    @Override
    public MobileTelephone findOne(int id) {
        return mobileTelephoneDao.findOne(id);
    }

    @Override
    public void delete(int id) {

        mobileTelephoneDao.delete(id);
    }

    @Override
    public void update(MobileTelephone telephone) {

        mobileTelephoneDao.save(telephone);
    }

    @Override
    public Page<MobileTelephone> findAllPages(Pageable pageable) {
        return mobileTelephoneDao.findAll(pageable);
    }
}
