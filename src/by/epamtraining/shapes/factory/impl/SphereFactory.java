package by.epamtraining.shapes.factory.impl;

import by.epamtraining.shapes.entity.Point;
import by.epamtraining.shapes.entity.Shape;
import by.epamtraining.shapes.entity.Sphere;
import by.epamtraining.shapes.exception.IncorrectDataException;
import by.epamtraining.shapes.exception.SphereFactoryCreateException;
import by.epamtraining.shapes.factory.ShapeFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SphereFactory implements ShapeFactory {
    private static Logger logger = LogManager.getLogger();

    @Override
    public Shape create(int id, double centerX, double centerY, double centerZ, double radius) throws SphereFactoryCreateException{
        logger.debug("parameters: id=" + id + ", centerX=" + centerX + ", centerY=" + centerY + ", centerZ=" + centerZ + ", radius=" + radius);
        Point centerPoint = new Point(centerX, centerY, centerZ);
        try{
            Shape sphere = new Sphere(centerPoint, radius);
            sphere.setId(id);
            logger.info("Sphere was created, sphere.id=" + sphere.getId());
            return sphere;
        } catch (IncorrectDataException e){
            logger.fatal("IncorrectDataException was thrown");
            throw new SphereFactoryCreateException(e);
        }
    }
}
