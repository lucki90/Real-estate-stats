package pl.luckit.ing.model;

import lombok.Getter;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Getter
public class RealEstateStatsResult {

    private final BigDecimal avgValue;

    public RealEstateStatsResult(BigDecimal avgValue) {
        this.avgValue = avgValue.setScale(2, RoundingMode.HALF_UP);
    }
}
