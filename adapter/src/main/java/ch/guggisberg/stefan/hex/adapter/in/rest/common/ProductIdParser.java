package ch.guggisberg.stefan.hex.adapter.in.rest.common;

import ch.guggisberg.stefan.hex.model.product.ProductId;

public final class ProductIdParser {
    public static ProductId parseProductId(String productId) {
        return new ProductId(productId);
    }
}
