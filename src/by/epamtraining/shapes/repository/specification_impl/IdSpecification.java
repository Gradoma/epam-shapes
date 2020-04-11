package by.epamtraining.shapes.repository.specification_impl;

import by.epamtraining.shapes.entity.Sphere;
import by.epamtraining.shapes.repository.Specification;

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
