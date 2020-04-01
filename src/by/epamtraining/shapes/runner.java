package by.epamtraining.shapes;

import by.epamtraining.shapes.dao.SphereDao;
import by.epamtraining.shapes.dao.impl.FileSphereDao;
import by.epamtraining.shapes.entity.Point;
import by.epamtraining.shapes.entity.Sphere;
import by.epamtraining.shapes.parser.Parser;
import by.epamtraining.shapes.service.SphereService;
import by.epamtraining.shapes.validation.Validator;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class runner {
    public static void main(String[] args) throws Exception{

        SphereDao dao = new FileSphereDao();
        List<String> list = dao.getStrings();

        Validator validator = new Validator();
        List<String> updList = validator.checkList(list);
        for (String s : updList) {
            System.out.println(s);
        }
        Parser parser = new Parser();
        for (String s : updList){
            System.out.println(parser.parse(s));
        }

    }
}
