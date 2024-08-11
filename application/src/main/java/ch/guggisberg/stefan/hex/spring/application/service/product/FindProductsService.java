package ch.guggisberg.stefan.hex.spring.application.service.product;

import ch.guggisberg.stefan.hex.model.product.Product;
import ch.guggisberg.stefan.hex.model.product.ProductId;
import ch.guggisberg.stefan.hex.spring.application.port.in.product.FindProductsUseCase;
import ch.guggisberg.stefan.hex.spring.application.port.out.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class FindProductsService implements FindProductsUseCase {

    private final ProductRepository productRepository;

    @Override
    public List<Product> findByNameOrDescription(String query) {
        Objects.requireNonNull(query, "'query' must not be null");
        if (query.length() < 2) {
            throw new IllegalArgumentException("'query' must be at least two characters long");
        }
        return productRepository.findByNameOrDescription(query);
    }

    @Override
    public Product findById(ProductId id) {
        return productRepository.findById(id).orElse(null);
    }
}
