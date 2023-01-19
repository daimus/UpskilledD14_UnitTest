package id.daimus.springswagger.application.product.service;

import id.daimus.springswagger.application.product.entity.Product;
import id.daimus.springswagger.application.product.repository.ProductRepository;
import id.daimus.springswagger.application.product.usecase.GetAllProductUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GetAllProductService implements GetAllProductUseCase {
    private final ProductRepository productRepository;
    @Override
    public List<Product> getAllProduct() {
        return productRepository.getAllProducts();
    }
}
