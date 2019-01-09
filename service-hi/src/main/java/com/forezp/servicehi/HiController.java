package com.forezp.servicehi;

import com.forezp.servicehi.model.User;
import com.forezp.servicehi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HiController {

    @Value("${server.port}")
    String port;

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/hi",method = RequestMethod.GET)
    public String home(@RequestParam(value = "name",defaultValue = "ass") String name) {
        System.out.println("hi: " + name + "," + port);
        return "hi: " + name + "," + port;
    }

    @RequestMapping(value = "/actuator/info",method = RequestMethod.GET)
    public List<User> list() {
        List<User> userList = userService.getUserList();
        return userList;
    }

}
