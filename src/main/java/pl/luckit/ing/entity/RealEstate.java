package pl.luckit.ing.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;
import pl.luckit.ing.model.Region;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity(name = "real_estate")
public class RealEstate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "region")
    private Region region;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "report_date")
    private LocalDate reportDate;

    @OneToMany(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    @JoinColumn(name = "real_estate_id", referencedColumnName = "id")
    private List<RealEstateData> realEstateDataList = new ArrayList<>();

}
