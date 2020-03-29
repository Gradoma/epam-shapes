package by.epamtraining.shapes.entities;

import by.epamtraining.shapes.exception.IncorrectDataException;

public class Sphere {
    private int id;
    private Point centerPoint;
    private double radius;

    public Sphere(){
        double zero = 0.0;
        centerPoint = new Point(zero, zero, zero);
        radius = 1.0;
    }

    public Sphere(Point centerPoint, double radius) throws IncorrectDataException{
        setCenterPoint(centerPoint);
        setRadius(radius);
    }

    public int getId() {
        return id;
    }

    public Point getCenterPoint() {
        return centerPoint;
    }

    public double getRadius() {
        return radius;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCenterPoint(Point centerPoint) throws IncorrectDataException{
        if(centerPoint != null){
            double x = centerPoint.getCoordinateX();
            double y = centerPoint.getCoordinateY();
            double z = centerPoint.getCoordinateZ();
            this.centerPoint = new Point(x, y, z);
            this.centerPoint = centerPoint;
        } else {
            throw new IncorrectDataException("null reference to Point object");
        }

    }

    public void setRadius(double radius) throws IncorrectDataException {
        if(radius > 0.0){
            this.radius = radius;
        } else {
            throw new IncorrectDataException("radius less or equal zero");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null){
            return false;
        }
        if (getClass() != o.getClass()){
            return false;
        }
        Sphere sphere = (Sphere) o;
        if (id != sphere.id){
            return false;
        }
        if (Double.compare(sphere.radius, radius) != 0) {
            return false;
        }
        if (centerPoint == null){
            return (sphere.centerPoint == null);
        } else {
            return centerPoint.equals(sphere.centerPoint);
        }
    }

    @Override
    public int hashCode() {
        int result = id;
        int primeNumber = 31;
        result = primeNumber * result + ((centerPoint == null) ? 0 : centerPoint.hashCode());       //null check is necessary?
        long temp = Double.doubleToLongBits(radius);
        result = primeNumber * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return getClass().getName() +
                "centerPoint=" + centerPoint +
                ", radius=" + radius;
    }
}
