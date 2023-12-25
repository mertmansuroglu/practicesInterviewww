package apiAutomation.parseJsons.pojo;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@Data
    public class Donut {
        private String id;
        private String type;
        private String name;
        private double ppu;
        private Batters batters;
        private List<Topping> topping;

        // getters and setters
    }

