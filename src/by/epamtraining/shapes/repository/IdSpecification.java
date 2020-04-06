package by.epamtraining.shapes.repository;

import by.epamtraining.shapes.entity.Sphere;

public class IdSpecification implements Specification {
    private long id;

    public IdSpecification(long id){
        this.id = id;
    }

    @Override
    public boolean specify(Sphere sphere){
        return id == sphere.getId();
    }
}
