package amadues.flight_search_api.business.concretes;

import amadues.flight_search_api.business.abstracts.AuthService;
import amadues.flight_search_api.business.abstracts.UserService;
import amadues.flight_search_api.business.requests.LoginRequest;
import amadues.flight_search_api.core.security.services.JwtService;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class AuthManager implements AuthService {
    private final UserService userService;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;

    @Override
    public String login(LoginRequest request) {
        return null;
    }
}
