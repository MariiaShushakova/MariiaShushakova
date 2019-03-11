package hw8.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class MetalsColorsFormData {
    public List<Integer> summary;
    public List<String> elements;
    public String color;
    public String metals;
    public List<String> vegetables;

    public static String listToStringWithoutBrackets(List<String> webElementList) {
        return webElementList.toString().substring(1,
                webElementList.toString().length() - 1);
    }
}