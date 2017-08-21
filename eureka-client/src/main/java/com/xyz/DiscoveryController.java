package com.xyz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by lmz on 2017/7/10.
 */
@RestController
public class DiscoveryController {
    @Autowired
    private DiscoveryClient discoveryClient;

    @GetMapping("/dc")
    public String dc() {
        String services = "services: " + discoveryClient.getServices();
        return services;
    }
    @GetMapping("/hello")
    public List<ServiceInstance> hello() {
        ServiceInstance serviceInstance = discoveryClient.getLocalServiceInstance();
        System.out.println("host:" + serviceInstance.getHost());
        System.out.println("port:" + serviceInstance.getPort());
        System.out.println("serviceId:" + serviceInstance.getServiceId());

        List<ServiceInstance> serviceInstanceList = discoveryClient.getInstances("eureka-client");
        return serviceInstanceList;
    }
}
