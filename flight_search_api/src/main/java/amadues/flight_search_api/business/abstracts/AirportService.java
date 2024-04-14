package amadues.flight_search_api.business.abstracts;

import amadues.flight_search_api.business.requests.airport.CreateAirportRequest;
import amadues.flight_search_api.business.requests.airport.UpdateAirportRequest;
import amadues.flight_search_api.business.responses.GetAllAirportsResponse;

import java.util.List;

public interface AirportService {
    List<GetAllAirportsResponse> getAll();
    void add(CreateAirportRequest createAirportRequest);
    void delete(int id);
    void update(UpdateAirportRequest updateAirportRequest);
}
