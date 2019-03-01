package base.JDI.enums;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum OddsSelector {
    ONE("1", 1),
    THREE("3", 3),
    FIVE("5", 5),
    SEVEN("7", 7);

    public String oddsSelector;
    public int value;
}
