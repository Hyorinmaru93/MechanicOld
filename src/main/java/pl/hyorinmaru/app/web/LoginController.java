package pl.hyorinmaru.app.web;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.hyorinmaru.app.domain.User;
import pl.hyorinmaru.app.domain.UserData;
import pl.hyorinmaru.app.service.UserDataService;
import pl.hyorinmaru.app.service.UserService;

import javax.validation.Valid;

@Controller
public class LoginController {

    private final UserService userService;

    private final UserDataService userDataService;

    public LoginController(UserService userService, UserDataService userDataService) {
        this.userService = userService;
        this.userDataService = userDataService;
    }

    @GetMapping("/login")
    public String login(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "loginForm";
    }

    @GetMapping("/registry")
    public String registryForm(Model model){
        User user = new User();
        model.addAttribute("user", user);
        return "registry";
    }

    @PostMapping("/registry")
    public String registry(@Valid User user, BindingResult bindingResult, Model model){
        if (userService.findByUserName(user.getUsername()) != null) {
            bindingResult.rejectValue("username", "error.user",
                    "User with that username already exists.");
        }
        if (userService.checkPassword(user.getPassword())){
            bindingResult.rejectValue("password", "error.password",
                    "Password has to be between 8 and 20 characters with lowercase and uppercase letter, and digit, and special character");
        }
        if (bindingResult.hasErrors()) {
            return "registry";
        }

        UserData userData = new UserData(user.getUsername());
        userDataService.save(userData);
        user.setUserData(userData);

        userService.saveUser(user);
        model.addAttribute("registered" , true);
        return "redirect:loginForm";
    }

    @GetMapping("/test2")
    @ResponseBody
    public String userInfo(@AuthenticationPrincipal UserDetails customUser) {

        return "You are logged as " + customUser +
                "\n Username = " + customUser.getUsername();
    }
}
