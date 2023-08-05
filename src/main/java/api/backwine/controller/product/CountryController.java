package api.backwine.controller.product;

import api.backwine.dto.mapper.product.CountryMapper;
import api.backwine.dto.request.product.CountryRequestDto;
import api.backwine.dto.response.product.CountryResponseDto;
import api.backwine.service.product.CountryService;
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
@RequestMapping(path = "/api/v1/countries", produces = "application/json")
public class CountryController {
    private final CountryService countryService;
    private final CountryMapper countryMapper;

    public CountryController(CountryService countryService, CountryMapper countryMapper) {
        this.countryService = countryService;
        this.countryMapper = countryMapper;
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping()
    public ResponseEntity<CountryResponseDto> create(@Valid @RequestBody
                                                     CountryRequestDto countryRequestDto) {
        return new ResponseEntity<>(countryMapper.toDto(
                countryService
                        .create(countryMapper.toModel(countryRequestDto))), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<CountryResponseDto>> getAll() {
        return ResponseEntity.ok(countryService.getAll()
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
                countryService.update(code, countryMapper.toModel(countryRequestDto))));
    }

    @GetMapping("/{code}")
    public ResponseEntity<CountryResponseDto> get(@PathVariable String code) {
        return ResponseEntity.ok(countryMapper.toDto(countryService.getById(code)));
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{code}")
    public ResponseEntity<String> delete(@PathVariable("code") String code) {
        countryService.deleteById(code);
        return ResponseEntity.ok("Success, deleted entity by code " + code);
    }
}
