package com.forezp.serviceribbon;

import com.alibaba.fastjson.JSONObject;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
public class HelloController {

    @Value("${hi.defaultZone}")
    String hiDefaultZone;

    @Autowired
    RestTemplate restTemplate;

    @GetMapping("/hi")
    public String hello(@RequestParam("name") String name) {
        String url = "http://SERVICE-HI/hi?name=" + name;
        return restTemplate.getForObject(url,String.class);
    }

    /**
     * @Author MSI
     * @Description 添加用户
     * @Date 2018/12/26 14:54
     * @Param [data]
     * @return java.lang.String
     **/
    @PostMapping("/user")
    @HystrixCommand(fallbackMethod = "hiError")
    public String addUser(@RequestBody JSONObject data) {
        return restTemplate.postForObject(hiDefaultZone,data,String.class);
    }

    /**
     * @Author MSI
     * @Description 用户删除
     * @Date 2018/12/26 16:38
     * @Param [id]
     * @return java.lang.String 
     **/       
    @DeleteMapping("/user")
    public String deleteUser(@PathVariable Integer id) {
        restTemplate.delete(hiDefaultZone,id);
        return "Success!!!";
    }

    /**
     * @Author MSI
     * @Description 用户修改
     * @Date 2018/12/26 16:38
     * @Param [id, data]
     * @return java.lang.String 
     **/       
    @PutMapping("/user/{id}")
    public String updateUser(@PathVariable Integer id,@RequestBody JSONObject data) {
        User user = new User();
        user.setId(id);
        user.setUserName(data.getString("userName"));
        user.setPassword(data.getString("password"));
        restTemplate.put(hiDefaultZone + "/{id}",user,user.getId());
        return "Success!";
    }

    /**
     * @Author MSI
     * @Description 用户详情
     * @Date 2018/12/26 16:38
     * @Param [id]
     * @return com.forezp.serviceribbon.User 
     **/       
    @GetMapping("/user/{userName}")
    public User dateil(@PathVariable String userName) {
        return restTemplate.getForObject(hiDefaultZone + "/{userName}",User.class,userName);
    }

    /**
     * @Author MSI
     * @Description 用户列表查询
     * @Date 2018/12/26 14:21
     * @Param []
     * @return java.lang.String
     **/
    @GetMapping("/user")
    public String list() {
        String url = hiDefaultZone;
        return restTemplate.getForObject(url,String.class);
    }

    public String hiError(@RequestBody JSONObject data) {
        return data.getString("userName: ") + "ERROR !!!";
    }
}
