package api.backwine.service.impl;

import api.backwine.model.Cart;
import api.backwine.model.Item;
import api.backwine.model.User;
import api.backwine.repository.CartRepository;
import api.backwine.service.CartService;
import java.math.BigDecimal;
import org.springframework.stereotype.Service;

@Service
public class CartServiceImpl extends GenericServiceImpl<Cart, Long> implements CartService {
    private final CartRepository cartRepository;

    public CartServiceImpl(CartRepository cartRepository) {
        super(Cart.class, cartRepository);
        this.cartRepository = cartRepository;
    }

    @Override
    protected Cart putId(Long id, Cart cart) {
        cart.setId(id);
        return cart;
    }

    @Override
    public Cart getByUser(User user) {
        return cartRepository.findByUser(user);
    }

//    @Override
//    public Cart addItemToCart(UserDetailed user, Item item) {
//        Cart cart = getByUser(user);
//        Optional<Item> optionalItem = cart.getItems()
//                .stream()
//                .filter(i -> i.getWine().getId().equals(item.getWine().getId()))
//                .findAny();
//        if (optionalItem.isEmpty()) {
//            cart.getItems().add(item);
//        } else {
//            cart.getItems().set(cart.getItems().indexOf(optionalItem.get()), item);
//        }
//        cartRepository.save(cart);
//        return cart;
//    }

    @Override
    public BigDecimal getTotalPrice(Cart cart) {
        BigDecimal totalPrice = BigDecimal.ZERO;
        for (Item i : cart.getItems()) {
            totalPrice =
                    totalPrice.add(
                            i.getWine().getPrice().multiply(BigDecimal.valueOf(i.getQuantity())));
        }
        return totalPrice;
    }
}
