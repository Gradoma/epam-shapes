package test.epamtraining.shapes.dao.impl;

import by.epamtraining.shapes.dao.impl.FileSphereDao;
import by.epamtraining.shapes.exception.DaoException;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.testng.Assert.*;

public class FileSphereDaoTest {
    FileSphereDao fileSphereDao;

    @BeforeClass
    public void setUp(){
        fileSphereDao = new FileSphereDao();
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