package by.epamtraining.shapes.reader.impl;

import by.epamtraining.shapes.reader.SphereReader;
import by.epamtraining.shapes.exception.DaoException;
import by.epamtraining.shapes.validation.FileValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class FileSphereReader implements SphereReader {
    private static final String DEFAULT_FILENAME = "resource/file.txt";
    private static Logger logger = LogManager.getLogger();

    @Override
    public List<String> getStrings(String fileName) throws DaoException{
        logger.debug("parameter: Sting fileName: " + fileName);
        if (fileName == null){
            logger.fatal("String fileName is null");
            throw new DaoException(" file name is null");
        }
        Path path;
        FileValidator fileValidator = new FileValidator();
        if (fileValidator.isFileExist(fileName)) {
            logger.info("file was founded");
            path = Paths.get(fileName);
        } else {
            logger.info("file wasn't found, try to read default file: " + DEFAULT_FILENAME);
            path = Paths.get(DEFAULT_FILENAME);         // КАК ТЕСТИРОВАТЬ ????
        }

        try{
            logger.info("read all lines was successful");
            return Files.readAllLines(path);
        }catch (IOException e){
            logger.fatal("IOException while readAllLines method");
            throw new DaoException(e);
        }
    }
}
