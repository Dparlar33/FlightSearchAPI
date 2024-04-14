package amadues.flight_search_api.business.outService.MockFlights;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetFlightsRequest {
    private LocalDate today;
}
