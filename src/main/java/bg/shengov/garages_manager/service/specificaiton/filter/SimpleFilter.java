package bg.shengov.garages_manager.service.specificaiton.filter;

import org.springframework.data.jpa.domain.Specification;

import java.util.Optional;
import java.util.function.Function;

public class SimpleFilter<K, T> implements FilterCriteria<T> {

    private final K param;
    private final Function<K, Specification<T>> specificationBuilder;

    public SimpleFilter(K param, Function<K, Specification<T>> specificationBuilder) {
        this.param = param;
        this.specificationBuilder = specificationBuilder;
    }

    public boolean isValidFilter() {
        return param != null;
    }
    @Override
    public Optional<Specification<T>> toSpecification() {
        return isValidFilter() ? Optional.of(specificationBuilder.apply(param)) : Optional.empty();
    }
}
