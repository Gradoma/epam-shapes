package by.epamtraining.shapes.parser;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {
    public Map<Integer, List<Double>> parse(String string){
        Pattern pattern = Pattern.compile("(^\\d+?)((\\s-?\\d+?\\.?\\d{0,2}){3})\\s(\\d+?\\.?\\d{0,2})");
        Matcher matcher = pattern.matcher(string);
        if(matcher.matches()){
            System.out.println(matcher.group());    //test
            Integer sphereId = Integer.parseInt(matcher.group(1));
            List<Double> values = getValueList(matcher.group(2).trim());
            Double radiusValue = Double.parseDouble(matcher.group(4));
            values.add(radiusValue);
            Map<Integer, List<Double>> sphereValues = new HashMap<>();
            sphereValues.put(sphereId, values);
            return sphereValues;
        }
        return null;
    }

    private List<Double> getValueList(String string){
        System.out.println("inside getValue = " + string);      //test
        List<Double> valuesList = new ArrayList<>();
        String[] valuesArr = string.split(" ");
        for (String s: valuesArr){
            valuesList.add(Double.parseDouble(s));
        }
        return valuesList;
    }
}
