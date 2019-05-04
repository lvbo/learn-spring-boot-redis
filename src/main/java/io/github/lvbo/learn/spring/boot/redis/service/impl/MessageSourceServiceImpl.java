package io.github.lvbo.learn.spring.boot.redis.service.impl;

import io.github.lvbo.learn.spring.boot.redis.service.MessageSourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import java.util.Locale;

/**
 * 国际化服务实现类
 * @author lvbo
 */
@Service
public class MessageSourceServiceImpl implements MessageSourceService  {

    @Autowired
    private MessageSource messageSource;

    @Override
    public String getMessage(String code, Locale locale) {
        return messageSource.getMessage(code, null, locale);
    }

    @Override
    public String getMessage(String code, Object[] args, Locale locale) {
        return messageSource.getMessage(code, args, locale);
    }
}
