package io.github.lvbo.learn.spring.boot.redis.service.impl;

import io.github.lvbo.learn.spring.boot.redis.service.MessageSourceService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Locale;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MessageSourceServiceImplTest {

    @Autowired
    private MessageSourceService messageSourceService;

    @Test
    public void getMessage() {
//        ResourceBundle rb1 = ResourceBundle.getBundle("i18n/performance-mgt", Locale.CHINA);
        System.out.println(messageSourceService.getMessage("operate.log.name.refresh", new Locale("cn", "zh")));
//        System.out.println(rb1.getString("operate.log.name.refresh"));
    }
}