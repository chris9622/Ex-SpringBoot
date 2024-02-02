package crudtest.crudtest.Services;

import crudtest.crudtest.Models.User;

import java.util.List;
import java.util.Optional;

// business logic component

public interface UserService {

    // CRUD
    public User createUser(User user);

    public User updateUser(User user,long id);

    public User getUserByName(String name);

    public Optional<User> getUserById(long id);

    public List<User> getAllUsers();

    public void deleteUser(long id);

}
