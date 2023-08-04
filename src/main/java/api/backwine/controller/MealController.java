package api.backwine.controller;

import api.backwine.dto.mapper.MealMapper;
import api.backwine.dto.request.MealRequestDto;
import api.backwine.dto.response.MealResponseDto;
import api.backwine.service.MealService;
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
@RequestMapping(path = "/api/v1/meals", produces = "application/json")
public class MealController {
    private final MealService mealService;
    private final MealMapper mealMapper;

    public MealController(MealService mealService, MealMapper mealMapper) {
        this.mealService = mealService;
        this.mealMapper = mealMapper;
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping()
    public ResponseEntity<MealResponseDto> create(@Valid @RequestBody
                                                  MealRequestDto mealRequestDto) {
        return new ResponseEntity<>(mealMapper.toDto(
                mealService.create(mealMapper.toModel(mealRequestDto))), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<MealResponseDto>> getAll() {
        return ResponseEntity.ok(mealService.getAll()
                .stream()
                .map(mealMapper::toDto)
                .collect(Collectors.toList()));
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/{id}")
    public ResponseEntity<MealResponseDto> update(@PathVariable("id") Long id,
                                                  @Valid @RequestBody
                                                  MealRequestDto mealRequestDto) {
        return ResponseEntity.ok(mealMapper.toDto(
                mealService.update(id, mealMapper.toModel(mealRequestDto))));
    }

    @GetMapping("/{id}")
    public ResponseEntity<MealResponseDto> get(@PathVariable Long id) {
        return ResponseEntity.ok(mealMapper.toDto(mealService.getById(id)));
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") Long id) {
        mealService.deleteById(id);
        return ResponseEntity.ok("Success, deleted entity by id " + id);
    }
}
