package by.epamtraining.shapes.repository;

import by.epamtraining.shapes.entity.Sphere;

import java.util.ArrayList;
import java.util.List;

public class SphereRepository {
    private static final SphereRepository instance = new SphereRepository();
    private final List<Sphere> sphereList = new ArrayList<>();

    private SphereRepository(){}

    public static SphereRepository getInstance() {
        return instance;
    }

    public boolean addSphere(Sphere sphere){
        return sphereList.add(sphere);
    }

    public boolean removeSphere(Sphere sphere){
        return sphereList.remove(sphere);
    }

    public List<Sphere> query(Specification specification){
        List<Sphere> resultList = new ArrayList<>();
        for (Sphere current : sphereList){
            if (specification.specify(current)){
                resultList.add(current);
            }
        }
        return resultList;
    }
}
