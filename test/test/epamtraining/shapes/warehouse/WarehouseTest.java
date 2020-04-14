package test.epamtraining.shapes.warehouse;

import by.epamtraining.shapes.entity.Point;
import by.epamtraining.shapes.entity.Sphere;
import by.epamtraining.shapes.repository.SphereRepository;
import by.epamtraining.shapes.warehouse.Characteristic;
import by.epamtraining.shapes.warehouse.SphereObserver;
import by.epamtraining.shapes.warehouse.Warehouse;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

public class WarehouseTest {
    SphereRepository repository;
    SphereObserver observer;
    Warehouse warehouse;

    @BeforeClass
    public void setUp(){
        repository = SphereRepository.getInstance();
        System.out.println(repository.getSphereList());
        observer = SphereObserver.getInstance();
        warehouse = Warehouse.getInstance();

        List<Sphere> repositoryList = repository.getSphereList();
        for(Sphere s : repositoryList){
            s.attach(observer);
        }
    }

    @Test (dependsOnGroups = "Repository")
    public void testGetCharacteristicByNewRadius() {
        long testId = 1;
        double testRadius = 1.0;
        repository.changeSphere(testId, testRadius);
        Characteristic initialCharacteristic = warehouse.getCharacteristic(testId);
        int initHashCode = initialCharacteristic.hashCode();

        double nextTestRadius = 10.0;
        repository.changeSphere(testId, nextTestRadius);
        Characteristic nextCharacteristic = warehouse.getCharacteristic(testId);
        int nextHashCode = nextCharacteristic.hashCode();

        Assert.assertNotEquals(initHashCode, nextHashCode);
    }

    @Test (dependsOnGroups = "Repository")
    public void testGetCharacteristicByNewCenterPoint() {
        long testId = 2;
        Point testCenterPoint = new Point (1.0, 1.0, 1.0);
        repository.changeSphere(testId, testCenterPoint);
        Characteristic initialCharacteristic = warehouse.getCharacteristic(testId);
        int initHashCode = initialCharacteristic.hashCode();

        Point nextPoint = new Point(2.0, 2.0, 2.0);
        repository.changeSphere(testId, nextPoint);
        Characteristic nextCharacteristic = warehouse.getCharacteristic(testId);
        int nextHashCode = nextCharacteristic.hashCode();

        Assert.assertNotEquals(initHashCode, nextHashCode);
    }
}