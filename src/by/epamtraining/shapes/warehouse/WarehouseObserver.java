package by.epamtraining.shapes.warehouse;

import by.epamtraining.shapes.action.SphereAction;
import by.epamtraining.shapes.entity.Sphere;
import by.epamtraining.shapes.util.observer.Observer;
import by.epamtraining.shapes.util.observer.SphereEvent;

import java.util.ArrayList;
import java.util.List;

public class WarehouseObserver implements Observer {

    @Override
    public void update(SphereEvent event){
        Sphere sphere = event.getSource();
        SphereAction action = new SphereAction();
        double square = action.findSurfaceSquare(sphere);
        double volume = action.findVolume(sphere);

        Warehouse warehouse = Warehouse.getInstance();
        List<Double> characteristics;
        if (warehouse.contains(sphere.getId())){
            characteristics = warehouse.getCharacteristics(sphere.getId());
        } else {
            characteristics = new ArrayList<>();
        }
        characteristics.add(square);
        characteristics.add(volume);

        warehouse.addCharacteristic(sphere.getId(), characteristics);
    }
}
