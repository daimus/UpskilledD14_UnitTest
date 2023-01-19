package id.daimus.springswagger.application.product.usecase;

import id.daimus.springswagger.application.product.entity.Product;

import java.util.Optional;

public interface GetProductByIdUseCase {
    Optional<Product> getProductById(Long id);
}
