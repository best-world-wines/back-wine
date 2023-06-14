//package api.backwine.config;
//
//import api.backwine.dto.api.ApiResponseDto;
//import api.backwine.repository.WineRepository;
//import api.backwine.service.HttpClient;
//import jakarta.annotation.PostConstruct;
//import jakarta.transaction.Transactional;
//import lombok.RequiredArgsConstructor;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.stereotype.Component;
//
//import java.rmi.server.UnicastRemoteObject;
//
//@Component
//@RequiredArgsConstructor
//public class DataLoader {
//    private final WineRepository wineRepository;
//    private final HttpClient httpClient;
//    @Value("${api.url.wines}")
//    private String url;
//
//    @PostConstruct
//    @Transactional
//    public void init() {
//        ApiResponseDto apiResponseDto = httpClient.get(url, ApiResponseDto.class);
//    }
//}
