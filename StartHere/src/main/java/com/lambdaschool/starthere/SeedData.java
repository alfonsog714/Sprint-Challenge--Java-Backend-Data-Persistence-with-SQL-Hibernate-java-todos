package com.lambdaschool.starthere;

import com.lambdaschool.starthere.models.Role;
import com.lambdaschool.starthere.models.ToDo;
import com.lambdaschool.starthere.models.User;
import com.lambdaschool.starthere.models.UserRoles;
import com.lambdaschool.starthere.repository.RoleRepository;
import com.lambdaschool.starthere.repository.ToDoRepository;
import com.lambdaschool.starthere.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

@Transactional
@Component
public class SeedData implements CommandLineRunner {
    RoleRepository rolerepos;
    UserRepository userrepos;
    ToDoRepository todorepos;

    public SeedData(RoleRepository rolerepos, UserRepository userrepos, ToDoRepository todorepos) {
        this.rolerepos = rolerepos;
        this.userrepos = userrepos;
        this.todorepos = todorepos;
    }

    @Override
    public void run(String[] args) throws Exception {
        Role r1 = new Role("admin");
        Role r2 = new Role("user");

        rolerepos.save(r1);
        rolerepos.save(r2);

        ArrayList<UserRoles> users = new ArrayList<>();
        users.add(new UserRoles(new User(), r2));
        User u1 = new User("barnbarn", "ILuvM4th!", users);
        u1.getTodos().add(new ToDo("Finish java-orders-swagger", true, u1));
        u1.getTodos().add(new ToDo("Feed the turtles", false, u1));
        u1.getTodos().add(new ToDo("Complete the sprint challenge", true, u1));
        userrepos.save(u1);

        ArrayList<UserRoles> admins = new ArrayList<>();
        admins.add(new UserRoles(new User(), r1));
        admins.add(new UserRoles(new User(), r2));
        User u2 = new User("admin", "password", admins);
        u2.getTodos().add(new ToDo("Walk the dogs", false, u2));
        u2.getTodos().add(new ToDo("provide feedback to my instructor", false, u2));
        userrepos.save(u2);

        users = new ArrayList<>();
        users.add(new UserRoles(new User(), r2));
        User u3 = new User("Bob", "password", users);
        userrepos.save(u3);

        users = new ArrayList<>();
        users.add(new UserRoles(new User(), r2));
        User u4 = new User("Jane", "password", users);
        userrepos.save(u4);
    }
}