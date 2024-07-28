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
@Table(name = "dry_food")
public class DryFood extends Product{
    @Column(name = "pack", nullable = false)
    private String pack;

    @Column(name = "weight", nullable = false)
    private String weight;
}
