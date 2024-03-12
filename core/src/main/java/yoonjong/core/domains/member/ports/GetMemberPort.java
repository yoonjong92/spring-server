package yoonjong.core.domains.member.ports;

import yoonjong.core.domains.member.models.MemberModel;

public interface GetMemberPort {
    MemberModel GetMember(long id);

    MemberModel GetMemberByEmail(String email);
}
