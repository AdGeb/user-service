package adam.os.userservice.user.endpoint;

import adam.os.userservice.user.UserCreationRequest;
import adam.os.userservice.user.UserDetails;
import adam.os.userservice.user.UserService;
import adam.os.userservice.user.endpoint.model.UserDetailsDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
class UserEndpoint {

    private final UserService userService;

    @GetMapping("/{id}")
    UserDetailsDto getUserById(@PathVariable String id) {
        UserDetails userDetails = userService.getUserDetails(id);
        return new UserDetailsDto(userDetails.id(), userDetails.name(), userDetails.email());
    }

    @PostMapping
    String createUser(@RequestBody UserCreationRequest request) {
        return userService.createUser(request);
    }
}
