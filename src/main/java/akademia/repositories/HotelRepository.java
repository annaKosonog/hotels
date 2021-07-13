package akademia.repositories;

import akademia.model.dao.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;
import java.util.Optional;

@Repository
public interface HotelRepository extends JpaRepository<Hotel, Long> {

    @Query("select h from Hotel h ") //JP
    List<Hotel> findAllHotel();
    List<Hotel>  findByCountry(String country);
    List<Hotel> findByCountryAndRate(String country, String rate);
    List<Hotel> findHotelByAddress_City(String city);

    @Query(value = "select id,country,rate,title from hotel where id = (select hotel_id from address where address.city = ?1)", nativeQuery = true)
    List<Hotel> findHotelByAddressCity(String city);
    Optional<Hotel> findHotelByPartnerCode(String partnerCode);

    @Transactional
    @Modifying
    void deleteHotelByPartnerCode(String partnerCode);

    List<Hotel> findHotelByRate(String rate);
}


