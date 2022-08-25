package pl.luckit.ing.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.*;
import pl.luckit.ing.exception.InvalidInputValueException;
import pl.luckit.ing.model.RealEstateStatsResult;
import pl.luckit.ing.service.RealEstateStatsService;

@RestController
@RequiredArgsConstructor
@Slf4j
public class RealEstateStatsController {

    private static final String REAL_ESTATES_STATS_ENDPOINT_LOG_MESSAGE = "Endpoint '/real-estates-stats' was called with the params: regionId={}, size={}, types={}, dateSince={}, dateUntil={},";
    private final RealEstateStatsService realEstateStatsService;

    @GetMapping("/real-estates-stats/{regionId}")
    @ResponseStatus(HttpStatus.OK)
    public RealEstateStatsResult realEstatesStats(@PathVariable String regionId,
                                                  @RequestParam @Nullable String size,
                                                  @RequestParam @Nullable String types,
                                                  @RequestParam @Nullable String dateSince,
                                                  @RequestParam @Nullable String dateUntil) throws InvalidInputValueException {
        log.info(REAL_ESTATES_STATS_ENDPOINT_LOG_MESSAGE, regionId, size, types, dateSince, dateUntil);
        return realEstateStatsService.averagePrice(regionId, size, types, dateSince, dateUntil);
    }
}
