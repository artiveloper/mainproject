package kr.mainproject.users;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/users")
public class UserController {

    @GetMapping("/sign-up")
    public String signUpPage() {
        return "users/sign-up";
    }

    @GetMapping("/sign-in")
    public String signInPage() {
        return "users/sign-in";
    }

}
