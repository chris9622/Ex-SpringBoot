package crudtest.crudtest.Models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name="users")
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "id_user")
    private long id;


    @Column(name = "name_user")
    private String name;

    @Column(name = "surname_user")
    private String surname;

    public User(){

    }

    public User(long id, String name, String surname) {
        this.id = id;
        this.name = name;
        this.surname = surname;
    }

    public User(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }




}
