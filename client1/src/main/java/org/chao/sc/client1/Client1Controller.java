package org.chao.sc.client1;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class Client1Controller {
    @Autowired
    private AuthorProperties authorProperties;

    @GetMapping("/getAuthor")
    public String getAuthor() throws JsonProcessingException {
        return new ObjectMapper().writeValueAsString(authorProperties);
    }
}
