package ch.guggisberg.stefan.hex.adapter.in.rest.cart;

import ch.guggisberg.stefan.hex.model.cart.CartLineItem;
import ch.guggisberg.stefan.hex.model.money.Money;
import ch.guggisberg.stefan.hex.model.product.Product;

public record CartLineItemWebModel(
        String productId, String productName, Money price, int quantity) {

    public static CartLineItemWebModel fromDomainModel(CartLineItem lineItem) {
        Product product = lineItem.product();
        return new CartLineItemWebModel(
                product.id().value(), product.name(), product.price(), lineItem.quantity());
    }
}
