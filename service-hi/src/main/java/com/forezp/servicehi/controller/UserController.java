package com.forezp.servicehi.controller;

import com.alibaba.fastjson.JSONObject;
import com.forezp.servicehi.model.User;
import com.forezp.servicehi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * @Author MSI
     * @Description 添加用户
     * @Date 2018/12/24 15:33
     * @Param [userName, password]
     * @return java.lang.String
     **/
    @PostMapping("/user")
    public String addUser(@RequestBody JSONObject data) {
        String userName = data.getString("userName");
        String password = data.getString("password");

        User user = new User();
        user.setUserName(userName);
        user.setPassword(password);
        if (userService.addUser(user) > 0 ) {
            return "Success!userName: " + userName +",password: " + password;
        }
        return "error!!!";
    }

    /**
     * @Author MSI
     * @Description 删除用户
     * @Date 2018/12/24 15:39
     * @Param [id]
     * @return java.lang.String
     **/
    @DeleteMapping("/user/{id}")
    public String  deleteUser(@PathVariable Integer id) {
        if (userService.deleteUser(id) > 0) {
            return "Success!delete: " + id;
        }
        return "error!!!";
    }

    /**
     * @Author MSI
     * @Description 用户修改
     * @Date 2018/12/26 14:28
     * @Param [id, data]
     * @return java.lang.String 
     **/       
    @PutMapping("/user/{id}")
    public String updateUser(@PathVariable Integer id,@RequestBody JSONObject data) {
        User user = new User();
        String userName = data.getString("userName");
        String password = data.getString("password");
        user.setId(id);
        user.setUserName(userName);
        user.setPassword(password);
        if (userService.updateUser(user) > 0) {
            return "Success!ID: " + id + ",userName: " + userName +",password: " + password;
        }
        return "error!!!";
    }

    /**
     * @Author MSI
     * @Description 用户详情
     * @Date 2018/12/26 14:28
     * @Param [userName]
     * @return java.lang.String
     **/
    @GetMapping("/user/{userName}")
    public String detail(@PathVariable String userName) {
        String result = userService.detail(userName);
        if (result == null) {
            return "error!!!";
        }
        return result;
    }

    /**
     * @Author MSI
     * @Description 用户列表查询方法
     * @Date 2018/12/24 10:12
     * @Param [userName]
     * @return java.util.List<com.forezp.servicehi.model.User>
     **/
    @GetMapping("/user")
    public List<User> list() {
        List<User> userList = userService.getUserList();
        return userList;
    }

}
