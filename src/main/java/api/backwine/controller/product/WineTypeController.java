package api.backwine.controller.product;

import api.backwine.dto.mapper.product.WineTypeMapper;
import api.backwine.dto.request.product.WineTypeRequestDto;
import api.backwine.dto.response.product.WineTypeResponseDto;
import api.backwine.service.product.WineTypeService;
import jakarta.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;
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
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/v1/wine-types", produces = "application/json")
public class WineTypeController {
    private final WineTypeService wineTypeService;
    private final WineTypeMapper wineTypeMapper;

    public WineTypeController(WineTypeService wineTypeService, WineTypeMapper wineTypeMapper) {
        this.wineTypeService = wineTypeService;
        this.wineTypeMapper = wineTypeMapper;
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping()
    public ResponseEntity<WineTypeResponseDto> create(@Valid @RequestBody
                                                      WineTypeRequestDto wineTypeRequestDto) {
        return new ResponseEntity<>(wineTypeMapper.toDto(
                wineTypeService
                        .create(wineTypeMapper.toModel(wineTypeRequestDto))), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<WineTypeResponseDto>> getAll() {
        return ResponseEntity.ok(wineTypeService.getAll()
                .stream()
                .map(wineTypeMapper::toDto)
                .collect(Collectors.toList()));
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/{id}")
    public ResponseEntity<WineTypeResponseDto> update(@PathVariable("id") Long id,
                                                      @Valid @RequestBody
                                                      WineTypeRequestDto wineTypeRequestDto) {
        return ResponseEntity.ok(wineTypeMapper.toDto(
                wineTypeService.update(id, wineTypeMapper.toModel(wineTypeRequestDto))));
    }

    @GetMapping("/{id}")
    public ResponseEntity<WineTypeResponseDto> get(@PathVariable Long id) {
        return ResponseEntity.ok(wineTypeMapper.toDto(wineTypeService.getById(id)));
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") Long id) {
        wineTypeService.deleteById(id);
        return ResponseEntity.ok("Success, deleted entity by id " + id);
    }
}
