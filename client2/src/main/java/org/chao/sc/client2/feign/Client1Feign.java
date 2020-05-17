package org.chao.sc.client2.feign;

import feign.hystrix.FallbackFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "client1", fallbackFactory = Client1HystrixClientFallbackFactory.class)
public interface Client1Feign {
    @GetMapping("/getAuthor")
    String getAuthorFormClient1();
}

@Component
@Slf4j
class Client1HystrixClientFallbackFactory implements FallbackFactory<Client1Feign> {

    @Override
    public Client1Feign create(Throwable throwable) {
        return new Client1Feign() {
            @Override
            public String getAuthorFormClient1() {
                return "getAuthorFormClient1请求失败，熔断降级处理";
            }
        };
    }
}

