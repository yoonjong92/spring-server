package yoonjong.webapp.dtos.Member;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MemberSimpleDto {
    private long id;
    private String email;
    private String name;
}
