package by.epamtraining.shapes.repository.specification_impl;

import by.epamtraining.shapes.entity.Sphere;
import by.epamtraining.shapes.repository.Specification;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class RadiusSpecification implements Specification {
    private double minRadius;
    private double maxRadius;
    private static Logger logger = LogManager.getLogger();

    public RadiusSpecification(double minRadius, double maxRadius){
        logger.debug("parameters: minimal radius: " + minRadius + ", maximum radius: " + maxRadius);
        this.minRadius = minRadius;
        this.maxRadius = maxRadius;
        logger.info("RadiusSpecification created, minRadius = " + this.minRadius + ", maxRadius = " + this.maxRadius);
    }

    @Override
    public boolean specify(Sphere sphere){
        logger.debug("parameter: Sphere" + sphere);
        double radius = sphere.getRadius();
        boolean minBorder = Double.compare(radius, minRadius) >= 0;
        logger.info("Sphere radius greater or equal minRadius: " + minBorder);
        boolean maxBorder = Double.compare(radius, maxRadius) <= 0;
        logger.info("Sphere radius less or equal maxRadius: " + maxBorder);
        boolean result = minBorder && maxBorder;
        logger.debug("result: radius meets conditions: " + result);
        return result;
    }
}
