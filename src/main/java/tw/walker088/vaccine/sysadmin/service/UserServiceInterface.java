package tw.walker088.vaccine.sysadmin.service;

import java.util.List;

import tw.walker088.vaccine.sysadmin.model.User;
import tw.walker088.vaccine.sysadmin.model.UserRestDto;
import tw.walker088.vaccine.sysadmin.model.UserViewDto;

public interface UserServiceInterface {
    //List<User> findAll();
    List<UserViewDto> findAllUserAsDto();
    UserRestDto findUserAsDto(String email);

    UserRestDto save(User user);
    UserRestDto update(User user);
}
