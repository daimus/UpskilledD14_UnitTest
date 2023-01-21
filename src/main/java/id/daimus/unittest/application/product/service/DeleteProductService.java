package id.daimus.unittest.application.product.service;

import id.daimus.unittest.application.product.entity.Product;
import id.daimus.unittest.application.product.repository.ProductRepository;
import id.daimus.unittest.application.product.usecase.DeleteProductUseCase;
import id.daimus.unittest.shared.exception.DataNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DeleteProductService implements DeleteProductUseCase {
    private final ProductRepository productRepository;
    @Override
    public boolean deleteProduct(Long id) throws DataNotFoundException {
        Optional<Product> product = productRepository.getProductById(id);
        if (product.isEmpty()){
            throw new DataNotFoundException(String.format("No product with id %s", id));
        }
        productRepository.deleteProduct(id);
        return true;
    }
}
