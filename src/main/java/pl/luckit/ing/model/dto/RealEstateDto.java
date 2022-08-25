package pl.luckit.ing.model.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import pl.luckit.ing.model.Region;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
public class RealEstateDto {

    private Integer totalPages;
    private Region region;
    private List<RealEstateDataDto> data = new ArrayList<>();

    public RealEstateDto(Region region) {
        this.region = region;
    }
}
