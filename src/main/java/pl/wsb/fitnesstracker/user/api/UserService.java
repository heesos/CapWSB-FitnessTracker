package pl.wsb.fitnesstracker.user.api;

/**
 * Interface (API) for modifying operations on {@link User} entities through the API.
 * Implementing classes are responsible for executing changes within a database transaction, whether by continuing an existing transaction or creating a new one if required.
 */
public interface UserService {

    /**
     * Creates and persists a new {@link User} in the database.
     *
     * @param user the {@link User} object to be created
     * @return the persisted {@link User} object with a generated ID
     * @throws IllegalArgumentException if the provided user already has an ID
     */
    User createUser(User user);

    /**
     * Deletes a {@link User} from the database based on the provided ID.
     *
     * @param id the ID of the user to be deleted
     * @throws UserNotFoundException if no user with the specified ID exists
     */
    void deleteUser(Long id);

    /**
     * Updates the data of an existing {@link User} identified by the given ID.
     * The user's fields will be overwritten with values from the provided {@code updatedUser} object.
     *
     * @param id the ID of the user to be updated
     * @param updatedUser a {@link User} object containing updated data
     * @throws UserNotFoundException if no user with the specified ID exists
     */
    void updateUser(Long id, User updatedUser);
}
