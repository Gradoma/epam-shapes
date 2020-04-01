package by.epamtraining.shapes.factory;

import by.epamtraining.shapes.entity.Sphere;

import java.util.ArrayList;
import java.util.List;

public class SphereHolderList {
    private static final SphereHolderList instance = new SphereHolderList();
    private List<Sphere> sphereList = new ArrayList<Sphere>();

    private SphereHolderList(){}

    public static SphereHolderList getInstance(){
        return instance;
    }

    public List<Sphere> getSphereList() {
        return sphereList;
    }

    public void addSphereToList(Sphere sphere){
        sphereList.add(sphere);
    }
}
