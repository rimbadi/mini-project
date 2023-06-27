package id.co.indivara.jdt12.mpcarrent.services;

import id.co.indivara.jdt12.mpcarrent.models.Driver;
import id.co.indivara.jdt12.mpcarrent.repository.DriverRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class DriverService {

    private final DriverRepository driverRepository;

    @Transactional
    public Driver saveDriver(Driver driver) throws Exception {
        if (driverRepository.existsByPhoneNumber()){
            throw new Exception("Phone number already exists");
        }
        return driverRepository.save(driver);
    }

    
    @Transactional
    public Driver updateDriver(Driver driver, String driverId)throws Exception{
        Driver driv = driverRepository.findById(driverId).orElseThrow(()->new Exception("Driver not found!"));
        if (Objects.nonNull(driver.getDriverName())&&!"".equalsIgnoreCase(driver.getDriverName())){
            driv.setDriverName(driver.getDriverName());
        }
        if (Objects.nonNull(driver.getAddress())&&!"".equalsIgnoreCase(driver.getAddress())){
            driv.setAddress(driver.getAddress());
        }
        if (Objects.nonNull(driver.getPhoneNumber())&&!"".equalsIgnoreCase(driver.getPhoneNumber())){
            driv.setPhoneNumber(driver.getPhoneNumber());
        }
        if (Objects.nonNull(driver.getDriverPrice())){
            driv.setDriverPrice(driver.getDriverPrice());
        }
        return driverRepository.save(driv);
    }

    public List<Driver> fetchAllDriver() {
        return driverRepository.findAll();
    }
    public void deleteDriverById(String driverId)throws Exception {
        driverRepository.findById(driverId).orElseThrow(()->new Exception("Driver not found!"));
        driverRepository.deleteById(driverId);
    }
    public Driver findByDriverId(String driverId) {
        Driver driver = driverRepository.findById(driverId).get();
        return driver;
    }
}
