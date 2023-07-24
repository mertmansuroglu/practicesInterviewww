package apiAutomation.restassured.alterPojo;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ParseHelper {
    public final Logger log = LogManager.getLogger(ParseHelper.class);

    /**
     * it parses string to int if the string parsable to boolean.
     * it loges the error if the string is not parsable to boolean and returns null.
     */
    public Integer parsStringToInt(String value) {
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException e) {
            log.warn("Found json value is integer, but the {} isn't parsable to integer, " +
                    "please set  a new integer value for update.", value);
        }
        return null;
    }

    public Boolean parseStringToBoolean(String value) {
        if (value.equalsIgnoreCase("false") || value.equalsIgnoreCase("true")) {
            return Boolean.parseBoolean(value);
        } else {
            log.warn("Found json value is boolean, but the {}, isn't boolean string, please set " +
                    "a new ture or false string for update", value);
        }
        return false;
    }

    public Float parsStringToFloat(String value) {
        try {
            return Float.parseFloat(value);
        } catch (NumberFormatException e) {
            log.warn("Found json value is float, but the {} isn't parsable to float, " +
                    "please set  a new float value for update.", value);
        }
        return null;
    }

    public Double parsStringToDouble(String value) {
        try {
            return Double.parseDouble(value);
        } catch (NumberFormatException e) {
            log.warn("Found json value is double, but the {} isn't parsable to double, " +
                    "please set  a new double value for update.", value);
        }
        return null;
    }
}

