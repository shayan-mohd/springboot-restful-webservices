package net.javaguides.springbootrestfulwebservices.service.Interface;

import net.javaguides.springbootrestfulwebservices.entity.User;

import java.util.List;

public interface UserService {
     User createUser(User user);

     List<User> getUsers();

    User updateUser( User user);

}
