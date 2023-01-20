package id.daimus.springswagger.application.product.usecase;

import id.daimus.springswagger.application.product.entity.Product;
import id.daimus.springswagger.shared.exception.DataNotFoundException;

import java.util.Optional;

public interface GetProductByIdUseCase {
    Product getProductById(Long id) throws DataNotFoundException;
}
