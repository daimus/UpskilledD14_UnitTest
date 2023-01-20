package id.daimus.springswagger.application.product.usecase;

import id.daimus.springswagger.shared.exception.DataNotFoundException;

public interface DeleteProductUseCase {
    void deleteProduct(Long id) throws DataNotFoundException;
}
