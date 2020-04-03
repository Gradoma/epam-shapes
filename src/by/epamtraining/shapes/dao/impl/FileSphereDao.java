package by.epamtraining.shapes.dao.impl;

import by.epamtraining.shapes.dao.SphereDao;
import by.epamtraining.shapes.exception.DaoException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class FileSphereDao implements SphereDao {
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
        if (Files.exists(Paths.get(fileName))) {
            logger.info("file was founded");
            path = Paths.get(fileName);
        } else {
            logger.info("file wasn't found, try to read default file: " + DEFAULT_FILENAME);
            path = Paths.get(DEFAULT_FILENAME);         // как тестировать?
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
