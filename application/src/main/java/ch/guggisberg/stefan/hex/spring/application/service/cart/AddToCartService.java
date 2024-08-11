package ch.guggisberg.stefan.hex.spring.application.service.cart;

import ch.guggisberg.stefan.hex.model.cart.Cart;
import ch.guggisberg.stefan.hex.model.cart.NotEnoughItemsInStockException;
import ch.guggisberg.stefan.hex.model.customer.CustomerId;
import ch.guggisberg.stefan.hex.model.product.Product;
import ch.guggisberg.stefan.hex.model.product.ProductId;
import ch.guggisberg.stefan.hex.spring.application.port.in.cart.AddToCartUseCase;
import ch.guggisberg.stefan.hex.spring.application.port.in.cart.ProductNotFoundException;
import ch.guggisberg.stefan.hex.spring.application.port.out.CartRepository;
import ch.guggisberg.stefan.hex.spring.application.port.out.peristence.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@RequiredArgsConstructor
public class AddToCartService implements AddToCartUseCase {

    private final CartRepository cartRepository;
    private final ProductRepository productRepository;

    @Override
    public Cart addToCart(CustomerId customerId, ProductId productId, int quantity)
            throws ProductNotFoundException, NotEnoughItemsInStockException {
        Objects.requireNonNull(customerId, "'customerId' must not be null");
        Objects.requireNonNull(productId, "'productId' must not be null");
        if (quantity < 1) {
            throw new IllegalArgumentException("'quantity' must be greater than 0");
        }

        Product product =
                productRepository.findById(productId).orElseThrow(ProductNotFoundException::new);

        Cart cart =
                cartRepository
                        .findByCustomerId(customerId)
                        .orElseGet(() -> new Cart(customerId));

        cart.addProduct(product, quantity);

        cartRepository.save(cart);

        return cart;
    }
}
