package project.qrscan.Entitiy;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor
@Table(name = "product")
@Inheritance(strategy = InheritanceType.JOINED)
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "type", nullable = false)
    private String type;

    @Column(name = "brand", nullable = false)
    private String brand;

    @Column(name = "origin", nullable = false)
    private String origin;

    @Column(name = "price", nullable = false)
    private Double price;

    @Column(name = "flavor", nullable = false)
    private String flavor;


    @Column(name = "ingredient", nullable = false, length = 1023)
    private String ingredient;

    @Column(name = "description")
    private String description;

}
