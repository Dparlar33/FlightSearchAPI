package amadues.flight_search_api.dataAccess;

import amadues.flight_search_api.entities.Airport;
import amadues.flight_search_api.entities.Flight;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;


public interface FlightRepository extends JpaRepository<Flight,Integer> {
    List<Flight>
    findAllByDepartureAirportEqualsAndArrivalAirportEqualsAndDepartureDateBetween
            (Airport departureAirport, Airport arrivalAirport,LocalDateTime departureDate,LocalDateTime departureDate2);
}
