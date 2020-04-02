package test.epamtraining.shapes.factory.impl;

import by.epamtraining.shapes.entity.Point;
import by.epamtraining.shapes.entity.Shape;
import by.epamtraining.shapes.entity.Sphere;
import by.epamtraining.shapes.exception.IncorrectDataException;
import by.epamtraining.shapes.exception.SphereFactoryCreateException;
import by.epamtraining.shapes.factory.impl.SphereFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class SphereFactoryTest {
    SphereFactory sphereFactory;

    @BeforeClass
    public void setUp(){
        sphereFactory = new SphereFactory();
    }
    @Test
    public void testCreate() {
        int id = 1;
        double centerX = 2.0;
        double centerY = -3.2;
        double centerZ = 5.3;
        double radius = 2.3;
        Point centerPoint = new Point(centerX, centerY, centerZ);
        Sphere expectedSphere = null;
        Sphere actualSphere = null;
        try{
            expectedSphere = new Sphere(centerPoint, radius);
            expectedSphere.setId(id);
            actualSphere = (Sphere) sphereFactory.create(id, centerX, centerY, centerZ, radius);
        } catch (Exception e){
            fail();
        }
        Assert.assertEquals(expectedSphere, actualSphere);
    }

    @Test (expectedExceptions = SphereFactoryCreateException.class)
    public void testCreateNegativeRadius() throws SphereFactoryCreateException {
        int id = 1;
        double centerX = 2.0;
        double centerY = -3.2;
        double centerZ = 5.3;
        double radius = -10;
        Point centerPoint = new Point(centerX, centerY, centerZ);
        Shape expectedSphere = sphereFactory.create(id, centerX, centerY, centerZ, radius);
    }
}