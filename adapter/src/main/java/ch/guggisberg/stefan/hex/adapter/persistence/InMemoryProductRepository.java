package ch.guggisberg.stefan.hex.adapter.persistence;

import ch.guggisberg.stefan.hex.model.product.Product;
import ch.guggisberg.stefan.hex.model.product.ProductId;
import ch.guggisberg.stefan.hex.spring.application.port.out.peristence.ProductRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class InMemoryProductRepository implements ProductRepository {
    private final Map<ProductId, Product> products = new ConcurrentHashMap<>();

    public InMemoryProductRepository() {
        createDemoProducts();
    }

    @Override
    public void save(Product product) {
        products.put(product.id(), product);
    }

    @Override
    public Optional<Product> findById(ProductId productId) {
        return Optional.ofNullable(products.get(productId));
    }

    @Override
    public List<Product> findByNameOrDescription(String query) {
        String queryLowerCase = query.toLowerCase(Locale.ROOT);
        return products.values().stream()
                .filter(product -> matchesQuery(product, queryLowerCase))
                .toList();
    }

    private void createDemoProducts() {
        DemoProducts.DEMO_PRODUCTS.forEach(this::save);
    }

    private boolean matchesQuery(Product product, String query) {
        return product.name().toLowerCase(Locale.ROOT).contains(query)
                || product.description().toLowerCase(Locale.ROOT).contains(query);
    }

}
