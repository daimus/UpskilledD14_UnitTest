package id.daimus.springswagger.application.product.service;

import id.daimus.springswagger.application.product.entity.Product;
import id.daimus.springswagger.application.product.repository.ProductRepository;
import id.daimus.springswagger.application.product.usecase.GetAllProductUseCase;
import id.daimus.springswagger.shared.exception.DataNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GetAllProductService implements GetAllProductUseCase {
    private final ProductRepository productRepository;
    @Override
    public List<Product> getAllProduct() throws DataNotFoundException {
        List<Product> products = productRepository.getAllProducts();
        if (products.size() == 0){
            throw new DataNotFoundException("Data product not found");
        }
        return products;
    }
}
