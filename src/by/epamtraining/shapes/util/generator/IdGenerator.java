package by.epamtraining.shapes.util.generator;

public class IdGenerator {
    private static long idCounter = 1;

    public long generateId(){
        return idCounter++;
    }
}
