package by.epamtraining.shapes;

import by.epamtraining.shapes.action.SphereAction;
import by.epamtraining.shapes.entity.Point;
import by.epamtraining.shapes.reader.SphereReader;
import by.epamtraining.shapes.reader.impl.FileSphereReader;
import by.epamtraining.shapes.entity.Shape;
import by.epamtraining.shapes.entity.Sphere;
import by.epamtraining.shapes.factory.ShapeFactory;
import by.epamtraining.shapes.factory.SphereHolderList;
import by.epamtraining.shapes.factory.impl.SphereFactory;
import by.epamtraining.shapes.parser.Parser;
import by.epamtraining.shapes.repository.RadiusSpecification;
import by.epamtraining.shapes.repository.Specification;
import by.epamtraining.shapes.repository.SphereRepository;
import by.epamtraining.shapes.util.sorting.Sorter;
import by.epamtraining.shapes.warehouse.Warehouse;
import by.epamtraining.shapes.warehouse.WarehouseObserver;

import java.util.ArrayList;
import java.util.List;

public class runner {
    public static void main(String[] args) throws Exception{

//        SphereReader dao = new FileSphereReader();
//        List<String> list = dao.getStrings("resource/file.txt");
//
//        Parser parser = new Parser();
//        List<List<Double>> allSpheres = parser.parseValue(list);
//        ShapeFactory factory = new SphereFactory();
//        SphereHolderList sphereHolderList = SphereHolderList.getInstance();
//
//        for (List<Double> valuesList: allSpheres){
//            Shape sphere = factory.create(valuesList);
//            sphereHolderList.addSphereToList((Sphere) sphere);
//        }
//        for (int i=0; i<sphereHolderList.getSphereList().size(); i++){
//            Sphere s = sphereHolderList.getSphereList().get(i);
//            System.out.print(s.getId() + " ");
//            System.out.print(s.getCenterPoint() + " ");
//            System.out.print(s.getRadius() + "\n");
//        }

        runner runner = new runner();
        Warehouse warehouse = Warehouse.getInstance();

        List<Double> testValue1 = new ArrayList<>();
        testValue1.add(10.5);
        testValue1.add(13.5);
        testValue1.add(0.0);
        testValue1.add(10.0);
        SphereFactory factory = new SphereFactory();
        Sphere sphere1 = (Sphere) factory.create(testValue1);           //sphere1 created

        System.out.println("1st===");
        warehouse.print();

        List<Double> testValue2 = new ArrayList<>();
        testValue2.add(5.0);
        testValue2.add(8.0);
        testValue2.add(12.0);
        testValue2.add(6.0);
        Sphere sphere2 = (Sphere) factory.create(testValue2);           //sphere2 created

        System.out.println("2nd====");
        warehouse.print();

        List<Double> testValue3 = new ArrayList<>();
        testValue3.add(4.0);
        testValue3.add(3.0);
        testValue3.add(8.0);
        testValue3.add(6.5);
        Sphere sphere3 = (Sphere) factory.create(testValue3);

        SphereRepository repo = SphereRepository.getInstance();
        repo.addSphere(sphere1);                                        // added to repo
        repo.addSphere(sphere2);
        repo.addSphere(sphere3);
        runner.printList(repo.sphereList);

        Sorter sorter = new Sorter();
        System.out.println("id=" + sorter.sortById(repo.sphereList));

        System.out.println("radius=" + sorter.sortByRadius(repo.sphereList));

//        Specification testSpecification = new RadiusSpecification(2.0, 7.0);
//        List<Sphere> testSphereList = repo.query(testSpecification);
//        Sphere targetSphere = testSphereList.get(0);
//        System.out.println(targetSphere);                               // target print
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

        System.out.println("repo after changes: ");      //test print
        runner.printList(repo.sphereList);

    }

    public void printList(List<Sphere> list){
        for(Sphere s: list){
            System.out.println("s Id = " + s.getId());
            System.out.println("s center = " + s.getCenterPoint());
            System.out.println("s radius = " + s.getRadius());
        }
    }
}
