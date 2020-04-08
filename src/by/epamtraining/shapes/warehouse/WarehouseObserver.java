package by.epamtraining.shapes.warehouse;

import by.epamtraining.shapes.action.SphereAction;
import by.epamtraining.shapes.entity.Sphere;
import by.epamtraining.shapes.util.observer.Observer;
import by.epamtraining.shapes.util.observer.SphereEvent;

import java.util.ArrayList;
import java.util.List;

public class WarehouseObserver implements Observer {
    private static final WarehouseObserver instance = new WarehouseObserver();

    private WarehouseObserver(){}

    public static WarehouseObserver getInstance(){
        return instance;
    }

    @Override
    public void update(SphereEvent event){
        Sphere sphere = event.getSource();
        SphereAction action = new SphereAction();
        double square = action.findSurfaceSquare(sphere);
        double volume = action.findVolume(sphere);
        boolean isTouch = action.isTouchCoordinatePlane(sphere);
        double volumeRatio = action.findVolumeRatio(sphere);

        Warehouse warehouse = Warehouse.getInstance();
        Characteristic characteristic;
        if (warehouse.contains(sphere.getId())){
            characteristic = warehouse.getCharacteristic(sphere.getId());
        } else {
            characteristic = new Characteristic();
        }
        characteristic.setSquare(square);
        characteristic.setVolume(volume);
        characteristic.setTouchPlane(isTouch);
        characteristic.setVolumeRatio(volumeRatio);


        warehouse.addCharacteristic(sphere.getId(), characteristic);
    }
}
