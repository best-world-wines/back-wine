package api.backwine.controller.product;

import api.backwine.dto.mapper.product.GrapeMapper;
import api.backwine.dto.request.product.GrapeRequestDto;
import api.backwine.dto.response.product.GrapeResponseDto;
import api.backwine.service.product.GrapeService;
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
@RequestMapping(path = "/api/v1/grapes", produces = "application/json")
public class GrapeController {
    private final GrapeService grapeService;
    private final GrapeMapper grapeMapper;

    public GrapeController(GrapeService grapeService, GrapeMapper grapeMapper) {
        this.grapeService = grapeService;
        this.grapeMapper = grapeMapper;
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping()
    public ResponseEntity<GrapeResponseDto> create(@Valid @RequestBody
                                                   GrapeRequestDto grapeRequestDto) {
        return new ResponseEntity<>(grapeMapper.toDto(
                grapeService.create(grapeMapper.toModel(grapeRequestDto))), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<GrapeResponseDto>> getAll() {
        return ResponseEntity.ok(grapeService.getAll()
                .stream()
                .map(grapeMapper::toDto)
                .collect(Collectors.toList()));
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/{id}")
    public ResponseEntity<GrapeResponseDto> update(@PathVariable("id") Long id,
                                                   @Valid @RequestBody
                                                   GrapeRequestDto grapeRequestDto) {
        return ResponseEntity.ok(grapeMapper.toDto(
                grapeService.update(id, grapeMapper.toModel(grapeRequestDto))));
    }

    @GetMapping("/{id}")
    public ResponseEntity<GrapeResponseDto> get(@PathVariable Long id) {
        return ResponseEntity.ok(grapeMapper.toDto(grapeService.getById(id)));
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") Long id) {
        grapeService.deleteById(id);
        return ResponseEntity.ok("Success, deleted entity by id " + id);
    }
}
