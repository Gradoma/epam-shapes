package by.epamtraining.shapes.repository;

import by.epamtraining.shapes.action.SphereAction;
import by.epamtraining.shapes.entity.Sphere;

public class VolumeSpecification implements Specification {
    private double minVolume;
    private double maxVolume;

    public VolumeSpecification(double minVolume, double maxVolume){
        this.minVolume = minVolume;
        this.maxVolume = maxVolume;
    }

    @Override
    public boolean specify(Sphere sphere){
        SphereAction action = new SphereAction();
        double volume = action.findVolume(sphere);
        boolean minBorder = Double.compare(volume, minVolume) >= 0;
        boolean maxBorder = Double.compare(volume, maxVolume) <= 0;
        return (minBorder && maxBorder);
    }
}
