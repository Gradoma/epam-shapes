package by.epamtraining.shapes.warehouse;

import by.epamtraining.shapes.entity.Sphere;
import by.epamtraining.shapes.util.observer.Observer;
import by.epamtraining.shapes.util.observer.SphereEvent;

public class WarehouseObserver implements Observer {

    @Override
    public void update(SphereEvent event){
        System.out.println("was updated:");
        Sphere sphere = event.getSource();
        System.out.println(sphere.getId());
        System.out.println(sphere.getCenterPoint());
        System.out.println(sphere.getRadius());
    }
}
