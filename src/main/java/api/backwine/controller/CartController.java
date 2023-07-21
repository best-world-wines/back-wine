package api.backwine.controller;

import api.backwine.dto.mapper.CartMapper;
import api.backwine.dto.mapper.OrderMapper;
import api.backwine.dto.request.CartRequestDto;
import api.backwine.dto.response.CartResponseDto;
import api.backwine.model.Cart;
import api.backwine.model.User;
import api.backwine.service.CartService;
import api.backwine.service.OrderService;
import api.backwine.service.UserDetailedService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/carts")
@Tag(name = "The Cart API", description = "Operations related to shopping carts")
public class CartController {
    private final CartMapper cartMapper;
    private final OrderMapper orderMapper;
    private final UserDetailedService userDetailedService;
    private final CartService cartService;
    private final OrderService orderService;

    public CartController(CartMapper cartMapper, OrderMapper orderMapper, UserDetailedService userDetailedService,
                          CartService cartService, OrderService orderService) {
        this.cartMapper = cartMapper;
        this.orderMapper = orderMapper;
        this.userDetailedService = userDetailedService;
        this.cartService = cartService;
        this.orderService = orderService;
    }

    // TODO figure out required annotations and how to specify passing parameters in entry points
    //  (for pages)
    @GetMapping
    @Operation(summary = "Gets cart", tags = "cart")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Found the cart",
                    content = {
                            @Content(
                                    mediaType = "application/json",
                                    array = @ArraySchema(schema = @Schema(implementation =
                                            CartResponseDto.class)))
                    })
    })
    public ResponseEntity<CartResponseDto> getCart(Authentication auth) {
        String email = auth.getName();
        User user = userDetailedService.getByEmail(email).orElseThrow(() ->
                new EntityNotFoundException("Can't get user by email " + email));
        return ResponseEntity.ok(cartMapper.toDto(cartService.getByUser(user)));
    }

    @PutMapping
    public ResponseEntity<CartResponseDto> updateCart(@RequestBody CartRequestDto cartDto,
                                                      Authentication auth) {
        String email = auth.getName();
        User user = userDetailedService.getByEmail(email).orElseThrow(() ->
                new EntityNotFoundException("Can't get user by email " + email));
        Cart cart = cartMapper.toModel(cartDto);
        cart.setTotalPrice(cartService.getTotalPrice(cart));
        cartService.update(user.getId(), cart);
        return ResponseEntity.ok(cartMapper.toDto(cart));
    }

    @GetMapping("/clear")
    public ResponseEntity<CartResponseDto> clearCart(Authentication auth) {
        String email = auth.getName();
        User user = userDetailedService.getByEmail(email).orElseThrow(() ->
                new EntityNotFoundException("Can't get user by email " + email));
        Cart cart = cartService.getByUser(user);
        cart.getItems().clear();
        return ResponseEntity.ok(cartMapper.toDto(cartService.update(cart.getId(), cart)));
    }
}
