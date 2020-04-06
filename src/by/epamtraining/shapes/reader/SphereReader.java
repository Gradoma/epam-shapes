package by.epamtraining.shapes.reader;

import by.epamtraining.shapes.exception.DaoException;

import java.io.IOException;
import java.util.List;

public interface SphereReader {
    List<String> getStrings(String fileName) throws IOException, DaoException;
}
