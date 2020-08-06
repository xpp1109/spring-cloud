package org.chao.sc.admin;

import org.chao.sc.admin.feign.Client1Feign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringCloudApplication
@EnableFeignClients
@RestController
@RequestMapping("/")
public class Client2Application {
    public static void main(String[] args) {
        SpringApplication.run(Client2Application.class, args);
    }
    @Autowired
    private Client1Feign client1Feign;
    @GetMapping("feignTest")
    public String feignTest(){
        return "当前服务是client2，请求client1的getAuthor接口， 返回" + client1Feign.getAuthorFormClient1();
    }
}
