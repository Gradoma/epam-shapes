package by.epamtraining.shapes.warehouse;

import by.epamtraining.shapes.action.SphereAction;
import by.epamtraining.shapes.entity.Sphere;
import by.epamtraining.shapes.util.observer.Observer;
import by.epamtraining.shapes.util.observer.SphereEvent;

public class SphereObserver implements Observer {
    private static final SphereObserver instance = new SphereObserver();

    private SphereObserver(){}

    public static SphereObserver getInstance(){
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


        warehouse.putCharacteristic(sphere.getId(), characteristic);
    }
}
