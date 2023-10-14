package util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * The PropertiesUtil class provides methods for interacting with properties files.
 * This class includes a method to get the value of a property by its key.
 *
 * @author Aliaksandr Khaukhliantsau
 * @version 1.0
 */
public final class PropertiesUtil {

    /**
     * The properties object that holds the loaded properties.
     */
    private static final Properties PROPERTIES = new Properties();

    static {
        loadProperties();
    }

    /**
     * Private constructor to prevent instantiation of this utility class.
     */
    private PropertiesUtil() {
    }

    /**
     * Loads the properties from the 'config.properties' file.
     *
     * @throws RuntimeException If an error occurs while loading the properties.
     */
    private static void loadProperties() {
        try (InputStream inputStream = PropertiesUtil.class.getClassLoader().getResourceAsStream("config.properties")) {
            PROPERTIES.load(inputStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Retrieves the value of a property by its key.
     *
     * @param key The key of the property to retrieve.
     * @return The value of the property with the specified key.
     */
    public static String get(String key) {
        return PROPERTIES.getProperty(key);
    }
}
