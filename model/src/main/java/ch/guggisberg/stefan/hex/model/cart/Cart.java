package ch.guggisberg.stefan.hex.model.cart;

import ch.guggisberg.stefan.hex.model.customer.CustomerId;
import ch.guggisberg.stefan.hex.model.money.Money;
import ch.guggisberg.stefan.hex.model.product.Product;
import ch.guggisberg.stefan.hex.model.product.ProductId;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.experimental.Accessors;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Accessors(fluent = true)
@RequiredArgsConstructor
public class Cart {

    @Getter
    private final CustomerId id;

    private final Map<ProductId, CartLineItem> lineItems = new LinkedHashMap<>();

    public void addProduct(Product product, int quantity)
            throws NotEnoughItemsInStockException {
        lineItems
                .computeIfAbsent(product.id(), ignored -> new CartLineItem(product))
                .increaseQuantityBy(quantity, product.itemsInStock());
    }
    public List<CartLineItem> lineItems() {
        return List.copyOf(lineItems.values());
    }

    public int numberOfItems() {
        return lineItems.values().stream().mapToInt(CartLineItem::quantity).sum();
    }

    public Money subTotal() {
        return lineItems.values().stream()
                .map(CartLineItem::subTotal)
                .reduce(Money::add)
                .orElse(null);
    }
}
