package ch.guggisberg.stefan.hex.adapter.out.rest;

import ch.guggisberg.stefan.hex.model.cart.Cart;
import ch.guggisberg.stefan.hex.model.customer.CustomerId;
import ch.guggisberg.stefan.hex.spring.application.port.out.peristence.CartRepository;

import java.util.Optional;

public class InMemoryCartRepository implements CartRepository {
    @Override
    public void save(Cart cart) {

    }

    @Override
    public Optional<Cart> findByCustomerId(CustomerId customerId) {
        return Optional.empty();
    }

    @Override
    public void deleteById(CustomerId customerId) {

    }
}
