package apiAutomation.parseJsons.registerUser;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import net.minidev.json.annotate.JsonIgnore;


@Data
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Root {

    String name;
    String job;
    String id;
    String createdAt;
}
