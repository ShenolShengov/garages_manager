package bg.shengov.garages_manager.service.specificaiton.impl;

import bg.shengov.garages_manager.service.specificaiton.SpecificationService;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.HashSet;

@Service
public class SpecificationServiceImpl<T> implements SpecificationService<T> {

    private final HashSet<Specification<T>> specifications;

    public SpecificationServiceImpl() {
        this.specifications = new HashSet<>();
    }

    @Override
    public void addSpecification(Specification<T> specification) {
        specifications.add(specification);
    }

    @Override
    public void clearSpecifications() {
        specifications.clear();
    }

    @Override
    public Specification<T> combineSpecifications() {
        return Specification.allOf(specifications);
    }
}
