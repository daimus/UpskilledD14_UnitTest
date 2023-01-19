package id.daimus.springswagger.application.product.usecase;

import id.daimus.springswagger.application.product.entity.Product;

public interface CreateProductUseCase {
    Product createProduct(Product product);
}
