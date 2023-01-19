package id.daimus.springswagger.application.product.usecase;

import id.daimus.springswagger.application.product.entity.Product;

import java.util.List;

public interface GetAllProductUseCase {
    List<Product> getAllProduct();
}
