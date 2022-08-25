package pl.luckit.ing.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import pl.luckit.ing.entity.RealEstate;
import pl.luckit.ing.exception.HttpClientServerException;
import pl.luckit.ing.exception.InvalidInputValueException;
import pl.luckit.ing.mapper.RealEstateMapper;
import pl.luckit.ing.model.Region;
import pl.luckit.ing.model.dto.RealEstateDto;
import pl.luckit.ing.repository.RealEstateRepository;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class RealEstateCollectService {

    private static final int FIRST_PAGE = 1;
    private final RealEstateClientService realEstateClientService;
    private final RealEstateRepository realEstateRepository;

    public void collectAndSaveData() throws InvalidInputValueException {
        realEstateRepository.saveAll(prepareRealEstatesList());
    }

    public List<RealEstate> prepareRealEstatesList() throws InvalidInputValueException {
        List<RealEstate> realEstateList = new ArrayList<>();
        for (Region region : Region.values()) {
            RealEstateDto realEstateDto = collectData(region);
            realEstateList.add(RealEstateMapper.mapFromDto(realEstateDto));
        }
        return realEstateList;
    }

    private RealEstateDto collectData(Region region) {
        RealEstateDto realEstateDto = new RealEstateDto(region);
        int totalPages = FIRST_PAGE;
        for (int actualPage = FIRST_PAGE; actualPage <= totalPages; actualPage++) {
            ResponseEntity<RealEstateDto> response = realEstateClientService.getRealEstate(realEstateDto.getRegion().name(), actualPage);
            if (!response.getStatusCode().is2xxSuccessful()) {
                throw new HttpClientServerException();
            }
            RealEstateDto responseBody = response.getBody();
            if (responseBody != null) {
                if (actualPage == FIRST_PAGE) {
                    totalPages = responseBody.getTotalPages() != null ? responseBody.getTotalPages() : 0;
                }
                realEstateDto.getData().addAll(responseBody.getData());
            }
        }
        return realEstateDto;
    }
}
