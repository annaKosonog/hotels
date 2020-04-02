package akademia.model.dao;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.hibernate.validator.constraints.URL;

import javax.persistence.*;
import javax.validation.constraints.Email;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
// Jeden Hotel miał jeden Adress
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String city;
    private String street;
    private String streetNo;
    @Email
    private String email;
    private String phone;
    @URL
    private String url;

   @JsonIgnore
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="hotel_id")
    private Hotel hotel;


    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("id", id)
                .append("city", city)
                .append("street", street)
                .append("streetNo", streetNo)
                .append("email", email)
                .append("phone", phone)
                .append("url", url)
                .append("hotel", hotel)
                .toString();
    }
}
