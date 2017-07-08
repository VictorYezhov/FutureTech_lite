package com.futureTech.validator.UserValidator;

import com.futureTech.dao.UserDao;
import com.futureTech.entity.User;
import com.futureTech.validator.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by Victor on 06.06.2017.
 */

@Component
public class UserValidator implements Validator {


    @Autowired
    private UserDao userDao;

    @Override
    public void validate(Object o) throws Exception {

        User user = (User) o;

        if (user.getName().isEmpty()) {
            throw new UserExeption(UserValidatorMessages.EMPTY_USERNAME_FIELD);
        } else if (userDao.findByName(user.getName()) != null) {
            throw new UserExeption(UserValidatorMessages.USERNAME_ALREADY_EXIST);
        } else  if(user.getEmail().isEmpty())
        {
            throw  new UserExeption(UserValidatorMessages.EMPTY_EMAIL_FIELD);
        }else if(!user.getEmail().contains("@")||!user.getEmail().contains("."))
        {
            throw  new UserExeption(UserValidatorMessages.INCORRECT_EMAIL);
        }else if(userDao.findByEmail(user.getEmail())!=null)
        {
            throw new UserExeption(UserValidatorMessages.EMAIL_ALREDY_EXIST);
        }
        else  if(user.getPassword().isEmpty())
        {
            throw  new UserExeption(UserValidatorMessages.EMPTY_PASSWORD_FIELD);
        }else if(user.getPassword().length()<4)
        {
            throw  new UserExeption(UserValidatorMessages.INCORRECT_PASSWORD_FIELD);
        }




    }
}
