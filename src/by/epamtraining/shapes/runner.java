package by.epamtraining.shapes;

import by.epamtraining.shapes.dao.SphereDao;
import by.epamtraining.shapes.dao.impl.FileSphereDao;
import by.epamtraining.shapes.entity.Point;
import by.epamtraining.shapes.entity.Sphere;
import by.epamtraining.shapes.service.SphereService;

public class runner {
    public static void main(String[] args) throws Exception{
//        Point firstCenter = new Point(1.0, 1.0, 1.0);
//        Sphere s = new Sphere(firstCenter, 1.0);
//
//        Point secCent = new Point(10, 10, 0);
//        Sphere s1 = new Sphere(secCent, 3.0);
//
//        SphereService sphereService = new SphereService();
//        System.out.println(sphereService.findSurfaceSquare(s));
//        System.out.println(sphereService.findVolume(s));
//        System.out.println(sphereService.isTouchCoordinatePlane(s));
//        System.out.println();
//        System.out.println(sphereService.isTouchCoordinatePlane(s1));
//        System.out.println(sphereService.findVolume(s1));
//        System.out.println(sphereService.findVolumeRatio(s1));
//
//        Point p2 = new Point(100, 100, 20);
//        Sphere s2 = new Sphere(p2, 40);
//        System.out.println();
//        System.out.println(sphereService.findVolume(s2));
//        System.out.println(sphereService.findVolumeRatio(s2));

        SphereDao dao = new FileSphereDao();
        dao.getStrings();
    }
}
