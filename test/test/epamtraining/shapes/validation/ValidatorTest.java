package test.epamtraining.shapes.validation;

import by.epamtraining.shapes.exception.ValidationException;
import by.epamtraining.shapes.validation.Validator;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.*;

public class ValidatorTest {
    Validator validator;

    @BeforeClass
    public void setUp(){
        validator = new Validator();
    }

    @Test
    public void testCheckList() {
        List<String> expectedList = new ArrayList<>();
        expectedList.add("1 a");
        expectedList.add("2 b");
        expectedList.add("3 c");
        List<String> actualList = null;
        try{
            actualList = validator.checkList(expectedList);
        } catch (ValidationException e){
            fail();
        }
        Assert.assertEquals(expectedList, actualList);
    }

    @Test (expectedExceptions = ValidationException.class)
    public void testCheckListException() throws ValidationException{
        List<String> epmtyList = new ArrayList<>();
        validator.checkList(epmtyList);
    }

    @Test
    public void testCheckListEmptyString() {
        List<String> testList = new ArrayList<>();
        testList.add("1 a");
        testList.add("");
        testList.add("3 c");

        List<String> expectedList = new ArrayList<>();
        expectedList.add("1 a");
        expectedList.add("3 c");
        List<String> actualList = null;
        try{
            actualList = validator.checkList(testList);
        } catch (ValidationException e){
            fail();
        }
        Assert.assertEquals(expectedList, actualList);
    }

    @Test
    public void testCheckListSpace() {
        List<String> testList = new ArrayList<>();
        testList.add("1 a");
        testList.add("2 f");
        testList.add("3c");

        List<String> expectedList = new ArrayList<>();
        expectedList.add("1 a");
        expectedList.add("2 f");
        List<String> actualList = null;
        try{
            actualList = validator.checkList(testList);
        } catch (ValidationException e){
            fail();
        }
        Assert.assertEquals(expectedList, actualList);
    }
}