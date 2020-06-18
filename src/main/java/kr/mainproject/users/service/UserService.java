package kr.mainproject.users.service;

import kr.mainproject.users.domain.User;
import kr.mainproject.users.dto.SignUpForm;
import kr.mainproject.users.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
@Transactional(readOnly = true)
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public void signUp(SignUpForm signUpForm) {
        User user = signUpForm.toUserEntity();
        user.encodePassword(passwordEncoder);

        userRepository.save(user);
    }

}
