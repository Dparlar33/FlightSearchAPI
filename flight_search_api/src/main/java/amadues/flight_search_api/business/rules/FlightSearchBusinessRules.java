package amadues.flight_search_api.business.rules;

import amadues.flight_search_api.business.requests.search.SearchOneWayFlightRequest;
import amadues.flight_search_api.business.requests.search.SearchTwoWayFlightRequest;
import amadues.flight_search_api.business.responses.GetAllTwoWayFlights;
import amadues.flight_search_api.dataAccess.AirportRepository;
import amadues.flight_search_api.dataAccess.FlightRepository;
import amadues.flight_search_api.entities.Airport;
import amadues.flight_search_api.entities.Flight;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Service
public class FlightSearchBusinessRules {
    private FlightRepository flightRepository;
    private AirportRepository airportRepository;

    public List<Flight> searchOneWayFlights(SearchOneWayFlightRequest searchOneWayFlightRequest){
        List<Airport> departureAirports = this.airportRepository.findAllByCityEquals(searchOneWayFlightRequest.getDepartureCity());
        List<Airport> arrivalAirports = this.airportRepository.findAllByCityEquals(searchOneWayFlightRequest.getArrivalCity());
        LocalDateTime flightDepartureDateMIN = searchOneWayFlightRequest.getDepartureDate().atStartOfDay().with(LocalTime.MIN);
        LocalDateTime flightDepartureDateMAX = searchOneWayFlightRequest.getDepartureDate().atStartOfDay().with(LocalTime.MAX);

        List<Flight> flights = new ArrayList<>();
        for (Airport airport: departureAirports){
            for (Airport airport1: arrivalAirports){
                flights.addAll(this.flightRepository.
                       findAllByDepartureAirportEqualsAndArrivalAirportEqualsAndDepartureDateBetween(
                               airport,airport1,flightDepartureDateMIN,flightDepartureDateMAX));
            }
        }

        return flights;
    }
    public List<GetAllTwoWayFlights> searchTwoWayFlights(SearchTwoWayFlightRequest searchTwoWayFlightRequest) {
        List<Airport> departureAirports = this.airportRepository.findAllByCityEquals(searchTwoWayFlightRequest.getArrivalCity());
        List<Airport> arrivalAirports = this.airportRepository.findAllByCityEquals(searchTwoWayFlightRequest.getDepartureCity());
        LocalDateTime flightDepartureDateMIN = searchTwoWayFlightRequest.getReturnDate().atStartOfDay().with(LocalTime.MIN);
        LocalDateTime flightDepartureDateMAX = searchTwoWayFlightRequest.getReturnDate().atStartOfDay().with(LocalTime.MAX);


        List<Flight> returnFlights = new ArrayList<>();
        for (Airport airport: departureAirports){
            for (Airport airport1: arrivalAirports){
                returnFlights.addAll(this.flightRepository.
                        findAllByDepartureAirportEqualsAndArrivalAirportEqualsAndDepartureDateBetween(
                                airport,airport1,flightDepartureDateMIN,flightDepartureDateMAX));
            }
        }
        return createMapWithDepartureAndReturnFlights(returnFlights,searchTwoWayFlightRequest);
    }

    public List<GetAllTwoWayFlights> createMapWithDepartureAndReturnFlights(List<Flight> returnFlights,SearchTwoWayFlightRequest searchTwoWayFlightRequest) {
        SearchOneWayFlightRequest searchOneWayFlightRequest = new SearchOneWayFlightRequest();
        searchOneWayFlightRequest.setDepartureCity(searchTwoWayFlightRequest.getDepartureCity());
        searchOneWayFlightRequest.setArrivalCity(searchTwoWayFlightRequest.getArrivalCity());
        searchOneWayFlightRequest.setDepartureDate(searchTwoWayFlightRequest.getDepartureDate());
        List<Flight> departureFlight = searchOneWayFlights(searchOneWayFlightRequest);

        List<GetAllTwoWayFlights> getAllTwoWayFlights = new ArrayList<>();
        for (Flight flight:departureFlight){
            for (Flight flight1:returnFlights){
                if (!isReturnDateBeforeDepartureDate(flight.getDepartureDate(),flight1.getDepartureDate())){
                    System.out.println("DONUS TARİHİ GİDİS TARİHİNDEN ONCE!");
                }else {
                     getAllTwoWayFlights.add(new GetAllTwoWayFlights(flight,flight1));
                }
            }
        }
        return getAllTwoWayFlights;
    }

    public boolean isReturnDateBeforeDepartureDate(LocalDateTime departureDate,LocalDateTime returnDate){
        return !returnDate.isBefore(departureDate);
    }
}
