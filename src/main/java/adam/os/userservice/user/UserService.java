package adam.os.userservice.user;

public interface UserService {
    UserDetails getUserDetails(String userId);
    String createUser(UserCreationRequest request);
}
