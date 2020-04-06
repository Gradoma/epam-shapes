package by.epamtraining.shapes;

import by.epamtraining.shapes.reader.SphereReader;
import by.epamtraining.shapes.reader.impl.FileSphereReader;
import by.epamtraining.shapes.entity.Shape;
import by.epamtraining.shapes.entity.Sphere;
import by.epamtraining.shapes.factory.ShapeFactory;
import by.epamtraining.shapes.factory.SphereHolderList;
import by.epamtraining.shapes.factory.impl.SphereFactory;
import by.epamtraining.shapes.parser.Parser;

import java.util.List;

public class runner {
    public static void main(String[] args) throws Exception{

        SphereReader dao = new FileSphereReader();
        List<String> list = dao.getStrings("resource/file.txt");
        
        Parser parser = new Parser();
        List<List<Double>> allSpheres = parser.parseValue(list);
        ShapeFactory factory = new SphereFactory();
        SphereHolderList sphereHolderList = SphereHolderList.getInstance();

        for (List<Double> valuesList: allSpheres){
            Shape sphere = factory.create(valuesList);
            sphereHolderList.addSphereToList((Sphere) sphere);
        }
        for (int i=0; i<sphereHolderList.getSphereList().size(); i++){
            Sphere s = sphereHolderList.getSphereList().get(i);
            System.out.print(s.getId() + " ");
            System.out.print(s.getCenterPoint() + " ");
            System.out.print(s.getRadius() + "\n");
        }

    }
}
