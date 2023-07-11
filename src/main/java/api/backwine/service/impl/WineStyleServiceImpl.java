package api.backwine.service.impl;

import api.backwine.model.WineStyle;
import api.backwine.repository.WineStyleRepository;
import api.backwine.service.AbstractService;
import java.util.List;
import java.util.NoSuchElementException;
import org.springframework.stereotype.Service;

@Service
public class WineStyleServiceImpl implements AbstractService<WineStyle> {
    private final WineStyleRepository wineStyleRepository;

    public WineStyleServiceImpl(WineStyleRepository wineStyleRepository) {
        this.wineStyleRepository = wineStyleRepository;
    }

    @Override
    public WineStyle create(WineStyle wineStyle) {
        return wineStyleRepository.save(wineStyle);
    }

    @Override
    public WineStyle getById(Long id) {
        return wineStyleRepository.findById(id).orElseThrow(() ->
                new NoSuchElementException("Can't get wine style by id " + id));
    }

    @Override
    public List<WineStyle> getAll() {
        return wineStyleRepository.findAll();
    }

    @Override
    public boolean deleteById(Long id) {
        WineStyle wineStyle = wineStyleRepository.findById(id).orElseThrow(() ->
                new NoSuchElementException("Can't delete wine style by id" + id));
        wineStyle.setDeleted(true);
        wineStyleRepository.save(wineStyle);
        return true;
    }

    @Override
    public WineStyle update(Long id, WineStyle wineStyle) {
        wineStyle.setId(id);
        return wineStyleRepository.save(wineStyle);
    }
}
