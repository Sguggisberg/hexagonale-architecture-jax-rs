package ch.guggisberg.stefan.hex.spring.application.port.out;

import ch.guggisberg.stefan.hex.model.product.Product;
import ch.guggisberg.stefan.hex.model.product.ProductId;

import java.util.List;
import java.util.Optional;

public interface ProductRepository {

    List<Product> findByNameOrDescription(String query);

    Optional<Product> findById(ProductId productId);

}
