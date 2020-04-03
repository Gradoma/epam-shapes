package by.epamtraining.shapes.parser;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {
    private final static Pattern SPHERE_STRING = Pattern.compile("(^\\d+?)((\\s-?\\d+?\\.?\\d{0,2}){3})\\s(\\d+?\\.?\\d{0,2})");
    private static Logger logger = LogManager.getLogger();

    public List<Double> parseValue(String string){
        logger.debug("parameter: String for parsing: " + string);
        Matcher matcher = SPHERE_STRING.matcher(string);
        List<Double> values = null;
        if(matcher.matches()){
            logger.info("String was matched successful");
            values = getValueList(matcher.group(2).trim());
            Double radiusValue = Double.parseDouble(matcher.group(4));
            values.add(radiusValue);
        }
        logger.info("result List parameters for Sphere creation: " + values);
        return values;
    }

    public int parseId (String string){
        logger.debug("parameter: String: " + string);
        Matcher matcher = SPHERE_STRING.matcher(string);
        int id = -1;
        if (matcher.matches()){
            logger.info("String was matched successful");
            String stringId = matcher.group(1);
            id = Integer.parseInt(stringId);
        }
        logger.info("id = " + id);
        return id;
    }

    private List<Double> getValueList(String string){
        logger.debug("parameter: String with values: " + string);
        List<Double> valuesList = new ArrayList<>();
        String[] valuesArr = string.split(" ");
        for (String s: valuesArr){
            valuesList.add(Double.parseDouble(s));
        }
        logger.info("result List of values: " + valuesList);
        return valuesList;
    }
}
