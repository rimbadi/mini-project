package id.co.indivara.jdt12.mpcarrent.services;

import id.co.indivara.jdt12.mpcarrent.models.Driver;
import id.co.indivara.jdt12.mpcarrent.repository.DriverRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
@Service
@RequiredArgsConstructor
public class DriverService {

    private final DriverRepository driverRepository;

    @Transactional
    public Driver saveDriver(Driver driver) {
        return driverRepository.save(driver);
    }

    
    @Transactional
    public Driver updateDriver(Driver driver, Long id) throws Exception{
        Driver driverDB=driverRepository.findById(id).orElseThrow(Exception::new);
        driverDB.setDriverId(driver.getDriverId());
        driverDB.setDriverName(driver.getDriverName());
        driverDB.setDriverPrice(driver.getDriverPrice());
        driverDB.setAddress(driver.getAddress());
        driverDB.setPhoneNumber(driver.getPhoneNumber());
        return driverRepository.save(driver);
    }

    
    public List<Driver> fetchAllDriver() {
        return driverRepository.findAll();
    }

    
    public void deleteDriverById(Long id) {
        driverRepository.deleteById(id);
    }
}
