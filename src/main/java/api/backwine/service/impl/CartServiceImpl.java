package api.backwine.service.impl;

import api.backwine.model.Cart;
import api.backwine.model.Item;
import api.backwine.model.User;
import api.backwine.repository.CartRepository;
import api.backwine.service.CartService;
import api.backwine.service.ItemService;
import jakarta.transaction.Transactional;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;
import org.hibernate.Hibernate;
import org.springframework.stereotype.Service;

@Service
public class CartServiceImpl extends GenericServiceImpl<Cart, Long> implements CartService {
    private final CartRepository cartRepository;
    private final ItemService itemService;

    public CartServiceImpl(CartRepository cartRepository, ItemService itemService) {
        super(Cart.class, cartRepository);
        this.cartRepository = cartRepository;
        this.itemService = itemService;
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

    @Override
    public Cart create(Cart cart) {
        cart.setTotalPrice(getTotalPrice(cart));
        return super.create(cart);
    }

    @Override
    public BigDecimal getTotalPrice(Cart cart) {
        BigDecimal totalPrice = BigDecimal.ZERO;
        for (Item item : cart.getItems()) {
            totalPrice =
                    totalPrice.add(
                            item.getProduct().getPrice()
                                    .multiply(BigDecimal.valueOf(item.getQuantity())));
        }
        return totalPrice;
    }

    @Override
    public Cart update(Cart savedCart, Cart updatedCart) {
        List<Item> removedItems = mergeCarts(savedCart, updatedCart);
        Cart cart = cartRepository.save(savedCart);
        for (int i = 0; i < cart.getItems().size(); i++) {
            cart.getItems().get(i).setProduct(savedCart.getItems().get(i).getProduct());
        }
        if (!removedItems.isEmpty()) {
            itemService.deleteItems(removedItems);
        }
        return cart;
    }

    private List<Item> mergeCarts(Cart savedCart, Cart updatedCart) {
        savedCart.setTotalPrice(getTotalPrice(updatedCart));
        List<Item> removedItems = new ArrayList<>();
        Map<Long, Item> updatedItemsMap = updatedCart.getItems()
                .stream()
                .filter(i -> i.getId() != null)
                .collect(Collectors.toMap(Item::getId, item -> item));
        Iterator<Item> iterator = savedCart.getItems().iterator();
        while (iterator.hasNext()) {
            Item savedItem = iterator.next();
            Item updatedItem = updatedItemsMap.get(savedItem.getId());
            if (updatedItem != null) {
                savedItem.setQuantity(updatedItem.getQuantity());
                savedItem.setProduct(updatedItem.getProduct());
            } else {
                iterator.remove();
                removedItems.add(savedItem);
            }
        }
        addNewItems(savedCart.getItems(), updatedCart.getItems());
        return removedItems;
    }

    private void addNewItems(List<Item> savedItems, List<Item> newItems) {
        newItems
                .stream()
                .filter(i -> i.getId() == null)
                .forEach(savedItems::add);
    }
}
