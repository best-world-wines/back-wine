package api.backwine.service;

import api.backwine.model.Wine;
import java.util.List;

public interface WineService {

    List<Wine> getAllWines();

    Wine getWineById(Long id);

    Wine createWine(Wine wine);

    void deleteWine(Long id);
}
