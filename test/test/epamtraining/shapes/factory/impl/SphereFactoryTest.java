package test.epamtraining.shapes.factory.impl;

import by.epamtraining.shapes.entity.Point;
import by.epamtraining.shapes.entity.Sphere;
import by.epamtraining.shapes.exception.IncorrectDataException;
import by.epamtraining.shapes.exception.SphereFactoryCreateException;
import by.epamtraining.shapes.factory.impl.SphereFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.testng.Assert.*;

public class SphereFactoryTest {
    SphereFactory factory;
    double x;
    double y;
    double z;
    double radius;
    List<Double> testValue;

    @BeforeClass
    public void setUp(){
        factory = new SphereFactory();
        x = 5.0;
        y = 2.5;
        z = -3.7;
        radius = 10.0;
        testValue = new ArrayList<>();
        testValue.add(x);
        testValue.add(y);
        testValue.add(z);
        testValue.add(radius);
    }

    @Test (priority = 1)
    public void testCreatePositive() {
        Point expectedCenterPoint = new Point(x, y, z);
        Sphere expectedSphere = null;
        try{
            expectedSphere = new Sphere(expectedCenterPoint, radius);
        } catch (IncorrectDataException e){
            Assert.fail();
        }
        expectedSphere.setId(1);

        Sphere actualSphere = null;
        try{
            actualSphere = (Sphere) factory.create(testValue);
        } catch (SphereFactoryCreateException e){
            Assert.fail();
        }
        Assert.assertEquals(actualSphere, expectedSphere);
    }

    @Test (expectedExceptions = SphereFactoryCreateException.class, priority = 2)
    public void testCreateException() throws SphereFactoryCreateException{
        testValue.remove(3);
        double testRadius = -5.2;
        testValue.add(testRadius);
        factory.create(testValue);
    }
}