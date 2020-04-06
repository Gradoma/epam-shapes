package by.epamtraining.shapes.repository;

import by.epamtraining.shapes.action.SphereAction;
import by.epamtraining.shapes.entity.Sphere;

public class SurfaceSquareSpecification implements Specification {
    private double minSquare;
    private double maxSquare;

    public SurfaceSquareSpecification(double minSquare, double maxSquare){
        this.minSquare = minSquare;
        this.maxSquare = maxSquare;
    }

    @Override
    public boolean specify(Sphere sphere){
        SphereAction action = new SphereAction();
        double square = action.findSurfaceSquare(sphere);
        boolean minBorder = Double.compare(square, minSquare) >= 0;
        boolean maxBorder = Double.compare(square, maxSquare) <= 0;
        return (minBorder && maxBorder);
    }

}
