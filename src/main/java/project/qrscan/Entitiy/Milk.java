package project.qrscan.Entitiy;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data @NoArgsConstructor @AllArgsConstructor
@Table(name = "milk")
public class Milk extends Product{
    @Column(name = "unit", nullable = false)
    private String unit;

    @Column(name = "capacity", nullable = false)
    private String capacity;
}
