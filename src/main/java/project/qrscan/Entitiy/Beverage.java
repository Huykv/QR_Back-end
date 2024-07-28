package project.qrscan.Entitiy;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data @NoArgsConstructor @AllArgsConstructor
@Table(name = "beverage")
public class Beverage extends Product{
    @Column(name = "pack", nullable = false)
    private String pack;

    @Column(name = "capacity", nullable = false)
    private String capacity;
}
