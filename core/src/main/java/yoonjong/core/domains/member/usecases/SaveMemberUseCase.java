package yoonjong.core.domains.member.usecases;

import yoonjong.core.domains.member.models.MemberModel;

public interface SaveMemberUseCase {
    MemberModel CreateMember(String email, String password, String name);
}
