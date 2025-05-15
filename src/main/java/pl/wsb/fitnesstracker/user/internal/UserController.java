package pl.wsb.fitnesstracker.user.internal;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.wsb.fitnesstracker.user.api.User;
import pl.wsb.fitnesstracker.user.api.UserNotFoundException;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/v1/users")
@RequiredArgsConstructor
class UserController {

    private final UserServiceImpl userService;

    private final UserMapper userMapper;

    @GetMapping
    public List<UserDto> getAllUsers() {
        return userService.findAllUsers()
                .stream()
                .map(userMapper::toDto)
                .toList();
    }

    @PostMapping
    public ResponseEntity<UserDto> addUser(@RequestBody UserDto userDto) {
        User userToCreate = userMapper.toEntity(userDto);
        User createdUser = userService.createUser(userToCreate);
        UserDto createdUserDto = userMapper.toDto(createdUser);
        return ResponseEntity.status(201).body(createdUserDto);
    }

    @GetMapping("/simple")
    public List<SimpleUserDto> getAllSimpleUsers() {
        return userService.findAllUsers().stream().map(userMapper::toSimpleDto).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDto> getUserById(@PathVariable Long id) {
        return ResponseEntity.ok(userService.getUser(id)
                        .map(userMapper::toDto)
                        .orElseThrow(() -> new UserNotFoundException(id))
        );
    }

    @GetMapping("/email")
    public ResponseEntity<List<EmailOnlyUserDto>> getUsersByEmail(@RequestParam String email) {
        List<User> matchedUsers = userService.findUsersByEmailContainingIgnoreCase(email);
        List<EmailOnlyUserDto> result = matchedUsers.stream()
                .map(userMapper::toEmailOnlyDto)
                .toList();

        return ResponseEntity.ok(result);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateUser(@PathVariable Long id, @RequestBody UserDto userDto) {
        userService.updateUser(id, userMapper.toEntity(userDto));
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/older/{time}")
    public ResponseEntity<List<UserDto>> getUsersOlderThan(@PathVariable LocalDate time) {
        List<UserDto> result = userService.findUsersOlderThan(time)
                .stream()
                .map(userMapper::toDto)
                .toList();

        return ResponseEntity.ok(result);
    }

    @GetMapping("/search/email")
    public List<UserDto> findByEmailFragment(@RequestParam String fragment) {
        return userService.findUserByEmailFragment(fragment)
                .stream()
                .map(userMapper::toDto)
                .toList();
    }
}
