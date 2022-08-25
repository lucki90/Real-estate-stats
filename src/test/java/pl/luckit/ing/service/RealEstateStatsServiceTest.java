package pl.luckit.ing.service;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pl.luckit.ing.exception.InvalidInputValueException;
import pl.luckit.ing.model.Region;
import pl.luckit.ing.model.Size;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
class RealEstateStatsServiceTest {

    @Autowired
    private RealEstateStatsService realEstateStatsService;

    static Stream<Arguments> invalidInputValues() {
        return Stream.of(
                Arguments.arguments("wrongRegionId", Size.L.name(), "detached_house,flat", "20220501", "20230910"),
                Arguments.arguments(Region.DLN_POZA_WROC.name(), "WrongSize", "detached_house,flat", "20220501", "20230910"),
                Arguments.arguments(Region.DLN_POZA_WROC.name(), Size.L.name(), "wrongType", "20220501", "20230910"),
                Arguments.arguments(Region.DLN_POZA_WROC.name(), Size.L.name(), ",,,,,,,,", "20220501", "20230910"),
                Arguments.arguments(Region.DLN_POZA_WROC.name(), Size.L.name(), "detached_house,flat", "asdasd", "20230910"),
                Arguments.arguments(Region.DLN_POZA_WROC.name(), Size.L.name(), "detached_house,flat", "20220501", "sdfsdf")

        );
    }

    @ParameterizedTest
    @MethodSource("invalidInputValues")
    void shouldReturnInvalidInputException(String regionId, String size, String types, String sinceDae, String untilDate) throws InvalidInputValueException {
        assertThrows(InvalidInputValueException.class,
                () -> realEstateStatsService.averagePrice(regionId, size, types, sinceDae, untilDate));
    }
}