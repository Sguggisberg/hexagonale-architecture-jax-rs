package ch.guggisberg.stefan.hex.adapter.persistence;

import ch.guggisberg.stefan.hex.model.cart.Cart;
import ch.guggisberg.stefan.hex.model.customer.CustomerId;
import ch.guggisberg.stefan.hex.spring.application.port.out.peristence.CartRepository;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class InMemoryCartRepository implements CartRepository {
    private final Map<CustomerId, Cart> carts = new ConcurrentHashMap<>();


    @Override
    public void save(Cart cart) {
        carts.put(cart.id(), cart);
    }

    @Override
    public Optional<Cart> findByCustomerId(CustomerId customerId) {
        return Optional.ofNullable(carts.get(customerId));
    }

    @Override
    public void deleteById(CustomerId customerId) {
        carts.remove(customerId);
    }
}
