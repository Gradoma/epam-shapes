package test.epamtraining.shapes.action;

import by.epamtraining.shapes.entity.Point;
import by.epamtraining.shapes.entity.Sphere;
import by.epamtraining.shapes.action.SphereAction;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SphereActionTest {
    Sphere sphere;
    SphereAction sphereAction;

    @BeforeClass
    public void setUp(){
        sphere = new Sphere();
        sphereAction = new SphereAction();
    }

    @Test (dependsOnGroups = "Factory")
    public void testFindSurfaceSquare() {
        double actual = sphereAction.findSurfaceSquare(sphere);
        double expected = 12.566;
        double delta = 0.001;
        Assert.assertEquals(actual, expected, delta);
    }

    @Test (dependsOnGroups = "Factory")
    public void testFindVolume() {
        double actual = sphereAction.findVolume(sphere);
        double expected = 4.188;
        double delta = 0.001;
        Assert.assertEquals(actual, expected, delta);
    }

    @Test (dependsOnGroups = "Factory")
    public void testIsTouchCoordinatePlane() {
        Point point = new Point(1.0, 1.0, 1.0);
        boolean actual;
        try {
            sphere.setCenterPoint(point);
            sphere.setRadius(1.0);
            actual = sphereAction.isTouchCoordinatePlane(sphere);
        } catch (Exception e){
            actual = false;
        }
        Assert.assertTrue(actual);
    }

    @Test (dependsOnGroups = "Factory")
    public void testFindVolumeRatio() {
        double actual = sphereAction.findVolumeRatio(sphere);
        double expected = 1.0;
        double delta = 0.0001;
        Assert.assertEquals(actual, expected, delta);
    }
}