package adam.os.userservice.user.service;

import adam.os.userservice.user.UserCreationRequest;
import adam.os.userservice.user.UserDetails;
import adam.os.userservice.user.UserService;
import adam.os.userservice.user.persistence.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository repository;

    @Override
    public UserDetails getUserDetails(String userId) {
        return repository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("User not found"));
    }

    @Override
    public String createUser(UserCreationRequest request) {
        return repository.save(request.name(), request.email()).id();
    }
}
