package pl.luckit.ing.entity;

import lombok.Getter;
import lombok.Setter;
import pl.luckit.ing.model.Size;
import pl.luckit.ing.model.Type;

import javax.persistence.*;
import java.math.BigDecimal;

@Getter
@Setter
@Entity(name = "real_estate_data")
public class RealEstateData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "type")
    private Type type;

    @Column(name = "price")
    private BigDecimal price;

    @Column(name = "description")
    private String description;

    @Enumerated(EnumType.STRING)
    @Column(name = "size")
    private Size size;

    @Column(name = "rooms")
    private Integer rooms;
}
