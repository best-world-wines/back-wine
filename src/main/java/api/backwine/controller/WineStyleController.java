package api.backwine.controller;

import api.backwine.dto.mapper.WineStyleMapper;
import api.backwine.dto.request.WineStyleRequestDto;
import api.backwine.dto.response.WineStyleResponseDto;
import api.backwine.model.WineStyle;
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
@RequestMapping("/wine_styles")
public class WineStyleController {
    private final AbstractService<WineStyle> service;
    private final WineStyleMapper wineStyleMapper;

    public WineStyleController(AbstractService<WineStyle> service,
                               WineStyleMapper wineStyleMapper) {
        this.service = service;
        this.wineStyleMapper = wineStyleMapper;
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping()
    public ResponseEntity<WineStyleResponseDto> create(@Valid @RequestBody
                                                       WineStyleRequestDto wineStyleRequestDto) {
        return new ResponseEntity<>(wineStyleMapper.toDto(
                service.create(wineStyleMapper.toModel(wineStyleRequestDto))), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<WineStyleResponseDto>> getAll() {
        return ResponseEntity.ok(service.getAll()
                .stream()
                .map(wineStyleMapper::toDto)
                .collect(Collectors.toList()));
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/{id}")
    public ResponseEntity<WineStyleResponseDto> update(@PathVariable("id") Long id,
                                                       @Valid @RequestBody
                                                       WineStyleRequestDto wineStyleRequestDto) {
        return ResponseEntity.ok(wineStyleMapper.toDto(
                service.update(id, wineStyleMapper.toModel(wineStyleRequestDto))));
    }

    @GetMapping("/{id}")
    public ResponseEntity<WineStyleResponseDto> get(@PathVariable Long id) {
        return ResponseEntity.ok(wineStyleMapper.toDto(service.getById(id)));
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") Long id) {
        service.deleteById(id);
        return ResponseEntity.ok("Success, deleted entity by id " + id);
    }
}
