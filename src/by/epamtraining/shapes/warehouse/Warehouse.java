package by.epamtraining.shapes.warehouse;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Warehouse {
    private static final Warehouse instance = new Warehouse();
    private Map<Long, List<Double>> sphereCharacteristics = new HashMap<>();

    private Warehouse(){}

    public static Warehouse getInstance() {
        return instance;
    }

    public boolean addCharacteristic(long id, List<Double> characteristic){
        sphereCharacteristics.put(id, characteristic);
        return true;
    }

    public boolean contains(long id){
        return sphereCharacteristics.containsKey(id);
    }

    public List<Double> getCharacteristics (long id){
        return sphereCharacteristics.get(id);
    }

    public void print(){
        System.out.println("map = " + sphereCharacteristics);
    }
}
