package test.epamtraining.shapes.parser;

import by.epamtraining.shapes.parser.Parser;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.testng.Assert.*;

public class ParserTest {

    @Test (dependsOnGroups = "Reader", groups = {"Parser"})
    public void testParseValue() {
        String testString1 = "3.4 4 2.1 2.7";
        String testString2 = "-2.1 7 5.1 3.1";
        String testString3 = "1 2 3";
        String testString4 = "1 2 3 -1.5";

        Double[] value1 = {3.4, 4.0, 2.1, 2.7};
        Double[] value2 = {-2.1, 7.0, 5.1, 3.1};
        List<Double> valueList1 = Arrays.asList(value1);
        List<Double> valueList2 = Arrays.asList(value2);
        List<List<Double>> expected = new ArrayList<>();
        expected.add(valueList1);
        expected.add(valueList2);

        List<String> testList = new ArrayList<>();
        testList.add(testString1);
        testList.add(testString2);
        testList.add(testString3);
        testList.add(testString4);

        Parser parser = new Parser();
        List<List<Double>> actual = parser.parseValue(testList);

        Assert.assertEquals(expected, actual);
    }
}