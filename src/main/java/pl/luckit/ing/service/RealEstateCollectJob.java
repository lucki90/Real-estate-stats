package pl.luckit.ing.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import pl.luckit.ing.exception.InvalidInputValueException;

@Slf4j
@Component
@RequiredArgsConstructor
public class RealEstateCollectJob {

    private static final String SCHEDULER_STARTED_MESSAGE = "Scheduler started collecting data from an external real estates API";
    private static final String SCHEDULER_FINISHED_MESSAGE = "Scheduler has finished collecting data successfully.";
    private final RealEstateCollectService realEstateCollectService;

    @Scheduled(cron = "0 0 21 * * ?")
    public void runJob() throws InvalidInputValueException {
        log.info(SCHEDULER_STARTED_MESSAGE);
        realEstateCollectService.collectAndSaveData();
        log.info(SCHEDULER_FINISHED_MESSAGE);
    }
}
