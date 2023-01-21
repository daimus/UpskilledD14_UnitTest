package id.daimus.unittest.application.product.service;

import id.daimus.unittest.application.product.entity.Product;
import id.daimus.unittest.application.product.repository.ProductRepository;
import id.daimus.unittest.application.product.usecase.GetProductByIdUseCase;
import id.daimus.unittest.shared.exception.DataNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class GetProductByIdService implements GetProductByIdUseCase {
    private final ProductRepository productRepository;
    @Override
    public Product getProductById(Long id) throws DataNotFoundException {
        Optional<Product> product = productRepository.getProductById(id);
        if (product.isEmpty()){
            throw new DataNotFoundException(String.format("Data product with id %s not found", id));
        }
        return product.get();
    }
}
