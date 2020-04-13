package by.epamtraining.shapes;

import by.epamtraining.shapes.action.SphereAction;
import by.epamtraining.shapes.entity.Shape;
import by.epamtraining.shapes.entity.Sphere;
import by.epamtraining.shapes.factory.impl.SphereFactory;
import by.epamtraining.shapes.parser.Parser;
import by.epamtraining.shapes.reader.SphereReader;
import by.epamtraining.shapes.reader.impl.FileSphereReader;
import by.epamtraining.shapes.repository.Specification;
import by.epamtraining.shapes.repository.SphereRepository;
import by.epamtraining.shapes.repository.comparator.IdComparator;
import by.epamtraining.shapes.repository.comparator.RadiusComparator;
import by.epamtraining.shapes.repository.specification_impl.IdSpecification;
import by.epamtraining.shapes.repository.specification_impl.RadiusSpecification;
import by.epamtraining.shapes.warehouse.SphereObserver;
import by.epamtraining.shapes.warehouse.Warehouse;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class runner {
    public static void main(String[] args) throws Exception{

        SphereReader dao = new FileSphereReader();
        List<String> list = dao.getStrings("resource/file.txt");

        Parser parser = new Parser();
        List<List<Double>> allSpheres = parser.parseValue(list);
        SphereFactory factory = new SphereFactory();

        SphereRepository repo = SphereRepository.getInstance();
        for (List<Double> valuesList: allSpheres){
            Sphere sphere = (Sphere)factory.create(valuesList);
            sphere.attach(SphereObserver.getInstance());
            repo.addSphere(sphere);
        }

        runner runner = new runner();
        runner.printList(repo.getSphereList());

        Specification<Sphere> idSpecif = new IdSpecification(3);
        List<Sphere> idList = repo.query(idSpecif);
        Sphere testSphere = idList.get(0);

        SphereAction action = new SphereAction();
        action.isTouchCoordinatePlane(testSphere);

//        Warehouse warehouse = Warehouse.getInstance();
//
//        List<Double> testValue1 = new ArrayList<>();
//        testValue1.add(10.5);
//        testValue1.add(13.5);
//        testValue1.add(0.0);
//        testValue1.add(10.0);
//        SphereFactory factory = new SphereFactory();
//        Sphere sphere1 = (Sphere) factory.create(testValue1);           //sphere1 created
//        sphere1.attach(SphereObserver.getInstance());
//
//        System.out.println("1st===");
//        warehouse.print();
//
//        List<Double> testValue2 = new ArrayList<>();
//        testValue2.add(5.0);
//        testValue2.add(8.0);
//        testValue2.add(12.0);
//        testValue2.add(6.0);
//        Sphere sphere2 = (Sphere) factory.create(testValue2);           //sphere2 created
//        sphere2.attach(SphereObserver.getInstance());
//
//        System.out.println("2nd====");
//        warehouse.print();
//
//        List<Double> testValue3 = new ArrayList<>();
//        testValue3.add(4.0);
//        testValue3.add(3.0);
//        testValue3.add(8.0);
//        testValue3.add(6.5);
//        Sphere sphere3 = (Sphere) factory.create(testValue3);
//        sphere3.attach(SphereObserver.getInstance());
//
//        SphereRepository repo = SphereRepository.getInstance();
//        repo.addSphere(sphere1);                                        // added to repo
//        repo.addSphere(sphere2);
//        repo.addSphere(sphere3);
//        runner.printList(repo.sphereList);
//
//        Comparator<Sphere> idComparator = new IdComparator();
//        System.out.println("id=" + repo.sort(idComparator));
//        System.out.println("repo:");
//        runner.printList(repo.sphereList);
//
//        Comparator<Sphere> radiusComparator = new RadiusComparator();
//        System.out.println("radius=" + repo.sort(radiusComparator));


//        Specification testSpecification = new RadiusSpecification(2.0, 7.0);
//        List<Sphere> testSphereList = repo.query(testSpecification);
//        Sphere targetSphere = testSphereList.get(0);
//        System.out.println("target sphere = " + targetSphere);                               // target print
//
//        long targetId = targetSphere.getId();
//        repo.changeSphere(targetId, 255.2);
//
//        System.out.println("3nd====");
//        warehouse.print();                                              // 1st change
//
//        Point testPoint = new Point(-15.5, 187.25, 35.66);
//        repo.changeSphere(1, testPoint);
//        System.out.println("4th====");
//        warehouse.print();                                              // 2nd change
//
//        repo.changeSphere(2, 10.0);
//        System.out.println("5th====");
//        warehouse.print();                                              //3nd change

//        System.out.println("repo after changes: ");      //test print
//        runner.printList(repo.sphereList);

    }

    public void printList(List<Sphere> list){
        for(Sphere s: list){
            System.out.println("s Id = " + s.getId());
            System.out.println("s center = " + s.getCenterPoint());
            System.out.println("s radius = " + s.getRadius());
        }
    }
}
