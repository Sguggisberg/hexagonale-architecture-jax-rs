package ch.guggisberg.stefan.hex.spring.application.port.in.product;

import ch.guggisberg.stefan.hex.model.product.Product;
import ch.guggisberg.stefan.hex.model.product.ProductId;

import java.util.List;

public interface FindProductsUseCase {
    List<Product> findByNameOrDescription(String query);
    Product findById(ProductId id);
}
