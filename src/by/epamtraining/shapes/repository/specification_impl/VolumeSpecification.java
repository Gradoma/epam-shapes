package by.epamtraining.shapes.repository.specification_impl;

import by.epamtraining.shapes.action.SphereAction;
import by.epamtraining.shapes.entity.Sphere;
import by.epamtraining.shapes.repository.Specification;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class VolumeSpecification implements Specification {
    private double minVolume;
    private double maxVolume;
    private static Logger logger = LogManager.getLogger();

    public VolumeSpecification(double minVolume, double maxVolume){
        logger.debug("parameters: minimal volume: " + minVolume + ", maximum volume: " + maxVolume);
        this.minVolume = minVolume;
        this.maxVolume = maxVolume;
        logger.info("VolumeSpecification created, minVolume = " + this.minVolume + ", maxVolume = " + this.maxVolume);
    }

    @Override
    public boolean specify(Sphere sphere){
        logger.debug("parameter: Sphere" + sphere);
        SphereAction action = new SphereAction();
        double volume = action.findVolume(sphere);
        logger.info("Volume of Sphere = " + volume);
        boolean minBorder = Double.compare(volume, minVolume) >= 0;
        logger.info("Sphere volume greater or equal minVolume: " + minBorder);
        boolean maxBorder = Double.compare(volume, maxVolume) <= 0;
        logger.info("Sphere volume less or equal maxVolume: " + maxBorder);
        boolean result = minBorder && maxBorder;
        logger.debug("result: volume meets conditions: " + result);
        return result;
    }
}
