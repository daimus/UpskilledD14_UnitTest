package id.daimus.unittest.application.product.usecase;

import id.daimus.unittest.shared.exception.DataNotFoundException;

public interface DeleteProductUseCase {
    boolean deleteProduct(Long id) throws DataNotFoundException;
}
