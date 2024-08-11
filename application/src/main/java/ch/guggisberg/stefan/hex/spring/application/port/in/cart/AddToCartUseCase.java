package ch.guggisberg.stefan.hex.spring.application.port.in.cart;

import ch.guggisberg.stefan.hex.model.cart.Cart;
import ch.guggisberg.stefan.hex.model.cart.NotEnoughItemsInStockException;
import ch.guggisberg.stefan.hex.model.customer.CustomerId;
import ch.guggisberg.stefan.hex.model.product.ProductId;

public interface AddToCartUseCase {
    Cart addToCart(CustomerId customerId, ProductId productId, int quantity)
            throws ProductNotFoundException, NotEnoughItemsInStockException;
}
