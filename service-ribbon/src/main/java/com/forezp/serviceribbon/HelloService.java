/*
package com.forezp.serviceribbon;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class HelloService {

    @Value("${hi.defaultZone}")
    String hiDefaultZone;

    @Autowired
    RestTemplate restTemplate;

    public String getHiService(String name) {
        String url = "http://SERVICE-HI/hi?name=" + name;
        return restTemplate.getForObject(url,String.class);
    }

    public String addUser(JSONObject data) {
        return restTemplate.postForObject(hiDefaultZone,data,String.class);
    }

    public String deleteUser(Integer id) {
        restTemplate.delete(hiDefaultZone,id);
        return "Success!!!";
    }

    public String updateUser(User user) {
        restTemplate.put(hiDefaultZone + "/{id}",user,user.getId());
        return "Success!";
    }
    //g

    public User dateil(Integer id) {
        return restTemplate.getForObject(hiDefaultZone + "/{id}",User.class);
    }

    public String list() {
        String url = hiDefaultZone + "/user";
        return restTemplate.getForObject(url,String.class);
    }

}
*/
