package by.epamtraining.shapes.factory.impl;

import by.epamtraining.shapes.entity.Point;
import by.epamtraining.shapes.entity.Shape;
import by.epamtraining.shapes.entity.Sphere;
import by.epamtraining.shapes.exception.IncorrectDataException;
import by.epamtraining.shapes.factory.ShapeFactory;

public class SphereFactory implements ShapeFactory {
    @Override
    public Shape create(int id, double centerX, double centerY, double centerZ, double radius) {
        Point centerPoint = new Point(centerX, centerY, centerZ);
        Shape sphere = null;
        try{
            sphere = new Sphere(centerPoint, radius);
        } catch (IncorrectDataException e){
            e.printStackTrace();
        }
        return sphere;
    }
}
