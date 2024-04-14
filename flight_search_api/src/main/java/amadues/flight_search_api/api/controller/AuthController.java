package amadues.flight_search_api.api.controller;

import amadues.flight_search_api.business.abstracts.AuthService;
import amadues.flight_search_api.business.requests.LoginRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;
    @PostMapping("/login")
    public String login(@RequestBody LoginRequest request)
    {
        return authService.login(request);
    }
}
