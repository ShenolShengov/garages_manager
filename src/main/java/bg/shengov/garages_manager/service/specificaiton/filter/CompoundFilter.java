package bg.shengov.garages_manager.service.specificaiton.filter;

import org.springframework.data.jpa.domain.Specification;

import java.util.Optional;
import java.util.function.BiFunction;

public class CompoundFilter<K, T> implements FilterCriteria<T> {

    private final K first;
    private final K second;
    private final BiFunction<K, K, Specification<T>> specificationBuilder;

    public CompoundFilter(K first, K second, BiFunction<K, K, Specification<T>> specificationBuilder) {
        this.first = first;
        this.second = second;
        this.specificationBuilder = specificationBuilder;
    }

    public boolean isValidFilter() {
        return first != null && second != null;
    }

    @Override
    public Optional<Specification<T>> toSpecification() {
        return isValidFilter() ? Optional.of(specificationBuilder.apply(first, second)) : Optional.empty();
    }
}
