package test.epamtraining.shapes.parser;

import by.epamtraining.shapes.parser.Parser;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.testng.Assert.*;

public class ParserTest {
    Parser parser;

    @BeforeClass
    public void setUp(){
        parser = new Parser();
    }

    @Test
    public void testParseValue() {
        String testString = "12 2.5 -3.7 8 12.4";
        Double[] values = {2.5, -3.7, 8.0, 12.4};
        List<Double> expectedValues = Arrays.asList(values);
        List<Double> actualValues = parser.parseValue(testString);
        Assert.assertEquals(expectedValues, actualValues);
    }

    @Test
    public void testParseValueIncorrectString() {
        String testString = "2b or not -3.7 8 12.4";
        List<Double> expectedValues = null;
        List<Double> actualValues = parser.parseValue(testString);
        Assert.assertEquals(expectedValues, actualValues);
    }
}