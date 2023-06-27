package id.co.indivara.jdt12.mpcarrent.services;

import id.co.indivara.jdt12.mpcarrent.models.*;
import id.co.indivara.jdt12.mpcarrent.models.DTO.CreateInvoiceDto;
import id.co.indivara.jdt12.mpcarrent.models.DTO.CreateRentDto;
import id.co.indivara.jdt12.mpcarrent.repository.*;
import lombok.RequiredArgsConstructor;
import org.hibernate.service.spi.ServiceException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.time.Duration;
import java.time.Instant;

import java.util.ArrayList;


@Service
@RequiredArgsConstructor
public class RentService  {

    private final RentRepository rentRepository;
    private final VehicleRepository vehicleRepository;
    private final DriverRepository driverRepository;
    private final CustomerRepository customerRepository;
    private final InvoiceRepository invoiceRepository;


    @Transactional
    public Rent saveRent(CreateRentDto createRentDto) throws Exception{
        Rent rent = new Rent();
        Customer customer = customerRepository.findById(createRentDto.getCustomerId()).orElseThrow(()-> new ServiceException("Customer not found"));

        if (createRentDto.getCustomerId() != null){
            rent.setVehicle(getVehicle(createRentDto.getVehicleId()));
        }
        if (createRentDto.getDriverId() != null){
            rent.setDriver(getEmployee(createRentDto.getDriverId()));
        }

        rent.setCustomer(customer);
        rent.setVehicleId(createRentDto.getVehicleId());
        rent.setDriverId(createRentDto.getDriverId());
        rent.setCustomerId(createRentDto.getCustomerId());

        rent.setStartHour(createRentDto.getStartHour());

        if (Instant.now().isBefore(createRentDto.getStartHour())){
            rent.setRentStatus(Rent.RentStatus.BOOKED);
        }else if (Instant.now().isAfter(createRentDto.getStartHour())){
            rent.setRentStatus(Rent.RentStatus.ON_GOING);
        }
        rentRepository.save(rent);
        return rent;
    }
    private Driver getEmployee(String driverId)throws Exception {
        Driver driver = driverRepository.findById(driverId).orElseThrow(()-> new Exception("driver not found"));
        String isDriverAvailable = rentRepository.findDriverAvailbility(driverId);
        if (isDriverAvailable != null && isDriverAvailable.equals(("no"))) {
            throw new Exception("Driver not available");
        }
        return driver;
    }



    private Vehicle getVehicle(String vehicleId)throws Exception {
        Vehicle vehicle = vehicleRepository.findById(vehicleId).orElseThrow(()->new Exception("Vehicle not found"));
        String isVehicleAvailble = rentRepository.findVehicleAvailbility(vehicleId);
        if (isVehicleAvailble != null && isVehicleAvailble.equals(("no"))) {
            throw new Exception("Vehicle not available");
        }
        return vehicle;
    }

    @Transactional
    public Invoice finishRent(CreateInvoiceDto createInvoiceDto, String id)throws Exception{
        if (invoiceRepository.existsByRentId(id)) {
            throw new Exception("Rent with ID " + id + " already has an invoice.");
        }
       Rent rent = rentRepository.findById(id).orElseThrow(()-> new Exception("rent_id not found"));
       rent.setRentStatus(Rent.RentStatus.RETURNED);
       rent.setActualEndHour(createInvoiceDto.getActualEndHour());
       rentRepository.save(rent);

        Invoice invoice = new Invoice();
        invoice.setRent(rent);
        invoice.setRentId(rent.getRentId());
        invoice.setCustomerName(rent.getCustomer().getName());

        invoice.setVehicleCost(rent.getVehicle().getVehiclePrice());

        Instant startHour= rent.getStartHour();
        Instant actualEndHour = createInvoiceDto.getActualEndHour();

        BigDecimal totalHours = new BigDecimal(Duration.between(startHour,actualEndHour).toHours());
        BigDecimal carCost = rent.getVehicle().getVehiclePrice();
        BigDecimal totalCost= totalHours.multiply(carCost);

        //jika pakai driver
        if (rent.getDriverId()!=null) {
            invoice.setInitialCost(totalCost);
            invoice.setDriverName(rent.getDriver().getDriverName());
            invoice.setDriverCost(rent.getDriver().getDriverPrice());
            BigDecimal dirverCost = rent.getDriver().getDriverPrice();
            BigDecimal withDriver = totalHours.multiply(dirverCost);
            invoice.setTotalCost(withDriver.add(invoice.getInitialCost()));
        }else {
            invoice.setDriverName("No Driver");
            invoice.setDriverCost(BigDecimal.valueOf(0));
            invoice.setInitialCost(totalCost);
            invoice.setTotalCost(totalCost);
        }
        invoiceRepository.save(invoice);
        return invoice;
    }

    public ArrayList<Rent> fetchAllRent() {
        return (ArrayList<Rent>) rentRepository.findAll();
    }

    public Rent findByRentId(String rentId) {
        Rent rent= rentRepository.findById(rentId).get();
        return rent;
    }
}
