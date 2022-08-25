package pl.luckit.ing.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import pl.luckit.ing.exception.InvalidInputValueException;
import pl.luckit.ing.model.Region;
import pl.luckit.ing.model.Size;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.stream.Stream;

import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Sql(scripts = "classpath:database/fill-database.sql")
@Transactional
class RealEstateStatsControllerTest {

    private static final String REAL_ESTATES_STATS_ENDPOINT = "/real-estates-stats/{regionId}?size={size}&types={types}&dateSince={dateSince}&dateUntil={dateUntil}";

    @Autowired
    private WebApplicationContext webApplicationContext;
    private MockMvc mockMvc;

    static Stream<Arguments> validInputValues() {
        return Stream.of(
                Arguments.arguments(Region.DLN_POZA_WROC.name(), Size.L.name(), "detached_house,flat", "20220501", "20230910", BigDecimal.valueOf(92243.00)),
                Arguments.arguments(Region.DLN_WROC_PC.name(), Size.L.name(), "detached_house,flat", "20250910", "20230910", BigDecimal.ZERO),
                Arguments.arguments(Region.M_WAW_CE.name(), Size.S.name(), "flat", "20220501", "20230910", BigDecimal.valueOf(568056.00)),
                Arguments.arguments(Region.SL_PN.name(), Size.L.name(), "semi_detached_house", "20220501", "20230910", BigDecimal.valueOf(293180.0)),
                Arguments.arguments(Region.SL_POL.name(), Size.L.name(), "detached_house,flat,semi_detached_house,terraced_house", "20220501", "20230910", BigDecimal.valueOf(462099.00)),
                Arguments.arguments(Region.DLN_POZA_WROC.name(), Size.L.name(), "detached_house", "20220501", "20230910", BigDecimal.ZERO),
                Arguments.arguments(Region.DLN_POZA_WROC.name(), Size.S.name(), "detached_house", "20220501", "", BigDecimal.valueOf(250308.8)),
                Arguments.arguments(Region.DLN_POZA_WROC.name(), Size.S.name(), "detached_house", "", "", BigDecimal.valueOf(250308.8)),
                Arguments.arguments(Region.DLN_POZA_WROC.name(), "", "", "", "", BigDecimal.valueOf(437310.40)),
                Arguments.arguments(Region.DLN_POZA_WROC.name(), null, null, null, null, BigDecimal.valueOf(437310.40))
        );
    }

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

    @BeforeEach
    public void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @ParameterizedTest
    @MethodSource("validInputValues")
    void shouldCallAddEndpointAndReturn200StatusAndExpectedResultValue(String regionId, String size, String types, String sinceDae, String untilDate, BigDecimal expected) throws Exception {
        mockMvc.perform(get(REAL_ESTATES_STATS_ENDPOINT,
                        regionId, size, types, sinceDae, untilDate)
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("avgValue", is(expected.doubleValue())));
    }

    @ParameterizedTest
    @MethodSource("invalidInputValues")
    void shouldCallAddEndpointAndReturnInvalidInputValueExceptionAndNotAcceptable(String regionId, String size, String types, String sinceDae, String untilDate) throws Exception {
        mockMvc.perform(get(REAL_ESTATES_STATS_ENDPOINT,
                        regionId, size, types, sinceDae, untilDate)
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isNotAcceptable())
                .andExpect(result -> assertTrue(result.getResolvedException() instanceof InvalidInputValueException));
    }

}