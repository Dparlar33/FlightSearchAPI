package amadues.flight_search_api.business.abstracts;

import amadues.flight_search_api.business.requests.RegisterRequest;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    void register(RegisterRequest request);
}
