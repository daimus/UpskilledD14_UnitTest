package id.daimus.unittest.application.product.usecase;

import id.daimus.unittest.application.product.entity.Product;
import id.daimus.unittest.shared.exception.DataNotFoundException;

import java.util.List;

public interface GetAllProductUseCase {
    List<Product> getAllProduct() throws DataNotFoundException;
}
