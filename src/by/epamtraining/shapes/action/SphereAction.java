package by.epamtraining.shapes.action;

import by.epamtraining.shapes.entity.Point;
import by.epamtraining.shapes.entity.Sphere;

public class SphereAction {

    public double findSurfaceSquare(Sphere sphere){
        double radius = sphere.getRadius();
        double square = 4.0 * Math.PI * Math.pow(radius, 2.0);
        return square;
    }

    public double findVolume(Sphere sphere){
        double radius = sphere.getRadius();
        double volume = (4.0/3.0) * Math.PI * Math.pow(radius, 3.0);
        return volume;
    }

    public boolean isTouchCoordinatePlane(Sphere sphere){
        double radius = sphere.getRadius();
        double distance = findMinDistanceToPlane(sphere);
        return (Double.compare(radius, distance) == 0);
    }

    public double findVolumeRatio(Sphere sphere){
        double radius = sphere.getRadius();
        double distance = findMinDistanceToPlane(sphere);
        double ratio = 0.0;
        if (Double.compare(radius, distance) != 0) {
            double h = radius - distance;
            double partOne = Math.PI * Math.pow(h, 2.0) * (radius - (1.0 / 3.0) * h);
            double partTwo = findVolume(sphere) - partOne;
            ratio = partTwo / partOne;
        }
        return Math.round(ratio);
    }

    private double findMinDistanceToPlane(Sphere sphere){
        Point centerPoint = sphere.getCenterPoint();
        double xCoordinate = centerPoint.getCoordinateX();
        double minDistance = Math.abs(xCoordinate);

        double yCoordinate = centerPoint.getCoordinateY();
        double distanceByY = Math.abs(yCoordinate);
        if (Double.compare(minDistance, distanceByY) > 0){
            minDistance = distanceByY;
        }
        double zCoordinate = centerPoint.getCoordinateZ();
        double distanceByZ = Math.abs(zCoordinate);
        if (Double.compare(minDistance, distanceByZ) > 0){
            minDistance = distanceByZ;
        }
        return minDistance;
    }
}