package by.epamtraining.shapes.repository;

import by.epamtraining.shapes.entity.Point;
import by.epamtraining.shapes.entity.Sphere;
import by.epamtraining.shapes.exception.IncorrectDataException;

import java.util.ArrayList;
import java.util.List;

public class SphereRepository {
    private static final SphereRepository instance = new SphereRepository();
    public final List<Sphere> sphereList = new ArrayList<>();

    private SphereRepository(){}

    public static SphereRepository getInstance() {
        return instance;
    }

    public boolean addSphere(Sphere sphere){
        return sphereList.add(sphere);
    }

    public boolean changeSphere(long id, double newRadius){
        Specification idSpecification = new IdSpecification(id);
        List<Sphere> sphereList = query(idSpecification);
        if (sphereList.isEmpty()){
            return false;
        }
        Sphere sphere = sphereList.get(0);
        try{
            sphere.setRadius(newRadius);
        } catch (IncorrectDataException e){
            return false;
        }
        return true;
    }

    public boolean changeSphere(long id, Point newCenterPoint){
        Specification idSpecification = new IdSpecification(id);
        List<Sphere> sphereList = query(idSpecification);
        if (sphereList.isEmpty()){
            return false;
        }
        Sphere sphere = sphereList.get(0);
        try{
            sphere.setCenterPoint(newCenterPoint);
        } catch (IncorrectDataException e){
            return false;
        }
        return true;
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
