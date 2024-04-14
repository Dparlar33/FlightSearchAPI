package amadues.flight_search_api.business.requests.airport;


import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateAirportRequest {
    private String name;
    private String city;
}
