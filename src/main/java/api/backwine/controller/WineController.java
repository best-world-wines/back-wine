package api.backwine.controller;

import api.backwine.dto.mapper.ProductPageMapper;
import api.backwine.dto.mapper.WineMapper;
import api.backwine.dto.request.WineRequestDto;
import api.backwine.dto.response.ProductPageResponse;
import api.backwine.dto.response.WineResponseDto;
import api.backwine.model.Wine;
import api.backwine.service.WineService;
import api.backwine.util.PageService;
import jakarta.validation.Valid;
import java.util.List;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/wines")
public class WineController {
    private static final String DEFAULT_PAGE_SIZE = "20";
    private static final String DEFAULT_PAGE_NUMBER = "0";
    private static final String DEFAULT_SORT_BY = "id";
    private final WineService wineService;
    private final PageService pageService;
    private final WineMapper wineMapper;
    private final ProductPageMapper<Wine, WineResponseDto> winePageMapper;

    public WineController(WineService wineService, WineMapper wineMapper, PageService pageService,
                          ProductPageMapper<Wine, WineResponseDto> winePageMapper) {
        this.wineService = wineService;
        this.wineMapper = wineMapper;
        this.pageService = pageService;
        this.winePageMapper = winePageMapper;
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping()
    public ResponseEntity<WineResponseDto> create(@Valid @RequestBody
                                                  WineRequestDto wineRequestDto) {
        return new ResponseEntity<>(wineMapper.toDto(
                wineService.create(wineMapper.toModel(wineRequestDto))), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<WineResponseDto>> getAll() {
        return ResponseEntity.ok(wineService.getAll()
                .stream()
                .map(wineMapper::toDto)
                .toList());
    }

    @GetMapping("/pages")
    public ResponseEntity<ProductPageResponse<WineResponseDto>> getWinePage(
            @RequestParam(value = "size", defaultValue = DEFAULT_PAGE_SIZE) Integer size,
            @RequestParam(value = "page", defaultValue = DEFAULT_PAGE_NUMBER) Integer pageNumber,
            @RequestParam(value = "sort", defaultValue = DEFAULT_SORT_BY) String sortBy) {
        Pageable pageable = pageService.getPageable(size, pageNumber, sortBy);
        return ResponseEntity.ok(winePageMapper.toDto(wineService.getAll(pageable), wineMapper));
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/{id}")
    public ResponseEntity<WineResponseDto> update(@PathVariable("id") Long id,
                                                  @Valid @RequestBody
                                                  WineRequestDto wineRequestDto) {
        return ResponseEntity.ok(wineMapper.toDto(
                wineService.update(id, wineMapper.toModel(wineRequestDto))));
    }

    @GetMapping("/{id}")
    public ResponseEntity<WineResponseDto> get(@PathVariable Long id) {
        return ResponseEntity.ok(wineMapper.toDto(wineService.getById(id)));
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") Long id) {
        wineService.deleteById(id);
        return ResponseEntity.ok("Success, deleted entity by id " + id);
    }
}
