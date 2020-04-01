package by.epamtraining.shapes.exception;

public class ValidationException extends Exception {
    static final long serialVersionUID = 1L;

    public ValidationException(){
        super();
    }

    public ValidationException(String message){
        super(message);
    }

    public ValidationException(Exception e){
        super(e);
    }

    public ValidationException(String message, Exception e){
        super(message, e);
    }
}
