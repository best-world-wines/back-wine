package api.backwine.service.impl;

import api.backwine.model.Cart;
import api.backwine.repository.CartRepository;
import api.backwine.service.CartService;
import java.util.List;
import jakarta.persistence.EntityNotFoundException;
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
}
