package id.daimus.springswagger.application.product.service;

import id.daimus.springswagger.application.product.entity.Product;
import id.daimus.springswagger.application.product.repository.ProductRepository;
import id.daimus.springswagger.application.product.usecase.UpdateProductUseCase;
import id.daimus.springswagger.shared.exception.DataNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UpdateProductService implements UpdateProductUseCase {
    private final ProductRepository productRepository;
    @Override
    public Product updateProduct(Long id, Product product) throws DataNotFoundException {
        Optional<Product> p = productRepository.getProductById(id);
        if (p.isEmpty()){
            throw new DataNotFoundException(String.format("Data product with id %s not found", id));
        }
        product.setId(id);
        return productRepository.updateProduct(product);
    }
}
