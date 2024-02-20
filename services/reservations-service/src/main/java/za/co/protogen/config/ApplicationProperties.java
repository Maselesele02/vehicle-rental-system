package za.co.protogen.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "reservations-service")
public class ApplicationProperties {

    // Properties
    private String defaultStatus = "pending";
    private int maxReservationsAllowed = 5;

    // Getters and setters for the properties

    public String getDefaultStatus() {
        return defaultStatus;
    }

    public void setDefaultStatus(String defaultStatus) {
        this.defaultStatus = defaultStatus;
    }

    public int getMaxReservationsAllowed() {
        return maxReservationsAllowed;
    }

    public void setMaxReservationsAllowed(int maxReservationsAllowed) {
        this.maxReservationsAllowed = maxReservationsAllowed;
    }
}
