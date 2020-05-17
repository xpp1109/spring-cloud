package org.chao.sc.circuitbreaker;

import com.netflix.hystrix.HystrixCommandProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@SpringCloudApplication
@RestController
@RequestMapping("cb")
public class CircuitBreakerApplication {
    public static void main(String[] args) {
        SpringApplication.run(CircuitBreakerApplication.class, args);
    }
    @Autowired
    StoreIntegration storeIntegration;
    @GetMapping("")
    public Object testCircuitBreaker(){
        Object stores = storeIntegration.getStores(null);
        return stores;
    }
}
