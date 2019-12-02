package com.example.Springbootdemo.common.i18n;

import org.springframework.util.StringUtils;

public enum LanguageEnum {
    LANGUAGE_ZH_CN("zh_CN"),
    LANGUAGE_EN_US("en_US");
    private String language;
    LanguageEnum(String language) {
        this.language = language;
    }
    @Override
    public String toString() {
        return language;
    }
    public static String getLanguageType(String language) {
        if (StringUtils.isEmpty(language)) {
            return LANGUAGE_ZH_CN.language;
        }
        for (LanguageEnum languageEnum : LanguageEnum.values()) {
            if (languageEnum.language.equalsIgnoreCase(language)) {
                return languageEnum.language;
            }
        }
        return LANGUAGE_ZH_CN.language;
    }
}
