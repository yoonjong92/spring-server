package yoonjong.core.domains.member.ports;

import yoonjong.core.domains.member.models.MemberModel;

import java.util.List;

public interface GetMemberPort {
    MemberModel GetMember(long id);
    List<MemberModel> GetAll();
    MemberModel GetMemberByEmail(String email);
}
