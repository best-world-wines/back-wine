package api.backwine.service.impl;

import api.backwine.model.Cart;
import api.backwine.model.Item;
import api.backwine.model.User;
import api.backwine.repository.CartRepository;
import api.backwine.service.CartService;
import jakarta.persistence.EntityNotFoundException;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class CartServiceImpl implements CartService {
    private final CartRepository cartRepository;

    public CartServiceImpl(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }

    @Override
    public Cart create(Cart cart) {
        return cartRepository.save(cart);
    }

    @Override
    public Cart getById(Long id) {
        return cartRepository.findById(id).orElseThrow(() ->
                new EntityNotFoundException("Can't get cart by id " + id));
    }

    @Override
    public List<Cart> getAll() {
        return cartRepository.findAll();
    }

    @Override
    public boolean deleteById(Long id) {
        cartRepository.deleteById(id);
        return true;
    }

    @Override
    public Cart update(Long id, Cart cart) {
        cart.setId(id);
        return cartRepository.save(cart);
    }

    @Override
    public Cart getByUser(User user) {
        return cartRepository.findByUser(user);
    }

    @Override
    public Cart addItemToCart(User user, Item item) {
        Cart cart = getByUser(user);
        Optional<Item> optionalItem = cart.getItems()
                .stream()
                .filter(i -> i.getWine().getId().equals(item.getWine().getId()))
                .findAny();
        if (optionalItem.isEmpty()) {

            cart.getItems().add(item);
        } else {
            cart.getItems().set(cart.getItems().indexOf(optionalItem.get()), item);
        }
        cartRepository.save(cart);
        return cart;
    }

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
