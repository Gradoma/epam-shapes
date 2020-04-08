package by.epamtraining.shapes;

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
        WarehouseObserver warehouseObserver = new WarehouseObserver();

        List<Double> testValue1 = new ArrayList<>();
        testValue1.add(2.5);
        testValue1.add(3.5);
        testValue1.add(5.2);
        testValue1.add(10.0);
        SphereFactory factory = new SphereFactory();
        Sphere sphere1 = (Sphere) factory.create(testValue1);           //sphere1 created
        sphere1.attach(warehouseObserver);                              // sphere1 attached

        List<Double> testValue2 = new ArrayList<>();
        testValue2.add(2.5);
        testValue2.add(3.5);
        testValue2.add(5.2);
        testValue2.add(15.4);
        Sphere sphere2 = (Sphere) factory.create(testValue2);           //sphere2 created
        sphere2.attach(warehouseObserver);                              // sphere2 attached

        SphereRepository repo = SphereRepository.getInstance();
        repo.addSphere(sphere1);                                        // added to repo
        repo.addSphere(sphere2);
        runner.printList(repo.sphereList);

        Specification testSpecification = new RadiusSpecification(12.0, 17.0);
        List<Sphere> testSphereList = repo.query(testSpecification);
        Sphere targetSphere = testSphereList.get(0);
        System.out.println(targetSphere);                               // target print

        long targetId = targetSphere.getId();
        repo.changeSphere(targetId, 255.2);

        Warehouse warehouse = Warehouse.getInstance();
        warehouse.print();                                              // 1st change

        Point testPoint = new Point(-15.5, 187.25, 35.66);
        repo.changeSphere(1, testPoint);
        warehouse.print();                                              // 2nd change

        repo.changeSphere(2, 10.0);
        warehouse.print();                                              //3nd change

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
