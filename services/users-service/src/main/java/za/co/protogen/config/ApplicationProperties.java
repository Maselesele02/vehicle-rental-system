package za.co.protogen.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "users-service")
public class ApplicationProperties {

    // Properties
    private String defaultRole = "admin";
    private int maxUsersAllowed = 5;

    // Getters and setters for the properties

    public String getDefaultRole() {
        return defaultRole;
    }

    public void setDefaultRole(String defaultRole) {
        this.defaultRole = defaultRole;
    }

    public int getMaxUsersAllowed() {
        return maxUsersAllowed;
    }

    public void setMaxUsersAllowed(int maxUsersAllowed) {
        this.maxUsersAllowed = maxUsersAllowed;
    }
}
