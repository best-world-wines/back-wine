package api.backwine.util;

import java.util.ArrayList;
import java.util.List;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

@Component
public class PageService {
    private static final int DIRECTION = 1;
    private static final int FIELD = 0;

    public Pageable getPageable(Integer size, Integer pageNumber, String sortBy) {
        List<Sort.Order> orders = new ArrayList<>();
        String[] fields = sortBy.split(";");
        for (String field : fields) {
            Sort.Order order;
            if (field.contains(":")) {
                String[] fieldAndDirection = field.split(":");
                order = new Sort.Order(Sort.Direction.valueOf(fieldAndDirection[DIRECTION]),
                        fieldAndDirection[FIELD]);
            } else {
                order = new Sort.Order(Sort.Direction.DESC, field);
            }
            orders.add(order);
        }
        return PageRequest.of(pageNumber, size, Sort.by(orders));
    }
}
