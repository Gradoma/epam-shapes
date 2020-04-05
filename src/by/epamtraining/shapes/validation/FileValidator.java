package by.epamtraining.shapes.validation;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileValidator {

    public boolean isFileExist(String fileName){
        Path filePath = Paths.get(fileName);
        return Files.exists(filePath);
    }
}
