package com.xyz.consulclient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by lmz on 2017/7/10.
 */
@RestController
public class DiscoveryController {
    @Autowired
    private DiscoveryClient discoveryClient;

    @Autowired
    private Environment environment;

    @RequestMapping("/hello")
    public Object hello(@RequestParam String name) {
        if (environment.getActiveProfiles()[0].equalsIgnoreCase("dev")) {
            System.out.println("1111111111111");
            return "hello " + name + ", from instance-1";
        } else {
            System.out.println("2222222222222");
            return "hello " + name + ", from instance-2";
        }
    }

    @GetMapping("/dc")
    public String dc() {
        String services = "services: " + discoveryClient.getServices();
        return services;
    }
}
