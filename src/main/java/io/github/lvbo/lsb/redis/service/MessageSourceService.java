package io.github.lvbo.lsb.redis.service;

import java.util.Locale;

/**
 * 国际化服务接口
 * @author lvbo
 */
public interface MessageSourceService {

    /**
     * 通过国际化code得到国际化信息
     * @param code 国际化code
     * @return 国际化信息
     */
    String getMessage(String code, Locale locale);

    /**
     * 通过国际化code得到国际化信息
     * @param code 国际化code
     * @param args 国际化参数
     * @return 国际化信息
     */
    String getMessage(String code, Object[] args, Locale locale);
}
