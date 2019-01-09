package com.forezp.servicehi.service;

import com.forezp.servicehi.dao.UserDao;
import com.forezp.servicehi.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    public int addUser(User user) {
        return userDao.addUser(user);
    }

    public int deleteUser(Integer id) {
        return userDao.deleteUser(id);
    }

    public int updateUser(User user) {
        return userDao.updateUser(user);
    }

    public String detail(String userName2333) {
        return userDao.detail(userName2333);
    }

    public List<User> getUserList() {
        return userDao.getListUser();
    }

}
