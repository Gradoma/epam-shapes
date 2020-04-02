package by.epamtraining.shapes.dao;

import by.epamtraining.shapes.exception.DaoException;

import java.io.IOException;
import java.util.List;

public interface SphereDao {
    List<String> getStrings(String fileName) throws IOException, DaoException;
}
