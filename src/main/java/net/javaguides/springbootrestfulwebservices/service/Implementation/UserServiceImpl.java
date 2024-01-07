package net.javaguides.springbootrestfulwebservices.service.Implementation;

import lombok.AllArgsConstructor;
import net.javaguides.springbootrestfulwebservices.entity.User;
import net.javaguides.springbootrestfulwebservices.repository.UserRepository;
import net.javaguides.springbootrestfulwebservices.service.Interface.UserService;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    @Override
    public User updateUser( @NotNull User user) {
        User result = userRepository.getReferenceById(user.getId());
        result.setEmail(user.getEmail());
        result.setFirstName(user.getFirstName());
        result.setLastName(user.getLastName());

        return userRepository.save(result);
    }


}
