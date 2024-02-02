package crudtest.crudtest.Controllers;

import crudtest.crudtest.Models.User;
import crudtest.crudtest.Services.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/prova")
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;


    @PostMapping("/add")
    public User create(@RequestBody User user){
        return userService.createUser(user);
    }

    @GetMapping("/get/{id}")
    public Optional<User> getUser(@PathVariable long id){
        return userService.getUserById(id);
    }


    @PutMapping("/update/{id}")
    public User updateUsers(@RequestBody User user, @PathVariable long id){
        return userService.updateUser(user,id);
    }

    @DeleteMapping("/remove/{id}")
    public void deleteUser(@PathVariable long id) throws Exception{
       try{
           userService.deleteUser(id);
           log.info("user cancelled");
       }catch (Exception e){
           log.error("ERROR");
       }
    }

    @GetMapping("/getAll")
    public List<User> allUsers(){
        return this.userService.getAllUsers();
    }
}
