package id.daimus.springswagger.application.product.service;

import id.daimus.springswagger.application.product.entity.Product;
import id.daimus.springswagger.application.product.repository.ProductRepository;
import id.daimus.springswagger.application.product.usecase.CreateProductUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateProductService implements CreateProductUseCase {
    private final ProductRepository productRepository;
    @Override
    public Product createProduct(Product product) {
        return productRepository.createProduct(product);
    }
}
