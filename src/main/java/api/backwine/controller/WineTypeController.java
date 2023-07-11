package api.backwine.controller;

import api.backwine.dto.mapper.WineTypeMapper;
import api.backwine.dto.request.WineTypeRequestDto;
import api.backwine.dto.response.WineTypeResponseDto;
import api.backwine.model.WineType;
import api.backwine.service.AbstractService;
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
@RequestMapping("/wine_types")
public class WineTypeController {
    private final AbstractService<WineType> service;
    private final WineTypeMapper wineTypeMapper;

    public WineTypeController(AbstractService<WineType> service, WineTypeMapper wineTypeMapper) {
        this.service = service;
        this.wineTypeMapper = wineTypeMapper;
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping()
    public ResponseEntity<WineTypeResponseDto> create(@Valid @RequestBody
                                                      WineTypeRequestDto wineTypeRequestDto) {
        return new ResponseEntity<>(wineTypeMapper.toDto(
                service.create(wineTypeMapper.toModel(wineTypeRequestDto))), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<WineTypeResponseDto>> getAll() {
        return ResponseEntity.ok(service.getAll()
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
                service.update(id, wineTypeMapper.toModel(wineTypeRequestDto))));
    }

    @GetMapping("/{id}")
    public ResponseEntity<WineTypeResponseDto> get(@PathVariable Long id) {
        return ResponseEntity.ok(wineTypeMapper.toDto(service.getById(id)));
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") Long id) {
        service.deleteById(id);
        return ResponseEntity.ok("Success, deleted entity by id " + id);
    }
}
