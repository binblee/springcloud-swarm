package com.example.webfeign;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by libin on 30/05/2017.
 */

@FeignClient("bookservice")
public interface Bookservice {
    @RequestMapping("/")
    String index();
}
