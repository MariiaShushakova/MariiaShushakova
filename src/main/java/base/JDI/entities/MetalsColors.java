package base.JDI.entities;

import base.JDI.enums.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Arrays;
import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class MetalsColors {
    public static MetalsColors DEFAULT = new MetalsColors(
                Arrays.asList(Vegetables.Cucumber.name(),
                Vegetables.Tomato.name()),
                Arrays.asList(Elements.Water.name(),
                Elements.Fire.name()),
                Metals.Selen.name(),
                Colors.Yellow.name(),
                EvenSelector.EIGHT.value,
                OddsSelector.THREE.value
    );

        List<String> vegetables;
        List<String> elements;
        String metals;
        String colors;
        int odds;
        int even;
}
