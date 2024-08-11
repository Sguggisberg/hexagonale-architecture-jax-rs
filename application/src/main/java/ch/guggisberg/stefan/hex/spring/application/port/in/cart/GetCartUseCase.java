package ch.guggisberg.stefan.hex.spring.application.port.in.cart;

import ch.guggisberg.stefan.hex.model.cart.Cart;
import ch.guggisberg.stefan.hex.model.customer.CustomerId;

public interface GetCartUseCase {
    Cart getCart(CustomerId customerId);
}
