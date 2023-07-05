package api.backwine.controller;

import api.backwine.dto.mapper.RegionMapper;
import api.backwine.dto.request.RegionRequestDto;
import api.backwine.dto.response.RegionResponseDto;
import api.backwine.model.Region;
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
@RequestMapping("/regions")
public class RegionController {
    private final AbstractService<Region> service;
    private final RegionMapper regionMapper;

    public RegionController(AbstractService<Region> service, RegionMapper regionMapper) {
        this.service = service;
        this.regionMapper = regionMapper;
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping()
    public ResponseEntity<RegionResponseDto> create(@Valid @RequestBody RegionRequestDto regionRequestDto) {
        return new ResponseEntity<>(regionMapper.toDto(
                service.create(regionMapper.toModel(regionRequestDto))), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<RegionResponseDto>> getAll() {
        return ResponseEntity.ok(service.getAll()
                .stream()
                .map(regionMapper::toDto)
                .collect(Collectors.toList()));
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/{id}")
    public ResponseEntity<RegionResponseDto> update(@PathVariable("id") Long id,
                                                    @Valid @RequestBody RegionRequestDto regionRequestDto) {
        return ResponseEntity.ok(regionMapper.toDto(
                service.update(id, regionMapper.toModel(regionRequestDto))));
    }

    @GetMapping("/{id}")
    public ResponseEntity<RegionResponseDto> get(@PathVariable Long id) {
        return ResponseEntity.ok(regionMapper.toDto(service.getById(id)));
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") Long id) {
        service.deleteById(id);
        return ResponseEntity.ok("Success, deleted entity by id " + id);
    }
}
