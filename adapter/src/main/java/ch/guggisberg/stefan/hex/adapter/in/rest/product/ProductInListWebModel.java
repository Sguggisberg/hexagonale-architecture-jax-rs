package ch.guggisberg.stefan.hex.adapter.in.rest.product;

import ch.guggisberg.stefan.hex.model.money.Money;
import ch.guggisberg.stefan.hex.model.product.Product;

public record ProductInListWebModel(
        String id, String name, Money price, int itemsInStock) {

    public static ProductInListWebModel fromDomainModel(Product product) {
        return new ProductInListWebModel(
                product.id().value(), product.name(), product.price(), product.itemsInStock());
    }
}
