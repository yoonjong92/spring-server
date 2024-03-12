package yoonjong.webapp.adapters.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import yoonjong.core.domains.member.usecases.GetMemberUseCase;

@Component
@RequiredArgsConstructor
public class MemberService {
    private final GetMemberUseCase getMemberUseCase;

    
}
