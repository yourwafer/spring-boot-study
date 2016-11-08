package com.tw.study.springboot.config;

import jersey.repackaged.com.google.common.base.Joiner;
import org.glassfish.jersey.jackson.JacksonFeature;
import org.glassfish.jersey.message.filtering.EntityFilteringFeature;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.internal.process.Endpoint;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import javax.ws.rs.ApplicationPath;

@Configuration
@ApplicationPath("api")
public class JerseyConfig extends ResourceConfig {
    private static final String[] MODULE_PACKAGES = new String[]{
            "com.tw.study.sprintboot.endpoint",
    };

    public JerseyConfig() {
        // common packages
        this.packages(
                "com.tw.study.springboot.endpoint.handlerr"
        );

        // module packages
        this.packages(
                MODULE_PACKAGES
        );

        this.registerClasses(
                EntityFilteringFeature.class,
                JacksonFeature.class
        );

    }
}