package base.JDI.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum OddsSelector {
    ONE("1", 1),
    THREE("3", 3),
    FIVE("5", 5),
    SEVEN("7", 7);

    private String oddsSelector;
    private Integer value;
}
