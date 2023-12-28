package org.example.postgresdb;

import java.io.IOException;
import java.io.InputStream;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.Properties;

/**
 * Reads properties from hibernate.properties
 */
public class PropertyReader {
    public static final String PROPERTY_FILE = "hibernate.properties";
    public static final String HIBERNATE_URL_PROP_NAME = "hibernate.connection.url";
    public static final String HIBERNATE_USER_PROP_NAME = "hibernate.connection.username";
    public static final String HIBERNATE_PASS_PROP_NAME = "hibernate.connection.password";

    /**
     * Reads DB URL from properties file
     */
    public static String getDBURL() {
        try {
            return getProperties(PROPERTY_FILE).get().getProperty(HIBERNATE_URL_PROP_NAME);
        } catch (NoSuchElementException ex) {
            System.out.println("Cannot find DB URL in " + PROPERTY_FILE);
            return "";
        }
    }

    /**
     * Reads DB user from properties file
     */
    public static String getDBUser() {
        try {
            return getProperties(PROPERTY_FILE).get().getProperty(HIBERNATE_USER_PROP_NAME);
        } catch (NoSuchElementException ex) {
            System.out.println("Cannot find DB User in " + PROPERTY_FILE);
            return "";
        }
    }

    /**
     * Reads DB password from properties file
     */
    public static String getDBPassword() {
        try {
            return getProperties(PROPERTY_FILE).get().getProperty(HIBERNATE_PASS_PROP_NAME);
        } catch (NoSuchElementException ex) {
            System.out.println("Cannot find DB Password in " + PROPERTY_FILE);
            return "";
        }
    }

    /**
     * Reads all properties from properties file
     */
    private static Optional<Properties> getProperties(String propertiesFile) {
        // read properties file as input stream
        try (InputStream input = PropertyReader.class.getClassLoader().getResourceAsStream(propertiesFile)) {

            if (input == null) {
                System.out.println("Cannot read properties. Unable to find " + propertiesFile);
                return Optional.empty();
            }

            Properties prop = new Properties();
            prop.load(input);
            return Optional.of(prop);

        } catch (IOException ex) {
            System.out.println("Cannot read properties. Reason: " + ex.getMessage());
            return Optional.empty();
        }
    }
}
