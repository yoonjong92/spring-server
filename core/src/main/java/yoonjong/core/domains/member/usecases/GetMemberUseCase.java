package yoonjong.core.domains.member.usecases;

import yoonjong.core.domains.member.models.MemberModel;

public interface GetMemberUseCase {
    MemberModel GetMember(long id);
    MemberModel GetMember(String email);
    MemberModel Login(String Email, String Password);
}
