package yoonjong.core.domains.member.models;

import lombok.Getter;
import lombok.Setter;

import java.time.OffsetDateTime;

@Getter
@Setter
public class MemberModel {
    private long id;
    private String email;
    private String password;
    private String name;
    private long permissionGroupId;
    private OffsetDateTime updatedAt;
    private OffsetDateTime createdAt;
}
