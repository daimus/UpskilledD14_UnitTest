package id.daimus.springswagger.application.product.usecase;

import id.daimus.springswagger.application.product.entity.Product;
import id.daimus.springswagger.shared.exception.DataNotFoundException;

import java.util.List;

public interface GetAllProductUseCase {
    List<Product> getAllProduct() throws DataNotFoundException;
}
