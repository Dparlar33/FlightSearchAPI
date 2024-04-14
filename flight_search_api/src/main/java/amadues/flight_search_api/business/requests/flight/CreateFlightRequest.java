package amadues.flight_search_api.business.requests.flight;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateFlightRequest {
    private int departureAirportId;
    private int arrivalAirportId;
    private LocalDateTime departureDate;
    private LocalDateTime arrivalDate;
    private double price;
}
