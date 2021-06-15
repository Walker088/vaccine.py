package tw.walker088.vaccine.sysadmin.service;

import tw.walker088.vaccine.sysadmin.model.User;
import tw.walker088.vaccine.sysadmin.model.UserDto;
import tw.walker088.vaccine.sysadmin.repository.UserRepository;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserServiceInterface {

    @Autowired
    private UserRepository repository;

    @Override
    public List<User> findAll() {
        var users = (List<User>) repository.findAll();
        return users;
    }

    @Override
    public List<UserDto> findAllUserAsDto() {
        var users = (List<UserDto>) repository.findAllUserAsDto();
        return users;
    }
}
