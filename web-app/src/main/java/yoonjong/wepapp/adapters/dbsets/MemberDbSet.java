package yoonjong.wepapp.adapters.dbsets;

import yoonjong.core.domains.member.models.Member;
import yoonjong.core.domains.member.ports.GetMemberPort;
import yoonjong.core.domains.member.ports.SaveMemberPort;

public class MemberDbSet implements GetMemberPort, SaveMemberPort {
    @Override
    public Member GetMember(long id) {
        return null;
    }

    @Override
    public Member GetMemberByEmail(String email) {
        return null;
    }

    @Override
    public long InsertMember(Member member) {
        return 0;
    }
}
