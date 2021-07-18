package akademia.controller;

import akademia.controllers.DTO.HotelDtoController;
import akademia.model.dao.SampleHotel;
import akademia.model.dto.HotelDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = HotelDtoController.class)
@ContextConfiguration(classes = MockMvcConfig.class)
public class HotelDtoPostAndPutControllerTest extends SampleHotel {

    @Test
    void should_return_status_200_when_correctly_add_hotel(@Autowired MockMvc mockMvc, @Autowired ObjectMapper objectMapper) throws Exception {
        HotelDto newHotel = newValamarPadovaHotelDto();
        final String expected = objectMapper.writeValueAsString(newHotel);

        final MvcResult result = mockMvc.perform(post("/api/v1/dto/hotels")
                .contentType(MediaType.APPLICATION_JSON)
                .content(expected))
                .andExpect(status().isCreated())
                .andDo(print())
                .andReturn();

        String actual = result.getResponse().getContentAsString();
        assertThat(actual).isEqualToIgnoringWhitespace(expected);
    }

    @Test
    void should_thrown_status_400_on_invalid_entity(@Autowired MockMvc mockMvc, @Autowired ObjectMapper objectMapper) throws Exception {
        HotelDto newHotel = valamarPadovaHotelDtoValidation();
        final String expected = objectMapper.writeValueAsString(newHotel);

        final MvcResult result = mockMvc.perform(post("/api/v1/dto/hotels")
                .contentType(MediaType.APPLICATION_JSON)
                .content(expected))
                .andExpect(status().isBadRequest())
                .andDo(print())
                .andReturn();

        String actual = result.getResponse().getContentAsString();
        assertThat(actual).contains(expectedErrorMessages());
    }

    @Test
    void should_return_status_200_when_correctly_update_hotel(@Autowired MockMvc mockMvc, @Autowired ObjectMapper objectMapper) throws Exception {
        final String partnerCode = "0b25d2b9-5573-4d38-a81f-de982bb554b6";
        HotelDto updateHotel =updateClarkHotelDto() ;
        final String expected = objectMapper.writeValueAsString(updateHotel);

        mockMvc.perform(put("/api/v1/dto/hotels/{partnerCode}", partnerCode)
                .contentType(MediaType.APPLICATION_JSON)
                .content(expected))
                .andExpect(status().isOk())
                .andDo(print())
                .andReturn();

    }

    private List<String> expectedErrorMessages() {
        return Arrays.asList(
                "Title may not be blank",
                "Country may not be blank",
                "Rate may not be blank",
                "City and street name and street number may not be blank",
                "Phone may not be blank");
    }
}
