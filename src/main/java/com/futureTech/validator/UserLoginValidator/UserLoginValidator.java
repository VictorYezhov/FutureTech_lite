package com.futureTech.validator.UserLoginValidator;

import com.futureTech.dao.UserDao;
import com.futureTech.entity.User;
import com.futureTech.validator.UserValidator.UserExeption;
import com.futureTech.validator.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

/**
 * Created by terty on 07.07.2017.
 */
@Component
public class UserLoginValidator implements Validator {

    @Autowired
    private UserDao userDao;

    @Autowired
    private BCryptPasswordEncoder encoder;

    @Override
    public void validate(Object o) throws Exception {

        User user = (User) o;

        if (user.getName().isEmpty()) {
            throw new UserExeption(UserLoginValidatorMessages.EMPTY_USERNAME_FIELD);
        }else if (userDao.findByName(user.getName()) == null) {
            throw new UserExeption(UserLoginValidatorMessages.WRONG_USERNAME_OR_PASSWORD);
        }else if (encoder.matches(user.getPassword(), userDao.findByName(user.getName()).getPassword())) {
            throw new UserExeption(UserLoginValidatorMessages.WRONG_USERNAME_OR_PASSWORD);
        }

    }
}
