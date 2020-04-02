package by.epamtraining.shapes.factory.impl;

import by.epamtraining.shapes.entity.Point;
import by.epamtraining.shapes.entity.Shape;
import by.epamtraining.shapes.entity.Sphere;
import by.epamtraining.shapes.exception.IncorrectDataException;
import by.epamtraining.shapes.exception.SphereFactoryCreateException;
import by.epamtraining.shapes.factory.ShapeFactory;

public class SphereFactory implements ShapeFactory {
    @Override
    public Shape create(int id, double centerX, double centerY, double centerZ, double radius) throws SphereFactoryCreateException{
        Point centerPoint = new Point(centerX, centerY, centerZ);
        Shape sphere = null;
        try{
            sphere = new Sphere(centerPoint, radius);
            sphere.setId(id);
        } catch (IncorrectDataException e){
            throw new SphereFactoryCreateException(e);
        }
        return sphere;
    }
}
