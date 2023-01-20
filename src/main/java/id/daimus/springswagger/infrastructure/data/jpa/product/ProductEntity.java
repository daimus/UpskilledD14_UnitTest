package id.daimus.springswagger.infrastructure.data.jpa.product;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="products")
public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;
    @Column(name="name", unique = true)
    @NotEmpty(message = "The full name is required.")
    private String name;
    @Column(name="description")
    @NotEmpty(message = "The description is required.")
    private String description;
    @Column(name="stock")
    @Min(value = 1, message = "The minimum stock is 1")
    private int stock;
    @Column(name="price")
    @Min(value = 1, message = "The minimum price is 1")
    private int price;
}
