package tu.project.jobfinder.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tu.project.jobfinder.entities.User;
import tu.project.jobfinder.repositories.UserRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    UserRepository userRepository;

    @GetMapping("/all")
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @GetMapping("/id/{id}")
    public User getUserById(@PathVariable Long id) {
        Optional<User> result = userRepository.findById(id);
        return result.isPresent() ? result.get() : null;
    }

    @PostMapping("/save")
    public ResponseEntity<?> saveUser(@RequestParam(required = false) Long id,
                                      @RequestParam(required = false) String username,
                                      @RequestParam(required = false) String password,
                                      @RequestParam(required = false) String first_name,
                                      @RequestParam(required = false) String last_name,
                                      @RequestParam(required = false) String email) {

        boolean isNew = id == null;

        User user = new User(id, username, password, first_name, last_name, email);
        user = userRepository.save(user);

        Map<String, Object> response = new HashMap<>();
        response.put("generatedId", user.getId());
        response.put("generatedUsername", user.getUsername());
        response.put("generatedPassword", user.getPassword());
        response.put("generatedFirstName", user.getFirstName());
        response.put("generatedLastName", user.getLastName());
        response.put("generatedEmail", user.getEmail());
        if (isNew) {
            response.put("message", "Successfully added!");
        } else {
            response.put("message", "Successfully edited!");
        }

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable Long id) {

        if (!userRepository.existsById(id)) {
            return ResponseEntity.ok("No such User!");
        }
        userRepository.deleteById(id);
        return ResponseEntity.ok("Deleted successfully!");
    }
}
