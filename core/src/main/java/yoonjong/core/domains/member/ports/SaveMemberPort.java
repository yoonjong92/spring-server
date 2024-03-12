package yoonjong.core.domains.member.ports;

import yoonjong.core.domains.member.models.MemberModel;

public interface SaveMemberPort {
    long InsertMember(MemberModel member);
}
