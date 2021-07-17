package akademia.services.DTO;

import akademia.model.dao.Hotel;
import akademia.model.dao.SampleHotel;
import akademia.model.dto.HotelDto;
import akademia.repositories.AddressRepository;
import akademia.repositories.HotelRepository;
import akademia.repositories.RoomRepository;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class HotelServiceDtoUnitTest extends SampleHotel {
    HotelRepository hotelRepository = mock(HotelRepository.class);
    AddressRepository addressRepository = mock(AddressRepository.class);
    RoomRepository roomRepository = mock(RoomRepository.class);

    HotelServiceDto hotelServiceDTO = new HotelServiceDto(hotelRepository, addressRepository, roomRepository);

    @Test
    void should_return_all_hotels() {
        //GIVEN
        when(hotelRepository.findAllHotel()).thenReturn(Arrays.asList(energyLandia(), sobieskiHotel(), clarkHotel()));

        //WHEN
        final List<HotelDto> allHotels = hotelServiceDTO.getHotels();

        //THEN
        assertThat(allHotels).isEqualTo(Arrays.asList(energylandiaDto(), sobieskiHotelDto(), clarkHotelDto()));
        verify(hotelRepository, times(1)).findAllHotel();
    }

    @Test
    void should_return_all_hotels_which_country_it_Poland() {
        //GIVEN
        when(hotelRepository.findByCountry("Poland")).thenReturn(Arrays.asList(energyLandia(), sobieskiHotel()));

        //WHEN
        final List<HotelDto> pol = hotelServiceDTO.getHotelsByCountry("Poland");

        //THEN
        assertThat(pol).isEqualTo(Arrays.asList(energylandiaDto(), sobieskiHotelDto()));
        assertThat(pol.size()).isEqualTo(2);
    }

    @Test
    void should_return_all_hotels_which_city_equals_Budapeszt() {
        //GIVEN
        when(hotelRepository.findHotelByAddress_City("Budapeszt")).thenReturn(Collections.singletonList(clarkHotel()));

        //WHEN
        final List<HotelDto> city = hotelServiceDTO.getHotelsByCity("Budapeszt");

        //THEN
        assertThat(city).isEqualTo(Collections.singletonList(clarkHotelDto()));
        assertThat(city).isNotNull();
    }

    @Test
    void should_return_all_hotels_which_rate_equals_four() {
        //GIVEN
        when(hotelRepository.findHotelByRate("4")).thenReturn(Arrays.asList(clarkHotel(), sobieskiHotel()));

        //WHEN
        final List<HotelDto> rate = hotelServiceDTO.getHotelsByRate("4");

        //THEN
        assertThat(rate).isEqualTo(Arrays.asList(clarkHotelDto(), sobieskiHotelDto()));
    }

    @Test
    void should_return_hotel_about_given_partner_code_0b25d2b9_5573_4d38_a81f_de982bb554b6() {
        //GIVEN
        final String PARTNER_CODE = "0b25d2b9-5573-4d38-a81f-de982bb554b6";
        when(hotelRepository.findHotelByPartnerCode(PARTNER_CODE)).thenReturn(Optional.of(clarkHotel()));
        //WHEN
        final HotelDto hotelByPartnerCode = hotelServiceDTO.getHotelByPartnerCode(PARTNER_CODE);

        //THEN
        assertThat(hotelByPartnerCode).isEqualTo(clarkHotelDto());
    }

    @Test
    void should_delete_hotel_about_given_partner_code_0b25d2b9_5573_4d38_a81f_de982bb554b6() {
        //GIVEN
        final String PARTNER_CODE = "0b25d2b9-5573-4d38-a81f-de982bb554b6";
        when(hotelRepository.deleteHotelByPartnerCode(PARTNER_CODE)).thenReturn("SUCCESS");

        //WHEN
        final String deleteHotel = hotelServiceDTO.deleteHotelByPartnerCode(PARTNER_CODE);

        //THEN
        assertThat(hotelRepository.findHotelByPartnerCode(PARTNER_CODE)).isNotPresent();
    }

    @Test
    void should_return_update_hotel_clark_hotel() {
        //GIVEN
        final String PARTNER_CODE = "0b25d2b9-5573-4d38-a81f-de982bb554b6";
        when(hotelRepository.findHotelByPartnerCode(PARTNER_CODE)).thenReturn(Optional.of(clarkHotel()));

        //WHEN
        final HotelDto update = hotelServiceDTO.updateHotel(updateClarkHotelDto(), PARTNER_CODE);

        //THEN
        assertThat(update.getTitle()).isEqualTo("Prestige Hotel Budapest");
        assertThat(clarkHotelDto()).isNotSameAs(update);

    }

    @Test
    void should_return_new_hotel_abaut_name_valamar_padova_Hotel() {
        //GIVEN
        when(hotelRepository.save(any(Hotel.class))).thenReturn(valamarPadovaHotel());

        //WHEN
        final HotelDto savedHotel = hotelServiceDTO.addHotel(newValamarPadovaHotelDto());
        //WHEN
        assertThat(savedHotel).isNotNull();
        verify(hotelRepository, times(1)).save(any());
    }
}
