package api.backwine.controller;

import api.backwine.dto.mapper.WineMapper;
import api.backwine.dto.request.WineRequestDto;
import api.backwine.dto.response.WineResponseDto;
import api.backwine.model.Wine;
import api.backwine.service.WineService;
import java.util.List;
import java.util.stream.Collectors;
import javax.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/wines")
public class WineController {

    private final WineService wineService;
    private final WineMapper wineMapper;

    public WineController(WineService wineService, WineMapper wineMapper) {
        this.wineService = wineService;
        this.wineMapper = wineMapper;
    }

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public WineResponseDto createWine(@Valid @RequestBody WineRequestDto wineRequestDto) {
        return wineMapper.mapToDto(wineService.createWine(wineMapper.mapToModel(wineRequestDto)));
    }

    @GetMapping
    public List<WineResponseDto> getAll() {
        return wineService.getAllWines()
                .stream()
                .map(wineMapper::mapToDto)
                .collect(Collectors.toList());
    }

    @PutMapping("/{id}")
    public WineResponseDto updateWine(@PathVariable Long id,
                                      @Valid @RequestBody WineRequestDto wineRequestDto) {
        Wine wine = wineMapper.mapToModel(wineRequestDto);
        wine.setId(id);
        return wineMapper.mapToDto(wineService.createWine(wine));
    }

    @GetMapping("/{id}")
    public WineResponseDto getWine(@PathVariable Long id) {
        return wineMapper.mapToDto(wineService.getWineById(id));
    }
}
