package api.backwine.controller.product;

import api.backwine.dto.mapper.product.ProductPageMapper;
import api.backwine.dto.mapper.product.WineMapper;
import api.backwine.dto.request.product.WineRequestDto;
import api.backwine.dto.response.product.ProductPageResponse;
import api.backwine.dto.response.product.WineResponseDto;
import api.backwine.model.product.Wine;
import api.backwine.service.product.WineService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import java.util.List;
import java.util.Map;
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
@RequestMapping(path = "/api/v1/wines", produces = "application/json")
@Tag(name = "The Wine API", description = "Operations related to wines")
public class WineController {
    private final WineService wineService;
    private final WineMapper wineMapper;
    private final ProductPageMapper<Wine, WineResponseDto> winePageMapper;

    public WineController(WineService wineService, WineMapper wineMapper,
                          ProductPageMapper<Wine, WineResponseDto> winePageMapper) {
        this.wineService = wineService;
        this.wineMapper = wineMapper;
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

    @Operation(summary = "Get a page of wines",
            description = "This operation gets a page of wines.",
            parameters = {
                    @Parameter(in = ParameterIn.QUERY, name = "page",
                            description = "The page number, default is 0"),
                    @Parameter(in = ParameterIn.QUERY, name = "size",
                            description = "The size of the page, default value is 20"),
                    @Parameter(in = ParameterIn.QUERY, name = "sort",
                            description = "The sort criteria, "
                                    + "default sort by id and default order is ASC, "
                                    + "may be specified by order DESC or ASC. "
                                    + "Example: name:desc,price:asc,year"),
                    @Parameter(in = ParameterIn.QUERY, name = "priceIn",
                            description = "Filter by price range. Example: 10,100"),
                    @Parameter(in = ParameterIn.QUERY, name = "mealIn",
                            description = "Filter by meal ids. Example: Meal id1,..."),
                    @Parameter(in = ParameterIn.QUERY, name = "regionIn",
                            description = "Filter by region ids. Example: Region id1,id2,..."),
                    @Parameter(in = ParameterIn.QUERY, name = "styleIn",
                            description = "Filter by wine style ids. "
                                    + "Example: Regional id1,id2,..."),
                    @Parameter(in = ParameterIn.QUERY, name = "typeIn",
                            description = "Filter by wine type ids. Example: Type id1,id2,..."),
                    @Parameter(in = ParameterIn.QUERY, name = "wineryIn",
                            description = "Filter by winery ids. Example: Winery id1,id2,..."),
                    @Parameter(in = ParameterIn.QUERY, name = "grapeIn",
                            description = "Filter by grape ids. Example: Grape id1,id2,..."),
                    @Parameter(in = ParameterIn.QUERY, name = "countryIn",
                            description = "Filter by country ids. Example: Country id1,id2,..."),
                    @Parameter(in = ParameterIn.QUERY, name = "volumeIn",
                            description = "Filter by bottle volumes. Example: 1.0,..."),
                    @Parameter(in = ParameterIn.QUERY, name = "yearIn",
                            description = "Filter by wine years. Example: 1992,...")
            })
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Found the wines",
                    content = {
                            @Content(
                                    array = @ArraySchema(schema = @Schema(implementation =
                                            WineResponseDto.class)))
                    })
    })
    @GetMapping("/pages")
    public ResponseEntity<ProductPageResponse<WineResponseDto>> getWinePage(
            @Parameter(hidden = true) @RequestParam Map<String, String> params) {
        return ResponseEntity.ok(winePageMapper.toDto(wineService.getAll(params), wineMapper));
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
        Wine byId = wineService.getById(id);
        WineResponseDto dto = wineMapper.toDto(byId);
        return ResponseEntity.ok(dto);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") Long id) {
        wineService.deleteById(id);
        return ResponseEntity.ok("Success, deleted entity by id " + id);
    }
}
