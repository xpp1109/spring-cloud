package org.chao.sc.client1;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class Client1Controller {

    @Value("${encryptContent}")
    private String encryptContent;

    @Value("${author}")
    private String author;
    @GetMapping("/getEncryptContent")
    public String getEncryptContent(){
        return encryptContent + "author=" + author;
    }
}
