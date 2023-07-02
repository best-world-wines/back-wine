package api.backwine.service.impl;

import api.backwine.model.Winery;
import api.backwine.repository.WineryRepository;
import api.backwine.service.WineryService;
import java.util.List;
import java.util.NoSuchElementException;
import org.springframework.stereotype.Service;

@Service
public class WineryServiceImpl implements WineryService {
    private final WineryRepository wineryRepository;

    public WineryServiceImpl(WineryRepository wineryRepository) {
        this.wineryRepository = wineryRepository;
    }

    @Override
    public Winery create(Winery winery) {
        return wineryRepository.save(winery);
    }

    @Override
    public Winery getById(Long id) {
        return wineryRepository.findById(id).orElseThrow(() ->
                new NoSuchElementException("Can't get winery by id " + id));
    }

    @Override
    public List<Winery> getAll() {
        return wineryRepository.findAll();
    }

    @Override
    public boolean deleteById(Long id) {
        wineryRepository.deleteById(id);
        return true;
    }

    @Override
    public Winery update(Long id, Winery winery) {
        winery.setId(id);
        return wineryRepository.save(winery);
    }
}
