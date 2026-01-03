package adam.os.userservice.user.persistence;

import adam.os.userservice.user.UserDetails;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Repository
public class UserRepository {

    private final Map<String, UserDetails> users = new HashMap<>();
    private long idCounter = 6; // Start from 6 since we have 5 initial users

    public UserRepository() {
        // Initialize with 5 test users
        users.put("1", new UserDetails("1", "John Doe", "john.doe@example.com"));
        users.put("2", new UserDetails("2", "Jane Smith", "jane.smith@example.com"));
        users.put("3", new UserDetails("3", "Bob Johnson", "bob.johnson@example.com"));
        users.put("4", new UserDetails("4", "Alice Williams", "alice.williams@example.com"));
        users.put("5", new UserDetails("5", "Charlie Brown", "charlie.brown@example.com"));
    }
    public UserDetails save(String name, String email) {
        String id = String.valueOf(idCounter++);
        UserDetails user = new UserDetails(id, name, email);
        users.put(id, user);
        return user;
    }

    public Optional<UserDetails> findById(String id) {
        return Optional.ofNullable(users.get(id));
    }

    public List<UserDetails> findAll() {
        return List.copyOf(users.values());
    }

    public Optional<UserDetails> update(String id, String name, String email) {
        if (!users.containsKey(id)) {
            return Optional.empty();
        }
        UserDetails updatedUser = new UserDetails(id, name, email);
        users.put(id, updatedUser);
        return Optional.of(updatedUser);
    }

    public boolean deleteById(String id) {
        return users.remove(id) != null;
    }
}
