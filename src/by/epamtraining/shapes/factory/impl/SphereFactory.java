package by.epamtraining.shapes.factory.impl;

import by.epamtraining.shapes.entity.Point;
import by.epamtraining.shapes.entity.Shape;
import by.epamtraining.shapes.entity.Sphere;
import by.epamtraining.shapes.exception.IncorrectDataException;
import by.epamtraining.shapes.exception.SphereFactoryCreateException;
import by.epamtraining.shapes.factory.ShapeFactory;
import by.epamtraining.shapes.util.generator.IdGenerator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class SphereFactory implements ShapeFactory {
    private static Logger logger = LogManager.getLogger();

    @Override
    public Shape create(List<Double> values) throws SphereFactoryCreateException {
        logger.debug("parameters: " + values);
        double centerX = values.get(0);
        double centerY = values.get(1);
        double centerZ = values.get(2);
        Point centerPoint = new Point(centerX, centerY, centerZ);
        double radius = values.get(3);
        Shape sphere;
        try {
            sphere = new Sphere(centerPoint, radius);
            logger.info("Sphere was created, sphere.id=" + sphere.getId());
        } catch (IncorrectDataException e) {
            logger.fatal("IncorrectDataException was thrown");
            throw new SphereFactoryCreateException(e);
        }
        IdGenerator generator = new IdGenerator();
        long id = generator.generateId();
        sphere.setId(id);
        return sphere;
    }
}
