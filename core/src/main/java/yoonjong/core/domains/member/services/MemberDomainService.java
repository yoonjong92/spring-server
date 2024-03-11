package yoonjong.core.domains.member.services;

import org.springframework.stereotype.Component;
import yoonjong.core.domains.member.models.Member;
import yoonjong.core.domains.member.usecases.GetMemberUseCase;

@Component
public class MemberDomainService implements GetMemberUseCase {
    @Override
    public Member GetMember(long id) {
        return null;
    }

    @Override
    public Member GetMember(String email) {
        return null;
    }
}
