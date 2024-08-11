package ch.guggisberg.stefan.hex.spring.application.service.cart;

import ch.guggisberg.stefan.hex.model.customer.CustomerId;
import ch.guggisberg.stefan.hex.spring.application.port.in.cart.EmptyCartUseCase;
import ch.guggisberg.stefan.hex.spring.application.port.out.peristence.CartRepository;
import java.util.Objects;

public class EmptyCartService implements EmptyCartUseCase {

    private final CartRepository cartRepository;

    public EmptyCartService(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }

    @Override
    public void emptyCart(CustomerId customerId) {
        Objects.requireNonNull(customerId, "'customerId' must not be null");

        cartRepository.deleteById(customerId);
    }
}
