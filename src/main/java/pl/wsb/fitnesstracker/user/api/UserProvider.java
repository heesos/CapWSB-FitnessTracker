package pl.wsb.fitnesstracker.user.api;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface UserProvider {

    /**
     * Retrieves a user based on their ID.
     * If the user with given ID is not found, then {@link Optional#empty()} will be returned.
     *
     * @param userId id of the user to be searched
     * @return An {@link Optional} containing the located user, or {@link Optional#empty()} if not found
     */
    Optional<User> getUser(Long userId);

    /**
     * Retrieves a user based on their email.
     * If the user with given email is not found, then {@link Optional#empty()} will be returned.
     *
     * @param email The email of the user to be searched
     * @return An {@link Optional} containing the located user, or {@link Optional#empty()} if not found
     */
    Optional<User> getUserByEmail(String email);

    /**
     * Retrieves all users.
     *
     * @return An {@link Optional} containing the all users,
     */
    List<User> findAllUsers();

    /**
     * Retrieves all users whose birthdate is earlier than the specified date,
     * meaning they are older than the provided date.
     *
     * @param date the cutoff {@link LocalDate}; only users born before this date will be returned
     * @return a {@link List} of {@link User} objects older than the given date;
     *         an empty list if no such users exist
     */
    List<User> findUsersOlderThan(LocalDate date);

    /**
     * Retrieves a list of users whose email addresses contain the specified fragment.
     *
     * @param emailFragment  fragment of the email address to search for
     * @return a list of {@link User} objects matching the given email fragment; never {@code null}, but possibly empty
     */
    List<User> findUserByEmailFragment(String emailFragment);
}
