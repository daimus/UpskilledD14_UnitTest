package id.daimus.springswagger.application.product.service;

import id.daimus.springswagger.application.product.entity.Product;
import id.daimus.springswagger.application.product.repository.ProductRepository;
import id.daimus.springswagger.application.product.usecase.GetProductByIdUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class GetProductByIdService implements GetProductByIdUseCase {
    private final ProductRepository productRepository;
    @Override
    public Optional<Product> getProductById(Long id) {
        return productRepository.getProductById(id);
    }
}
