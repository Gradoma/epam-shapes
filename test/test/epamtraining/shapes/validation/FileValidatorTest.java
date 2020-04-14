package test.epamtraining.shapes.validation;

import by.epamtraining.shapes.validation.FileValidator;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.nio.file.Path;
import java.nio.file.Paths;

import static org.testng.Assert.*;

public class FileValidatorTest {
    FileValidator fileValidator;

    @BeforeClass
    public void setUp(){
        fileValidator = new FileValidator();
    }

    @Test(groups = {"Validation"})
    public void testIsFileExist() {
        String testFileName = "test_resource/testfile.txt";
        Assert.assertTrue(fileValidator.isFileExist(testFileName));
    }

    @Test(groups = {"Validation"})
    public void isEmptyFileTest() {
        String nameEmptyFile = "test_resource/empty.txt";
        Path pathEmptyFile = Paths.get(nameEmptyFile);
        Assert.assertTrue(fileValidator.isEmptyFile(pathEmptyFile));
    }
}