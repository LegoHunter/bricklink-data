package net.bricklink.data.lego.ibatis.configuration;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Properties;

@Slf4j
@Getter
@Setter
@Primary
@Configuration
@ConfigurationProperties(prefix = "spring.datasource")
public class DataSourceProperties extends org.springframework.boot.autoconfigure.jdbc.DataSourceProperties {
    @JsonIgnore
    private Path clientConfigDir;

    @JsonIgnore
    private Path clientConfigFile;

    Databases databases;

    private Properties hikari;

    @JsonIgnore
    private String databaseKeyName;

    public void setClientConfigDir(Path clientConfigDir) {
        this.clientConfigDir = clientConfigDir;
        loadPropertiesFromJson();
    }

    public void setClientConfigFile(Path clientConfigFile) {
        this.clientConfigFile = clientConfigFile;
        loadPropertiesFromJson();
    }

    @Override
    public String determinePassword() {
        return Optional.ofNullable(super.determinePassword())
                       .orElseGet(() -> getDatabase(getDatabaseKeyName()).map(Database::getPassword)
                                                                         .orElse(null));
    }

    @Override
    public String determineUrl() {
        return getDatabase(getDatabaseKeyName()).map(Database::getUrl).orElseGet(super::determineUrl);
    }

    @Override
    public String determineUsername() {
        return getDatabase(getDatabaseKeyName()).map(Database::getUsername).orElseGet(super::determineUsername);
    }

    @Override
    public String determineDriverClassName() {
        return getDatabase(getDatabaseKeyName()).map(Database::getDriverClassName).orElseGet(super::determineDriverClassName);
    }

    @SuppressWarnings("unchecked")
    private void loadPropertiesFromJson() {
        Optional<Path> optionalDir = Optional.ofNullable(getClientConfigDir());
        Optional<Path> optionalFile = Optional.ofNullable(getClientConfigFile());
        if ((optionalDir.isPresent()) && (optionalFile.isPresent())) {
            Path jsonConfigFile = Paths.get(clientConfigDir.toString(), clientConfigFile.toString());
            if (Files.exists(jsonConfigFile)) {
                ObjectMapper mapper = new ObjectMapper();
                try {
                    databases = mapper.readValue(jsonConfigFile.toFile(), Databases.class);
                    log.info("Loaded secure configuration [{}] from path [{}]", clientConfigFile, clientConfigDir);
                } catch (IOException e) {
                    throw new LegoDataException(e);
                }
            } else {
                throw new LegoDataException("[" + jsonConfigFile.toAbsolutePath() + "] does not exist");
            }
        }
    }

    @JsonIgnore
    public Optional<Database> getDatabase(String key) {
        return Optional.ofNullable(databases)
                       .map(d -> d.databases.get(key));
    }

    @Data
    public static class Databases {
        private Map<String, Database> databases = new HashMap<>();
    }

    @Data
    public static class Database {
        private String url;
        private String username;
        private String password;
        private String driverClassName;
    }
}
