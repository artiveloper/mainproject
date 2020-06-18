package kr.mainproject.users.controller;

import kr.mainproject.users.dto.SignUpForm;
import kr.mainproject.users.service.UserService;
import kr.mainproject.users.validator.SignUpFormValidator;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/users")
@AllArgsConstructor
public class UserController {

    private final UserService userService;
    private final SignUpFormValidator signUpFormValidator;

    @InitBinder("signUpForm")
    public void siguUpFormValidation(WebDataBinder webDataBinder) {
        webDataBinder.addValidators(signUpFormValidator);
    }

    @GetMapping("/sign-up")
    public String signUpPage(Model model) {
        model.addAttribute(new SignUpForm());
        return "users/sign-up";
    }

    @PostMapping("/sign-up")
    public String signUp(@Valid SignUpForm signUpForm, Errors errors, RedirectAttributes redirectAttributes) {
        if (errors.hasErrors()) {
            return "users/sign-up";
        }
        userService.signUp(signUpForm);
        redirectAttributes.addFlashAttribute("message", "회원가입이 완료되었습니다 :)");
        return "redirect:/users/sign-in";
    }

    @GetMapping("/sign-in")
    public String signInPage() {
        return "users/sign-in";
    }

}
