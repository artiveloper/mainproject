package kr.mainproject.users.dto;

import kr.mainproject.users.domain.User;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
public class SignUpForm {

    @Email(message = "{email.format.invalid}")
    @NotBlank(message = "{email.not.blank}")
    private String email;

    @NotBlank(message = "{nickname.not.blank}")
    @Size(min = 3, max = 20, message = "{nickname.size.invalid}")
    private String nickname;

    @NotBlank(message = "{password.not.blank}")
    @Size(min = 8, max = 50, message = "{password.size.invalid}")
    private String password;

    @AssertTrue(message = "{signUpAgreement.invalid}")
    private Boolean signUpAgreement;

    public User toUserEntity() {
        return User.builder()
                .email(this.email)
                .nickname(this.nickname)
                .password(this.password)
                .build();
    }

}
