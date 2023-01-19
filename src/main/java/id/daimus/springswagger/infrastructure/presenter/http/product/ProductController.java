package id.daimus.springswagger.infrastructure.presenter.http.product;

import id.daimus.springswagger.application.product.entity.Product;
import id.daimus.springswagger.application.product.usecase.*;
import id.daimus.springswagger.infrastructure.presenter.http.Response;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springdoc.core.annotations.RouterOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {
    private final GetAllProductUseCase getAllProductUseCase;
    private final GetProductByIdUseCase getProductByIdUseCase;
    private final CreateProductUseCase createProductUseCase;
    private final UpdateProductUseCase updateProductUseCase;
    private final DeleteProductUseCase deleteProductUseCase;

    @Operation(summary = "Find all products")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation"),
            @ApiResponse(responseCode = "404", description = "Product not found")
    })
    @GetMapping
    public ResponseEntity<Object> getAllProduct() {
        log.info("GET /products called");
        Response response = new Response();
        try {
            List<Product> products = getAllProductUseCase.getAllProduct();
            response.setData(products);
        } catch (Exception e) {
            log.error("GET /products error: {}", e.getMessage());
            response.setErrors(e.getMessage());
        }
        return response.getResponse();
    }
    @Operation(summary = "Find product by id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation"),
            @ApiResponse(responseCode = "400", description = "Invalid Product Id supplied"),
            @ApiResponse(responseCode = "404", description = "Product not found")
    })
    @Parameters(value = {
            @Parameter(in = ParameterIn.PATH, name = "id", description = "Product Id")
    })
    @GetMapping("{id}")
    public ResponseEntity<Object> getProductById(@PathVariable Long id) {
        log.info("GET /products/{} called", id.toString());
        Response response = new Response();
        try {
            Optional<Product> product = getProductByIdUseCase.getProductById(id);
            response.setData(product);
        } catch (Exception e) {
            log.error("GET /products/{} error: {}", id.toString(), e.getMessage());
            response.setErrors(e.getMessage());
        }
        return response.getResponse();
    }

    @Operation(summary = "Create new product")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "successful operation"),
            @ApiResponse(responseCode = "400", description = "Invalid product supplied")
    })
    @PostMapping
    public ResponseEntity<Object> createProduct(@RequestBody Product productParam) {
        log.info("POST /products called");
        Response response = new Response();
        try {
            Product product = createProductUseCase.createProduct(productParam);
            response.setData(product);
            response.setHttpCode(201);
        } catch (Exception e) {
            log.error("POST /products error: {}", e.getMessage());
            response.setErrors(e.getMessage());
        }
        return response.getResponse();
    }

    @Operation(summary = "Update product by id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation"),
            @ApiResponse(responseCode = "400", description = "Invalid Product Id supplied"),
    })
    @Parameters(value = {
            @Parameter(in = ParameterIn.PATH, name = "id", description = "Product Id")
    })
    @PatchMapping("{id}")
    public ResponseEntity<Object> updateProduct(@PathVariable Long id, @RequestBody Product productParam) {
        log.info("PATCH /products/{} called", id.toString());
        Response response = new Response();
        try {
            Product product = updateProductUseCase.updateProduct(id, productParam);
            response.setData(product);
        } catch (Exception e) {
            log.error("PATCH /products/{} error: {}", id.toString(), e.getMessage());
            response.setErrors(e.getMessage());
        }
        return response.getResponse();
    }

    @Operation(summary = "Delete product by id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "successful operation"),
            @ApiResponse(responseCode = "400", description = "Invalid Product Id supplied"),
    })
    @Parameters(value = {
            @Parameter(in = ParameterIn.PATH, name = "id", description = "Product Id")
    })
    @DeleteMapping("{id}")
    public ResponseEntity<Object> deleteProduct(@PathVariable Long id) {
        log.info("DELETE /products/{} called", id.toString());
        Response response = new Response();
        try {
            deleteProductUseCase.deleteProduct(id);
            response.setHttpCode(204);
        } catch (Exception e) {
            log.error("DELETE /products/{} error: {}", id.toString(), e.getMessage());
            response.setErrors(e.getMessage());
        }
        return response.getResponse();
    }
}
