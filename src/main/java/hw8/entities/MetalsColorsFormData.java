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

    // TODO This parameter is not a web element list.
    // TODO Anyway, this is not an appropriate place for this method,
    // TODO `cause it has no relation with Entity
    public static String listToStringWithoutBrackets(List<String> webElementList) {
        // TODO What are you doing here ? Removing spaces ? Tale a look on String::trim method.
        return webElementList.toString().substring(1,
                webElementList.toString().length() - 1);
    }
}