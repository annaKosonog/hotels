package akademia.exception;

import lombok.Getter;

import javax.persistence.EntityNotFoundException;

@Getter
public class ResourceNotFoundException extends EntityNotFoundException {

    private static final long serialVersionUID = -4856846361193249489L;
    private final String infoRequestPartnerCode;

    public ResourceNotFoundException(String partnerCode) {
        super(String.format("Hotel not found about given partner_code: ", partnerCode));
        this.infoRequestPartnerCode = partnerCode;
    }
}
