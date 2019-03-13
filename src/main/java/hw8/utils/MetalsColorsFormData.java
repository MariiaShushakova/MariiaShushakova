package hw8.utils;

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
    // it is just a temp name for method's parameter
    // TODO Anyway, this is not an appropriate place for this method,
    // TODO `cause it has no relation with Entity
    // Created a separate 'utils' package for this one
    public static String listToStringWithoutBrackets(List<String> list) {
        // TODO What are you doing here ? Removing spaces ? Tale a look on String::trim method.
        // This method is not to remove spaces but to remove list's square brackets
        return list.toString().substring(1,
                list.toString().length() - 1);
    }
}