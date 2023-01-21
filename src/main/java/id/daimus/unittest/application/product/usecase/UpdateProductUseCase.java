package id.daimus.unittest.application.product.usecase;

import id.daimus.unittest.application.product.entity.Product;
import id.daimus.unittest.shared.exception.DataNotFoundException;

public interface UpdateProductUseCase {
    Product updateProduct(Long id, Product product) throws DataNotFoundException;
}
