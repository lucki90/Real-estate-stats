package pl.luckit.ing.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pl.luckit.ing.entity.RealEstate;
import pl.luckit.ing.model.Region;
import pl.luckit.ing.model.Size;
import pl.luckit.ing.model.Type;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface RealEstateRepository extends JpaRepository<RealEstate, Long> {

    @Query("SELECT AVG(d.price) FROM real_estate r LEFT JOIN r.realEstateDataList d "
            + "WHERE r.region = :region "
            + "AND (:size IS NULL OR d.size = :size) "
            + "AND d.type IN :types "
            + "AND (r.reportDate BETWEEN :dateSince AND :dateUntil)")
    Optional<BigDecimal> avgPriceByParams(@Param("region") Region region,
                                          @Param("size") Size size,
                                          @Param("types") List<Type> types,
                                          @Param("dateSince") LocalDate dateSince,
                                          @Param("dateUntil") LocalDate dateUntil);
}
