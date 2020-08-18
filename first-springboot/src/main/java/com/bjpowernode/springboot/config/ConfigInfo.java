package com.bjpowernode.springboot.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author: tianxin
 * @create: 2020-08-14 13:13
 */
@Component
//@ConfigurationProperties(prefix = "boot")
public class ConfigInfo {

    private String name;
    private String location;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
