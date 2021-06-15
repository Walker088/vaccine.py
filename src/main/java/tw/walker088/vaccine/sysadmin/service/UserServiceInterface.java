package tw.walker088.vaccine.sysadmin.service;

import java.util.List;

import tw.walker088.vaccine.sysadmin.model.User;
import tw.walker088.vaccine.sysadmin.model.UserDto;

public interface UserServiceInterface {
    List<User> findAll();
    List<UserDto> findAllUserAsDto();
}
