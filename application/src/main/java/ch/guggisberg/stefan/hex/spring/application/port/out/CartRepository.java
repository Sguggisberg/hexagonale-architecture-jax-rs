package ch.guggisberg.stefan.hex.spring.application.port.out;

import ch.guggisberg.stefan.hex.model.cart.Cart;
import ch.guggisberg.stefan.hex.model.customer.CustomerId;

import java.util.Optional;

public interface CartRepository {

    void save(Cart cart);

    Optional<Cart> findByCustomerId(CustomerId customerId);
}
