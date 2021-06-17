package tw.walker088.vaccine.sysadmin.controller;

//import tw.walker088.vaccine.sysadmin.model.User;
import tw.walker088.vaccine.sysadmin.model.UserViewDto;
import tw.walker088.vaccine.sysadmin.service.UserServiceInterface;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

//import lombok.extern.slf4j.Slf4j;

import java.util.List;

//@Slf4j
@Controller
@RequestMapping("/sysadmin")
public class UserViewController {
    @Autowired
    private UserServiceInterface userService;

    @GetMapping("/userlist")
    public String UserListView(Model model) {

        var users = (List<UserViewDto>) userService.findAllUserAsDto();

        model.addAttribute("userIcon", "<i class=\"fas fa-user\"></i>");
        model.addAttribute("userList", users);

        return "/sysadmin/userList";
    }
}
