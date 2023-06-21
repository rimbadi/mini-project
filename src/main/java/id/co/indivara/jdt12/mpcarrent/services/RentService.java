package id.co.indivara.jdt12.mpcarrent.services;

import id.co.indivara.jdt12.mpcarrent.error.VehicleNotFoundException;
import id.co.indivara.jdt12.mpcarrent.models.Customer;
import id.co.indivara.jdt12.mpcarrent.models.DTO.RentalDtoReq;
import id.co.indivara.jdt12.mpcarrent.models.Driver;
import id.co.indivara.jdt12.mpcarrent.models.Rent;
import id.co.indivara.jdt12.mpcarrent.models.Vehicle;
import id.co.indivara.jdt12.mpcarrent.repository.CustomerRepository;
import id.co.indivara.jdt12.mpcarrent.repository.DriverRepository;
import id.co.indivara.jdt12.mpcarrent.repository.RentRepository;
import id.co.indivara.jdt12.mpcarrent.repository.VehicleRepository;
import lombok.RequiredArgsConstructor;
import org.hibernate.service.spi.ServiceException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class RentService  {

    private final RentRepository rentRepository;
    private final VehicleRepository vehicleRepository;
    private final DriverRepository driverRepository;
    private final CustomerRepository customerRepository;



    @Transactional
    public Rent saveRent(RentalDtoReq rentalDtoReq) {
        //TODO: create customer
        Customer customer = getCustomer(rentalDtoReq.getCustomerId());
        //TODO: get vehicle
        Vehicle vehicle = getVehicle(rentalDtoReq.getVehicleId());
        //TODO: get driver
        Driver driver = getEmployee(rentalDtoReq.getDriverId());
        //TODO: create/save transaction rental
        Rent rent = new Rent();
        if (rentalDtoReq.getDriverId() != null){
            rent.setDriverId(driver.getDriverId());
        }
        rent.setVehicleId(vehicle.getVehicleId());
        rent.setCustomerId(customer.getCustomerId());
        rent.setStartHour(rentalDtoReq.getStartHour());
        rent.setPlannedEndHour(rentalDtoReq.getPlannedEndHour());
        rent.setActualEndHour(rentalDtoReq.getActualEndHour());
        if (Instant.now().isBefore(rent.getActualEndHour())){
            rent.setRentStatus(Rent.RentStatus.RENTED);
        }else {
            rent.setRentStatus(Rent.RentStatus.ON_GOING);
        }
        return rentRepository.save(rent);
    }

    private Driver getEmployee(Long driverId) {
        return driverRepository.findById(driverId).orElse(null);
    }
    private Customer getCustomer(Long customerID){
        return customerRepository.findById(customerID).orElseThrow(()-> new ServiceException("Customer not found"));
    }

    private Vehicle getVehicle(long vehicleId) {
        return vehicleRepository.findById(vehicleId).orElseThrow(()-> new VehicleNotFoundException(vehicleId));
    }

//    private Customer createCustomer(RentalDtoReq rentalDtoReq) {
//        Customer customer = new Customer();
//        customer.setName(rentalDtoReq.getCustomerName());
//        customer.setEmail(rentalDtoReq.getCustomerEmail());
//        customer.setAddress(rentalDtoReq.getCustomerAddress());
//        customer.setPhoneNumber(rentalDtoReq.getCustomerPhoneNumber());
//        customer.setKtpNumber(rentalDtoReq.getCustomerKtpNumber());
//
//        return customer;
//    }

    @Transactional
    public Rent updateRent(Rent rent, Long rentId) {
        Rent rentDB = rentRepository.findById(rentId).get();
        rentDB.setRentId(rent.getRentId());
        rentDB.setCustomerId(rent.getCustomerId());
        rentDB.setDriverId(rent.getDriverId());
        rentDB.setVehicleId(rent.getVehicleId());
        rentDB.setStartHour(rent.getStartHour());
        rentDB.setPlannedEndHour(rent.getPlannedEndHour());
        rentDB.setActualEndHour(rent.getActualEndHour());
        rentDB.setRentStatus(rent.getRentStatus());
        return rentRepository.save(rentDB);
    }

    
    public List<Rent> fetchAllRent() {
        return rentRepository.findAll();
    }



    
    public List<Rent> findByRentId(String rentId) {
        ArrayList<Rent> rents= (ArrayList<Rent>) rentRepository.findByRentId(rentId);
        return rents;
    }
}
