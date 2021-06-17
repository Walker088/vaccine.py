package tw.walker088.vaccine.sysadmin.service;

import tw.walker088.vaccine.sysadmin.model.User;
import tw.walker088.vaccine.sysadmin.model.UserRestDto;
import tw.walker088.vaccine.sysadmin.model.UserViewDto;
import tw.walker088.vaccine.sysadmin.repository.UserRepository;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Service
public class UserServiceImpl implements UserServiceInterface {

    @Autowired
    private UserRepository repository;

    @Override
    public List<UserViewDto> findAllUserAsDto() {
        var users = (List<UserViewDto>) repository.findAllUserAsDto();
        return users;
    }

    @Override
    public UserRestDto findUserAsDto(String email) {
        var user = repository.findUserAsDto(email);
        return user;
    }

    @Override
    public UserRestDto save(User user) {
        //var plainPass = user.getUser_pass();
        //var hashedPass = new BCryptPasswordEncoder().encode(plainPass);
        //user.setUser_pass(hashedPass);
        var savedUser = repository.save(user);
        return repository.findUserAsDto(savedUser.getUser_email());
    }

    @Override
    public UserRestDto update(User user) {
        var updatedUser = repository.save(user);
        return repository.findUserAsDto(updatedUser.getUser_email());
    }
}
