package net.bricklink.data.lego.ibatis.configuration;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@Getter
@Setter
@ConfigurationProperties
public class DatabaseProperties {
    private Map<String, Database> databases = new HashMap<>();

    @Data
    public static class Database {
        private String url;
        private String username;
        private String password;
        private String driverClassName;
    }
}
