package id.co.indivara.jdt12.mpcarrent.implement;

import id.co.indivara.jdt12.mpcarrent.models.Driver;
import id.co.indivara.jdt12.mpcarrent.repository.DriverRepository;
import id.co.indivara.jdt12.mpcarrent.services.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DriverImpl implements DriverService {
    @Autowired
    DriverRepository driverRepository;

    @Override
    public Driver saveDriver(Driver driver) {
        return driverRepository.save(driver);
    }

    @Override
    public Driver updateDriver(Driver driver, Long id) throws Exception{
        Driver driverDB=driverRepository.findById(id).orElseThrow(()-> new Exception());
        driverDB.setDriverId(driver.getDriverId());
        driverDB.setDriverName(driver.getDriverName());
        driverDB.setDriverPrice(driver.getDriverPrice());
        driverDB.setAddress(driver.getAddress());
        driverDB.setContact(driver.getContact());
        return driverRepository.save(driver);
    }

    @Override
    public List<Driver> fetchAllDriver() {
        return driverRepository.findAll();
    }

    @Override
    public void deleteDriverById(Long id) {
        driverRepository.deleteById(id);
    }
}
