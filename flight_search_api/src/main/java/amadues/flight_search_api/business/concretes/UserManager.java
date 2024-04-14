package amadues.flight_search_api.business.concretes;

import amadues.flight_search_api.business.abstracts.UserService;
import amadues.flight_search_api.business.requests.RegisterRequest;
import amadues.flight_search_api.dataAccess.UserRepository;
import amadues.flight_search_api.entities.User;
import amadues.flight_search_api.core.mappers.ModelMapperService;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class UserManager implements UserService {
    private final UserRepository userRepository;
    private final ModelMapperService modelMapperService;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void register(RegisterRequest request) {
        User user = modelMapperService.forRequest().map(request, User.class);
        String encodedPassword = passwordEncoder.encode(request.getPassword());
        user.setPassword(encodedPassword);

        userRepository.save(user);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return null;
    }
}
