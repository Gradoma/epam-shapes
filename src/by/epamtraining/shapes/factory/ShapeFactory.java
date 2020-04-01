package by.epamtraining.shapes.factory;

import by.epamtraining.shapes.entity.Shape;

import java.util.List;
import java.util.Map;

public interface ShapeFactory {
    Shape create(int id, double centerX, double centerY, double centerZ, double radius);
}
