package amadues.flight_search_api.business.abstracts;

import amadues.flight_search_api.business.requests.LoginRequest;

public interface AuthService {
    String login(LoginRequest request);
}
