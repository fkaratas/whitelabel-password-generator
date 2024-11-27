package com.blackstone.wpg;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.validation.annotation.Validated;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@Validated
@AllArgsConstructor
@ConfigurationProperties(prefix = "application", ignoreUnknownFields = false)
public class WpgConfigurationProperties {

    @Valid
    @NotNull
    private final Locale locale;

    @Getter
    @AllArgsConstructor
    public static class Locale {
        private final @NotEmpty String paramName;
        private final @NotNull java.util.Locale defaultLanguage;
    }

    public String getLocaleParameterName() {
        return getLocale().getParamName();
    }

    public java.util.Locale getDefaultLocale() {
        return getLocale().getDefaultLanguage();
    }

}
