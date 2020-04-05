package by.epamtraining.shapes;

import by.epamtraining.shapes.dao.SphereDao;
import by.epamtraining.shapes.dao.impl.FileSphereDao;
import by.epamtraining.shapes.entity.Shape;
import by.epamtraining.shapes.entity.Sphere;
import by.epamtraining.shapes.factory.ShapeFactory;
import by.epamtraining.shapes.factory.SphereHolderList;
import by.epamtraining.shapes.factory.impl.SphereFactory;
import by.epamtraining.shapes.parser.Parser;
import by.epamtraining.shapes.validation.Validator;

import java.util.List;

public class runner {
    public static void main(String[] args) throws Exception{

        SphereDao dao = new FileSphereDao();
        List<String> list = dao.getStrings("examplefile.txt");

        Validator validator = new Validator();
        List<String> updatedList = validator.checkList(list);
        Parser parser = new Parser();
        ShapeFactory factory = new SphereFactory();
        SphereHolderList sphereHolderList = SphereHolderList.getInstance();
        for (String s : updatedList){
            if (parser.parseValue(s) == null){
                continue;
            }
            List<Double> valuesList = parser.parseValue(s);
            double xCoordinate = valuesList.get(0);
            double yCoordinate = valuesList.get(1);
            double zCoordinate = valuesList.get(2);
            double radius = valuesList.get(3);
            int id = 1;
            Shape sphere = factory.create(id, xCoordinate, yCoordinate, zCoordinate, radius);
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
