package bg.shengov.garages_manager.service.specificaiton.filter;

import org.springframework.data.jpa.domain.Specification;

import java.util.Optional;
import java.util.function.BiFunction;
import java.util.function.Function;

public class CompoundFilter<K, T> implements FilterCriteria<T> {

    private final K first;
    private final K second;
    private final BiFunction<K, K, Specification<T>> specificationBuilder;
    private Function<K, Specification<T>> firstSpecificationBuilder;
    private Function<K, Specification<T>> secondSpecificationBuilder;

    public CompoundFilter(K first, K second, BiFunction<K, K, Specification<T>> specificationBuilder) {
        this.first = first;
        this.second = second;
        this.specificationBuilder = specificationBuilder;
    }

    public CompoundFilter(K first, K second, BiFunction<K, K, Specification<T>> specificationBuilder,
                          Function<K, Specification<T>> firstSpecificationBuilder,
                          Function<K, Specification<T>> secondSpecificationBuilder) {
        this.first = first;
        this.second = second;
        this.specificationBuilder = specificationBuilder;
        this.firstSpecificationBuilder = firstSpecificationBuilder;
        this.secondSpecificationBuilder = secondSpecificationBuilder;
    }

    public boolean isValidFilter() {
        return first != null && second != null;
    }

    @Override
    public Optional<Specification<T>> toSpecification() {
        if (isValidFilter()) {
            return Optional.of(specificationBuilder.apply(first, second));
        }
        if (first != null) {
            return Optional.of(firstSpecificationBuilder.apply(first));
        }
        if (second != null) {
            return Optional.of(secondSpecificationBuilder.apply(second));
        }
        return Optional.empty();
    }
}
