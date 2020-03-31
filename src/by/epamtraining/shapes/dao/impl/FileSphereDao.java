package by.epamtraining.shapes.dao.impl;

import by.epamtraining.shapes.dao.SphereDao;
import by.epamtraining.shapes.exception.DaoException;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class FileSphereDao implements SphereDao {
    private static final String FILE_NAME = "resource/file.txt";

    @Override
    public List<String> getStrings() throws IOException, DaoException{
        Path path = Paths.get(FILE_NAME);
        try{
            return Files.readAllLines(path);
        }catch (IOException e){
            // write log
            throw new DaoException(e);
        }
    }
}
