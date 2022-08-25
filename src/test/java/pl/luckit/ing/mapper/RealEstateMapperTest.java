package pl.luckit.ing.mapper;

import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Test;
import pl.luckit.ing.entity.RealEstate;
import pl.luckit.ing.exception.InvalidInputValueException;
import pl.luckit.ing.model.Region;
import pl.luckit.ing.model.Size;
import pl.luckit.ing.model.Type;
import pl.luckit.ing.model.dto.RealEstateDataDto;
import pl.luckit.ing.model.dto.RealEstateDto;
import pl.luckit.ing.stub.RealEstateDtoResponseEntityStub;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertThrows;

class RealEstateMapperTest {

    @Test
    void shouldReturnProperEntityObj() throws InvalidInputValueException {
        //given
        RealEstateDto dto = RealEstateDtoResponseEntityStub.getValidResponseEntity().getBody();
        //when
        assert dto != null;
        RealEstate result = RealEstateMapper.mapFromDto(dto);
        //then
        SoftAssertions softly = new SoftAssertions();
        softly.assertThat(result.getRealEstateDataList()).isNotNull();
        softly.assertThat(result.getRealEstateDataList()).hasSize(1);
        softly.assertThat(result.getRealEstateDataList().get(0).getPrice()).isEqualTo(new BigDecimal("1231.32"));
        softly.assertThat(result.getRealEstateDataList().get(0).getType()).isEqualTo(Type.FLAT);
        softly.assertThat(result.getRealEstateDataList().get(0).getSize()).isEqualTo(Size.L);
        softly.assertThat(result.getRegion()).isEqualTo(Region.LUBL);
        softly.assertThat(result.getReportDate()).isEqualTo(LocalDate.now());
        softly.assertAll();
    }

    @Test
    void shouldReturnInvalidInputException() {
        //given
        RealEstateDto dto = new RealEstateDto();
        RealEstateDataDto dataDto = new RealEstateDataDto();
        dto.getData().add(dataDto);
        //when
        //then
        assertThrows(InvalidInputValueException.class,
                () -> RealEstateMapper.mapFromDto(dto));
    }


}