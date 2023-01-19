package id.daimus.springswagger.infrastructure.data.jpa.product;

import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaProductRepository extends JpaRepository<ProductEntity, Long> {
}
