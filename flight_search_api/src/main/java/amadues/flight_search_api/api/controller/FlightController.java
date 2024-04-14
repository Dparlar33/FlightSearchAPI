package amadues.flight_search_api.api.controller;


import amadues.flight_search_api.business.abstracts.FlightService;
import amadues.flight_search_api.business.requests.flight.CreateFlightRequest;
import amadues.flight_search_api.business.requests.flight.UpdateFlightRequest;
import amadues.flight_search_api.business.responses.GetAllFlightsResponse;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/flights")
public class FlightController {
    private FlightService flightService;

    @GetMapping("/getall")
    public List<GetAllFlightsResponse> getAllFlights(){
        return this.flightService.getAll();
    }

    @PostMapping("/add")
    public void add(@RequestBody() CreateFlightRequest createFlightRequest){
        this.flightService.add(createFlightRequest);
    }
    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable int id){
        this.flightService.delete(id);
    }

    @PutMapping("/update")
    public void update(@RequestBody() UpdateFlightRequest updateFlightRequest){
        this.flightService.update(updateFlightRequest);
    }

}
