package amadues.flight_search_api.business.responses;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllAirportsResponse {
    private int id;
    private String name;
    private String city;
}
