package akademia.services;

import akademia.model.dao.Address;
import akademia.repositories.AddresRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressService {

    private static final Logger logger = LoggerFactory.getLogger(AddressService.class);

    private AddresRepository addresRepository;

    public AddressService(AddresRepository addresRepository) {
        this.addresRepository = addresRepository;
    }

    public List<Address> getAddresses(){
        return addresRepository.findAll();
    }
}
