package ch.guggisberg.stefan.hex.spring.application.service.cart;

import ch.guggisberg.stefan.hex.model.cart.Cart;
import ch.guggisberg.stefan.hex.model.customer.CustomerId;
import ch.guggisberg.stefan.hex.spring.application.port.in.cart.GetCartUseCase;
import ch.guggisberg.stefan.hex.spring.application.port.out.CartRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@RequiredArgsConstructor
public class GetCartService implements GetCartUseCase {
    private final CartRepository cartRepository;

    @Override
    public Cart getCart(CustomerId customerId) {
        Objects.requireNonNull(customerId, "'customerId' must not be null");

        return cartRepository
                .findByCustomerId(customerId)
                .orElseGet(() -> new Cart(customerId));
    }
}
