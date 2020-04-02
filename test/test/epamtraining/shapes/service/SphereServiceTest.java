package test.epamtraining.shapes.service;

import by.epamtraining.shapes.entity.Point;
import by.epamtraining.shapes.entity.Sphere;
import by.epamtraining.shapes.service.SphereService;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class SphereServiceTest {
    Sphere sphere;
    SphereService sphereService;

    @BeforeClass
    public void setUp(){
        sphere = new Sphere();
        sphereService = new SphereService();
    }

    @Test
    public void testFindSurfaceSquare() {
        double actual = sphereService.findSurfaceSquare(sphere);
        double expected = 12.566;
        double delta = 0.001;
        Assert.assertEquals(actual, expected, delta);
    }

    @Test
    public void testFindVolume() {
        double actual = sphereService.findVolume(sphere);
        double expected = 4.188;
        double delta = 0.001;
        Assert.assertEquals(actual, expected, delta);
    }

    @Test
    public void testIsTouchCoordinatePlane() {
        Point point = new Point(1.0, 1.0, 1.0);
        boolean actual;
        try {
            sphere.setCenterPoint(point);
            sphere.setRadius(1.0);
            actual = sphereService.isTouchCoordinatePlane(sphere);
        } catch (Exception e){
            actual = false;
        }
        Assert.assertTrue(actual);
    }

    @Test
    public void testFindVolumeRatio() {
        double actual = sphereService.findVolumeRatio(sphere);
        double expected = 1.0;
        double delta = 0.0001;
        Assert.assertEquals(actual, expected, delta);
    }
}