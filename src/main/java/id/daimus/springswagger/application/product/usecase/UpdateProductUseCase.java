package id.daimus.springswagger.application.product.usecase;

import id.daimus.springswagger.application.product.entity.Product;
import id.daimus.springswagger.shared.exception.DataNotFoundException;

public interface UpdateProductUseCase {
    Product updateProduct(Long id, Product product) throws DataNotFoundException;
}
