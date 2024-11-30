package com.easypan.entity.config;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Getter
@Component("appConfig")
public class AppConfig {
    /**
     * 文件目录
     */
    @Value("${project.folder:}")
    private String projectFolder;

    /**
     * 发送人
     */
    @Value("${spring.mail.username:}")
    private String sendUserName;


    @Value("${admin.emails:}")
    private String adminEmails;

    @Value("${dev:false}")
    private Boolean dev;

}
