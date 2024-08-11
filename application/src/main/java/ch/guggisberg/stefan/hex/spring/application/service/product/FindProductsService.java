package ch.guggisberg.stefan.hex.spring.application.service;

import ch.guggisberg.stefan.hex.spring.application.port.in.product.FindProductsUseCase;
import ch.guggisberg.stefan.hex.spring.application.port.out.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FindProductsService implements FindProductsUseCase {

    private final ProductRepository productRepository;

    @Override
    public List findByNameOrDescription(String query) {
        return List.of();
    }
}
