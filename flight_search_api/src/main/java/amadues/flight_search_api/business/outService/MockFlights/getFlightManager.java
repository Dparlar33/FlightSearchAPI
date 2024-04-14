package amadues.flight_search_api.business.outService.MockFlights;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
@AllArgsConstructor
public class getFlightManager implements getFlightService{
    private RestTemplate restTemplate;
    @Override
    public CreatedFlightResponse[] getFlights() {
        String url = "https://run.mocky.io/v3/040aa26d-f81e-43fd-ae7a-384f3a575877";
        ResponseEntity<CreatedFlightResponse[]> createdFlightResponse =
                this.restTemplate.getForEntity(url,CreatedFlightResponse[].class);
        return createdFlightResponse.getBody();
    }
}
