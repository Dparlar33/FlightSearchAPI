package amadues.flight_search_api.business.concretes;

import amadues.flight_search_api.business.abstracts.FlightSearchService;
import amadues.flight_search_api.business.requests.search.SearchOneWayFlightRequest;
import amadues.flight_search_api.business.requests.search.SearchTwoWayFlightRequest;
import amadues.flight_search_api.business.responses.GetAllFlightSearchResultResponse;
import amadues.flight_search_api.business.responses.GetAllTwoWayFlights;
import amadues.flight_search_api.business.rules.FlightSearchBusinessRules;
import amadues.flight_search_api.core.mappers.ModelMapperService;
import amadues.flight_search_api.entities.Flight;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class FlightSearchManager implements FlightSearchService {
    private ModelMapperService modelMapperService;
    private FlightSearchBusinessRules flightSearchBusinessRules;
    @Override
    public List<GetAllFlightSearchResultResponse> askOneWay(SearchOneWayFlightRequest searchOneWayFlightRequest) {
       List<Flight> flights = this.flightSearchBusinessRules.searchOneWayFlights(searchOneWayFlightRequest);
       return flights.stream().map(flight -> this.modelMapperService.forResponse().
               map(flight, GetAllFlightSearchResultResponse.class)).collect(Collectors.toList());
    }

    @Override
    public List<GetAllTwoWayFlights> askTwoWay(SearchTwoWayFlightRequest searchTwoWayFlightRequest) {
        return this.flightSearchBusinessRules.searchTwoWayFlights(searchTwoWayFlightRequest);
    }
}
