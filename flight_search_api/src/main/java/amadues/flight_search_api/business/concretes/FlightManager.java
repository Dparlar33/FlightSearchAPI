package amadues.flight_search_api.business.concretes;

import amadues.flight_search_api.business.abstracts.FlightService;
import amadues.flight_search_api.business.requests.flight.CreateFlightRequest;
import amadues.flight_search_api.business.requests.flight.UpdateFlightRequest;
import amadues.flight_search_api.business.responses.GetAllFlightsResponse;
import amadues.flight_search_api.core.mappers.ModelMapperService;
import amadues.flight_search_api.dataAccess.FlightRepository;
import amadues.flight_search_api.entities.Flight;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class FlightManager implements FlightService {
    private ModelMapperService modelMapperService;
    private FlightRepository flightRepository;
    @Override
    public void add(CreateFlightRequest createFlightRequest) {
        Flight flight = this.modelMapperService.forRequest().map(createFlightRequest,Flight.class);
        this.flightRepository.save(flight);
    }
    @Override
    public List<GetAllFlightsResponse> getAll() {
        List<Flight> flights = this.flightRepository.findAll();
        return flights.stream().map(flight -> this.modelMapperService.forResponse().
                map(flight, GetAllFlightsResponse.class)).collect(Collectors.toList());
    }
    @Override
    public void delete(int id) {
        this.flightRepository.deleteById(id);
    }

    @Override
    public void update(UpdateFlightRequest updateFlightRequest) {
        Flight flight = this.modelMapperService.forRequest().map(updateFlightRequest,Flight.class);
        this.flightRepository.save(flight);
    }
}
