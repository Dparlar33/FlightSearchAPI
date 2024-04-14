package amadues.flight_search_api.business.concretes;

import amadues.flight_search_api.business.abstracts.AirportService;
import amadues.flight_search_api.business.requests.airport.CreateAirportRequest;
import amadues.flight_search_api.business.requests.airport.UpdateAirportRequest;
import amadues.flight_search_api.business.responses.GetAllAirportsResponse;
import amadues.flight_search_api.dataAccess.AirportRepository;
import amadues.flight_search_api.entities.Airport;
import amadues.flight_search_api.core.mappers.ModelMapperService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class AirportManager implements AirportService {
    private AirportRepository airportRepository;
    private ModelMapperService modelMapperService;
    @Override
    public List<GetAllAirportsResponse> getAll() {
        List<Airport> airports = this.airportRepository.findAll();

        return airports.stream().map(airport -> this.modelMapperService.forResponse().
                map(airport,GetAllAirportsResponse.class)).collect(Collectors.toList());
    }

    @Override
    public void add(CreateAirportRequest createAirportRequest) {
        Airport airport = this.modelMapperService.forRequest().
                map(createAirportRequest,Airport.class);

        this.airportRepository.save(airport);
    }

    @Override
    public void delete(int id) {
        this.airportRepository.deleteById(id);
    }

    @Override
    public void update(UpdateAirportRequest updateAirportRequest) {
        Airport airport = this.modelMapperService.forRequest().
                map(updateAirportRequest,Airport.class);

        this.airportRepository.save(airport);
    }
}
