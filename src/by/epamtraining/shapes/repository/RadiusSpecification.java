package by.epamtraining.shapes.repository;

import by.epamtraining.shapes.entity.Sphere;

public class RadiusSpecification implements Specification {
    private double minRadius;
    private double maxRadius;

    public RadiusSpecification(double minRadius, double maxRadius){
        this.minRadius = minRadius;
        this.maxRadius = maxRadius;
    }

    @Override
    public boolean specify(Sphere sphere){
        double radius = sphere.getRadius();
        boolean minBorder = Double.compare(radius, minRadius) >= 0;
        boolean maxBorder = Double.compare(radius, maxRadius) <= 0;
        return (minBorder && maxBorder);
    }
}
