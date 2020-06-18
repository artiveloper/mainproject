package kr.mainproject.users.validator;

import kr.mainproject.users.dto.SignUpForm;
import kr.mainproject.users.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
@RequiredArgsConstructor
public class SignUpFormValidator implements Validator {

    private final UserRepository userRepository;

    @Override
    public boolean supports(Class<?> aClass) {
        return aClass.equals(SignUpForm.class);
    }

    @Override
    public void validate(Object o, Errors errors) {
        SignUpForm signUpForm = (SignUpForm) o;
        if (userRepository.existsByEmail(signUpForm.getEmail())) {
            errors.rejectValue("email", "email.exists");
        }

        if (userRepository.existsByNickname(signUpForm.getNickname())) {
            errors.rejectValue("nickname", "nickname.exists");
        }
    }

}
