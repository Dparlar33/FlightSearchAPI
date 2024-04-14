package amadues.flight_search_api.business.requests.search;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SearchTwoWayFlightRequest {
    private String departureCity;
    private String arrivalCity;
    private LocalDate departureDate;
    private LocalDate returnDate;
}
