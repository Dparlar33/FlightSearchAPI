package amadues.flight_search_api.dataAccess;

import amadues.flight_search_api.entities.Airport;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AirportRepository extends JpaRepository<Airport,Integer> {
    List<Airport> findAllByCityEquals(String city);
}
