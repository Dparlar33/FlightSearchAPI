package amadues.flight_search_api.api.controller;

import amadues.flight_search_api.business.abstracts.FlightSearchService;
import amadues.flight_search_api.business.requests.search.SearchOneWayFlightRequest;
import amadues.flight_search_api.business.requests.search.SearchTwoWayFlightRequest;
import amadues.flight_search_api.business.responses.GetAllFlightSearchResultResponse;
import amadues.flight_search_api.business.responses.GetAllTwoWayFlights;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/search")
@AllArgsConstructor
public class FlightSearchController {
    private FlightSearchService flightSearchService;
    @PostMapping("/askOneWay")
    public List<GetAllFlightSearchResultResponse> askOneWay(@RequestBody SearchOneWayFlightRequest searchOneWayFlightRequest){
        return this.flightSearchService.askOneWay(searchOneWayFlightRequest);
    }
    @PostMapping("/askTwoWay")
    public List<GetAllTwoWayFlights> askTwoWay(@RequestBody SearchTwoWayFlightRequest searchTwoWayFlightRequest){
        return this.flightSearchService.askTwoWay(searchTwoWayFlightRequest);
    }
}
