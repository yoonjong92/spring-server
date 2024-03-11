package yoonjong.core.domains.member.ports;

import yoonjong.core.domains.member.models.Member;

public interface GetMemberPort {
    Member GetMember(long id);

    Member GetMemberByEmail(String email);
}
