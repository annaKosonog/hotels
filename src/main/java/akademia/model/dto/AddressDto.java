package akademia.model.dto;

import lombok.*;


@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class AddressDto {

  
    private String postalAddress;
  
    private String email;
   
    private String phone;
   
    private String url;

    //todo dodać dane geograficzne z google maps



