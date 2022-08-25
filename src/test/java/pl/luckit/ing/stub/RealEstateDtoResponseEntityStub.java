package pl.luckit.ing.stub;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import pl.luckit.ing.model.Region;
import pl.luckit.ing.model.dto.RealEstateDataDto;
import pl.luckit.ing.model.dto.RealEstateDto;

public class RealEstateDtoResponseEntityStub {

    public static ResponseEntity<RealEstateDto> getValidResponseEntity() {

        RealEstateDataDto dataDto = new RealEstateDataDto();
        dataDto.setArea("123");
        dataDto.setDescription("description");
        dataDto.setPrice("1231.32");
        dataDto.setRooms(3);
        dataDto.setType("flat");

        RealEstateDto dto = new RealEstateDto();
        dto.setRegion(Region.LUBL);
        dto.setTotalPages(12);
        dto.getData().add(dataDto);

        HttpHeaders header = new HttpHeaders();
        header.setContentType(MediaType.APPLICATION_JSON);

        return new ResponseEntity<>(
                dto,
                header,
                HttpStatus.OK
        );
    }

    public static ResponseEntity<RealEstateDto> getInvalidResponseEntityWithEmptyBodyAndStatus503() {
        RealEstateDataDto dataDto = new RealEstateDataDto();
        RealEstateDto dto = new RealEstateDto();
        dto.getData().add(dataDto);
        HttpHeaders header = new HttpHeaders();
        header.setContentType(MediaType.APPLICATION_JSON);

        return new ResponseEntity<>(
                dto,
                header,
                HttpStatus.SERVICE_UNAVAILABLE
        );
    }

}
