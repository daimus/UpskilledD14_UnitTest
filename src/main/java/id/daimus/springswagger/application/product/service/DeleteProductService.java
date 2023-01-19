package id.daimus.springswagger.application.product.service;

import id.daimus.springswagger.application.product.repository.ProductRepository;
import id.daimus.springswagger.application.product.usecase.DeleteProductUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DeleteProductService implements DeleteProductUseCase {
    private final ProductRepository productRepository;
    @Override
    public void deleteProduct(Long id) {
        productRepository.deleteProduct(id);
    }
}
