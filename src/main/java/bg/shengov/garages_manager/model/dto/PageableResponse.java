package bg.shengov.garages_manager.model.dto;

import org.springframework.data.domain.Page;
import org.springframework.data.web.PagedModel;

import java.io.Serializable;
import java.util.List;

public record PageableResponse<T>(List<T> content, PagedModel.PageMetadata page, boolean hasNext,
                                  boolean hasPrevious) implements Serializable {

    public static <T> PageableResponse<T> from(Page<T> page) {
        PagedModel<T> pagedModel = new PagedModel<>(page);
        return new PageableResponse<>(page.getContent(), pagedModel.getMetadata(), page.hasNext(), page.hasPrevious());
    }
}
