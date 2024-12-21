package bg.shengov.garages_manager.service.specificaiton.filter;

import org.springframework.data.jpa.domain.Specification;

import java.util.Optional;

public interface FilterCriteria<T> {

    Optional<Specification<T>> toSpecification();
}
