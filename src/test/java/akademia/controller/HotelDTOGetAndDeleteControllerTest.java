package akademia.controller;

import akademia.configuration.MessageSourceConfig;
import akademia.controllers.DTO.HotelDtoController;
import akademia.exception.ResourceNotFoundExceptionTest;
import akademia.exception.validation.ValidationErrorControllerAdvice;
import akademia.model.dao.SampleHotel;
import akademia.model.dto.HotelDto;
import akademia.repositories.AddressRepository;
import akademia.repositories.HotelRepository;
import akademia.repositories.RoomRepository;
import akademia.services.DTO.HotelServiceDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest(controllers = HotelDtoController.class)
@ContextConfiguration(classes = MockMvcConfig.class)
public class HotelDTOGetAndDeleteControllerTest extends SampleHotel {

    @Test
    void should_return_status_ok_when_found_all_hotels(@Autowired MockMvc mockMvc, @Autowired ObjectMapper objectMapper) throws Exception {
        final List<HotelDto> expectedHotels = Arrays.asList(energylandiaDto(), sobieskiHotelDto(), clarkHotelDto());
        String expectedResponse = objectMapper.writeValueAsString(expectedHotels);

        final MvcResult result = mockMvc.perform(get("/api/v1/dto/hotels"))
                .andExpect(status().isOk())
                .andDo(print())
                .andReturn();

        String actualResponseWithBody = result.getResponse().getContentAsString();
        assertThat(actualResponseWithBody.equals(expectedResponse));
    }

    @Test
    void should_return_status_ok_when_found_hotel_by_country(@Autowired MockMvc mockMvc, @Autowired ObjectMapper objectMapper) throws Exception {
        final List<HotelDto> expectedHotels = Collections.singletonList(clarkHotelDto());
        String expectedResponse = objectMapper.writeValueAsString(expectedHotels);

        final MvcResult result = mockMvc.perform(get("/api/v1/dto/hotels/country/Hungary"))
                .andExpect(status().isOk())
                .andDo(print())
                .andReturn();

        String actualResponseWithBody = result.getResponse().getContentAsString();
        assertThat(actualResponseWithBody.equals(expectedResponse));
    }

    @Test
    void should_return_status_ok_when_found_hotel_by_city(@Autowired MockMvc mockMvc, @Autowired ObjectMapper objectMapper) throws Exception {
        final List<HotelDto> expectedHotels = Collections.singletonList(sobieskiHotelDto());
        String expectedResponse = objectMapper.writeValueAsString(expectedHotels);

        final MvcResult result = mockMvc.perform(get("/api/v1/dto/hotels/city/{city}", "Warszawa"))
                .andExpect(status().isOk())
                .andDo(print())
                .andReturn();

        String actualResponseWithBody = result.getResponse().getContentAsString();
        assertThat(actualResponseWithBody.equals(expectedResponse));
    }


    @Test
    void should_return_status_ok_when_he_finds_a_hotel_with_a_given_partner_code_23c39ece_89c3_4834_97e2_2c089e2a7724(@Autowired MockMvc mvc, @Autowired ObjectMapper objectMapper) throws Exception {
        final List<HotelDto> expectedHotels = Collections.singletonList(clarkHotelDto());
        String expectedResponse = objectMapper.writeValueAsString(expectedHotels);

        final MvcResult result = mvc.perform(get("/api/v1/dto/hotels/{partnerCode}", "0b25d2b9-5573-4d38-a81f-de982bb554b6"))
                .andExpect(status().isOk())
                .andDo(print())
                .andReturn();

        String actualResponseWithBody = result.getResponse().getContentAsString();
        assertThat(actualResponseWithBody.equals(expectedResponse));
    }


    @Test
    void should_return_status_not_found_when_delete_a_hotel_with_a_given_partner_code_100(@Autowired MockMvc mvc, @Autowired ObjectMapper objectMapper) throws Exception {
        final String partnerCode = "100";

        mvc.perform(delete("/api/v1/dto/hotels/{partnerCode}", partnerCode)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());
    }

    @Test
    void should_return_status_201_when_delete_a_hotel_with_after_partner_code(@Autowired MockMvc mvc) throws Exception {
        final String partnerCode = "a372b512-9a48-4107-8d4e-3fbc3fa22ccd";
        mvc.perform(delete("/api/v1/dto/hotels/{partnerCode}", partnerCode)
                .accept(MediaType.APPLICATION_JSON)
                .param("partner_code", partnerCode))
                .andExpect(status().isAccepted())
                .andDo(print())
                .andReturn();
    }
}

@Import(MessageSourceConfig.class)
@Configuration(proxyBeanMethods = false)
class MockMvcConfig extends SampleHotel implements ResourceNotFoundExceptionTest {

    HotelRepository hotelRepository = mock(HotelRepository.class);
    AddressRepository addressRepository = mock(AddressRepository.class);
    RoomRepository roomRepository = mock(RoomRepository.class);


    @Bean
    HotelServiceDto hotelServiceDTO() {
        return new HotelServiceDto(hotelRepository, addressRepository, roomRepository) {
            @Override
            public List<HotelDto> getHotels() {
                return Arrays.asList(energylandiaDto(), sobieskiHotelDto(), clarkHotelDto());
            }

            @Override
            public List<HotelDto> getHotelsByCountry(String country) {
                if ("Poland".equals(country)) {
                    return Arrays.asList(energylandiaDto(), sobieskiHotelDto());
                } else if ("Hungary".equals(country)) {
                    return Collections.singletonList(clarkHotelDto());
                }
                return Collections.emptyList();
            }

            public List<HotelDto> getHotelsByCity(String city) {
                if ("Warszawa".equals(city)) {
                    return Collections.singletonList(sobieskiHotelDto());
                } else if ("Budapeszt".equals(city)) {
                    return Collections.singletonList(clarkHotelDto());
                }
                return Collections.emptyList();
            }


            @Override
            public HotelDto getHotelByPartnerCode(String partnerCode) {
                if ("a372b512-9a48-4107-8d4e-3fbc3fa22ccd".equals(partnerCode)) {
                    return energylandiaDto();
                } else if ("0b25d2b9-5573-4d38-a81f-de982bb554b6".equals(partnerCode)) {
                    return clarkHotelDto();
                } else if ("d36b7579-39ff-488d-8551-d811c4f1c0b9".equals(partnerCode)) {
                    return sobieskiHotelDto();
                }
                throw resourceNotFoundExceptionTest(partnerCode);
            }

            @Override
            public String deleteHotelByPartnerCode(String partnerCode) {
                if ("a372b512-9a48-4107-8d4e-3fbc3fa22ccd".equals(partnerCode)) {
                    return energylandiaDto().getPartnerCode();
                }
                throw resourceNotFoundExceptionTest(partnerCode);
            }

            @Override
            public HotelDto updateHotel(HotelDto hotelDTO, String partnerCode) {
                if ("0b25d2b9-5573-4d38-a81f-de982bb554b6".equals(partnerCode)) {
                    hotelDTO = updateClarkHotelDto();
                    return hotelDTO;
                }
                throw resourceNotFoundExceptionTest(partnerCode);
            }

            @Override
            public HotelDto addHotel(HotelDto hotelDTO) {
                return newValamarPadovaHotelDto();
            }
        };
    }

    @Bean
    HotelDtoController hotelDTOController(HotelServiceDto hotelServiceDTO) {
        return new HotelDtoController(hotelServiceDTO, hotelRepository);
    }

    @Bean
    public ValidationErrorControllerAdvice apiValidationError() {
        return new ValidationErrorControllerAdvice();
    }
}




