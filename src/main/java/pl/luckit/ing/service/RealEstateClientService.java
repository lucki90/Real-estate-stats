package pl.luckit.ing.service;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import pl.luckit.ing.model.dto.RealEstateDto;

@Service
@RequiredArgsConstructor
public class RealEstateClientService {

    private static final String REAL_ESTATES_URL = "http://localhost:9090/api/real-estates/%s?page=%d";
    private final RestTemplate restTemplate;

    public ResponseEntity<RealEstateDto> getRealEstate(String region, Integer page) {
        return restTemplate.exchange(
                String.format(REAL_ESTATES_URL, region, page),
                HttpMethod.GET,
                new HttpEntity<>(new HttpHeaders()),
                RealEstateDto.class);
    }
}
