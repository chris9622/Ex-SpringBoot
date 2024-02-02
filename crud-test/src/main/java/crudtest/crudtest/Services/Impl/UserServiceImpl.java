package crudtest.crudtest.Services.Impl;

import crudtest.crudtest.Models.User;
import crudtest.crudtest.Repository.UserRepository;
import crudtest.crudtest.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserServiceImpl implements UserService {


    @Autowired
    private UserRepository repository;

    @Override
    public User createUser(User user) {
        return repository.save(user);
    }

    @Override
    public User updateUser(User user,long id) {
        Optional<User> userUptated = repository.findById(id);
        if(userUptated.isPresent()){
            userUptated.get().setName(user.getName());
            userUptated.get().setSurname(user.getSurname());
            repository.save(userUptated.get());
            return userUptated.get();
        }
        return null;

    }

    @Override
    public User getUserByName(String name){
        return repository.findByName(name);
    }


    public Optional<User> getUserById(long id) {
        return repository.findById(id);
    }

    @Override
    public List<User> getAllUsers() {
        return this.repository.findAll();
    }

    @Override
    public void deleteUser(long id) {
        repository.deleteById(id);
    }
}
