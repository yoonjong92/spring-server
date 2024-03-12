package yoonjong.core.domains.member.ports;

import yoonjong.core.domains.member.models.Member;

public interface SaveMemberPort {
    long InsertMember(Member member);
}
