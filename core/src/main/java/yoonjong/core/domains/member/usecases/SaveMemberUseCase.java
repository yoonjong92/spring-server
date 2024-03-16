package yoonjong.core.domains.member.usecases;

import yoonjong.core.domains.member.models.MemberModel;

public interface SaveMemberUseCase {

    void DeleteMember(long id);
    MemberModel CreateMember(String email, String password, String name);
}
