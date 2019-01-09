package com.forezp.servicezuul;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.stereotype.Component;

/**
 * @ClassName: MyFilter
 * @Description: 自定义过滤器，测试用
 * @Author: MSI
 * @Date: 2018/12/28 16:44
 * @Vresion: 1.0.0
 **/
@Component
public class MyFilter extends ZuulFilter {
    /**
     * @Author MSI
     * @Description 过滤器执行类型   pre：路由之前，  routing：路由之时，  post： 路由之后，  error：发送错误调用
     * @Date 2018/12/28 17:02
     * @Param []
     * @return java.lang.String 
     **/       
    @Override
    public String filterType() {
        return "pre";
    }

    /**
     * @Author MSI
     * @Description 返回执行顺序
     * @Date 2018/12/28 17:04
     * @Param []
     * @return int
     **/
    @Override
    public int filterOrder() {
        return 10;
    }

    /**
     * @Author MSI
     * @Description 过滤判定
     * @Date 2018/12/28 17:04
     * @Param []  返回true，在任何情况下都执行过滤操作
     * @return boolean
     **/
    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        System.out.println("Filter1");
        return null;
    }
}
