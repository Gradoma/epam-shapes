package test.epamtraining.shapes.dao.impl;

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

    @Test
    public void testGetStringsPositive() {
        String path = "test_resource/testfile.txt";
        String[] expectedArr = {};
        List<String> expected = Arrays.asList(expectedArr);
        List<String> actual;
            try{
                actual = fileSphereDao.getStrings(path);
            } catch (DaoException e){
                actual = null;
            }
        Assert.assertEquals(actual, expected);
    }

    @Test(expectedExceptions = DaoException.class)
    public void testGetStringsNull() throws DaoException{
        String path = null;
        fileSphereDao.getStrings(path);
    }

    @Test
    public void testGetStringsFileDoesntExist(){
        String path = "resource/wrong.txt";

    }
}