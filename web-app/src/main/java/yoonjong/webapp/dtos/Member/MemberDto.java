package yoonjong.webapp.dtos.Member;

import lombok.Getter;
import lombok.Setter;
import yoonjong.core.domains.member.models.MemberModel;

import java.time.OffsetDateTime;

@Getter
@Setter
public class MemberDto {
    private long id;
    private String email;
    private String password;
    private String name;
    private long permissionGroupId;
    private OffsetDateTime updatedAt;
    private OffsetDateTime createdAt;

    public MemberDto(MemberModel model) {
        id = model.getId();
        email = model.getEmail();
        password = model.getPassword();
        name = model.getName();
        permissionGroupId = model.getPermissionGroupId();
        updatedAt = model.getUpdatedAt();
        createdAt = model.getCreatedAt();
    }
}