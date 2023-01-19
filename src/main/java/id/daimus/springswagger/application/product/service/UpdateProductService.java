package id.daimus.springswagger.application.product.service;

import id.daimus.springswagger.application.product.entity.Product;
import id.daimus.springswagger.application.product.repository.ProductRepository;
import id.daimus.springswagger.application.product.usecase.UpdateProductUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UpdateProductService implements UpdateProductUseCase {
    private final ProductRepository productRepository;
    @Override
    public Product updateProduct(Long id, Product product) {
        product.setId(id);
        return productRepository.updateProduct(product);
    }
}
