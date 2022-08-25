package pl.luckit.ing.model.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class RealEstateDataDto {

    private String id;
    private String type;
    private String price;
    private String description;
    private String area;
    private Integer rooms;
}
