package by.epamtraining.shapes.dao.impl;

import by.epamtraining.shapes.dao.SphereDao;
import by.epamtraining.shapes.exception.DaoException;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class FileSphereDao implements SphereDao {
    private static final String DEFAULT_FILENAME = "resource/file.txt";

    @Override
    public List<String> getStrings(String fileName) throws DaoException{
        Path path;
        if (Files.exists(Paths.get(fileName))) {
            path = Paths.get(fileName);
        } else {
            path = Paths.get(DEFAULT_FILENAME);
        }
        try{
            return Files.readAllLines(path);
        }catch (IOException e){
            // write log
            throw new DaoException(e);
        }
    }
}
