package api.backwine.controller;

import api.backwine.dto.mapper.WineMapper;
import api.backwine.dto.request.WineRequestDto;
import api.backwine.dto.response.WineResponseDto;
import api.backwine.model.Wine;
import api.backwine.service.AbstractService;
import java.util.List;
import java.util.stream.Collectors;
import javax.validation.Valid;
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
@RequestMapping("/wines")
public class WineController {
    private final AbstractService<Wine> service;
    private final WineMapper wineMapper;

    public WineController(AbstractService<Wine> service, WineMapper wineryMapper) {
        this.service = service;
        this.wineMapper = wineryMapper;
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping()
    public ResponseEntity<WineResponseDto> create(@Valid @RequestBody WineRequestDto wineRequestDto) {
        return new ResponseEntity<>(wineMapper.toDto(
                service.create(wineMapper.toModel(wineRequestDto))), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<WineResponseDto>> getAll() {
        return ResponseEntity.ok(service.getAll()
                .stream()
                .map(wineMapper::toDto)
                .collect(Collectors.toList()));
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/{id}")
    public ResponseEntity<WineResponseDto> update(@PathVariable("id") Long id,
                                                  @Valid @RequestBody WineRequestDto wineRequestDto) {
        return ResponseEntity.ok(wineMapper.toDto(
                service.update(id, wineMapper.toModel(wineRequestDto))));
    }

    @GetMapping("/{id}")
    public ResponseEntity<WineResponseDto> get(@PathVariable Long id) {
        return ResponseEntity.ok(wineMapper.toDto(service.getById(id)));
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") Long id) {
        service.deleteById(id);
        return ResponseEntity.ok("Success, deleted entity by id " + id);
    }
}
