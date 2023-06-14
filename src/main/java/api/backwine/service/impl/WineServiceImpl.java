package api.backwine.service.impl;

import api.backwine.dao.WineDao;
import api.backwine.model.Wine;
import api.backwine.service.WineService;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class WineServiceImpl implements WineService {
    private final WineDao wineDao;

    public WineServiceImpl(WineDao wineDao) {
        this.wineDao = wineDao;
    }

    @Override
    public List<Wine> getAllWines() {
        return wineDao.findAll();
    }

    @Override
    public Wine getWineById(Long id) {
        return wineDao.findById(id).orElseThrow(() ->
                new RuntimeException("Can't get wine by id " + id));
    }

    @Override
    public Wine createWine(Wine wine) {
        return wineDao.save(wine);
    }

    @Override
    public void deleteWine(Long id) {
        wineDao.deleteById(id);
    }
}


