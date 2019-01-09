package com.scfchapter.servicefeign;

import org.springframework.stereotype.Component;

/**
 * @ClassName: FeignServiceHiHystric
 * @Description: TODO
 * @Author: MSI
 * @Date: 2018/12/28 8:53
 * @Vresion: 1.0.0
 **/
@Component
public class SchedualServiceHiHystric implements SchedualServiceHi {
    @Override
    public String sayHiFromClientOne(String name) {
        return "sorry "+name;
    }
}
