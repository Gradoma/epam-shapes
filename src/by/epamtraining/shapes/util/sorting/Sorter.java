package by.epamtraining.shapes.util.sorting;

import by.epamtraining.shapes.entity.Sphere;

import java.util.Comparator;
import java.util.List;

public class Sorter {
    private Comparator<Sphere> idComparator = new Comparator<Sphere>() {
        @Override
        public int compare(Sphere o1, Sphere o2) {
            return (int)(o1.getId() - o2.getId());
        }
    };

    private Comparator<Sphere> radiusComparator = new Comparator<Sphere>() {
        @Override
        public int compare(Sphere o1, Sphere o2) {
            double r1 = o1.getRadius();
            double r2 = o2.getRadius();
            return (int)(r1 - r2);
        }
    };

    public List<Sphere> sortById(List<Sphere> list){
        list.sort(idComparator);
        return list;
    }

    public List<Sphere> sortByRadius(List<Sphere> list){
        list.sort(radiusComparator);
        return list;
    }
}
