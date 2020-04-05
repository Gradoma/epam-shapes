package by.epamtraining.shapes.factory;

import by.epamtraining.shapes.entity.Shape;
import by.epamtraining.shapes.exception.SphereFactoryCreateException;

import java.util.List;

public interface ShapeFactory {
    Shape create(List<Double> values) throws SphereFactoryCreateException;
}
