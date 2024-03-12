package yoonjong.core.domains.member.services;

import org.springframework.stereotype.Component;
import yoonjong.core.domains.member.models.Member;
import yoonjong.core.domains.member.usecases.GetMemberUseCase;
import yoonjong.core.domains.member.usecases.SaveMemberUseCase;

@Component
public class MemberDomainService implements GetMemberUseCase, SaveMemberUseCase {
    @Override
    public Member GetMember(long id) {
        return null;
    }

    @Override
    public Member GetMember(String email) {
        return null;
    }

    @Override
    public long CreateMember(String email, String password, String name) {
        return 0;
    }
}
