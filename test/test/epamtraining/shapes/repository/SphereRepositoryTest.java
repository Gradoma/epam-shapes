package test.epamtraining.shapes.repository;

import by.epamtraining.shapes.entity.Point;
import by.epamtraining.shapes.entity.Sphere;
import by.epamtraining.shapes.exception.IncorrectDataException;
import by.epamtraining.shapes.repository.SphereRepository;
import by.epamtraining.shapes.repository.comparator.IdComparator;
import by.epamtraining.shapes.repository.comparator.RadiusComparator;
import by.epamtraining.shapes.repository.specification_impl.IdSpecification;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static org.testng.Assert.*;

public class SphereRepositoryTest {
    Point p1 = new Point(2.5, 5.0, 1.3);
    Point p2 = new Point(-5.4, 2.4, 5.3);
    Point p3 = new Point(-11.2, 0.4, 9.2);
    Sphere s1 ;
    Sphere s2 ;
    Sphere s3 ;
    double r1 = 5.0;
    double r2 = 3.0;
    double r3 = 1.0;

    @BeforeClass
    public void setUp(){
        try{
            s1 = new Sphere(p1, r1);
            s2 = new Sphere(p2, r2);
            s3 = new Sphere(p3, r3);
        } catch (IncorrectDataException e){
            Assert.fail();
        }
        s1.setId(1);
        s2.setId(2);
        s3.setId(3);

        SphereRepository repository = SphereRepository.getInstance();
//        if (!repository.getSphereList().isEmpty()){
//            repository.getSphereList().clear();
//        }
        repository.addSphere(s2);
        repository.addSphere(s1);
        repository.addSphere(s3);
    }

    @AfterMethod
    public void setRepositoryToDefault(){
        try{
            s1.setCenterPoint(p1);
            s1.setRadius(r1);
            s2.setCenterPoint(p2);
            s2.setRadius(r2);
            s3.setCenterPoint(p3);
            s3.setRadius(r3);
        } catch (IncorrectDataException e){
            Assert.fail();
        }
    }

    @Test (dependsOnGroups = "Factory", groups = "Repository")
    public void testChangeSphereByRadiusPositive() {
        long id = 2;
        double newRadius = 10.0;
        SphereRepository repository = SphereRepository.getInstance();
        Assert.assertTrue(repository.changeSphere(id, newRadius));
    }

    @Test (dependsOnGroups = "Factory", groups = "Repository")
    public void testChangeSphereByRadiusIncorrectId() {
        long id = 5;
        double newRadius = 10.0;
        SphereRepository repository = SphereRepository.getInstance();
        Assert.assertFalse(repository.changeSphere(id, newRadius));
    }

    @Test (dependsOnGroups = "Factory", groups = "Repository")
    public void testChangeSphereByRadiusIncorrectRadius() {
        long id = 2;
        double newRadius = -10.0;
        SphereRepository repository = SphereRepository.getInstance();
        Assert.assertFalse(repository.changeSphere(id, newRadius));
    }

    @Test (dependsOnGroups = "Factory", groups = "Repository")
    public void testChangeSphereByCenterPointPositive() {
        long id = 3;
        Point newPoint = new Point(-10, -10, -10);
        SphereRepository repository = SphereRepository.getInstance();
        Assert.assertTrue(repository.changeSphere(id, newPoint));
    }

    @Test (dependsOnGroups = "Factory", groups = "Repository")
    public void testChangeSphereByCenterPointIncorrectId() {
        long id = 6;
        Point newPoint = new Point(-10, -10, -10);
        SphereRepository repository = SphereRepository.getInstance();
        Assert.assertFalse(repository.changeSphere(id, newPoint));
    }

    @Test (dependsOnGroups = "Factory", groups = "Repository")
    public void testChangeSphereByCenterPointNullPoint() {
        long id = 6;
        Point newPoint = null;
        SphereRepository repository = SphereRepository.getInstance();
        Assert.assertFalse(repository.changeSphere(id, newPoint));
    }

    @Test (dependsOnGroups = "Factory", groups = "Repository")
    public void testSortById() {
        Sphere s1 = null;
        Sphere s2 = null;
        Sphere s3 = null;
        try{
            s1 = new Sphere(p1, r1);
            s2 = new Sphere(p2, r2);
            s3 = new Sphere(p3, r3);
        } catch (IncorrectDataException e){
            Assert.fail();
        }
        s1.setId(1);
        s2.setId(2);
        s3.setId(3);
        List<Sphere> expected = new ArrayList<>();
        expected.add(s1);
        expected.add(s2);
        expected.add(s3);

        Comparator<Sphere> idComparator = new IdComparator();
        SphereRepository repository = SphereRepository.getInstance();
        List<Sphere> actual = repository.sort(idComparator);

        Assert.assertEquals(actual, expected);
    }

    @Test (dependsOnGroups = "Factory", groups = "Repository")
    public void testSortByRadius() {
        Sphere s1 = null;
        Sphere s2 = null;
        Sphere s3 = null;
        try{
            s1 = new Sphere(p1, r1);
            s2 = new Sphere(p2, r2);
            s3 = new Sphere(p3, r3);
        } catch (IncorrectDataException e){
            Assert.fail();
        }
        s1.setId(1);
        s2.setId(2);
        s3.setId(3);
        List<Sphere> expected = new ArrayList<>();
        expected.add(s3);
        expected.add(s2);
        expected.add(s1);

        Comparator<Sphere> radiusComparator = new RadiusComparator();
        SphereRepository repository = SphereRepository.getInstance();
        List<Sphere> actual = repository.sort(radiusComparator);

        Assert.assertEquals(actual, expected);
    }
}