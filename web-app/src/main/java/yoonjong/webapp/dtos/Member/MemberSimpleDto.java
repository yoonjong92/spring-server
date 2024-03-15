package yoonjong.webapp.dtos.Member;

import lombok.Getter;
import lombok.Setter;
import yoonjong.core.domains.member.models.MemberModel;

@Getter
@Setter
public class MemberSimpleDto {
    private long id;
    private String email;
    private String name;

    public MemberSimpleDto() {

    }

    public MemberSimpleDto(MemberModel model) {
        id = model.getId();
        email = model.getEmail();
        name = model.getName();
    }
}
