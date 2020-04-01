package by.epamtraining.shapes.parser;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {
    private Pattern pattern = Pattern.compile("(^\\d+?)((\\s-?\\d+?\\.?\\d{0,2}){3})\\s(\\d+?\\.?\\d{0,2})");

    public List<Double> parse(String string){
        Matcher matcher = pattern.matcher(string);
        List<Double> values = null;
        if(matcher.matches()){
            values = getValueList(matcher.group(2).trim());
            Double radiusValue = Double.parseDouble(matcher.group(4));
            values.add(radiusValue);
        }
        return values;
    }

    public int parseId (String string){
        Matcher matcher = pattern.matcher(string);
        int id = -1;
        if (matcher.matches()){
            String stringId = matcher.group(1);
            id = Integer.parseInt(stringId);
        }
        return id;
    }

    private List<Double> getValueList(String string){
        List<Double> valuesList = new ArrayList<>();
        String[] valuesArr = string.split(" ");
        for (String s: valuesArr){
            valuesList.add(Double.parseDouble(s));
        }
        return valuesList;
    }
}
