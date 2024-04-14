package amadues.flight_search_api.business.abstracts;

import amadues.flight_search_api.business.requests.search.SearchOneWayFlightRequest;
import amadues.flight_search_api.business.requests.search.SearchTwoWayFlightRequest;
import amadues.flight_search_api.business.responses.GetAllFlightSearchResultResponse;
import amadues.flight_search_api.business.responses.GetAllTwoWayFlights;

import java.util.List;

public interface FlightSearchService {
    List<GetAllFlightSearchResultResponse> askOneWay(SearchOneWayFlightRequest searchOneWayFlightRequest);
    List<GetAllTwoWayFlights> askTwoWay(SearchTwoWayFlightRequest searchTwoWayFlightRequest);
}
