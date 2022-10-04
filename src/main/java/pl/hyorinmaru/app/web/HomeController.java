package pl.hyorinmaru.app.web;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import pl.hyorinmaru.app.service.UserService;

@Controller
@SessionAttributes("DBUser")
public class HomeController {

    private final UserService userService;

    public HomeController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping("/")
    public String homePage() {
        return "Test";
    }

    @RequestMapping("/main")
    public String successfull(Model model, @AuthenticationPrincipal UserDetails customUser) {
        model.addAttribute("DBUser", userService.findByUserName(customUser.getUsername()));
        return "Test";
    }
}
