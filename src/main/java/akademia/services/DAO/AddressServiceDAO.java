package akademia.services.DAO;

import akademia.model.dao.Address;
import akademia.repositories.AddressRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressServiceDAO {

    private AddressRepository addressRepository;

    public AddressServiceDAO(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    public List<Address> getAddresses(){
        return addressRepository.findAll();
    }
}
