package id.co.indivara.jdt12.mpcarrent.services;

import id.co.indivara.jdt12.mpcarrent.models.Driver;

import java.util.List;

public interface DriverService{
    Driver saveDriver(Driver driver);
    Driver updateDriver(Driver driver, Long id) throws Exception;
    List<Driver> fetchAllDriver();
    void deleteDriverById(Long id);
}
