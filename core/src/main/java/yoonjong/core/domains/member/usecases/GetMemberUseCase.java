package yoonjong.core.domains.member.usecases;

import yoonjong.core.domains.member.models.MemberModel;

import java.util.List;

public interface GetMemberUseCase {
    MemberModel GetMember(long id);
    MemberModel GetMember(String email);
    List<MemberModel> GetAll();
    MemberModel Login(String Email, String Password);
}
