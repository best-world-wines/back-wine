package api.backwine.controller;

import api.backwine.dto.mapper.CartMapper;
import api.backwine.dto.request.CartRequestDto;
import api.backwine.dto.response.CartResponseDto;
import api.backwine.model.Cart;
import api.backwine.model.User;
import api.backwine.service.CartService;
import api.backwine.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/v1/carts", produces = "application/json")
@Tag(name = "The Cart API", description = "Operations related to shopping carts")
public class CartController {
    private final CartMapper cartMapper;
    private final UserService userService;
    private final CartService cartService;

    public CartController(CartMapper cartMapper, UserService userService,
                          CartService cartService) {
        this.cartMapper = cartMapper;
        this.userService = userService;
        this.cartService = cartService;
    }

    @GetMapping
    @PreAuthorize("hasRole('USER')")
    @Operation(summary = "Get cart", tags = "cart")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Found the cart",
                    content = {
                            @Content(array =
                                    @ArraySchema(schema =
                                    @Schema(implementation = CartResponseDto.class)))
                    })
    })
    public ResponseEntity<CartResponseDto> getCart(Authentication auth) {
        User user = userService.getByEmail(auth.getName());
        return ResponseEntity.ok(cartMapper.toDto(cartService.getByUser(user)));
    }

    @PutMapping
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<CartResponseDto> updateCart(@RequestBody CartRequestDto cartDto,
                                                      Authentication auth) {
        User user = userService.getByEmail(auth.getName());
        Cart updatedCart = cartMapper.toModel(cartDto);
        return ResponseEntity.ok(cartMapper.toDto(cartService.update(user.getCart(), updatedCart)));
    }

    @GetMapping("/clear")
    public ResponseEntity<CartResponseDto> clearCart(Authentication auth) {
        User user = userService.getByEmail(auth.getName());
        Cart cart = cartService.getByUser(user);
        cart.getItems().clear();
        return ResponseEntity.ok(cartMapper.toDto(cartService.update(cart.getId(), cart)));
    }
}
