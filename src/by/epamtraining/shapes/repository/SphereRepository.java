package by.epamtraining.shapes.repository;

import by.epamtraining.shapes.entity.Point;
import by.epamtraining.shapes.entity.Sphere;
import by.epamtraining.shapes.exception.IncorrectDataException;
import by.epamtraining.shapes.repository.specification_impl.IdSpecification;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class SphereRepository {
    private static final SphereRepository instance = new SphereRepository();
    private final List<Sphere> sphereList = new ArrayList<>();
    private static Logger logger = LogManager.getLogger();

    private SphereRepository(){}

    public static SphereRepository getInstance() {
        return instance;
    }

    public boolean addSphere(Sphere sphere){
        logger.info("parameter: Sphere for adding: " + sphere);
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

    public List<Sphere> getSphereList(){
        return sphereList;
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
        logger.info("parameter: Sphere for removing: " + sphere);
        return sphereList.remove(sphere);
    }

    public List<Sphere> sort(Comparator comparator){
        List<Sphere> sortedList = new ArrayList<>(sphereList);
        sortedList.sort(comparator);
        return sortedList;
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
