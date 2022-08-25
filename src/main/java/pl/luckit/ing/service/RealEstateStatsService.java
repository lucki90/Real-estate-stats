package pl.luckit.ing.service;

import liquibase.repackaged.org.apache.commons.lang3.StringUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.luckit.ing.exception.InvalidInputValueException;
import pl.luckit.ing.model.RealEstateStatsResult;
import pl.luckit.ing.model.Region;
import pl.luckit.ing.model.Size;
import pl.luckit.ing.model.Type;
import pl.luckit.ing.repository.RealEstateRepository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RealEstateStatsService {

    private static final String TYPES_SPLITTER = ",";
    private final RealEstateRepository realEstateRepository;

    public RealEstateStatsResult averagePrice(String regionId, String size, String types, String dateSince, String dateUntil) throws InvalidInputValueException {
        BigDecimal avgPrice = getAvgPriceByParams(
                Region.findByRegionId(regionId),
                Size.findBySize(size),
                prepareTypeParams(types),
                StringUtils.isBlank(dateSince) ? LocalDate.MIN : prepareLocalDate(dateSince),
                StringUtils.isBlank(dateUntil) ? LocalDate.now() : prepareLocalDate(dateUntil))
                .orElse(BigDecimal.ZERO);

        return new RealEstateStatsResult(avgPrice);
    }

    public Optional<BigDecimal> getAvgPriceByParams(Region region, Size size, List<Type> types, LocalDate dateSince, LocalDate dateUntil) {
        return realEstateRepository.avgPriceByParams(region, size, types, dateSince, dateUntil);
    }

    private LocalDate prepareLocalDate(String localDate) throws InvalidInputValueException {
        if (StringUtils.isBlank(localDate)) {
            return null;
        }
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
        try {
            return LocalDate.parse(localDate, formatter);
        } catch (DateTimeParseException e) {
            throw new InvalidInputValueException();
        }
    }

    private List<Type> prepareTypeParams(String types) throws InvalidInputValueException {
        List<Type> typeParams = new ArrayList<>();
        if (StringUtils.isNotBlank(types)) {
            String[] typesSplit = types.split(TYPES_SPLITTER);
            for (String type : typesSplit) {
                typeParams.add(Type.findByType(type));
            }
        } else {
            typeParams = new ArrayList<>(EnumSet.allOf(Type.class));
        }
        if (typeParams.isEmpty()) {
            throw new InvalidInputValueException();
        }
        return typeParams;
    }
}
