package base.JDI.entities;

import base.JDI.enums.*;
import lombok.*;

import java.util.Arrays;
import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class MetalsColors {
    public static MetalsColors DATASET = new MetalsColors(
                Arrays.asList(Vegetables.Cucumber.name(),
                Vegetables.Tomato.name()),
                Arrays.asList(Elements.Water.name(),
                Elements.Fire.name()),
                Metals.Selen.name(),
                Colors.Yellow.name(),
                EvenSelector.EIGHT.getValue(),
                OddsSelector.THREE.getValue()
    );

        List<String> vegetable;
        List<String> element;
        String metal;
        String color;
        Integer odd;
        Integer even;
}
