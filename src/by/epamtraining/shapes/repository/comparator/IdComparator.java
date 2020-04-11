package by.epamtraining.shapes.repository.comparator;

import by.epamtraining.shapes.entity.Sphere;

import java.util.Comparator;

public class IdComparator implements Comparator<Sphere> {

    @Override
    public int compare(Sphere o1, Sphere o2) {
        return Long.compare(o1.getId(), o2.getId());
    }
}
