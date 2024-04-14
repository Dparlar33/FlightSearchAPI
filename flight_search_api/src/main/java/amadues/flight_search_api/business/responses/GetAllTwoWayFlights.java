package amadues.flight_search_api.business.responses;


import amadues.flight_search_api.entities.Flight;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class GetAllTwoWayFlights {
    private Flight departureFlight;
    private Flight returnFlight;
}
