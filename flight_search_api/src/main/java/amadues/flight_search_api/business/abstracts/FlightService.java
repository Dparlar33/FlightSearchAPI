package amadues.flight_search_api.business.abstracts;

import amadues.flight_search_api.business.requests.flight.CreateFlightRequest;
import amadues.flight_search_api.business.requests.flight.UpdateFlightRequest;
import amadues.flight_search_api.business.responses.GetAllFlightsResponse;

import java.util.List;

public interface FlightService {
    List<GetAllFlightsResponse> getAll();
    void add(CreateFlightRequest createFlightRequest);
    void delete(int id);
    void update(UpdateFlightRequest updateFlightRequest);
}
