package base.JDI.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum EvenSelector {
    TWO("2",2),
    FOUR("4",4),
    SIX("6",6),
    EIGHT("8",8);

    private String evenSelector;
    private Integer value;
}
