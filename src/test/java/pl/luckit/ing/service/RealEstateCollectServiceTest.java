package pl.luckit.ing.service;

import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pl.luckit.ing.entity.RealEstate;
import pl.luckit.ing.exception.HttpClientServerException;
import pl.luckit.ing.model.Region;
import pl.luckit.ing.model.Size;
import pl.luckit.ing.model.Type;
import pl.luckit.ing.stub.RealEstateDtoResponseEntityStub;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class RealEstateCollectServiceTest {

    @Mock
    private RealEstateClientService realEstateClientService;
    @InjectMocks
    private RealEstateCollectService collectService;

    @Test
    void shouldReturnListOfRealEstate() throws Exception {
        //given
        when(realEstateClientService.getRealEstate(anyString(), anyInt()))
                .thenReturn(RealEstateDtoResponseEntityStub.getValidResponseEntity());
        //when
        List<RealEstate> realEstateList = collectService.prepareRealEstatesList();

        //then
        SoftAssertions softly = new SoftAssertions();
        softly.assertThat(realEstateList).isNotNull();
        softly.assertThat(realEstateList).hasSize(10);
        softly.assertThat(realEstateList.get(0).getReportDate()).isEqualTo(LocalDate.now());
        softly.assertThat(realEstateList.get(0).getRegion()).isEqualTo(Region.DLN_WROC_PC);
        softly.assertThat(realEstateList.get(1).getRegion()).isEqualTo(Region.DLN_POZA_WROC);
        softly.assertThat(realEstateList.get(9).getRegion()).isEqualTo(Region.LUBL_INNE);
        softly.assertThat(realEstateList.get(0).getRealEstateDataList()).isNotNull();
        softly.assertThat(realEstateList.get(0).getRealEstateDataList()).hasSize(12);
        softly.assertThat(realEstateList.get(0).getRealEstateDataList().get(0).getSize()).isEqualTo(Size.L);
        softly.assertThat(realEstateList.get(0).getRealEstateDataList().get(0).getPrice()).isEqualTo(new BigDecimal("1231.32"));
        softly.assertThat(realEstateList.get(0).getRealEstateDataList().get(0).getRooms()).isEqualTo(3);
        softly.assertThat(realEstateList.get(0).getRealEstateDataList().get(0).getType()).isEqualTo(Type.FLAT);

        softly.assertAll();

    }

    @Test
    void shouldThrowHttpClientServerExceptionWhenResponseStatusOtherThan2xx() {
        //given
        when(realEstateClientService.getRealEstate(anyString(), anyInt()))
                .thenReturn(RealEstateDtoResponseEntityStub.getInvalidResponseEntityWithEmptyBodyAndStatus503());
        //when
        //then
        assertThrows(HttpClientServerException.class,
                () -> collectService.prepareRealEstatesList());
    }

}