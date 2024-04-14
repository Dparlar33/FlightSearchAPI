package amadues.flight_search_api.business.rules;

import java.time.LocalDateTime;

public class FlightBusinessRules {
    public boolean isNull(LocalDateTime returnDate){
        return returnDate == null;
    };
}
