package org.chao.sc.client1;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(value = "author")
@Data
public class AuthorProperties {
    private String name;
    private String pwd;
}
