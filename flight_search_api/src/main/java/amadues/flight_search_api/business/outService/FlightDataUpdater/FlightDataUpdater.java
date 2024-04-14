package amadues.flight_search_api.business.outService.FlightDataUpdater;

import amadues.flight_search_api.business.outService.MockFlights.CreatedFlightResponse;
import amadues.flight_search_api.business.outService.MockFlights.getFlightService;
import amadues.flight_search_api.core.mappers.ModelMapperService;
import amadues.flight_search_api.dataAccess.FlightRepository;
import amadues.flight_search_api.entities.Flight;
import lombok.AllArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class FlightDataUpdater {
    private getFlightService getFlightService;
    private ModelMapperService modelMapperService;
    private FlightRepository flightRepository;

    @Scheduled(fixedRate = 86400000)
    public void updateFlightData(){
       CreatedFlightResponse[] createdFlightResponseList = getFlightService.getFlights();

       for (CreatedFlightResponse createdFlightResponse : createdFlightResponseList){
           Flight flight = this.modelMapperService.forResponse().map(createdFlightResponse, Flight.class);
           this.flightRepository.save(flight);
       }
    }
}
