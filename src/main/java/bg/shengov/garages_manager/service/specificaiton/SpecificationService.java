package bg.shengov.garages_manager.service.specificaiton;

import org.springframework.data.jpa.domain.Specification;

public interface SpecificationService<T> {

    void addSpecification(Specification<T> specification);

    void clearSpecifications();

    Specification<T> combineSpecifications();

}

