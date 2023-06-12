package api.backwine.config;

import api.backwine.model.Wine;
import api.backwine.repository.WineRepository;
import api.backwine.service.WineService;
import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
@RequiredArgsConstructor
public class DataLoader {
    private final WineRepository wineRepository;

    private static final String API_URL = "https://api.example.com/wines";


    @PostConstruct
    @Transactional
    public void init() {
    }
}
