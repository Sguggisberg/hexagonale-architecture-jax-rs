package ch.guggisberg.stefan.hex.spring.application.port.in.cart;

import ch.guggisberg.stefan.hex.model.customer.CustomerId;

public interface EmptyCartUseCase {
    void emptyCart(CustomerId customerId);
}
