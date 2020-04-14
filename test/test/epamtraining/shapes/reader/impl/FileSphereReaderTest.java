package test.epamtraining.shapes.reader.impl;

import by.epamtraining.shapes.exception.EmptySourceException;
import by.epamtraining.shapes.reader.impl.FileSphereReader;
import by.epamtraining.shapes.exception.DaoException;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

public class FileSphereReaderTest {
    FileSphereReader fileSphereDao;

    @BeforeClass
    public void setUp(){
        fileSphereDao = new FileSphereReader();
    }

    @Test (dependsOnGroups = {"Validation"}, groups = {"Reader"})
    public void testGetStringsPositive() {
        String path = "test_resource/testfile.txt";
        String[] expectedArr = {"123 613 56", "165 05465 3321", "32 65132 6132"};
        List<String> expected = Arrays.asList(expectedArr);
        List<String> actual = null;
            try{
                actual = fileSphereDao.getStrings(path);
            } catch (DaoException e){
                Assert.fail();
            }
        Assert.assertEquals(actual, expected);
    }

    @Test(expectedExceptions = DaoException.class)
    public void testGetStringsNull() throws DaoException{
        String path = null;
        fileSphereDao.getStrings(path);
    }

    @Test(expectedExceptions = EmptySourceException.class)
    public void testGetStringsEmptyFile() throws DaoException{
        String path = "test_resource/empty.txt";
        fileSphereDao.getStrings(path);
    }
}