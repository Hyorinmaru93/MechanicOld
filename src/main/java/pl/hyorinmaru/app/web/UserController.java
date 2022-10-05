package pl.hyorinmaru.app.web;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.hyorinmaru.app.domain.User;
import pl.hyorinmaru.app.domain.UserData;
import pl.hyorinmaru.app.service.UserDataService;
import pl.hyorinmaru.app.service.UserService;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
@RequestMapping("/user")
@SessionAttributes("DBUser")
public class UserController {

    private final UserService userService;

    private final UserDataService userDataService;

    public UserController(UserService userService, UserDataService userDataService) {
        this.userService = userService;
        this.userDataService = userDataService;
    }

    @GetMapping("/main")
    public String userHomepage() {
       return "/user/main";
    }

    @GetMapping("/settings")
    public String settingsForm(HttpSession session, Model model) {
        User user = (User)session.getAttribute("DBUser");
        model.addAttribute("userData", user.getUserData());
        return "/user/settings";
    }

    @PostMapping("/settings")
    public String settings(@Valid UserData userData, BindingResult bindingResult, Model model, @AuthenticationPrincipal UserDetails userDetails) {
        UserData byUserEmail = userDataService.findByUserEmail(userData.getEmail());
        if (byUserEmail != null){
            bindingResult.rejectValue("email", "error.email",
                    "User with that email address already exist, contact us to resolve this problem");
        }
        if (bindingResult.hasErrors()) {
            return "/user/settings";
        }
        User user = userService.findByUserName(userDetails.getUsername());
        user.setUserData(userData);
        model.addAttribute("DBUser", user);
        userDataService.updateUserData(userData);
        return "/user/settings";
    }


}
