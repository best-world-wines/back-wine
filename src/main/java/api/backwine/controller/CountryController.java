package api.backwine.controller;

import api.backwine.dto.mapper.CountryMapper;
import api.backwine.dto.request.CountryRequestDto;
import api.backwine.dto.response.CountryResponseDto;
import api.backwine.service.CountryService;
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
@RequestMapping("/countries")
public class CountryController {
    private final CountryService service;
    private final CountryMapper countryMapper;

    public CountryController(CountryService service, CountryMapper countryMapper) {
        this.service = service;
        this.countryMapper = countryMapper;
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping()
    public ResponseEntity<CountryResponseDto> create(@Valid @RequestBody
                                                     CountryRequestDto countryRequestDto) {
        return new ResponseEntity<>(countryMapper.toDto(
                service.create(countryMapper.toModel(countryRequestDto))), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<CountryResponseDto>> getAll() {
        return ResponseEntity.ok(service.getAll()
                .stream()
                .map(countryMapper::toDto)
                .collect(Collectors.toList()));
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/{code}")
    public ResponseEntity<CountryResponseDto> update(@PathVariable("code") String code,
                                                     @Valid @RequestBody
                                                     CountryRequestDto countryRequestDto) {
        return ResponseEntity.ok(countryMapper.toDto(
                service.update(code, countryMapper.toModel(countryRequestDto))));
    }

    @GetMapping("/{code}")
    public ResponseEntity<CountryResponseDto> get(@PathVariable String code) {
        return ResponseEntity.ok(countryMapper.toDto(service.getByCode(code)));
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{code}")
    public ResponseEntity<String> delete(@PathVariable("code") String code) {
        service.deleteByCode(code);
        return ResponseEntity.ok("Success, deleted entity by code " + code);
    }
}
