package by.epamtraining.shapes.validation;

import by.epamtraining.shapes.exception.ValidationException;

import java.util.ArrayList;
import java.util.List;

public class Validator {

    public List<String> checkList (List<String> list) throws ValidationException{
        if (list.isEmpty()){
            throw new ValidationException("file if empty");
        }
        List<String> checkedList = new ArrayList<>();
        for (String s : list) {
            if (s.isEmpty()){
                continue;
            }
            if (!s.contains(" ")){
                continue;
            }
            checkedList.add(s);
        }
        return checkedList;
    }
}
