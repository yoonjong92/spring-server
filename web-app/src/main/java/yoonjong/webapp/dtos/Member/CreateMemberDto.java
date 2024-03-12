package yoonjong.webapp.dtos.Member;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateMemberDto {
    private String email;
    private String name;
    private String password;
}
