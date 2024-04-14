package amadues.flight_search_api.api.controller;

import amadues.flight_search_api.business.abstracts.AirportService;
import amadues.flight_search_api.business.requests.airport.CreateAirportRequest;
import amadues.flight_search_api.business.requests.airport.UpdateAirportRequest;
import amadues.flight_search_api.business.responses.GetAllAirportsResponse;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/airports")
@AllArgsConstructor
public class AirportController {
    private AirportService airportService;

    @GetMapping("/getall")
    public List<GetAllAirportsResponse> getAll(){
        return this.airportService.getAll();
    }

    @PostMapping("/add")
    public void add(@RequestBody() CreateAirportRequest createAirportRequest){
        this.airportService.add(createAirportRequest);
    }
    @PutMapping("/update")
    public void update(@RequestBody() UpdateAirportRequest updateAirportRequest){
        this.airportService.update(updateAirportRequest);
    }
    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable int id){
        this.airportService.delete(id);
    }
}
