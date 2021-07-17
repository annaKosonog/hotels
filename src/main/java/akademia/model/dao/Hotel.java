package akademia.model.dao;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.apache.commons.lang3.builder.ToStringExclude;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.List;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@EqualsAndHashCode
@ToString
public class Hotel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(length = 36)
    private String partnerCode;

    @NotBlank
    private String title;
    @NotBlank
    private String country;
    @NotBlank
    private String rate;

    @ToStringExclude
    @EqualsAndHashCode.Exclude
    @OneToOne(mappedBy = "hotel", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Address address;

    //  @JsonIgnore
    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    //kaskadowośc co się stanie z obiektem room kiedy operuję na obiekcie Hotel
    @JoinTable(name = "hotel_room", joinColumns = @JoinColumn(name = "hotel_id"), inverseJoinColumns = @JoinColumn(name = "room_id"))
    private List<Room> rooms;

    @CreationTimestamp
    private LocalDateTime createDateTime;

    @UpdateTimestamp
    private LocalDateTime updateDateTime;

    // todo dodać klasę z opiniami o hotelu


}
