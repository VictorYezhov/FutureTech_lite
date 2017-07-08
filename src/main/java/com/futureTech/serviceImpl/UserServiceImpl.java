package com.futureTech.serviceImpl;

import com.futureTech.dao.UserDao;
import com.futureTech.entity.Role;
import com.futureTech.entity.User;
import com.futureTech.service.UserService;
import com.futureTech.validator.UserValidator.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

/**
 * Created by Victor on 31.05.2017.
 */
@Service("userDetailsService")
public class UserServiceImpl implements UserService, UserDetailsService {

    @Autowired
    UserDao userDao;

    @Autowired
    UserValidator userValidator;

    @Autowired
    private BCryptPasswordEncoder encoder;

    @Override
    public void save(User user) throws Exception{

        userValidator.validate(user);
        user.setRole(Role.ROLE_USER);
        user.setPassword(encoder.encode(user.getPassword()));
        user.setRegisterDate(LocalDate.now());
        userDao.save(user);
    }

    @Override
    public List<User> findAll() {
        return userDao.findAll();
    }

    @Override
    public User findOne(int id) {
        return userDao.findOne(id);
    }

    @Override
    public void delete(int id) {

        userDao.delete(id);
    }

    @Override
    public List<User> findAllByOrderByName() {
        return userDao.findAllByOrderByName();
    }

    @Override
    public void update(User user) {

        userDao.save(user);
    }

     public  void update(User user,MultipartFile image)
    {
       ImageSaver.saveImage(user,image);

        userDao.save(user);
    }

    @Override
    public User findByName(String name) {
        return userDao.findByName(name);
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return userDao.findByName(s);
    }

    @Override
    public User findByUuid(String uuid) {
        return userDao.findByUuid(uuid);
    }

    @Override
    public User findUserWithOrder(int id) {
        return userDao.findUserWithOrder(id);
    }
}
