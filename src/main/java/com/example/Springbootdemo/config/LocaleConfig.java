package com.example.Springbootdemo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import java.util.Locale;

/**
 * i18n config
 * 默认解析器：LocaleResolver用于设置当前会话的默认国际化语言
 * 默认拦截器：LocaleChangeInterceptor指定切换国际化语言的参数名。（ie：?lang=zh_CN表示读取国际化文件messages_zh_CN.properties）
 */
@Configuration
public class LocaleConfig {
    /**
     * set default locale resolver.
     * @return locale resolver
     */
    @Bean
    public LocaleResolver localeResolver() {
        SessionLocaleResolver localeResolver = new SessionLocaleResolver();
        localeResolver.setDefaultLocale(Locale.US);
        return localeResolver;
    }

    /**
     * default locale interceptor
     * 'lang' 表示切换语言的参数名
     * @return
     */
    @Bean
    public WebMvcConfigurer localeInterceptor() {
        return new WebMvcConfigurer() {
            @Override
            public void addInterceptors(InterceptorRegistry registry) {
                LocaleChangeInterceptor changeInterceptor = new LocaleChangeInterceptor();
                changeInterceptor.setParamName("lang");
                registry.addInterceptor(changeInterceptor);
            }
        };
    }
}
