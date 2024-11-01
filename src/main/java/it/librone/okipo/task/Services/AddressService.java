package it.librone.okipo.task.Services;

import it.librone.okipo.task.entities.Address;
import it.librone.okipo.task.repositories.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressService {
    @Autowired
    private AddressRepository addressRepository;

    public boolean exists(String address) {
        return addressRepository.existsByEthAddress(address);
    }

    public Address getByEthAddress(String address) {
        return addressRepository.findByEthAddress(address).orElse(null);
    }

    public Address saveAddress(Address address) {
        return addressRepository.save(address);
    }

    public Address saveAddress(String address) {
        Address add= new Address();
        add.setEthAddress(address);
        return addressRepository.save(add);
    }

    public void save(Long id) {
        addressRepository.deleteById(id);
    }
    public void updateAddress(Address address) {
        addressRepository.save(address);
    }
}
