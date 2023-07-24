package apiAutomation.restassured.alterPojo;



import com.jayway.jsonpath.Configuration;
import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.PathNotFoundException;
import com.jayway.jsonpath.spi.json.JacksonJsonNodeJsonProvider;
import com.jayway.jsonpath.spi.mapper.JacksonMappingProvider;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Objects;

import static com.jayway.jsonpath.JsonPath.read;
import static com.jayway.jsonpath.JsonPath.using;

public class JSONHelper {
    public final Logger log = LogManager.getLogger(JSONHelper.class);

    public static Object getJsonValueFromResponseByCondition(Object jsonPathObj, String filter, String filterValue, String requestedSelector) {
        List<LinkedHashMap<String, Object>> jsonPathh = (List<LinkedHashMap<String, Object>>) jsonPathObj;
//jsonpathobj=resp.jsonpath.get(items)
        for (LinkedHashMap<String, Object> json : jsonPathh) {
            String json_result;
            json_result = String.valueOf(json.get(filter));
            if (json_result.equalsIgnoreCase(filterValue)) {
                return json.get(requestedSelector);
            }
        }
        return null;
    }
//

    private DocumentContext getJsonDocumentContext(String json) {
        Configuration configuration = Configuration.builder()
                .jsonProvider(new JacksonJsonNodeJsonProvider())
                .mappingProvider(new JacksonMappingProvider())
                .build();
        return using(configuration).parse(json);
    }

    public String updateJsonValue(String json, String jsonKey, Object newValue) {
        DocumentContext context = getJsonDocumentContext(json);
        ParseHelper parseHelper = new ParseHelper();
        try {
            Object o = read(json, jsonKey);
            String valueType = o.getClass().getSimpleName();

            switch (valueType) {
                case "Integer": {
                    Integer integerValue = parseHelper.parsStringToInt(String.valueOf(newValue));
                    if (integerValue != null)
                        context.set(jsonKey, integerValue);
                }
                break;
                case "Boolean": {
                    Boolean boolValue = parseHelper.parseStringToBoolean(String.valueOf(newValue));
                    if (boolValue != null)
                        context.set(jsonKey, boolValue);
                }
                break;
                case "Float": {
                    Float floatValue = parseHelper.parsStringToFloat(String.valueOf(newValue));
                    if (floatValue != null)
                        context.set(json, floatValue);
                }
                break;
                case "Double": {
                    Double doubleValue = parseHelper.parsStringToDouble(String.valueOf(newValue));
                    if (doubleValue != null)
                        context.set(jsonKey, doubleValue);
                }
                break;
                default:
                    context.set(jsonKey, newValue);
            }
            return context.jsonString();
        } catch (PathNotFoundException je) {
            log.warn("{} is couldn't find, in JSON \n{}", jsonKey, json);
            return json;
        }
    }

    public String getFile(String fileName) {
        InputStream is = Objects.requireNonNull(
                getClass()
                        .getClassLoader()
                        .getResourceAsStream("payloads/" + fileName));
        try {
            return new String(is.readAllBytes());
        } catch (IOException e) {
            throw new RuntimeException(String.format("An error occurred message:%s", e.getMessage()));
        }
    }

}