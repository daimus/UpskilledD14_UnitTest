package id.daimus.springswagger.application.product.usecase;

import id.daimus.springswagger.application.product.entity.Product;

public interface UpdateProductUseCase {
    Product updateProduct(Long id, Product product);
}
