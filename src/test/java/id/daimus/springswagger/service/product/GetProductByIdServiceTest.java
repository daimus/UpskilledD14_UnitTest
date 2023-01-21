package id.daimus.springswagger.service.product;

import id.daimus.springswagger.application.product.entity.Product;
import id.daimus.springswagger.application.product.repository.ProductRepository;
import id.daimus.springswagger.application.product.service.GetProductByIdService;
import id.daimus.springswagger.shared.exception.DataNotFoundException;
import org.jeasy.random.EasyRandom;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.mockito.BDDMockito.given;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class GetProductByIdServiceTest {
    @Mock
    ProductRepository productRepository;
    @InjectMocks
    GetProductByIdService getProductByIdService;
    @Test
    void getProductById_WhenProductExist_ShouldReturnProduct() throws DataNotFoundException {
        EasyRandom easyRandom = new EasyRandom();
        // Given
        Product expectedProduct = easyRandom.nextObject(Product.class);
        given(productRepository.getProductById(expectedProduct.getId())).willReturn(Optional.of(expectedProduct));
        // When
        Product actualProduct = getProductByIdService.getProductById(expectedProduct.getId());
        // Then
        assertEquals(actualProduct, expectedProduct);
    }
    @Test
    void getProductById_WhenProductNotExist_ShouldThrowDataNotFoundException(){
        EasyRandom easyRandom = new EasyRandom();
        // Given
        Long productId = (long) easyRandom.nextInt(100);
        // When
        Exception exception = assertThrows(DataNotFoundException.class, () -> {
            getProductByIdService.getProductById(productId);
        });
        // Then
        assertEquals(exception.getClass(), DataNotFoundException.class);
    }
}
