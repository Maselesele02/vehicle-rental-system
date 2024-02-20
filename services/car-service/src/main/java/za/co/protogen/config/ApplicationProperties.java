package za.co.protogen.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "cars-service")
public class ApplicationProperties {

    // Properties
    private String defaultColor = "black";
    private int maxCarsAllowed = 5;

    // Getters and setters for the properties

    public String getDefaultColor() {
        return defaultColor;
    }

    public void setDefaultColor(String defaultColor) {
        this.defaultColor = defaultColor;
    }

    public int getMaxCarsAllowed() {
        return maxCarsAllowed;
    }

    public void setMaxCarsAllowed(int maxCarsAllowed) {
        this.maxCarsAllowed = maxCarsAllowed;
    }
}
