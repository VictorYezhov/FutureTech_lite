package com.futureTech.service;

import com.futureTech.entity.User;
import com.futureTech.validator.UserValidator.UserExeption;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface UserService {

    void save(User user) throws UserExeption, Exception;

    List<User> findAll();

    User findOne(int id);

    void delete(int  id);

    void update(User user);

    void update(User user,MultipartFile image);



    User findByName(String name);

    List<User> findAllByOrderByName();

    User findUserWithOrder(int id);

    User findByUuid(String uuid);
}
