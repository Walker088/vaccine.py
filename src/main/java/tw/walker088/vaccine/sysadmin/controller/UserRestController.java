package tw.walker088.vaccine.sysadmin.controller;

import tw.walker088.vaccine.sysadmin.model.User;
import tw.walker088.vaccine.sysadmin.model.UserRestDto;
import tw.walker088.vaccine.sysadmin.service.UserServiceInterface;
import tw.walker088.vaccine.common.utils.RestPreconditions;
import tw.walker088.vaccine.exception.ResourceNotFoundException;

import org.springframework.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping(value = "/api/v1/user")
public class UserRestController {

    @Autowired
    private UserServiceInterface userService;

    @GetMapping(value = "/{email}")
    public UserRestDto findById(@PathVariable("email") final String email) {
        try {
            return RestPreconditions.checkFound(userService.findUserAsDto(email));
        }
        catch (ResourceNotFoundException exc) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User Not Found", exc);
        }
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UserRestDto create(@RequestBody User user) {
        return userService.save(user);
    }

    @PutMapping(value = "/{email}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void update(@PathVariable("email") final String email, @RequestBody User user) {
        userService.update(user);
    }

}
