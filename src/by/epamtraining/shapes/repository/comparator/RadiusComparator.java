package by.epamtraining.shapes.repository.comparator;

import by.epamtraining.shapes.entity.Sphere;

import java.util.Comparator;

public class RadiusComparator implements Comparator<Sphere> {

    @Override
    public int compare(Sphere o1, Sphere o2) {
        return Double.compare(o1.getRadius(), o2.getRadius());
    }
}
