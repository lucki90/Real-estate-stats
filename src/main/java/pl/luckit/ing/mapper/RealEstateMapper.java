package pl.luckit.ing.mapper;

import pl.luckit.ing.entity.RealEstate;
import pl.luckit.ing.entity.RealEstateData;
import pl.luckit.ing.exception.InvalidInputValueException;
import pl.luckit.ing.model.Size;
import pl.luckit.ing.model.Type;
import pl.luckit.ing.model.dto.RealEstateDataDto;
import pl.luckit.ing.model.dto.RealEstateDto;

import java.math.BigDecimal;
import java.time.LocalDate;

public class RealEstateMapper {

    private RealEstateMapper() {
    }

    public static RealEstate mapFromDto(RealEstateDto dto) throws InvalidInputValueException {
        RealEstate entity = new RealEstate();
        entity.setRegion(dto.getRegion());
        entity.setReportDate(LocalDate.now());
        for (RealEstateDataDto realEstateDataDto : dto.getData()) {
            entity.getRealEstateDataList().add(mapFromDto(realEstateDataDto));
        }

        return entity;
    }

    private static RealEstateData mapFromDto(RealEstateDataDto dto) throws InvalidInputValueException {
        RealEstateData entity = new RealEstateData();
        entity.setType(Type.findByType(dto.getType()));
        entity.setSize(Size.findByArea(dto.getArea()));
        entity.setRooms(dto.getRooms());
        entity.setPrice(new BigDecimal(dto.getPrice()));
        entity.setDescription(dto.getDescription());

        return entity;
    }

}
