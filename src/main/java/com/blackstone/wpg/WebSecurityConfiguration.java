package com.blackstone.wpg;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.HeadersConfigurer;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.header.writers.ReferrerPolicyHeaderWriter.ReferrerPolicy;

@Configuration
@EnableWebSecurity
public class WebSecurityConfiguration {

    @Bean
    public SecurityFilterChain filterChain(final HttpSecurity http) throws Exception {
        http.headers(securityHeaderCustomizer());

        return http.build();
    }

    private static Customizer<HeadersConfigurer<HttpSecurity>> securityHeaderCustomizer() {
        return headers -> headers //
                .contentSecurityPolicy(contentSecurityPolicyCustomizer()) //
                .referrerPolicy(referrerPolicyCustomizer()) //
                .permissionsPolicyHeader(permissionsPolicyCustomizer());
    }

    private static Customizer<HeadersConfigurer<HttpSecurity>.ContentSecurityPolicyConfig> contentSecurityPolicyCustomizer() {
        return csp -> csp.policyDirectives( //
                "default-src 'self'; " //
                        + "script-src 'self' 'unsafe-inline'; " //
                        + "img-src 'self' data: http:; " //
        );
    }

    private static Customizer<HeadersConfigurer<HttpSecurity>.ReferrerPolicyConfig> referrerPolicyCustomizer() {
        return referrer -> referrer.policy(ReferrerPolicy.STRICT_ORIGIN_WHEN_CROSS_ORIGIN);
    }

    private static Customizer<HeadersConfigurer<HttpSecurity>.PermissionsPolicyConfig> permissionsPolicyCustomizer() {
        return c -> c.policy("geolocation=(self)");
    }

}
