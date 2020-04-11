package by.epamtraining.shapes.repository;

import by.epamtraining.shapes.entity.Sphere;

public interface Specification <T extends Sphere> {
    boolean specify(T t);
}
