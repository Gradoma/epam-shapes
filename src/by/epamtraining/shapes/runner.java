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
        List<String> list = dao.getStrings();

        Validator validator = new Validator();
        List<String> updList = validator.checkList(list);
        Parser parser = new Parser();
        ShapeFactory factory = new SphereFactory();
        SphereHolderList sphereHolderList = SphereHolderList.getInstance();
        for (String s : updList){
            if (parser.parseId(s) < 0){
                continue;
            }
            int id = parser.parseId(s);
            if (parser.parse(s) == null){
                continue;
            }
            List<Double> valuesList = parser.parse(s);
            double xCoordinate = valuesList.get(0);
            double yCoordinate = valuesList.get(1);
            double zCoordinate = valuesList.get(2);
            double radius = valuesList.get(3);
            Shape sphere = factory.create(id, xCoordinate, yCoordinate, zCoordinate, radius);
            sphereHolderList.addSphereToList((Sphere) sphere);
        }
        System.out.println(sphereHolderList.getSphereList());
    }
}
