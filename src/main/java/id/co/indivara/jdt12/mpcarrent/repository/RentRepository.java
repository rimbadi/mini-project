package id.co.indivara.jdt12.mpcarrent.repository;

import id.co.indivara.jdt12.mpcarrent.models.Rent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RentRepository extends JpaRepository<Rent,String> {
    @Query(value = "SELECT \n" +
            "(CASE WHEN r.rent_status <> 2 THEN 'no' ELSE 'yes' END) AS result\n" +
            "FROM trx_rents r\n" +
            "WHERE\n" +
            "r.vehicle_id = :vehicleId \n" +
            "ORDER BY \n" +
            "r.update_date_time DESC \n" +
            "LIMIT 1",nativeQuery = true)
    String findVehicleAvailbility(@Param("vehicleId") String vehicleId);
    @Query(value = "SELECT \n" +
            "(CASE WHEN r.rent_status <> 2 THEN 'no' ELSE 'yes' END) AS result\n" +
            "FROM trx_rents r\n" +
            "WHERE\n" +
            "r.driver_id = :driverId \n" +
            "ORDER BY \n" +
            "r.update_date_time DESC \n" +
            "LIMIT 1",nativeQuery = true)
    String findDriverAvailbility(@Param("driverId") String driverId);
}
